CREATE TABLE productos(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(40) NOT NULL UNIQUE,
    Precio DECIMAL(10, 2),
    Marca VARCHAR(20),
    Categoria INT,
    FOREIGN KEY (Categoria) REFERENCES categorias(Id)
);


SELECT * FROM productos;
INSERT INTO productos (Nombre,Precio,Marca,categorias)
VALUES ("Botella 300cm",0.60,"PONY MALTA",2),
("Empaque 6 galletas", 0.45,"FESTIVAL",2),
("Empaque 4 galletas",0.30,"KONITO",1),
("Botella 1L", 1.0,"PEPSI",1),
("Botellas 3L",2.75,"COCA COLA",1),
("Empaque 12 galletas",1.50,"CHIPS AHOY",3),
("Esmalte de uñas","1.75","MARCA A",2);

update productos 
set categoria=4
where id= 10


Delete from procductos 
where Id=4;

CREATE TABLE t_res(
Id INT,
Nombre VARCHAR (40) NOT NULL UNIQUE,
Precio DECIMAL (10,2),
Marca VARCHAR (20) 
);
select * from t_res;

INSERT INTO t_res(Id,Nombre,Precio,Marca)
select * FROM prodcutos;

Create table categorias(
	id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR (50)
);

INSERT INTO categorias(Nombre)
Values ("Comida"),("Belleza"),("Bebida");

SELECT * FROM categorias;
