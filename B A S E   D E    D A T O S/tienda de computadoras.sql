CREATE TABLE componentes(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR (75) NOT NULL UNIQUE,
    Precio Decimal (10,3),
    Marca varchar (75),
    Factura INT	(50),
    Calidad VARCHAR (75)
);

select * from componentes;

INSERT INTO componentes (Nombre,Precio,Marca,Factura,Calidad)
VALUES ("Procesador",450.00,"Intel",18,"Premium"),
("Tarjeta Grafica",599.00,"Intel Arc A780 12GB",19,"Bueno"),
("Memoria Ram",120.00,"Corsair Vengeance LPX DDR4 32GB",20,"Exelente"),
("Discos SSDS",270.00,"Western Digital Black AN1500 1TB",21,"Premium"),
("Sistemas de refrigeración",150.00,"ASUS ROG RYUO 240",22,"Bueno");

SELECT * FROM componentes
ORDER BY Precio ASC
LIMIT 1;

Select * from componentes
where id<=3;

SELECT * FROM componentes 
where (id%2)=0;

select AVG (precio) from componentes