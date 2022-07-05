DROP DATABASE IF EXISTS jauth;
CREATE DATABASE IF NOT EXISTS jauth;
drop user if exists 'jauth'@'localhost';
create user 'jauth'@'localhost' identified by '1234';
GRANT ALL PRIVILEGES ON *.* TO 'jauth'@'localhost';
use jauth;

DROP TABLE IF EXISTS Teachers;
DROP TABLE IF EXISTS Fichar;

CREATE TABLE Teachers(
    id varchar(128) PRIMARY KEY,
    user_name varchar(24) UNIQUE,
    name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    email VARCHAR(25)
);
CREATE TABLE Fichar(
    teacher_id varchar(128) NOT NULL,
    hora TIMESTAMP NOT NULL,
    tipo ENUM('Entrada','Salida'),

    FOREIGN KEY (teacher_id) REFERENCES Teachers(id)
);

INSERT INTO Teachers (id, name, last_name, pwd) VALUES ('mco7','Pepe','Villuela','pepitoloco123');
INSERT INTO Teachers (id, name, last_name, pwd) VALUES ('meg4c9','Agustín','Hernandez','ahahahah');
INSERT INTO Teachers (id, name, last_name, pwd) VALUES ('4wn36','Antonia','Benito','abenitoaaa');
INSERT INTO Teachers (id, name, last_name, pwd) VALUES ('3f8j9','Maria','Del Carmen','mariadelc123');

INSERT INTO Fichar VALUES ('mco7','2022-01-01 10:30:35','Entrada');
INSERT INTO Fichar VALUES ('mco7','2022-01-01 15:05:18','Salida');
