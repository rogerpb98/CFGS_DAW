/*
source ~/UF2_BBDD/altaconcesionarios.sql
*/
SET AUTOCOMMIT=1;

DROP DATABASE IF EXISTS concesionario;

CREATE SCHEMA IF NOT EXISTS concesionario charset utf8;

USE concesionario; 

/************CREACION DE TABLAS************/
\! echo "Creación de la tabla Cliente:";
CREATE TABLE IF NOT EXISTS concesionario.CLIENTE (
        identificador TINYINT  UNSIGNED AUTO_INCREMENT,
        tipo          ENUM('Particular','Empresa') NOT NULL,
        nombre        VARCHAR(20)   NOT NULL,
        apellido      VARCHAR(20)   NULL,
        telefono      CHAR(9)       NOT NULL,
        cuenta        CHAR(20)      NOT NULL,

        PRIMARY KEY (identificador)
);
\! echo "Creación de la tabla Concesionario:";
CREATE TABLE IF NOT EXISTS concesionario.CONCESIONARIO (
        codigo               TINYINT      UNSIGNED AUTO_INCREMENT,
        nombre 	             VARCHAR(20)  NOT NULL,
        fecha_inauguracion   DATE         NOT NULL,
        direccion            VARCHAR(35)  NOT NULL,
        telefono             CHAR(9)      NOT NULL,
        marca                VARCHAR(15)  NOT NULL,

        PRIMARY KEY (codigo)
);

\! echo "Creación de la tabla Marca:";
CREATE TABLE IF NOT EXISTS concesionario.MARCA (
        nombre VARCHAR(15) NOT NULL,
        concesionario_principal TINYINT UNSIGNED NOT NULL,

        PRIMARY KEY (nombre),
        FOREIGN KEY (concesionario_principal) REFERENCES CONCESIONARIO(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

\! echo "Creación de la tabla Vendedor:";
CREATE TABLE IF NOT EXISTS concesionario.VENDEDOR (
        codigo           SMALLINT UNSIGNED AUTO_INCREMENT,
        nombre           VARCHAR(10) NOT NULL,
        telefono         CHAR(9)  NOT NULL,
        jefe             SMALLINT UNSIGNED NULL,
        concesionario    TINYINT  UNSIGNED NOT NULL,

        PRIMARY KEY (codigo),

        FOREIGN KEY (concesionario) REFERENCES CONCESIONARIO(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

\! echo "Creación de la tabla Modelo:";
CREATE TABLE IF NOT EXISTS concesionario.MODELO (
        marca     VARCHAR(15) NOT NULL,
        modelo    VARCHAR(10) NOT NULL,
        pvr       MEDIUMINT   NOT NULL,

        PRIMARY KEY (modelo, marca),
        FOREIGN KEY (marca) REFERENCES MARCA(nombre) ON DELETE CASCADE ON UPDATE CASCADE
);

\! echo "Creación de la tabla Coche:";
CREATE TABLE IF NOT EXISTS concesionario.COCHE (
        marca           VARCHAR(15) NOT NULL,
        modelo          VARCHAR(10) NOT NULL,
        numero          CHAR(3),
        color           VARCHAR(12) NOT NULL,
        puertas         ENUM('3', '5') NOT NULL,
        cilindrada      CHAR(7) NOT NULL,
        matricula       CHAR(7) UNIQUE,
        concesionario   TINYINT UNSIGNED NOT NULL,

        PRIMARY KEY (numero, marca, modelo),
        FOREIGN KEY (marca, modelo) REFERENCES MODELO(marca, modelo) ON DELETE CASCADE ON UPDATE CASCADE,

        FOREIGN KEY (concesionario) REFERENCES CONCESIONARIO(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

\! echo "Creación de la tabla Venta:";
CREATE TABLE IF NOT EXISTS concesionario.VENTA (
        marca      VARCHAR(15) NOT NULL,
        modelo     VARCHAR(10) NOT NULL,
        coche      CHAR(3),
        cliente    TINYINT UNSIGNED NOT NULL,
        vendedor   SMALLINT UNSIGNED NOT NULL,
        fecha      DATE NOT NULL,
        precio     MEDIUMINT NOT NULL,

        PRIMARY KEY (marca, modelo, coche),
        FOREIGN KEY (marca, modelo, coche)  REFERENCES COCHE(marca, modelo, numero) ON DELETE CASCADE ON UPDATE CASCADE,

        FOREIGN KEY (cliente)  REFERENCES CLIENTE(identificador) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (vendedor) REFERENCES VENDEDOR(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

\! echo "Creación de la tabla Catalogo:";
CREATE TABLE IF NOT EXISTS concesionario.CATALOGO (
        concesionario  TINYINT UNSIGNED NOT NULL,
        marca          VARCHAR(15) NOT NULL,
        modelo         VARCHAR(10) NOT NULL,

        PRIMARY KEY (concesionario, marca, modelo),
        FOREIGN KEY (concesionario) REFERENCES CONCESIONARIO(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (marca)  REFERENCES MARCA(nombre) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (modelo) REFERENCES MODELO(modelo) ON DELETE CASCADE ON UPDATE CASCADE
);




\! echo "20 Inserts en la tabla Cliente (10 Particulares y 10 Empresas):";
/*Particulares*/
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Mateo',     'García',     '663827594',  '49171329434679619603');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Soledad ',  'Jiménez',    '663827594',  '84035875085188224129');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Adella',    'Molina',     '663827594',  '76818477771664307153');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Emiliano',  'Gutiérrez',  '663827594',  '66113840319333607489');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Araceli',   'Gil',        '663827594',  '64643877550905739317');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Ruth',      'Morales',    '663827594',  '36849550206319020778');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Heraclio',  'Molina',     '663827594',  '01560151543466134796');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Ximena',    'García',     '663827594',  '17567991346579921478');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Gerald',    'Muñoz',      '663827594',  '74172060100886135279');
INSERT INTO concesionario.CLIENTE (tipo, nombre, apellido, telefono, cuenta) VALUES ('Particular',  'Michelle',  'Sánchez',    '663827594',  '21880551987386011335');
/*Empresas*/
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Coches Pepito',      '619958248', '30004728833753060730');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Desguace Impostor',  '673358507', '66087609368090687426');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Cochelín',           '698172723', '95203882954403254508');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'BrumBrum',           '639247083', '32630085713836314903');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Mekedo',             '622864114', '78797604580838704470');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Sinideas',           '642633050', '96549551699120672781');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Paranombres',        '688087644', '43556863002981107460');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Dempresas',          '668106779', '58118120970794972382');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Asiquestos',         '699625343', '60068036012297775161');
INSERT INTO concesionario.CLIENTE (tipo, nombre, telefono, cuenta) VALUES ('Empresa', 'Sonrandom',          '654596539', '46165753686897821182');

\! echo "12 Inserts en la tabla Concesionario:";
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Automus',   '2010-11-01', 'Carrer Taquígraf Garriga, 23', '935130146', 'Toyota');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Collabcar', '2007-03-24', 'Carrer Trafalgar, 12',         '935261216', 'Opel');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Parkiing',  '2015-05-08', 'Carrer Sant Elíes, 51',        '932574564', 'Seat');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Rightcar',  '2010-07-11', 'Carrer Cabanes, 35',           '939169973', 'Ford');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Accella',   '2014-10-24', 'Carrer Calàbria, 63',          '933984460', 'Volkswagen');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Motory',    '2012-11-22', 'Carrer Espronceda, 36',        '937270440', 'Renault');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Autost',    '2007-01-01', 'Carrer Tuset, 66',             '930087037', 'Seat');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Petrolley', '2015-09-17', 'Carrer Ganduxer, 29',          '933005420', 'Volkswagen');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Protor',    '2008-12-14', 'Carrer Ausiàs March, 11',      '937597811', 'Renault');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Percar',    '2014-12-15', 'Carrer Hondures, 1',           '936056534', 'Toyota');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Automobex', '2010-07-13', 'Carrer Jaume Pinent, 87',      '937582802', 'Opel');
INSERT INTO concesionario.CONCESIONARIO (nombre, fecha_inauguracion, direccion, telefono, marca) VALUES ('Driverly',  '2015-05-21', 'Carrer Girona, 112',           '937184811', 'Opel');

/*Insertamos los campos para cada marca*/
\! echo "6 Inserts en la tabla Marca:";
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Toyota', 1);
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Opel', 12);
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Ford', 4);
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Seat', 3);
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Volkswagen', 5);
INSERT INTO concesionario.MARCA (nombre, concesionario_principal) VALUES ('Renault', 6);

/*Añadimos ahora la clave foranea a concesionario ya que si lo hacemos antes, peta al hacer los enteriores inserts*/
\! echo "Añadir las claves foraneas que no nos permitías al momento de crear sus tablas:";
ALTER TABLE concesionario.CONCESIONARIO
ADD FOREIGN KEY (marca) REFERENCES concesionario.MARCA(nombre) ON DELETE CASCADE ON UPDATE CASCADE;

/*Insertamos los campos para cada vendedor*/
\! echo "20 Inserts en la tabla Vendedor:";
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Mariano',    '638669007', null, 1);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Angel',      '639281130', null, 2);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Simplicio',  '610805724', null, 3);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Ezequiel',   '678324721', null, 4);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Eleonor',    '682994537', null, 5);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Natacha',    '657183040', null, 6);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Erica',      '673470247', 3,    7);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Estanislao', '658215791', 5,    8);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Evaristo',   '659967873', 6,    9);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Amparo',     '615027076', 1,    10);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Esmeralda',  '655871270', 2,    11);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Modesta',    '600283641', 2,    12);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Sancho',     '617112070', 2,    2);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Fabian',     '614235447', 4,    4);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Silvestre',  '688346781', 1,    10);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Fatima',     '601270124', 3,    7);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Zulema',     '665482377', 3,    3);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Arduino',    '660336146', 4,    4);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Eunice',     '655370727', 2,    11);
INSERT INTO concesionario.VENDEDOR (nombre, telefono, jefe, concesionario) VALUES ('Martiniano', '607176661', 1,    10);

\! echo "12 Inserts en la tabla Modelo:";
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Toyota',      'Corolla', 74000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Toyota',      'Yaris',   15000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Opel',        'Astra',   51000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Opel',        'Corsa',   59000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Seat',        'León',    32000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Seat',        'Ibiza',   45000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Ford',        'Fiesta',  94000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Ford',        'Focus',   92000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Volkswagen',  'Polo',    20000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Volkswagen',  'Golf',    76000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Renault',     'Clio',    67000);
INSERT INTO concesionario.MODELO (marca, modelo, pvr) VALUES ('Renault',     'Captur',  43000);

\! echo "17 Inserts en la tabla Coche:";
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Toyota',     'Corolla', 'Azul',  '5', 120, 1);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('2','Toyota',     'Corolla', 'Verde', '5', 120, 10);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('3','Toyota',     'Corolla', 'Verde', '5', 120, 1);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Toyota',     'Yaris',   'Rojo',  '3', 100, 10);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Opel',       'Astra',   'Azul',  '5', 120, 12);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('2','Opel',       'Astra',   'Negro', '3', 120, 2);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('3','Opel',       'Astra',   'Rojo',  '5', 120, 2);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Opel',       'Corsa',   'Rojo',  '3', 125, 2);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Seat',       'Ibiza',   'Azul',  '3', 125, 3);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Seat',       'León',    'Azul',  '5', 125, 7);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Ford',       'Fiesta',  'Negro', '3', 130, 4);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Ford',       'Focus',   'Azul',  '3', 135, 4);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Volkswagen', 'Polo',    'Negro', '5', 135, 5);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Volkswagen', 'Golf',    'Azul',  '5', 125, 8);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('2','Volkswagen', 'Golf',    'Rojo',  '3', 125, 5);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Renault',    'Clio',    'Negro', '5', 115, 9);
INSERT INTO concesionario.COCHE (numero, marca, modelo, color, puertas, cilindrada, concesionario) VALUES ('1','Renault',    'Captur',  'Negro', '3', 135, 6);

\! echo "10 Inserts en la tabla Venta:";
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Toyota',     'Corolla', '3', 5,  20, '2015-11-21', 80000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Toyota',     'Corolla', '2', 2,  15,  '2016-11-21', 78000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Seat',       'Ibiza',   '1', 13, 16,  '2015-11-21', 40000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Volkswagen', 'Polo',    '1', 3,  5,  '2017-11-21', 22000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Volkswagen', 'Golf',    '2', 15, 5,  '2015-11-21', 70000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Toyota',     'Corolla', '1', 5,  20, '2016-11-21', 76000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Toyota',     'Yaris',   '1', 2,  1,  '2015-11-21', 14500);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Seat',       'León',    '1', 13, 16,  '2017-11-21', 35000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Volkswagen', 'Golf',    '1', 3,  8,  '2016-11-21', 82000);
INSERT INTO concesionario.VENTA (marca, modelo, coche, cliente, vendedor, fecha, precio) VALUES ('Renault',    'Captur',  '1', 15, 9,  '2017-11-21', 38000);

\! echo "18 Inserts en la tabla Catalogo:";
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (1,  'Toyota',     'Corolla');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (2,  'Opel',       'Astra');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (3,  'Seat',       'Ibiza');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (4,  'Ford',       'Fiesta');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (5,  'Volkswagen', 'Golf');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (6,  'Renault',    'Clio');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (7,  'Seat',       'León');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (8,  'Volkswagen', 'Golf');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (9,  'Renault',    'Clio');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (10, 'Toyota',     'Yaris');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (11, 'Opel',       'Astra');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (12, 'Opel',       'Astra');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (2,  'Opel',       'Corsa');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (3,  'Seat',       'León');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (4,  'Ford',       'Focus');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (5,  'Volkswagen', 'Polo');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (11, 'Opel',       'Corsa');
INSERT INTO concesionario.CATALOGO (concesionario, marca, modelo) VALUES (12, 'Opel',       'Corsa');
