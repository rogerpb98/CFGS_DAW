/*Cargar en la base de datos World el script BBDD WORLD*/
use world;
/*1. Crea un procedimiento que reciba como parámetros de entrada 
el continente y la lengua y obtenga todos los países de ese 
continente que hablen esa lengua. ¿qué países de Asia tienen 
como lengua entre otras el inglés?
Nota, a pesar de que el campo continente es de tipo enum, 
podemos pasar el continente como tipo varchar porque es compatible.*/
drop procedure if exists ex1;
delimiter //
create procedure ex1(in continente VARCHAR(45), in lengua CHAR(30), out listaPaises VARCHAR(200))
begin
    set listaPaises = (select group_concat(name) from country, countrylanguage 
    where countrylanguage.countrycode=code 
        and countrylanguage.language=lengua
        and continent=continente);
end //
delimiter ;

call ex1('asia', 'english', @llistaPaisos);
select @llistaPaisos;
/*2. Crear una función que calcule el volumen de una esfera cuyo 
radio de tipo FLOAT se pasará como parámetro. 
Realiza una consulta después para calcular el volumen
de una esfera de radio 5*/
drop function if exists ex2;
delimiter //
create function ex2(radio float) returns float
begin
    declare volumen float;
    set volumen = (4*3.14*(pow(22,3))/3);
    return volumen;
end //
delimiter ;

select ex2(5);

/*3. Escribe un procedimiento que reciba una palabra y la 
devuelva escrita del revés. Utiliza para
ello un único parámetro de entrada y salida*/
drop procedure if exists ex2;
delimiter //
create procedure ex2(inout argument VARCHAR(45))
begin
    set argument = reverse(argument);
end //
delimiter ;

set @paraulaReves='Mozambique';
call ex2(@paraulaReves);
select @paraulaReves;

/*4. Crear un PA que cambie la dirección de un un cliente 
(BBDD Empresa), tabla cliente, por otra que se pasará como 
parámetro, el PA recibirá dos parámetros, el identificador del
cliente y la nueva dirección. Ejecutar el PA*/
use empresa;
drop procedure if exists ex4;
delimiter //
create procedure ex4(in codigoCliente int, in direccionCliente VARCHAR(40))
begin
    update CLIENTE set dirección = direccionCliente where cliente_cod=codigoCliente;
end //
delimiter ;

select cliente_cod, dirección from CLIENTE;
call ex4(103, 'mi calle venti tres');
select cliente_cod, dirección from CLIENTE;

/*5. Crear un PA que tenga como parámetros el nombre, telefono y 
la nueva dirección de un cliente de la tabla cliente, 
(NOTA: debes utilizar el procedimiento anterior para cambiar la
dirección.)*/
drop procedure if exists ex5;
delimiter //
create procedure ex5(in nombreCliente VARCHAR(45), in telefonoCliente VARCHAR(9), in direccionCliente VARCHAR(40))
begin
    declare codigoCliente int;
    set codigoCliente = (select cliente_cod from CLIENTE where nombreCliente = nombre and telefonoCliente = telefono limit 1);
    call ex4(codigoCliente, direccionCliente);
end //
delimiter ;

select nombre, telefono, dirección from CLIENTE;
call ex5('vollyrite', '644-3341', 'calle asd');
select nombre, telefono, dirección from CLIENTE;

/*6. Realizar una función que calcule el factorial de un número. 
Recuerda que 0! o 1! Es 1. No utilices recursividad. 
Trata de utilizar ahora la recursividad ¿Qué ocurre?*/
drop function if exists ex6;
delimiter //
create function ex6(numero int) returns int
begin
    DECLARE factorial int DEFAULT 1;
    DECLARE contador int;
    SET contador = numero;
    WHILE contador>1 DO
        SET factorial = factorial * contador;
        SET contador = contador - 1;
    END WHILE;
    RETURN factorial;
end //
delimiter ;

select ex6(6);

/*7. Crea un procedimiento que reciba una cadena que puede 
contener letras y números y sustituya los número por *. 
Por ejemplo si hemos introducido la cadena 12abcd23rts,
devolverá **abcd**rst. Consulta el manual de referencia 
sobre funciones.*/
use empresa;
drop procedure if exists ex7;
delimiter //
create procedure ex7(inout cadenaCaracteres text)
begin
    declare contador int;
    set contador = 0;
    while contador < 10 do
        set cadenaCaracteres = replace(cadenaCaracteres, convert(contador, char(1)) , '*');
        set contador = contador+1;
    end while;
end //
delimiter ;

set @cadena = '12abcd23rts';
call ex7(@cadena);
select @cadena;

/*8. Desarrollar una función que devuelva el número de años 
completos que hay entre dos fechas que se pasan como parámetros. 
Utiliza la función DATEDIFF. Para visualizar el formato de la 
fecha con la que trabaja mysql en la sesión que estás utilizando 
visualiza la fecha actual utilizando la función current_date()*/
drop function if exists ex8;
delimiter //
create function ex8(fecha1 date, fecha2 date) returns float
begin
    declare diferencia float;
    set diferencia = (DATEDIFF(fecha1, fecha2)/365);
    return diferencia;
end //
delimiter ;

select ex8("2017-06-25", "2012-06-15");

/*9. Escribir una función que, haciendo uso de la función 
anterior, devuelva los trienios que hay entre dos fechas.*/
drop function if exists ex9;
delimiter //
create function ex9(fecha1 date, fecha2 date) returns int
begin
    declare trienios int;
    set trienios = (select FLOOR(ex8(fecha1, fecha2)/3));
    return trienios;
end //
delimiter ;

select ex9("2017-06-25", "2012-06-15");

/*10. Codificar un procedimiento que reciba una lista de hasta 
tres números y visualice su suma.
Nota, PL-SQL permite utilizar parámetros opcionales, mysql no, 
debes pasar tantos parámetros a la función o procedimiento 
como hayas definido en la función. Si luego no quieres pasar 
un parámetro en mysql, utiliza null a la hora de llamar a la 
función o procedimiento.*/
use empresa;
drop procedure if exists ex10;
delimiter //
create procedure ex10(in numero1 int, in numero2 int, in numero3 int)
begin
    declare suma int;
    if numero1 is null then 
        set numero1=0;
    end if;
    if numero2 is null then 
        set numero2=0;
    end if;
    if numero3 is null then 
        set numero3=0;
    end if;
    set suma = numero1+numero2+numero3;
    select suma;
end //
delimiter ;

call ex10(22, 22, null);
call ex10(null, 4, 25);
call ex10(102, null, 86);
call ex10(14, 9, 8);

/*11. En la tabla country de la BD World, actualizar el GPN de un 
país cuyo nombre se pasará como parámetro, de la siguiente forma, 
si es de África, se aumentará un 1%, si es de Antartida un 1,5%, 
si es de Asia o Sudamérica un 1,7%, si es de Europa o NorteAmérica
un 1,9% y si es de Oceania, un 1,6%.*/
use world;
drop procedure if exists ex11;
delimiter //
create procedure ex11(in nombrePais char(62))
begin
    declare continente enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America');
    select name, continent, gnp from country where name=nombrePais;

    set continente = (select continent from country where name=nombrePais);
    if continente = 'Asia' then 
        UPDATE country set gnp = gnp+(gnp*1.7/100) where name = nombrePais;
    elseif continente = 'Europe' then 
        UPDATE country set gnp = gnp+(gnp*1.9/100);
    elseif continente = 'North America' then 
        UPDATE country set gnp = gnp+(gnp*1.9/100);
    elseif continente = 'Africa' then 
        UPDATE country set gnp = gnp+(gnp*1/100);
    elseif continente = 'Oceania' then 
        UPDATE country set gnp = gnp+(gnp*1.6/100);
    elseif continente = 'Antarctica' then 
        UPDATE country set gnp = gnp+(gnp*1.5/100);
    elseif continente = 'South America' then 
        UPDATE country set gnp = gnp+(gnp*1.7/100);
    end if;

    select name, continent, gnp from country where name=nombrePais;
end //
delimiter ;

call ex11('Somalia');
call ex11('Tuvalu');
call ex11('Romania');
call ex11('Yemen');
