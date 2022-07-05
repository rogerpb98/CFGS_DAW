drop schema if exists pruebatrigger;
create schema if not exists pruebatrigger;

use pruebatrigger;
drop TABLE IF EXISTS pruebatrigger.persona;
DROP TRIGGER IF EXISTS EjTrigger;
DROP TRIGGER IF EXISTS EjTrigger2;
DROP TRIGGER IF EXISTS EjTrigger3;
DROP TRIGGER IF EXISTS EjTrigger4;

CREATE TABLE IF NOT EXISTS pruebatrigger.persona (
        dni varchar(10),
        salario int,

        PRIMARY KEY (dni)
);

CREATE TABLE IF NOT EXISTS pruebatrigger.estadisticas (
        clave char(10),
        suma int,

        PRIMARY KEY (clave)
);
insert into estadisticas values ('m.salarial',0);


/************en cada insert suma 1 al contador*********************/
SET @num=0;
select @num;
DROP TRIGGER IF EXISTS EjTrigger;
DELIMITER //
CREATE TRIGGER EjTrigger after insert on persona for each row
begin
    set @num=@num+1;
end //
DELIMITER ;
/*******************************************************************/
/**********mantener un total del salario en todos los casos************/
SET @suma=0;
select @suma;

delimiter //
create function salarioMinimo(salario int) returns int
begin
    if salario<950 then
        return 950;
    else
        return salario;
    end if;
end //
delimiter ;

/****en cada insert actualiza el total(suma) de todos los salarios*/
DELIMITER //
CREATE TRIGGER EjTrigger2 before insert on persona for each row
begin
    set new.salario = salarioMinimo(new.salario);
    update estadisticas set suma=suma+new.salario where clave='m.salarial';
end //
DELIMITER ;
/****en cada update actualiza el total(suma) de todos los salarios**/
DELIMITER //
CREATE TRIGGER EjTrigger3 before update on persona for each row
begin
    set new.salario = salarioMinimo(new.salario);
    update estadisticas set suma=suma-old.salario+new.salario where clave='m.salarial';
end //
DELIMITER ;
/****en cada delete actualiza el total(suma) de todos los salarios**/
DELIMITER //
CREATE TRIGGER EjTrigger4 before delete on persona for each row
begin
    update estadisticas set suma=suma-old.salario where clave='m.salarial';
end //
DELIMITER ;



insert into persona values ('a',700);
select * from estadisticas;
insert into persona values ('b',2946);
select * from estadisticas;
insert into persona values ('c',1648);
select * from estadisticas;
insert into persona values ('d',1028);
select * from estadisticas;
insert into persona values ('e',625);
select * from estadisticas;