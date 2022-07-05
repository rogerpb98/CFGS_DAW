CREATE TABLE UUSER (
 email varchar(200) PRIMARY KEY,
 password varchar(200) NOT NULL
);
insert into uuser values ('pepe.potamo@jda','hdjfkflslsjdhfg');

CREATE TABLE CATEGORY (
    name VARCHAR(100) PRIMARY KEY
);
insert into category values ('hogar');
insert into category values ('informatica');
insert into category values ('ocio');
CREATE TABLE PRODUCT (
    product_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price REAL NOT NULL,
    category VARCHAR(100),
    email VARCHAR(200)
);
insert into product values ('batidora','batidora superchula',10,'hogar','pepe.potamo@jda');
insert into product values ('freidora','freidora superchula',10,'hogar','homer.simpsom@jda');