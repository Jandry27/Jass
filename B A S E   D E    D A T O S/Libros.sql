CREATE TABLE categorias_libros(
	ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Nombre VARCHAR(40) 
);

CREATE TABLE libros (
	ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Nombre VARCHAR (40) NOT NULL,
    Autor VARCHAR (40),
    Categoria INT, 
    Fecha_publi VARCHAR (40),
    CONSTRAINT CF_cat FOREIGN KEY (categoria) REFERENCES categorias_libros(ID)
    );
    
INSERT INTO categorias_libros (Nombre)
VALUES ("TERROR"),("CIENCIA FICCION"),("HISTORIA"),("FISICA");

INSERT INTO categorias_libros(nombre)
VALUES ("NOVELA");
SELECT * FROM categorias_libros;

INSERT INTO libros(Nombre, Autor,Categoria,Fecha_publi)
VALUES ("Times of shadow","Joaquin Segarra",2,"08-22"),
("Caverna","Emilio Cvallos",1,"09-21"),
("Relatividad Especial","Albert Einstein",4,"06-46"),
("Cultura Incaica","Hernan Guayllas",3,"12-11");
SELECT * FROM libros;

INSERT INTO  libros(Nombre,Autor,Fecha_publi)
VALUES("B2 English level","Cambridge","10-23");

SELECT * FROM libros;

SELECT libros.Nombre AS libro,categorias_libros.Nombre AS categoria
FROM libros
LEFT JOIN categorias_libros
ON libros.categoria = categorias_libros.ID
UNION
SELECT libros.Nombre, categorias_libros.Nombre
FROM libros
RIGHT JOIN categorias_libros
ON libros.categoria = categorias_libros.ID;


