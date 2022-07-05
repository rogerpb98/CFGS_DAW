drop database m6botiga;

create database m6botiga;

\c m6botiga

CREATE TABLE UUSER (
    email varchar(200) PRIMARY KEY,
    name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    password varchar(200) NOT NULL,
    tlf varchar(9),
    DNI varchar(9),
    adress varchar(100) NOT NULL,
    lat varchar(20),
    long varchar(20)
);
CREATE TYPE CATEGORIES AS ENUM ('Motos', 'Electrodomesticos', 'Videojuegos', 'Plantas', 'Bebidas');
CREATE TABLE PRODUCT (
    product_id SERIAL PRIMARY KEY,
    email_owner varchar(200),
    product_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price REAL NOT NULL,
    category CATEGORIES,
    img VARCHAR(300)
);

insert into UUSER values ('carreroazul@nasa.es', 'Carrero', 'Azul', 'password123', '685734182', '27483912R', 'Calle de las persianas 123', '3465346', '-346554');
insert into UUSER values ('escrotolamo@real.com', 'Crotolamo', 'Es', 'password345', '624687454', '27646734A', 'Calle de las cremalleras 123', '13241234', '-43212');
insert into UUSER values ('espermatrago@real.com', 'Permatrago', 'Es', 'password678', '638597741', '22341562T', 'Calle de Crotolamo 123', '39875654', '-363547654');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('carreroazul@nasa.es',   'batidora',     'batidora superchula',  10,     'Electrodomesticos',    'batidora.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('escrotolamo@real.com',  'zelda botw',   'juegazo super caro',   70,     'Videojuegos',          'zelda.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('espermatrago@real.com', 'geranio',      'pues un geranio',      3,      'Plantas',              'geranio.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('carreroazul@nasa.es',   'pepsi lata',   'diabetes a los 30',    1,      'Bebidas',              'pepsi.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('escrotolamo@real.com',  'Moto',         'muy segura asies',     1000,   'Motos',                'moto.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('carreroazul@nasa.es',   'Bubble Tea',   'pop',                  5,      'Bebidas',              'bbtea.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('espermatrago@real.com', 'Marihuana',    'la planta del diablo', 5,      'Plantas',              'maria.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('escrotolamo@real.com',  'Lean',         'sketit',               7,      'Bebidas',              'lean.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('escrotolamo@real.com',  'Moto 2',       'Motorola Motorola',    1200,   'Motos',                'moto2.png');
insert into PRODUCT (email_owner, product_name, description, price, category, img) values ('espermatrago@real.com', 'Minecraft',    'Ratkid since 2007',    20,     'Videojuegos',          'mc.png');