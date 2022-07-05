/*Ejercicios Triggers*/

/*Ejercicio 1
Muestra los triggers de la BD sakila de dos formas diferentes.  
Haz lo mismo con la BD world.*/
show triggers \G;
use information_schema;
select * from triggers where trigger_schema='sakila' \G;
select * from triggers where trigger_schema='world' \G;
/*Ejercicio 2
Con la información que muestra la tabla TRIGGERS de 
information_schema, ¿Qué tipo de evento y cuando disparan los 
triggers costumer_create_date, ins_film, upd_film, del_film?*/

/*costumer_create_date  Tipo: insert    Cuando: Antes*/
/*ins_film              Tipo: insert    Cuando: Despues*/
/*upd_film              Tipo: update    Cuando: Despues*/
/*del_film              Tipo: delete    Cuando: Despues*/

/*Ejercicio 3
Visualiza los triggers de la tabla film. ¿Cuántos tiene?*/
select count(*) from triggers where trigger_schema='sakila' and event_object_table='film' \G;

/*Ejercicio 4
Escribe un disparador que muestre un mensaje 
cualquiera al realizar una  inserción en la tabla 
empresa.CLIENTES.*/
use empresa;
DELIMITER //
CREATE TRIGGER insertClientes after insert on cliente for each row
begin
    declare mensaje varchar(50);
    select 'cualquier mensaje' into mensaje;
end //
DELIMITER ;

/*Ejercicio 5
Escribe un disparador que contabilice -utilizando una tabla aparte- el número  de modificaciones que sufre la tabla comanda.*/
CREATE TABLE IF NOT EXISTS empresa.estadisticas (
        clave char(25),
        suma int,

        PRIMARY KEY (clave)
);
insert into estadisticas values ('modificaciones',0);
/****en cada insert*/
DELIMITER //
CREATE TRIGGER EjTrigger2 after insert on comanda for each row
begin
    update estadisticas set suma=suma+1 where clave='modificaciones';
end //
DELIMITER ;
/****en cada update**/
DELIMITER //
CREATE TRIGGER EjTrigger3 after update on comanda for each row
begin
    update estadisticas set suma=suma+1 where clave='modificaciones';
end //
DELIMITER ;
/****en cada delete**/
DELIMITER //
CREATE TRIGGER EjTrigger4 after delete on comanda for each row
begin
    update estadisticas set suma=suma+1 where clave='modificaciones';
end //
DELIMITER ;

/*Ejercicio 6
Escribe un disparador que acumule en una variable de usuario la suma 
de los  "totales" de la tabla comanda cada vez que haya una inserción.*/
SET @totales=0;
DROP TRIGGER IF EXISTS InsertSuma;
DELIMITER //
CREATE TRIGGER InsertSuma after insert on comanda for each row
begin
    set @totales=(SELECT sum(total) from comanda);
end //
DELIMITER ;

/*Ejercicio 7
Escribe un disparador que se active al eliminar un registro en la 
tabla  COMANDA y que reste el valor de TOTAL del registro eliminado a 
la variable  de usuario creada en el ejercicio anterior.*/
DROP TRIGGER IF EXISTS DeleteResta;
DELIMITER //
CREATE TRIGGER DeleteResta after delete on comanda for each row
begin
    set @totales=(SELECT sum(total) from comanda);
end //
DELIMITER ;

/*Ejercicio 8
Escribe un disparador que, cuando se produzca una actualización en  
COMANDA, impida que el campo COM_TIPUS varie.*/
DROP TRIGGER IF EXISTS UpdateSameTipus;
DELIMITER //
CREATE TRIGGER UpdateSameTipus before update on comanda for each row
begin
    if new.com_tipo != old.com_tipo then
        set new.com_tipo = old.com_tipo;
    end if;
end //
DELIMITER ;

/*Ejercicio 9
Construir un disparador de base de datos que permita auditar 
las operaciones de borrado de datos que se realicen en la tabla 
actor según las siguientes especificaciones:
1.	En primer lugar se creará la tabla auditaractor con la 
columna col1 VARCHAR2(200).
2.	Cuando se produzca cualquier borrado de datos en esta 
tabla se insertará una fila en dicha tabla que contendrá:
-Fecha y hora
-Número de actor
-Apellido de actor
Puede aparecer con el siguiente formato : El actor XX de apellido XXXX fue borrado el día XXXXX
3.	Para probar el funcionamiento del trigger, realiza las siguientes operaciones:
	Inserta las siguientes filas en la tabla actor
    (444, 'Sergio', 'Lopez')
    (445, 'Sergio', 'Lopez')
    (446, 'Sergio', 'Lopez')
	Borra primero la primera fila (delete from actor where actor_id=444). Comprueba los cambios en la tabla auditar_actor.
	Borra las dos siguientes filas ( delete from actor where first_name='Sergio'). Comprueba los cambios en la tabla auditar_actor.
*/
use sakila;

CREATE TABLE IF NOT EXISTS sakila.auditaractor (
    col1 VARCHAR(200)
);

DROP TRIGGER IF EXISTS AuditarDeletes;
DELIMITER //
CREATE TRIGGER AuditarDeletes after delete on actor for each row
begin
    insert into auditaractor values (concat('El actor ',old.first_name,' de apellido ',old.last_name,' fue borrado el dia ',current_timestamp()));
end //
DELIMITER ;

insert into actor (actor_id, first_name, last_name) values (444, 'Sergio', 'Lopez');
insert into actor (actor_id, first_name, last_name) values (445, 'Sergio', 'Lopez');
insert into actor (actor_id, first_name, last_name) values (446, 'Sergio', 'Lopez');
delete from actor where actor_id=444;
select * from auditaractor;
delete from actor where first_name='Sergio';
select * from auditaractor;

/*Ejercicio 10
Construir un nuevo disparador de base de datos de forma que 
al borrar una actor introduzca en la tabla auditaractor el 
mensaje 'se ha borrado un actor'.¿Qué ocurre?¿Porqué?*/
DROP TRIGGER IF EXISTS AuditarDeletesMensaje;
DELIMITER //
CREATE TRIGGER AuditarDeletesMensaje after delete on actor for each row
begin
    insert into auditaractor values ('Se ha borrado un actor');
end //
DELIMITER ;
/*No pasa nada raro, creo que en versiones anteriores no se podía, pero ahora sí*/

/*Ejercicio 11
Escribir un trigger de base de datos un que permita auditar 
las modificaciones de nombre y apellidos en la tabla actores 
insertado en la tabla auditaremple los siguientes datos:
-Fecha y hora
-Número de actor
La operación de actualización: MODIFICACIÓN.
El valor anterior y el valor nuevo del nombre y el apellido
Realiza una operación de actualización sobre la tabla actor y 
comprueba los cambios en la tabla tabla1.*/
CREATE TABLE IF NOT EXISTS sakila.auditaremple (
    UpdateDate timestamp,
    ActorID smallint(15),
    OldName varchar(45),
    NewName varchar(45),
    OldApellido varchar(45),
    NewApellido varchar(45)
);

DROP TRIGGER IF EXISTS AuditarUpdates;
DELIMITER //
CREATE TRIGGER AuditarUpdates after update on actor for each row
begin
    insert into auditaremple values (current_timestamp(), old.actor_id, old.first_name, new.first_name, old.last_name, new.last_name);
end //
DELIMITER ;

update actor set first_name='manolito', last_name='manostijeras' where actor_id=307;
select * from auditaremple;

/*Ejercicio 12
Escribir un disparador para la tabla film de modo que cuando 
se realice una operación de actualización el costo de reemplazo 
no pueda sufrir un incremento mayor del 10% es decir si la 
operación de actualización va a suponer un aumento mayor del 
10%, se pondrá como mucho una subida del 10%.
Comprueba el funcionamiento del trigger actualizando por 
ejemplo el costo de reemplazo de la película con 
identificador 1 a un valor de 60 ¿Qué costo de reemplazo 
tiene ahora el film?*/

/*duda old.replacement_cost*/
DROP TRIGGER IF EXISTS UpdateControlIncrement;
DELIMITER //
CREATE TRIGGER UpdateControlIncrement before update on film for each row
begin 
    declare limiteCoste decimal(5,2) default old.replacement_cost+old.replacement_cost*10/100;
    if new.replacement_cost > limiteCoste then
        set new.replacement_cost = limiteCoste;
    end if;
end //
DELIMITER ;

/*Ejercicio 13
Crear un trigger que solo audite las modificaciones de título 
o descripción de la tabla film, de modo que si se ha producido 
una modificación de alguna de las dos columnas, se inserte en 
una nueva tabla el valor antiguo y el nuevo del título y/o la 
descripción. Realiza comprobaciones modificando alguno de los 
dos campos y también haciendo actualizaciones que no afecten a 
uno de esos campos (en este caso el trigger no debe dispararse)*/
CREATE TABLE IF NOT EXISTS sakila.modificaciones_film (
    OldTitle varchar(255),
    NewTitle varchar(255),
    OldDesc text,
    NewDesc text
);

DROP TRIGGER IF EXISTS UpdateTituloDescripcion;
DELIMITER //
CREATE TRIGGER UpdateTituloDescripcion after update on film for each row
begin 
    if old.title != new.title and old.description != new.description then
        insert into modificaciones_film values (old.title, new.title, old.description, new.description);
    elseif old.title != new.title then
        insert into modificaciones_film (OldTitle, NewTitle) values (old.title, new.title);
    elseif old.description != new.description then
        insert into modificaciones_film (OldDesc, NewDesc) values (old.description, new.description);
    end if;
end //
DELIMITER ;

/*Ejercicio 14
Busca el trigger rental_date y explica qué es lo que hace.*/
use information_schema;
select * from triggers where trigger_name='rental_date' \G;

/*
abans d'un insert, cambia la rental date a l'hora actual
*/

/*Ejercicio 15
Busca el trigger ins_film y explica qué es lo que hace.*/
select * from triggers where trigger_name='ins_film' \G;

/*
després d'un insert, inserta els valors que haguem insertat
*/

/*Ejercicio 16
Crear un trigger de modo que cada vez que se haga una 
operación de inserción sobre la tabla country de la BD world, 
automáticamente se calcule por cada continente correspondiente 
a ese país, el número de países y la media de la población de 
esos países. Estos datos se introducirán en una tabla llamada 
estadísticas que tendrá los siguientes campos estadísticas
(continente char(50), numeroPaises int, 
mediaPoblacion int)*/
use world;
drop table if exists estadisticas;
CREATE TABLE IF NOT EXISTS world.estadisticas (
    continente char(50),
    numeroPaises int,
    mediaPoblacion int
);

DROP TRIGGER IF EXISTS InsertCountry;
DELIMITER //
CREATE TRIGGER InsertCountry after insert on country for each row
begin 
    declare continente char(20) default (SELECT continent from country where code = new.code);
    declare numPaises int default (SELECT count(*) from country where continent = continente);
    declare mediaPob int default (SELECT sum(population) from country where code = new.code)/numPaises;

    insert into estadisticas values (continente, numPaises, mediaPob);
end //
DELIMITER ;

insert into country (code, name, continent, region, surfacearea, population, localname, governmentform, code2) values ('AAA', 'AAAAAAAAAA', 'Oceania','AAAAAAAAA', 999.99, 9999999, 'AAAAAAAAA', 'AAAAAAAAAAAAAA', 'AA');
/*Ejercicio 17
Buscar ejemplos de triggers en páginas web y aplicarlos a 
nuestra BD sakila.*/


/*Ejercicio 18
Crea un disparador para que, cada vez que un cliente alquile 
5 películas se le otorgue un préstamo gratuito. (bbdd videoclub)*/
use sakila;
drop table if exists sakila.descuentos;
CREATE TABLE IF NOT EXISTS sakila.descuentos (
    idCliente smallint(5) unsigned,
    cantidadAlquileres int default 0,
    prestamosGratuitos int default 0,

    PRIMARY KEY (idCliente),
    FOREIGN KEY (idCliente) REFERENCES sakila.customer(customer_id)
);

drop procedure if exists añadirClientesDescuentos;
/*Procedimiento para importar todos los clientes a la tabla de descuentos, 
aplicandoles ya los descuentos acumulados que tengan en base a anteriores alquileres*/
delimiter //
create procedure añadirClientesDescuentos()
begin
    declare cliente_id smallint(5) unsigned;
    declare numAlquileres int unsigned;
    declare numPrestamosGratis int unsigned;

    declare condicion tinyint default 1;

    declare cursorCliente cursor for select customer_id from customer;

    DECLARE continue HANDLER FOR SQLSTATE '02000' set condicion = 0; 

    open cursorCliente;
    fetch cursorCliente into cliente_id;
    while condicion>0 do

        if (select count(idCliente) from descuentos where idCliente=cliente_id)=0 then
            set numAlquileres = (select count(customer_id) from rental where customer_id=cliente_id);
            set numPrestamosGratis = numAlquileres/5;
            set numAlquileres = numAlquileres%5;
            insert into descuentos values (cliente_id, numAlquileres, numPrestamosGratis);
        end if;
        fetch cursorCliente into cliente_id;
    
    end while;
    close cursorCliente;
end //
delimiter ;

DROP TRIGGER IF EXISTS prestamos;
DELIMITER //
CREATE TRIGGER prestamos after insert on rental for each row
begin 
    declare numAlquileres int unsigned default (
        select cantidadAlquileres from descuentos where cliente_id=rental_id
    );
    call añadirClientesDescuentos();
    if numAlquileres+1=5 then
        update descuentos set cantidadAlquileres=0, prestamosGratuitos=prestamosGratuitos+1 where cliente_id=rental_id;
    else 
        update descuentos set cantidadAlquileres=cantidadAlquileres+1;
    end if;
end //
DELIMITER ;

