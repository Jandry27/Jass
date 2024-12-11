
CREATE TABLE Cuentas(
    ID_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Titular VARCHAR(100) NOT NULL,
    Saldo DECIMAL(10, 2) NOT NULL
);

-- Insertar registros en la tabla Cuentas
INSERT INTO Cuentas (Nombre_Titular, Saldo)
VALUES 
    ("Juan Perez", 500.00),
    ("Maria Lopez", 1000.00),
    ("Carlos Gomez", 1500.00),
    ("Ana Rodriguez", 200.00),
    ("Luis Martinez", 300.00);

-- Verificar los registros en la tabla Cuentas
SELECT * FROM Cuentas;

-- Crear tabla Movimientos
CREATE TABLE Movimientos(
    ID_Movimiento INT AUTO_INCREMENT PRIMARY KEY,
    Fecha_Movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ID_Cuenta_Origen INT,
    ID_Cuenta_Destino INT,
    Monto DECIMAL(10, 2) NOT NULL,
    Tipo ENUM('DEPOSITO', 'RETIRO') NOT NULL,
    FOREIGN KEY (ID_Cuenta_Origen) REFERENCES Cuentas(ID_cuenta),
    FOREIGN KEY (ID_Cuenta_Destino) REFERENCES Cuentas(ID_cuenta)
);

-- Crear procedimiento almacenado para transferir dinero
DELIMITER //

CREATE PROCEDURE TransferirDinero(
    IN cuenta_origen INT,
    IN cuenta_destino INT,
    IN monto DECIMAL(10, 2)
)

BEGIN
    DECLARE saldo_actual DECIMAL(10, 2);

    START TRANSACTION;

    -- Verificar saldo suficiente
    SELECT Saldo INTO saldo_actual FROM Cuentas WHERE ID_cuenta = cuenta_origen;

    IF saldo_actual < monto THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Fondos insuficientes';
        ROLLBACK;
    ELSE
        -- Retirar dinero de la cuenta origen
        UPDATE Cuentas
        SET Saldo = Saldo - monto
        WHERE ID_cuenta = cuenta_origen;

        -- Registrar retiro
        INSERT INTO Movimientos (ID_Cuenta_Origen, ID_Cuenta_Destino, Monto, Tipo)
        VALUES (cuenta_origen, cuenta_destino, monto, 'RETIRO');

        -- Depositar dinero en la cuenta destino
        UPDATE Cuentas
        SET Saldo = Saldo + monto
        WHERE ID_cuenta = cuenta_destino;

        -- Registrar depósito
        INSERT INTO Movimientos (ID_Cuenta_Origen, ID_Cuenta_Destino, Monto, Tipo)
        VALUES (cuenta_origen, cuenta_destino, monto, 'DEPOSITO');
    END IF;

    COMMIT;
END;

//
DELIMITER ;

CALL TransferirDinero(1, 2, 100.00);
CALL TransferirDinero(2, 3, 200.00);
CALL TransferirDinero(3, 4, 300.00);
CALL TransferirDinero(4, 5, 50.00);
CALL TransferirDinero(5, 1, 30.00);

CALL TransferirDinero(4, 2, 500.00);

SELECT ID_Cuenta_Origen AS Cuenta, SUM(Monto) AS Total_Retirado
FROM Movimientos
WHERE Tipo = 'RETIRO'
GROUP BY ID_Cuenta_Origen;

SELECT ID_Cuenta_Destino AS Cuenta, SUM(Monto) AS Total_Depositado
FROM Movimientos
WHERE Tipo = 'DEPOSITO'
GROUP BY ID_Cuenta_Destino;

SELECT * FROM Cuentas;
SELECT * FROM Movimientos;




