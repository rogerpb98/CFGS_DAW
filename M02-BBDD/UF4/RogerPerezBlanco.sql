/*psql postgres -f UF4/RogerPerezBlanco.sql*/
/*
Les bandes musicals estan formades per un conjunt de músics. 
Les bandes musicals tenen álbums que contenen cançons.
Les cançons tenen un nom i la durada (en minuts). 
Les bandes tenen un nom, un estil, un país i una biografia. 
Els músics tenen un nom, sexe, edat i el nom dels instruments que toquen. 
Els àlbums tenen un nom, any d’edició, i el número de cançons que contenen.
*/
/* Esborrem la base de dades -si existeix- i la creem, connectant-nos. */
drop database if exists projecte;
create database projecte;
\c projecte;

/* Domini per els anys d'edició */
create domain Danyo int check (value >1950 AND value <2022);
/* Creem els tipus que utilitzarem durant el projecte */
/* Tipus de suport */
create type TSexo as ENUM('H','M');
create type TPersona as (
    nombre varchar(15),
    sexo TSexo,
    edad int
);
create type TInstrumento as ENUM('Guitarra','Bateria','Piano','Bajo','Voz');
create type TGeneroMusical as ENUM('Pop','Punk','Rock','Metal','Rap','Trap');
/* Taula Persona basada en el tipus TPersona */
create table Persona of TPersona(
    nombre with options not null,
    sexo with options not null,
    edad with options not null
);
/* Tipus per a taules */
create type TBandas as (
    nombre varchar(30),
    genero TGeneroMusical[],
    pais varchar(20),
    biografia text
);
create type TAlbumes as (
    cod_album int,
    nombre varchar(25),
    anyo_edicion DAnyo,
    num_canciones int,
    /*foreign*/
    banda varchar(30)
);
create type TCanciones as (
    cod_cancion int,
    nombre varchar(50),
    duracion int,
    /*foreign*/
    album int
);
/* Crear taules per cada tipus */
create table Bandas of TBandas (
    nombre primary key,
    genero with options not null
);

create table Albumes of TAlbumes (
    cod_album primary key,
    nombre with options not null,

    foreign key (banda) references Bandas (nombre)
    on update cascade
    on delete cascade
);
create table Canciones of TCanciones (
    cod_cancion primary key,
    nombre with options not null,

    foreign key (album) references Albumes (cod_album)
    on update cascade
    on delete cascade
);
/* Crear taula Musicos (que hereda de persona)*/
create table Musicos (
    cod_musico serial primary key,
    instrumentos TInstrumento[] not null,
    /*foreign*/
    banda varchar(30) not null,

    foreign key (banda) references Bandas (nombre)
    on update cascade
    on delete cascade
) INHERITS (Persona);

/*INSERTS*/
/*Bandas y musicos*/
insert into Bandas (nombre, genero, pais, biografia) values ('HIM', '{Metal}', 'Finlandia', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Ville Valo', 'H', 50, default, '{Voz}', 'HIM');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Mikko Lindström', 'H', 51, default, '{Guitarra}', 'HIM');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Janne Puurtinen', 'H', 46, default, '{Piano}', 'HIM');

insert into Bandas (nombre, genero, pais, biografia) values ('Linkin Park', '{Metal, Rock, Rap}', 'Estados Unidos', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Cheesty', 'H', 44, default, '{Voz}', 'Linkin Park');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Mike Shinoda', 'H', 44, default, '{Voz}', 'Linkin Park');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Joe Hahn', 'H', 44, default, '{Piano, Bateria}', 'Linkin Park');

insert into Bandas (nombre, genero, pais, biografia) values ('Violadores del Verso', '{Rap}', 'España', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Lirico', 'H', 44, default, '{Bateria}', 'Violadores del Verso');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Kase.O', 'H', 50, default, '{Voz}', 'Violadores del Verso');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('SHO-HAI', 'H', 50, default, '{Voz}', 'Violadores del Verso');

insert into Bandas (nombre, genero, pais, biografia) values ('Barderos', '{Trap, Rap}', 'Argentina', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('C.R.O', 'H', 50, default, '{Voz}', 'Barderos');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Homer', 'H', 50, default, '{Voz}', 'Barderos');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Chulu', 'H', 50, default, '{Bajo, Guitarra}', 'Barderos');

insert into Bandas (nombre, genero, pais, biografia) values ('AC/DC', '{Rock}', 'Estados Unidos', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Angus Young', 'H', 113, default, '{Guitarra}', 'AC/DC');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Brian Johnson', 'H', 96, default, '{Voz}', 'AC/DC');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Bon Scott', 'H', 60, default, '{Bateria}', 'AC/DC');

insert into Bandas (nombre, genero, pais, biografia) values ('Green Day', '{Rock}', 'Estados Unidos', 'lorem ipsum');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Billie Joe', 'H', 57, default, '{Guitarra, Voz}', 'Green Day');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Tré Cool', 'H', 48, default, '{Guitarra, Bateria}', 'Green Day');
insert into Musicos (nombre, sexo, edad, cod_musico, instrumentos, banda) values ('Mike Dirnt', 'H', 49, default, '{Bajo}', 'Green Day');
/*Albumes y canciones*/
insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (1, 'Razorblade Romance', 2000, 6, 'HIM');
insert into Canciones (cod_album, nombre, duracion, album) values (1, 'I Love You', 190, 1);
insert into Canciones (cod_album, nombre, duracion, album) values (2, 'Poison Girl', 231, 1);
insert into Canciones (cod_album, nombre, duracion, album) values (3, 'Join Me in Death', 216, 1);
insert into Canciones (cod_album, nombre, duracion, album) values (4, 'Right Here in My Arms', 242, 1);
insert into Canciones (cod_album, nombre, duracion, album) values (5, 'Gone with the Sin', 261, 1);
insert into Canciones (cod_album, nombre, duracion, album) values (6, 'Razorblade Kiss', 260, 1);

insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (2, 'Meteora', 2003, 6, 'Linkin Park');
insert into Canciones (cod_album, nombre, duracion, album) values (7, 'Dont Stay', 187, 2);
insert into Canciones (cod_album, nombre, duracion, album) values (8, 'Somewhere I Belong', 213, 2);
insert into Canciones (cod_album, nombre, duracion, album) values (9, 'Lying from You', 175, 2);
insert into Canciones (cod_album, nombre, duracion, album) values (10, 'Hit the Floor', 165, 2);
insert into Canciones (cod_album, nombre, duracion, album) values (11, 'Easier to Run', 204, 2);
insert into Canciones (cod_album, nombre, duracion, album) values (12, 'Faint', 162, 2);

insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (3, 'Atrás', 2001, 6, 'Violadores del Verso');
insert into Canciones (cod_album, nombre, duracion, album) values (13, 'Atrás', null, 3);
insert into Canciones (cod_album, nombre, duracion, album) values (14, 'Rap solo universidad', null, 3);
insert into Canciones (cod_album, nombre, duracion, album) values (15, 'Nadie lo haze', null, 3);
insert into Canciones (cod_album, nombre, duracion, album) values (16, 'Atrás (Instrumental)', null, 3);
insert into Canciones (cod_album, nombre, duracion, album) values (17, 'Rap solo universidad (Instrumental)', null, 3);
insert into Canciones (cod_album, nombre, duracion, album) values (18, 'Nadie lo haze (Instrumental)', null, 3);

insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (4, 'Esperanza', 2019, 8, 'Barderos');
insert into Canciones (cod_album, nombre, duracion, album) values (19, 'Hard Street Shit', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (20, 'La Droga Está Acá', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (21, 'A Fuego Lento', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (22, 'Ahora Quieren Volar?', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (23, 'Asuntos Del Barrio', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (24, 'Me Sueltan Los Angeles', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (25, 'Tardes Grises', null, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (26, 'Tengo Sed Remix', null, 4);

insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (5, 'High Voltage', 1975, 8, 'AC/DC');
insert into Canciones (cod_album, nombre, duracion, album) values (27, 'Baby, Please Dont Go', 293, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (28, 'Shes Got Balls', 293, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (29, 'Little Lover', 342, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (30, 'Stick Around', 287, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (31, 'Soul Stripper', 390, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (32, 'You Aint Got a Hold on Me', 211, 5);
insert into Canciones (cod_album, nombre, duracion, album) values (33, 'Love Song', 317, 4);
insert into Canciones (cod_album, nombre, duracion, album) values (35, 'Show Business', 290, 5);

insert into Albumes (cod_album, nombre, anyo_edicion, num_canciones, banda) values (6, 'Dookie', 2003, 7, 'Green Day');
insert into Canciones (cod_album, nombre, duracion, album) values (36, 'Burnout', 127, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (37, 'Having a Blast', 164, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (38, 'Chump', 174, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (39, 'Longview', 239, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (40, 'Welcome to Paradise', 224, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (41, 'Pulling Teeth', 151, 6);
insert into Canciones (cod_album, nombre, duracion, album) values (42, 'Basket case', 181, 6);

/* Inserts en persona para luego hacer updates en su apartado*/
insert into Persona (nombre, sexo, edad) values('Persona1', 'H', 57);
insert into Persona (nombre, sexo, edad) values('Persona2', 'H', 76);
insert into Persona (nombre, sexo, edad) values('Persona3', 'M', 34);
insert into Persona (nombre, sexo, edad) values('Persona4', 'H', 23);
insert into Persona (nombre, sexo, edad) values('Persona5', 'H', 65);
insert into Persona (nombre, sexo, edad) values('Persona6', 'M', 57);
insert into Persona (nombre, sexo, edad) values('Persona7', 'M', 32);
insert into Persona (nombre, sexo, edad) values('Persona8', 'H', 45);