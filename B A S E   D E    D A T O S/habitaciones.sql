create table tipos_habitaciones(
	ID_hab Int primary key auto_increment,
    nombre VARCHAR(40) NOT NULL
);

SELECT * FROM tipos_habitaciones;

CREATE TABLE hospedados(
	ID INT PRIMARY KEY auto_increment,
    nombre VARCHAR(40) not null,
    telefono VARCHAR(40),
    edad INT,
    num_hab INT NOT NULL ,
    tipo_h INT NOT NULL,
    CONSTRAINT CF_tipos FOREIGN KEY (tipo_h) REFERENCES tipos_habitaciones(ID_hab)
);

select * FROM hospedados;

INSERT INTO tipos_habitaciones(nombre)
VALUES("Individual"),("Doble"),("Matrimonial"),("Familiar");

INSERT INTO hospedados(nombre,telefono,edad,num_hab,tipo_h)
VALUES("Jose Martinez","0969650297",36,5,1),
("Roberto Íñiguez","0989575378",34,14,4),
("Alex Criollo","0980331827",23,60,2),
("Josue Quiñonez","0993098725",25,17,3);

SELECT nombre FROM tipos_habitaciones
WHERE ID_hab=3;



