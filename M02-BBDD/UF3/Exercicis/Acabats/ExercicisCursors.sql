use mysql;

/*1-Escribe un procedimiento que imprima por pantalla el primer
usuario del sistema, sin utilizar variables de control ni handlers*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare cursorUsuarios cursor for select user from user;
    open cursorUsuarios;

    fetch cursorUsuarios into nombreUsuario;
    select nombreUsuario;

    close cursorUsuarios;
end //
delimiter ;

call exCursor();

/*2-Escribe un procedimiento que imprima por pantalla dos 
usuarios del sistema pero sin utilizar ninguna variable 
de control ni handler*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare contador int default 2;
    declare cursorUsuarios cursor for select user from user;

    open cursorUsuarios;
    while contador>0 do

        fetch cursorUsuarios into nombreUsuario;
        select nombreUsuario;
        set contador = contador - 1;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor();

/*3-Escribe un procedimiento que imprima por pantalla todos los 
usuarios del sistema sin que se dispare el error y sin handler 
(contandolos previamente)*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare contador int default (select count(*) from user);
    declare cursorUsuarios cursor for select user, host from user order by user, host;

    open cursorUsuarios;
    while contador>0 do

        fetch cursorUsuarios into nombreUsuario, hostUsuario;
        select nombreUsuario;
        set contador = contador - 1;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor();


/*4-Reescribe el procedimiento anterior pero utiliza un handler 
para evitar el error de "No data -zero rows fetched"*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare condicion int default 1;
    declare cursorUsuarios cursor for select user, host from user order by user, host;
    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorUsuarios;
    while condicion>0 do

        fetch cursorUsuarios into nombreUsuario, hostUsuario;
        select nombreUsuario;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor();


/*5-Reescribe el procedimiento anterior para que muestre no 
solo el usuario sino  también el 'Host' asociado.*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare condicion int default 1;
    declare cursorUsuarios cursor for select user, host from user order by user, host;
    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorUsuarios;
    while condicion>0 do

        fetch cursorUsuarios into nombreUsuario, hostUsuario;
        select nombreUsuario, hostUsuario;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor();

/*6-Escribe un procedimiento que detecte si hay clientes con el 
mismo nombre en empresa.CLIENTE y videoclub.customer.*/
drop procedure if exists exMatching;
delimiter //
create procedure exMatching()
begin
    declare fin int default 0;

    declare customerActual varchar(45);
    declare clienteActual varchar(45);
    declare condicion int default 1;
    declare cursorCustomers cursor for select last_name from sakila.customer order by last_name;
    declare cursorClientes cursor for select apellido from empresa.EMP order by apellido;
    DECLARE exit HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorCustomers;
    open cursorClientes;
    fetch cursorCustomers into customerActual;
    fetch cursorClientes into clienteActual;

    while condicion>0 do
        if customerActual > clienteActual then
            fetch cursorClientes into clienteActual;
        elseif customerActual < clienteActual then
            fetch cursorCustomers into customerActual;
        else
            select 'Match';
            fetch cursorClientes into clienteActual;
            fetch cursorCustomers into customerActual;
        end if;
    end while;
    close cursorCustomers;
    close cursorClientes;
end //
delimiter ;

call exMatching();

/*7-Crea un procedimiento que muestre para cada continente, 
los nombres y la población de los 5 países más poblados. 
Utiliza un cursor que recorra los distintos continentes que 
aparecen en la tabla country*/
use world;

drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare continente char(32);
    declare condicion int default 1;

    declare cursorContinentes cursor for select distinct continent from country;

    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorContinentes;
    while condicion>0 do

        fetch cursorContinentes into continente;
        select name, population from country where continent = continente order by population desc limit 5;
    
    end while;
    close cursorContinentes;
end //
delimiter ;

call exCursor();

/*8-Cursor que muestra un informe como el que se indica en la 
figura, debe mostrar para cada pel�cula de la tabla film, 
los actores que han trabajado en ella.
| ___________________________________                      |
| Actores que han trabajado en ZORRO ARK                   |
| ___________________________________                      |
| IAN TANDY                                                |
| NICK DEGENERES                                           |
| LISA MONROE                                              |
| ___________________________________                      |*/
select film_id, title from film;
select actor_id, film_id from film_actor;
select actor_id, first_name, last_name from actor;

use sakila;

drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nomActor varchar(45);
    declare cognomActor varchar(45);
    declare condicion int default 1;
    declare titol varchar(255);

    declare cursorPeliculas cursor for select title from film;

    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorPeliculas;
    fetch cursorPeliculas into titol;
    while condicion>0 do

        select CONCAT(actor.first_name,' ', actor.last_name) from actor, film_actor, film where film.title=titol and film.film_id=film_actor.film_id and actor.actor_id=film_actor.actor_id;
        fetch cursorPeliculas into titol;

    end while;
    close cursorPeliculas;
end //
delimiter ;

call exCursor();

/*9-Modificar el procedimiento anterior para que muestre los 
actores que han trabajado en cada película pero clasificadas 
por cada una de las categorías*/
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nomActor varchar(45);
    declare cognomActor varchar(45);
    declare categoriaActual varchar(45);
    declare categoriaAComparar varchar(45) default '';
    declare condicion int default 1;
    declare titol varchar(255);

    declare cursorPeliculas cursor for select title, name from film, film_category, category where film.film_id=film_category.film_id and film_category.category_id=category.category_id order by category.category_id desc;

    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorPeliculas;
    fetch cursorPeliculas into titol, categoriaActual;
    while condicion>0 do
        if categoriaAComparar != categoriaActual then
            set categoriaAComparar = categoriaActual;
            select categoriaActual;
        end if;
        select CONCAT(actor.first_name,' ', actor.last_name) from actor, film_actor, film where film.title=titol and film.film_id=film_actor.film_id and actor.actor_id=film_actor.actor_id;
        fetch cursorPeliculas into titol, categoriaActual;

    end while;
    close cursorPeliculas;
end //
delimiter ;

call exCursor();