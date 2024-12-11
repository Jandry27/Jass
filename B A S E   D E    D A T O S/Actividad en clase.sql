CREATE TABLE Estados (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(40)
);

CREATE TABLE estudiantes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(40) NOT NULL,
    Edad INT,
    Calificacion INT,
    Estado_ID INT,
    CONSTRAINT FK_Estado FOREIGN KEY (Estado_ID) REFERENCES Estados(ID)
);

INSERT INTO Estados (Nombre) VALUES ("Aprobado"), ("Reprobado"), ("Retirado"), ("Remedial");

INSERT INTO estudiantes (Nombre, Edad, Calificacion, Estado_ID)
VALUES 
    ("Alex", 20, 35, 1), 
    ("Andres", 19, 20, 4), 
    ("Jandry", 20, 0, 3), 
    ("Josue", 22, 14, 2), 
    ("Jeremy", 18, 19, 4);

SELECT * FROM estudiantes;
SELECT estudiantes.Nombre AS Estudiante, estudiantes.Edad, estudiantes.Calificacion, Estados.Nombre AS Estado
FROM estudiantes
LEFT JOIN Estados 
ON estudiantes.Estado_ID = Estados.ID
UNION
SELECT estudiantes.Nombre AS Estudiante, estudiantes.Edad, estudiantes.Calificacion, Estados.Nombre AS Estado
FROM estudiantes
RIGHT JOIN Estados 
ON estudiantes.Estado_ID = Estados.ID;




