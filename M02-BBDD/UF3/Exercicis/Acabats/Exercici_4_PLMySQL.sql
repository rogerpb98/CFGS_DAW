use sakila;
/*Ejercicios Procedimientos y funciones.  BBDD Videoclub.
El Objetivo de este proyecto es consolidar la teor�a sobre 
procedimientos y funciones vistos en clase.*/

/*Ejercicio 1
Crea un procedimiento proc1 que visualice todas las películas cuyo 
coste de reemplazo sea superior a un valor que se pasará como 
parámetro de entrada. 
¿Cuántas películas tienen un coste de reemplazo superior a 20�?*/
drop procedure if exists proc1;
delimiter //
create procedure proc1(in coste int)
begin
    select count(replacement_cost) from film where replacement_cost>coste;
end //
delimiter ;

call proc1(20);

/*Ejercicio 2
Crea un procedimiento ex2 que visualice todas las películas 
cuyo coste de reemplazo está comprendido entre dos cantidades 
que se pasarán como parámetros de entrada. 
¿Cuántas películas tienen un coste de reemplazo superior a 
20� y 21,99 �?*/
drop procedure if exists proc2;
delimiter //
create procedure proc2(in costeMin float, in costeMax float)
begin
    select count(replacement_cost) from film where replacement_cost>costeMin and replacement_cost<costeMax;
end //
delimiter ;

call proc2(20, 21.99);

/*Ejercicio 3
Crear una función ex3 que retorne el número de actor de la 
tabla actor, pasando como parámetros el apellido y nombre.*/
drop function if exists ex3;
delimiter //
create function ex3(nombre varchar(45), apellido varchar(45)) returns smallint unsigned
begin
    declare numeroActor int;
    set numeroActor = (select actor_id from actor where first_name=nombre and last_name=apellido);
    return numeroActor;
end //
delimiter ;

select ex3("jayne", "silverstone");
select ex3("reese", "west");
select ex3("al", "garland");

/*Ejercicio 4
Crea un procedimiento ex4 que visualice las películas cuya 
categoría (comedy, drama,... ) se pasa como parámetro. 
Llama después a este procedimiento para obtener todas 
las películas de la categoría drama y de la categoría comedia. 
¿ Qué ventaja le encuentras a realizar esta consulta de esta 
forma a realizarla de forma directa a trav�s de sentencias SQL?*/
drop procedure if exists ex4;
delimiter //
create procedure ex4(in categoria varchar(25))
begin
    select film.title from film, film_category, category where film_category.film_id = film.film_id and film_category.category_id = category.category_id and category.name = categoria;
end //
delimiter ;

call ex4('comedy');
call ex4('drama');

/*Ejercicio 5.1
Crea un procedimiento ex51 que pase dos parámetros de entrada, 
identificador de categoría e identificador de actor y 
obtenga los datos de las películas sobre esa categoría en 
las que ha trabajado ese actor. 
Prueba el ejemplo con el actor 182 y la categoría 2.*/
drop procedure if exists ex51;
delimiter //
create procedure ex51(in idcategoria smallint unsigned, in idactor smallint unsigned)
begin
	select film.* from film_actor, actor, film, film_category, category where film_actor.actor_id=actor.actor_id and film_actor.film_id=film.film_id and film_category.film_id = film.film_id and film_category.category_id = category.category_id and category.category_id = idcategoria and actor.actor_id = idactor;
end //
delimiter ;

call ex51(2, 182);

/*Ejercicio 5.2
Modifica el procedimiento para que tenga 3 parámetros de entrada, 
nombre, apellidos del actor y nombre de la categoría y visualice 
para un determinado actor y una determinada categoría, las 
películas en las que ha trabajado (realiza este procedimiento 
primero sin utilizar el ejercicio anterior y luego utilizándolo).
Utiliza cualquiera de los dos procedimientos que has creado en 
este ejercicio para encontrar todas las películas de animación 
en las que ha trabajado el actor DEBBIE AKROYD. 
Busca ahora todas las películas Documentales en las que ha 
trabajado el actor ED CHASE*/
/*Version 1*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in nombreActor varchar(45), in apellidoActor varchar(45), in categoriaPeli varchar(25))
begin
    select film.title from film, actor, category, film_actor, film_category where
    actor.first_name = nombreActor and
    actor.last_name = apellidoActor and
    category.name = categoriaPeli and

    actor.actor_id = film_actor.actor_id and
    film.film_id = film_actor.film_id and
    film.film_id = film_category.film_id and
    category.category_id = film_category.category_id;

end //
delimiter ;

call ex52('DEBBIE', 'AKROYD', 'animation');
call ex52('ED', 'CHASE', 'documentary');

/*Ejercicio 6
Crea un procedimiento que tenga un parámetro de entrada que será 
el nombre de la categoría y un parámetro de salida que conTendrá 
el número de películas para esa categoría.*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in categoriaPeli varchar(25))
begin
    select count(film.film_id) from film, category, film_category where
    category.name = categoriaPeli and
    film.film_id = film_category.film_id and
    category.category_id = film_category.category_id;

end //
delimiter ;

call ex52('animation');
call ex52('documentary');

/*Ejercicio 7
Escribir un procedimiento que permita borrar un actor cuyo 
identificador se pasará como parámetro. Si el actor cuyo número 
se ha pasado como parámetro no existe, aparecerá un mensaje 
diciendo "Ese actor no existe". Comprueba el funcionamiento 
del procedimiento. ¿Qué ocurre cuando tratas de borrar un actor 
que ya existe? ¿Porqué?*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in idActor smallint(5))
begin
    if 0=(select count(*) from actor where actor_id=idActor) then
        select 'Ese actor no existe';
    else
        delete from actor where actor_id=idActor;
    end if;
end //
delimiter ;

call ex52(523);
call ex52(1);
/*Cuando trato de eliminar un actor no deja, ya que hay campos en otras tablas
Que referencian a dichos actores*/

/*Ejercicio 8
Escribir un procedimiento que añada una nueva entrada a la tabla 
film_category que guarda la categoría/s a la/s que pertenece 
cada películas. El procedimiento recibirá como parámetros el 
identificador de película y el nombre de la categoría. 
Deberán tenerse en cuenta las siguientes situaciones:
1.	Si no existe el film correspondiente al número pasado como 
parámetro, se mostrará un mensaje diciendo 
"El film con no x no existe" en x debe aparecer el número de 
film pasado como parámetro y se abandonará el procedimiento.
2.	Si no existe la categoría pasada como parámetro, se mostrará 
un mensaje diciendo 'la categoría x no existe' donde x será el 
nombre de la categoría pasada como parámetro y se abandonará el 
procedimiento.
3.	Si ya existe la entrada o fila que se pretende añadir a 
film_category, aparecerá un mensaje diciendo el film x ya 
pertenece a esa categoría. En caso contrario se procederá a dar 
de alta la fila en la tabla film_category.
4.	Comprueba finalmente el procedimiento anterior para ver el 
funcionamiento de las distintas situaciones.
NOTA: no utilices HANDLERS*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in idFilm smallint unsigned, in nomCategoria varchar(25))
begin
    declare existePeli tinyint default (select count(*) from film where film_id=idFilm);
    declare existeCategoria tinyint default (select count(*) from category where name=nomCategoria);
    declare idCategoria tinyint default (select category_id from category where name=nomCategoria);
    declare existeEntrada tinyint default (select count(*) from film_category where film_id=idFilm and category_id=idCategoria);


    if existePeli=0 then
        select 'El film con no ',idFilm,' no existe';
    elseif existeCategoria=0 then
        select 'La categoria ',nomCategoria,' no existe';
    elseif existeEntrada=1 then
        select "El film x ya pertenece a esa categoría";
    else
        insert into film_category (film_id, category_id) values(idFilm, idCategoria);
    end if;
end //
delimiter ;

call ex52(1438, 'Travel'); /*Film no existe*/
call ex52(10, 'noexiste'); /*Categoria no existe*/
call ex52(989, 'Travel'); /*Entrada existe*/
call ex52(989, 'Sports'); /*Se puede*/

/*Ejercicio 9
Crear un procedimiento en el que se introduzca el identificador 
de una película y nos devuelva en un parámetro de salida si es 
de corta duración (lenght<50), media duración((50<lenght<120) 
o larga duración (lenght>120). Comprueba que tipo de duración 
tienen las películas 1, 12 y 100*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in idPeli smallint(5), out tipo varchar(15))
begin
    declare duracion smallint(5) default (select length from film where film_id=idPeli);
    if duracion<50 then
        set tipo = 'corta duracion';
    elseif duracion>50 and duracion<120 then
        set tipo = 'media duracion';
    elseif duracion>120 then
        set tipo = 'larga duracion';
    end if;
end //
delimiter ;

call ex52(1, @duracion);
select @duracion;
call ex52(12, @duracion);
select @duracion;
call ex52(100, @duracion);
select @duracion;

/*Ejercicio 10
Realiza un procedimiento en el que se pasen como parámetros el 
identificador, nombre y apellidos de un actor y lo inserte en 
la tabla actor. ¿qué ocurre si tratas de insertar un actor con 
un identificador que ya existe? Modifica el procedimiento anterior 
tratándose esta condición (clave duplicada). En ese caso el 
procedimiento deberá finalizar y mostrar el mensaje el 
identificador de actor ya existe. Probar el procedimiento 
primero con los datos (1,'luis','lopez') y luego con los 
datos (300,'luis','lopez')*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in idActor smallint, in nomActor varchar(45), in cognomActor varchar(45))
begin
    declare claveDuplicada tinyint default (select count(*) from actor where idActor=actor_id);
    if claveDuplicada=1 then
        select 'El identificador ya existe';
    else
        insert into actor (actor_id, first_name, last_name) values (idActor, nomActor, cognomActor);
    end if;
end //
delimiter ;

call ex52(1,'luis','lopez');
call ex52(300,'luis','lopez');

/*Ejercicio 11
Crea un procedimiento con dos parámetros de entrada, nombre y apellidos, para 
borrar un actor de la tabla actor. Trata ahora de borrar un actor ¿qué ocurre? 
Modifica ahora el procedimiento realizando el tratamiento de los posibles errores 
con los correspondientes mensajes. (Ten en cuenta que pueden darse dos posibles 
errores, que el actor no exista, o que el actor está en otra tabla relacionado).
Comprueba el funcionamiento del procedimiento con los valores
Actor: ED CHASE
Actor: ALVARO LOPEZ
Inserta en la tabla actor la entrada (800, Julio, Perez) y aplica 
luego a este actor el procedimiento ¿Lo ha borrado? ¿Porqué?*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in nomActor varchar(45), in cognomActor varchar(45))
begin
    declare existeixActor tinyint default (select count(*) from actor where first_name=nomActor and last_name=cognomActor);
    
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' select 'esta referenciado en otro lado';
    if existeixActor=0 then
        select 'El actor no existe';
    else
        insert into actor (first_name, last_name) values (nomActor, cognomActor);
    end if;
end //
delimiter ;

call ex52('ed','chase');
call ex52('alvaro','lopez');
insert into actor (actor_id, first_name, last_name) values (800, 'Julio', 'Perez');
call ex52('Julio','Perez');
/*Si lo borra, porque es un actor que no esta referenciado en ninguna otra tabla*/


/*Ejercicio 12
Crea un procedimiento para añadir un nuevo registro a la tabla 
film_actor, recibirá como parámetros de entrada el título de la 
película, nombre y apellidos del actor realiza el tratamiento de 
todos los posibles errores que puedan producirse.
·	Si el actor no existe, debe aparecer el mensaje el actor xxxxx 
	no existe y salir del procedimiento.
·	Si la película no existe, debe aparecer el mensaje la película 
	xxxx, no existe en la BD y se saldrá del procedimiento.
·	Si la entrada ya existe en la tabla film-actor, deberá aparecer 
	un mensaje, 'entrada duplicada'
Realiza las siguientes llamadas al procedimiento con estos datos y comprueba el funcionamiento.
película: ALIEN CENTER Actor ED CHASE debe hacer una inserción correcta
película: ALIEN CENTER3 Actor ED CHASE debe aparecer el mensaje la película no existe en la BD
película: ALIEN CENTER Actor ED1 CHASE1 debe aparecer el mensaje el actor no existe en la BD
película: ALONE TRIP Actor ED CHASE debe aparecer el mensaje, entrada duplicada en la tabla film-actor*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in tituloPeli varchar(255), in nomActor varchar(45), in cognomActor varchar(45))
begin
    declare existeixActor tinyint default (select count(*) from actor where first_name=nomActor and last_name=cognomActor);
    declare existeixPeli tinyint default (select count(*) from film where tituloPeli=title);
    declare idPeli smallint default (select film_id from film where title=tituloPeli);
    declare idActor smallint default (select actor_id from actor where first_name=nomActor and last_name=cognomActor);
    declare entradaExiste tinyint default (select count(*) from film_actor where film_id=idPeli and actor_id=idActor);

    if existeixActor=0 then
        select 'El actor ',nomActor,' ',cognomActor,' no existe';
    elseif existeixPeli=0 then
        select 'La película ',tituloPeli,' no existe';
    elseif entradaExiste=1 then
        select 'Entrada duplicada';
    else
        insert into film_actor (actor_id, film_id) values (idActor, idPeli);
    end if;
end //
delimiter ;

call ex52('ALIEN CENTER','ED','CHASE');
call ex52('ALIEN CENTER3','ED','CHASE');
call ex52('ALIEN CENTER','ED1','CHASE1');
call ex52('ALONE TRIP','ED','CHASE');

/*Ejercicio 13
Crear un procedimiento que actualice el coste de reemplazo de las 
películas de una determinada categoría. 
Tendrá tres parámetros de entrada, el nombre de la categoría, 
un importe y un porcentaje. La subida será el porcentaje o el 
importe que se indica en el parámetro (el que sea superior.)*/
drop procedure if exists ex52;
delimiter //
create procedure ex52(in nomCategoria varchar(25), in importe decimal(4,2), in porcentaje int)
begin
    declare condicion tinyint default 1;
    declare idPeli int;
    declare idCategoria int default (select category_id from category where name=nomCategoria);
    declare aumentoPorcentaje decimal(4,2);

    declare cursorPeliculas cursor for select film_id from category, film_category where film_category.category_id=idCategoria;

    DECLARE exit HANDLER FOR SQLSTATE '02000' set condicion = 0; 

    open cursorPeliculas;
    fetch cursorPeliculas into idPeli;
    while condicion>0 do
        set aumentoPorcentaje = (select (rental_rate*porcentaje/100) from film where idPeli=film_id);
        select aumentoPorcentaje, importe;
        if importe<aumentoPorcentaje then
            update film set rental_rate=rental_rate+importe where film_id=idPeli;
        else
            update film set rental_rate=rental_rate+aumentoPorcentaje where film_id=idPeli;
        end if;
        fetch cursorPeliculas into idPeli;
    end while;
    close cursorPeliculas;
end //
delimiter ;

call ex52('Comedy', 2.4, 5);