/*
\c botiga -> use botiga
\dt -> show tables
drop database botiga
create database botiga
*/
DROP DATABASE botiga;
CREATE DATABASE botiga;

\c botiga;

CREATE TABLE UUSER (
    user_name varchar(35),
    password varchar(255) NOT NULL,
    email varchar(200) NOT NULL,

    PRIMARY KEY(user_name)
);

CREATE TABLE PRODUCT (
    product_id INT GENERATED ALWAYS AS IDENTITY,
    product_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price REAL NOT NULL,
    owner varchar(35),

    PRIMARY KEY (product_id),
    CONSTRAINT fk_uuser
        FOREIGN KEY(owner)
            REFERENCES UUSER(user_name)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
-- insert into product values ('batidora','batidora superchula',10);
-- insert into product values ('freidora','freidora superchula',10);