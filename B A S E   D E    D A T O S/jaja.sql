create table categorias(
ID int primary key auto_increment,
nombre varchar(40) not null
);


insert into categorias(nombre)

values("Ropa"),("Tecnologia"),("Comida"),("Bebidas"),("Muebleria");

create table registro_ventas(
ID int primary key auto_increment,
producto varchar(50) not null,
cantidad int not null,
fecha timestamp default current_timestamp,
categoria int,
constraint CF_ca foreign key (categoria) references categorias(ID)
);

insert into registro_ventas(producto,cantidad,categoria)
values ("reloj",2,2);

insert into registro_ventas(producto,cantidad,categoria)
values ("sombrero",3,1);

insert into registro_ventas(producto,cantidad,categoria)
values ("sombrero",8,1);

insert into registro_ventas(producto,cantidad,categoria)
values ("reloj",9,2);

insert into registro_ventas(producto,cantidad,categoria)
values ("sombrero",1,1);

select * from registro_ventas;
SELECT registro_venta.prodcuto, categorias.nombre
FROM registro_ventas
INNER JOIN categorias On registro_ventas.categroia=categorias.ID;

SELECT producto,SUM(registro_ventas.cantidad) AS total_ventas
FROM registro_ventas
INNER JOIN categorias On registro_ventas.categroia=categorias.ID;

GROUP BY registro_ventas.producto;
