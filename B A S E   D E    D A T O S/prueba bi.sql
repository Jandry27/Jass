
DROP PROCEDURE IF EXISTS RealizarPedido;
DROP TABLE IF EXISTS Detalles;
DROP TABLE IF EXISTS Pedidos;
DROP TABLE IF EXISTS Productos;
DROP TABLE IF EXISTS Clientes;


CREATE TABLE Clientes (
    ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) UNIQUE NOT NULL
);
INSERT INTO Clientes (Nombre, Correo) VALUES 
("Juan Pérez", "juan.perez@example.com"),
("María López", "maria.lopez@example.com"),
("Carlos Ramírez", "carlos.ramirez@example.com");
SELECT * from clientes;


CREATE TABLE Productos (
    ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    Stock INT NOT NULL
);
INSERT INTO Productos (Nombre, Precio, Stock)
VALUES 
("Laptop", 1200.50, 10),
("Teléfono", 800.75, 20),
("Audífonos", 50.00, 50);
SELECT * FROM Productos;


CREATE TABLE Pedidos (
    ID_Pedido INT AUTO_INCREMENT PRIMARY KEY,
    Fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ID_Cliente INT NOT NULL,
    CONSTRAINT FK_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);
SELECT * FROM Pedidos;


CREATE TABLE Detalles (
    ID_Detalle INT AUTO_INCREMENT PRIMARY KEY,
    ID_Pedido INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT NOT NULL,
    CONSTRAINT FK_Pedido FOREIGN KEY (ID_Pedido) REFERENCES Pedidos(ID_Pedido),
    CONSTRAINT FK_Producto FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto)
);
SELECT * FROM Detalles;


DELIMITER $$
CREATE PROCEDURE RealizarPedido(
    IN p_cliente INT,
    IN p_producto INT,
    IN p_cantidad INT
)
BEGIN
    DECLARE stock_actual INT;

    START TRANSACTION;

    SELECT Stock INTO stock_actual
    FROM Productos
    WHERE ID_Producto = p_producto;

    IF stock_actual < p_cantidad THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Error: Insuficiente";
    ELSE
        INSERT INTO Pedidos (ID_Cliente) VALUES (p_cliente);

        SET @id_pedido = LAST_INSERT_ID();

        INSERT INTO Detalles (ID_Pedido, ID_Producto, Cantidad)
        VALUES (@id_pedido, p_producto, p_cantidad);

        UPDATE Productos
        SET Stock = Stock - p_cantidad
        WHERE ID_Producto = p_producto;

        COMMIT;
    END IF;
END$$

DELIMITER ;

CALL RealizarPedido(1, 2, 5); 
CALL RealizarPedido(2, 2, 15);
CALL RealizarPedido(3, 3, 10); 

CALL RealizarPedido(1, 1, 100);

SELECT c.Nombre AS Cliente, COUNT(p.ID_Pedido) AS Numero_Pedidos, SUM(d.Cantidad * pr.Precio) AS Total_Gastado FROM Clientes c
JOIN Pedidos p ON c.ID_Cliente = p.ID_Cliente 
JOIN Detalles d ON p.ID_Pedido = d.ID_Pedido
JOIN Productos pr ON d.ID_Producto = pr.ID_Producto
GROUP BY c.ID_Cliente;

 

