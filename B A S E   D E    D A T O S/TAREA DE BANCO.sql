CREATE TABLE Cuentas(
    ID_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Titular VARCHAR(100) NOT NULL,
    Saldo DECIMAL(10, 2) NOT NULL
);

INSERT INTO Cuentas (Nombre_Titular, Saldo)
VALUES 
('Sayda', 1000.00),
('Elizabeth', 1000.00),
('Alexis', 1000.00),
('Alexa', 1000.00),
('Juliet', 1000.00);

SELECT * FROM Cuentas;

CREATE TABLE Movimientos (
    ID_Movimiento INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ID_Cuenta_Origen INT,
    ID_Cuenta_Destino INT,
    Monto DECIMAL(10, 2),
    Tipo VARCHAR(10) CHECK (Tipo IN ("DEPOSITO", "RETIRO")),
    CONSTRAINT FK_Cuenta_Origen FOREIGN KEY (ID_Cuenta_Origen) REFERENCES Cuentas(ID_cuenta),
    CONSTRAINT FK_Cuenta_Destino FOREIGN KEY (ID_Cuenta_Destino) REFERENCES Cuentas(ID_cuenta)
);

SELECT * FROM Movimientos;

DELIMITER $$

CREATE PROCEDURE TransferirDinero(
    IN ID_Origen INT,
    IN ID_Destino INT,
    IN Monto DECIMAL(10, 2)
)
BEGIN
    DECLARE saldo_origen DECIMAL(10,2);
    
    START TRANSACTION;
    
    SELECT Saldo INTO saldo_origen
    FROM Cuentas
    WHERE ID_cuenta = ID_Origen;
    
    IF saldo_origen < Monto THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Dinero Insuficiente para la Transferencia';
    ELSE 
        UPDATE Cuentas 
        SET Saldo = Saldo - Monto
        WHERE ID_cuenta = ID_Origen;
    
        UPDATE Cuentas 
        SET Saldo = Saldo + Monto
        WHERE ID_cuenta = ID_Destino;
    
        INSERT INTO Movimientos (ID_Cuenta_Origen, ID_Cuenta_Destino, Monto, Tipo)
        VALUES (ID_Origen, ID_Destino, Monto, 'RETIRO');
    
        INSERT INTO Movimientos (ID_Cuenta_Origen, ID_Cuenta_Destino, Monto, Tipo)
        VALUES (ID_Origen, ID_Destino, Monto, 'DEPOSITO');
    
        COMMIT;
    END IF;
END $$

DELIMITER ;

CALL TransferirDinero(1, 2, 530.00); #Sayda a Elizabeth le transfiere 530
CALL TransferirDinero(3, 4, 100.00); # Alexis a Alexa le tranfiere 100
CALL TransferirDinero(5, 1, 800.00); # Juliet a Sayda 800
CALL TransferirDinero(2, 3, 120.00); # Elizabeth a Alexis 120
CALL TransferirDinero(4, 5, 600.00);  #Alexa a Julieth 600

-- Intento de transferencia con saldo insuficiente
CALL TransferirDinero(1, 2, 6000.00);

SELECT ID_Cuenta_Origen AS Cuenta, SUM(Monto) AS Total_Retirado
FROM Movimientos
WHERE Tipo = "RETIRO"
GROUP BY ID_Cuenta_Origen;

SELECT ID_Cuenta_Destino AS Cuenta, SUM(Monto) AS Total_Depositado
FROM Movimientos
WHERE Tipo = "DEPOSITO"
GROUP BY ID_Cuenta_Destino;



DROP PROCEDURE IF EXISTS TransferirDinero;
DROP TABLE IF EXISTS Movimientos;
DROP TABLE IF EXISTS Cuentas;