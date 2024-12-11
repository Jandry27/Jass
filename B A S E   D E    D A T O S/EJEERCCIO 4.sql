CREATE TABLE roles(
	id_rol INT PRIMARY KEY AUTO_INCREMENT,
    rol VARCHAR (30) NOT NULL
    
);

INSERT INTO roles(rol)
VALUES("ADMIN"),("EDITOR"),("MOD"),("COMMON");
SELECT * FROM roles;


CREATE TABLE generos(
	id_genero INT PRIMARY KEY AUTO_INCREMENT,
    genero VARCHAR (30) NOT NULL UNIQUE
);


INSERT INTO generos(genero)
VALUES("MASCULINO"),("FEMENINO"),("OTRO");
SELECT * FROM generos;


CREATE TABLE usuarios(
	id_usuarios INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR (50) NOT NULL,
    edad INT NOT NULL,
    rol INT NOT NULL,
    genero INT NOT NULL,
    CONSTRAINT CF_rol FOREIGN KEY (rol) REFERENCES roles(id_rol),
	CONSTRAINT CF_gen FOREIGN KEY (genero) REFERENCES generos(id_genero)
);

INSERT INTO usuarios(nombre,edad,rol,genero)
VALUES ("Julian",25,3,1),
("Maria",43,2,2),
("Milton",12,1,1),
("Teresa",17,4,3),
("Sofia",28,1,2);

SELECT * FROM usuarios;

#CUAL ES LA EDAD PROMEDIO DE CADA ROL?
SELECT roles.rol, AVG(usuarios.edad) AS Edad_Promedio
FROM roles
INNER JOIN usuarios ON usuarios.rol = roles.id_rol
GROUP BY roles.rol;

# cual es a edad de promedio de cada genero

SELECT generos.genero, AVG(usuarios.edad) AS Edad_Promedio
FROM generos
INNER JOIN usuarios ON usuarios.genero = generos.id_genero
GROUP BY generos.genero;

#(nombre, rol, genero)

SELECT usuarios.nombre, roles.rol, generos.genero
FROM usuarios
INNER JOIN roles ON usuarios.rol = roles.id_rol
INNER JOIN generos ON usuarios.genero = generos.id_genero;
 
 
 #TOTAL DE USUARIOS FEMENINOS COUNT(*)

SELECT COUNT(*) AS Total_Mujeres
FROM usuarios
WHERE genero=2;


SELECT COUNT(*) 
FROM usuarios
WHERE rol=1 AND genero=2;
