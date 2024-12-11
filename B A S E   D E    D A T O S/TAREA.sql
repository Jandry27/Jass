CREATE TABLE Tarea(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Usuario VARCHAR(50),
    Edad INT,
    Correo VARCHAR(50),
    Cedula VARCHAR (10)
);

INSERT INTO Tarea (Nombre, Apellido, Usuario, Edad, Correo, Cedula)
VALUES ("Carla","Rodriguez","carla_rodri89",44,"carla.rodri89@mail.com",0102030405),
("Mario","Gomez","mariogmz94",13,"mariogomez94@mail.com",1102233445),
("Fernanda","López","fer.lopez91",30,"ferlopez91@mail.com",2203344556),
("Juan","Perez","jperez88",22,"juan.perez88@mail.com",3304455667),
("Ana","Morales","ana_morales92",56,"anamoral92@mail.com",4405566778),
("Laura","Castillo","lauracast_90",32,"aura.cast90@mail.com",5506677889),
("Diego","Fernández","diegofz_85",17,"diegofz85@mail.com",6607788990),
("Javier","Torres","jtorres_86",38,"jtorres86@mail.com",7708899001),
("Sofía","Ruiz","sofiaruiz_93",23,"sofia.ruiz93@mail.com",8809900112),
("Pablo","Sánchez","psanchez_87",19,"pablo.sanchez87@mail.com",9901011223);

# b. Personas de edad de entre 20 y 30
SELECT * FROM Tarea
WHERE Edad BETWEEN 20 AND 30;

#c. Consultar el username y el número de cédula de los últimos 4 usuarios registrados.
SELECT Id,Usuario, Cedula
FROM Tarea
ORDER BY Id DESC
LIMIT 4;

# d) Consultar el número de cédula y el correo electrónico de los primeros 3 usuarios.
SELECT Id, Cedula, Correo 
From Tarea 
Limit 3; 
 
 # e) Consultar la edad promedio de los usuarios impares.
 SELECT AVG (Edad) AS Edad_Promedio FROM Tarea
 WHERE MOD (Id, 2) = 1;
 
 # f) Actualizar (modificar) el Apellido del séptimo usuario.
UPDATE Tarea
SET Apellido = 'Saritama'
WHERE Id = 7; 
SELECT * FROM Tarea
WHERE Id = 7; 

# g) Eliminar a todos los usuarios menores de edad. (no importa si no hay).
DELETE FROM Tarea WHERE Edad < 18;
SELECT * FROM Tarea WHERE Edad < 18;




#3. Crear una tabla respaldo que sólo almacene el username y el correo electrónico de todos los usuarios.
CREATE TABLE Respaldo (
	Usuario VARCHAR (50),
    Correo VARCHAR (50)
);
INSERT INTO Respaldo ( Usuario, Correo)
SELECT Usuario, Correo FROM Tarea;


#4. Crear una tabla de roles de usuario (tabla hija). 
CREATE TABLE Roles (
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Rol ENUM ("ADMIN", "EDITOR", "COMMON"),
    Usuario_Id INT,
    Fecha_Asignacion DATE,
    FOREIGN KEY (Usuario_Id) REFERENCES Tarea(Id)
);

INSERT INTO Roles (Rol, Usuario_Id, Fecha_Asignacion) VALUES 
    ('ADMIN', 1, '2024-11-01'),
    ('EDITOR', 3, '2024-11-02'),
    ('COMMON', 5, '2024-11-03'),
    ('ADMIN', 7, '2024-11-04'),
    ('COMMON', 9, '2024-11-05');
    SELECT * FROM Roles;







