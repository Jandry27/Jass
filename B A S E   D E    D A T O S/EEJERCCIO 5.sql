CREATE TABLE clientes(
		Id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    cliente VARCHAR(30) NOT NULL UNIQUE
);

INSERT INTO clientes(cliente)
VALUES("Alex"), ("Josue"), ("Jhon");

SELECT * FROM clientes;

CREATE TABLE cuentas(
    id_cuentas INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL UNIQUE,
    num_cuenta VARCHAR(10) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL,
    CONSTRAINT CF_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

INSERT INTO cuentas(id_cliente, num_cuenta, saldo)
VALUES (2, "15497", 4500.25), 
       (3, "89654", 2368.75), 
       (1, "54123", 3847.50);

SELECT * FROM cuentas;


CREATE TABLE movimientos(
    id_movimiento INT PRIMARY KEY AUTO_INCREMENT,
    id_cuenta INT NOT NULL,
    movimiento VARCHAR(30) NOT NULL,
    CONSTRAINT CF_cuenta FOREIGN KEY (id_cuenta) REFERENCES cuentas(id_cuentas)
);

SELECT * FROM movimientos;

-- INICIO DE TRANSACTION
START TRANSACTION;

UPDATE cuentas
SET saldo = saldo - 1000
WHERE id_cuentas = 2;

UPDATE cuentas
SET saldo = saldo + 1000
WHERE id_cuentas = 3;

INSERT INTO movimientos (id_cuenta,movimiento)
VALUES(2,"RETIRO"),(3,"DEPOSITO");

-- EN CASO DE QUE NO SALIERA BIEN
ROLLBACK;

-- FIN DE TRANSTACTION
COMMIT;

DELIMITER $$
CREATE PROCEDURE transferir(
	IN ID_origen INT,
	IN ID_destino INT,
    IN monto DECIMAL(10,2)
)

BEGIN 
	DECLARE saldo_origen DECIMAL(10,2);
    START TRANSACTION; 
	SELECT saldo INTO saldo_origen
    FROM cuentas
    WHERE id_cuentas=ID_origen;
    IF monto > saldo_origen THEN
		ROLLBACK;
        SELECT * FROM cuentas;
        SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT="FONDOS INSUFICIENTES PARA LA TRANSEFERENCIA";
	ELSE
		UPDATE cuentas
        SET saldo=saldo-monto
        WHERE id_cuentas=ID_origen;
        UPDATE cuentas
        SET saldo=saldo+monto
        WHERE id_cuentas=ID_destino;
		INSERT INTO movimientos (id_cuenta,movimiento)
		VALUES(ID_origen,"RETIRO"),(ID_destino,"DEPOSITO");
        COMMIT;
        SELECT * FROM cuentas;
	END IF;
END $$
DELIMITER ;

DROP PROCEDURE transferir;

CALL transferir(3,1,2000.00);


-- Verificar que todo ha sido eliminado
SHOW TABLES;
SHOW PROCEDURE STATUS WHERE Db = DATABASE();
