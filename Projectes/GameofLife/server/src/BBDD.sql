/* creación de base de datos del programa GAME OF LIFE*/
use mysql;
drop user 'conway'@'localhost';
create user 'conway'@'localhost' IDENTIFIED BY '1234';
grant all privileges on *.* to 'conway'@'localhost';

create database if not exists BBDD;

use BBDD;

create table if not exists logins (
    usuario VARCHAR (20) not null primary key,
    password VARCHAR (255) not null
);
