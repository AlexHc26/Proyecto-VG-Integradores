create table productos(
cod_prod int primary key auto_increment,
nom_prod varchar(50),
fknom_marc int,
precio numeric(8,2),
stock int
);

alter table productos
add foreign key (fknom_marc) references marca (cod_marc);

create table marca(
cod_marc int primary key,
nom_marc varchar(30)
);

insert marca values (1,'hikvision');
insert marca values (2,'garrett');
insert marca values (3,'axix');

create procedure listar_marca()
select cod_marc,nom_marc from marca order by nom_marc asc;

call listar_marca();

create table cliente(
cod_client char(5) primary key,
nom_client varchar(50),
ape_client varchar(50),
direccion varchar(60),
fech_nac date,
telefono varchar(15),
correo varchar(50)
);

insert cliente values ('manu1','Manuel','Huamanchumo','Los Jazmines',20040126,940328193,'alehc@gmail.com');

select * from productos;
insert productos values (null,'camara2',1,170,170);
insert into productos (cod_prod,nom_prod, fknom_marc,precio,stock)values (null,'detector',2,170,10);
SELECT * FROM PRODUCTOS WHERE COD_PROD=1;
select * from tb_usuarios;

insert into tb_usuarios (cod_user,nom_user,apellido,username,clave,fec_acceso,tipo,estado) values (null,'Erick','Ceballos','ERICC',839100,'2020-09-11',default,default)
