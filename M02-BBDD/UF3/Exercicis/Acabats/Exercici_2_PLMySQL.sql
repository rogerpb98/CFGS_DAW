SET GLOBAL log_bin_trust_function_creators = 1;
/*1. Escribe la función ex1 que devuelva tu nombre.*/
use empresa;
drop function if exists ex1;
delimiter //
create function ex1() returns varchar(30)
begin
    return 'Roger Pérez Blanco';
end //
delimiter ;

select ex1();

/*2. Escribe el procedimiento ex2 que devuelva tu nombre.*/
use empresa;
drop procedure if exists ex2;
delimiter //
create procedure ex2(out salida varchar(30))
begin
    set salida = 'Roger Pérez Blanco';
end //
delimiter ;

call ex2(@variable);

/*3. Escribe la función ex3 que reciba un parámetro de tipo varchar y 
devuelva ese mismo parámetro.*/
use empresa;
drop function if exists ex3;
delimiter //
create function ex3(var varchar(30)) returns varchar(30)
begin
    return var;
end //
delimiter ;

select ex3('asd');

/*4. Escribe el procedimiento ex4 que reciba un parámetro de tipo 
varchar y devuelva ese mismo parámetro.*/
use empresa;
drop procedure if exists ex4;
delimiter //
create procedure ex4(in var varchar(30), out varchar(30))
begin
    set salida = var;
end //
delimiter ;

select ex4('asd', @sketit);

/*5. Escribe la función ex5 que reciba un varchar como parámetro de 
entrada y devuelva la segunda letra del varchar recibido.*/
use empresa;
drop function if exists ex5;
delimiter //
create function ex5(var varchar(30)) returns varchar(1)
begin
    declare salida;
    set salida = substring(var,2,1);
    return salida;
end //
delimiter ;

select ex5('asd');

/*6. Escribe el procedImiento ex6 que reciba un varchar como parámetro 
de entrada y devuelva la segunda letra del varchar recibido.*/
use empresa;
drop procedure if exists ex6;
delimiter //
create procedure ex6(in var varchar(30), out varchar(1))
begin
    set salida = substring(var,2,1);
end //
delimiter ;

select ex6('asd', @sketit);

/*7. Escribe la función ex7 que devuelva el idcliente del cliente 
a partir de su nombre pasado como parámetro de entrada 
(utilizar la tabla clientes)*/
use empresa;
drop function if exists ex7;
delimiter //
create function ex7(nombreCliente varchar(45)) returns int(6)
begin
    declare idcliente int(6);
    set idcliente = (select CLIENTE_COD from CLIENTE WHERE NOMBRE=nombreCliente);
    return idcliente;
end //
delimiter ;

select ex7('vollyrite');
 
/*8. Escribe el procedimiento ex8 que devuelva el idcliente del 
cliente a partir de su nombre pasado como parámetro de entrada 
(utilizar la tabla clientes)*/
use empresa;
drop procedure if exists ex8;
delimiter //
create procedure ex8(in nombreCliente varchar(45), out int(6))
begin
    set salida = (select CLIENTE_COD from CLIENTE WHERE NOMBRE=nombreCliente);
end //
delimiter ;

select ex8('vollyrite', @sketit);

/*9. Escribe la función ex9 que devuelva una fecha dada con el 
formato: día de la semana, día del mes, hora, minutos y segundos.*/
use empresa;
drop function if exists ex9;
delimiter //
create function ex9(fechaInput DATETIME) returns varchar(200)
begin
    declare fechaIntroducida varchar(200);
    set fechaIntroducida = (select DATE_FORMAT(fechaInput, "%W %d %H:%i:%s"));
    return fechaIntroducida;
end //
delimiter ;

select ex9(now());

/*10. Escribe el procedimiento ex10 que devuelva una fecha dada con el 
formato: d�a de la semana, d�a del mes, hora, minutos y segundos.*/
use empresa;
drop procedure if exists ex10;
delimiter //
create procedure ex10(in fechaInput DATETIME, out fechaOut varchar(200))
begin
    set fechaOut = (select DATE_FORMAT(fechaInput, "%W %d %H:%i:%s"));
end //
delimiter ;

call ex10(now(), @variable);
select @variable;

/*11. Escribe la función ex11 que devuelva el número de años completos 
de diferencia entre  dos fechas que se le pasan como parámetros*/
use empresa;
drop function if exists ex11;
delimiter //
create function ex11(fechaInput1 DATE, fechaInput2 DATE) returns int
begin
    declare diferenciaFecha int;
    set diferenciaFecha = (select DATEDIFF(fechaInput1, fechaInput2));
    return diferenciaFecha/365;
end //
delimiter ;

select ex11(now(), "2004-03-23");

/*12. Escribe el procedimiento ex12 que devuelva el número de años 
completos de diferencia entre  dos fechas que se le pasan como parámetros*/
use empresa;
drop procedure if exists ex12;
delimiter //
create procedure ex12(in fechaInput1 DATE, in fechaInput2 DATE, out diferenciaFecha int)
begin
    set diferenciaFecha = ((select DATEDIFF(fechaInput1, fechaInput2))/365);
end //
delimiter ;

call ex12(now(), "2004-03-23", @variable);
select @variable;
    
/*13. Desarrolla la función ex13 que devuelva la suma de los 
idcliente de la tabla cliente*/
use empresa;
drop function if exists ex13;
delimiter //
create function ex13() returns int
begin
    declare sumaIds int;
    set sumaIds = (select SUM(CLIENTE_COD) from CLIENTE);
    return sumaIds;
end //
delimiter ;

select ex13();

/*14. Desarrolla el procedimiento ex14 que devuelva la suma de 
los idcliente de la tabla cliente*/
use empresa;
drop procedure if exists ex14;
delimiter //
create procedure ex14(out sumaIds int)
begin
    set sumaIds = (select SUM(CLIENTE_COD) from CLIENTE);
end //
delimiter ;

call ex14(@variable);
select @variable;

/*15. Escribe la función ex15 que devuelva el nombre
y la poblacion de un cliente que le pasamos como parámetro de entrada.*/
use empresa;
drop function if exists ex15;
delimiter //
create function ex15(nombreInput VARCHAR(45)) returns VARCHAR(200)
begin
    declare nombreMasPob VARCHAR(200);
    set nombreMasPob = (select CONCAT(nombre, '---' ,ciudad) from CLIENTE where nombre=nombreInput);
    return nombreMasPob;
end //
delimiter ;

select ex15('VOLLYRITE');

/*16. Escribe el procedimiento ex16 que devuelva el nombre
y la poblacion de un cliente que le pasamos como parámetro de entrada.*/
use empresa;
drop procedure if exists ex16;
delimiter //
create procedure ex16(in nombreInput VARCHAR(45), out nombreMasPob VARCHAR(200))
begin
    set nombreMasPob = (select CONCAT(nombre, '---' ,ciudad) from CLIENTE where nombre=nombreInput);
end //
delimiter ;

call ex16('VOLLYRITE', @variable);
select @variable;

/*17. Escribe la función ex17 que compare dos letras minúsculas del 
rango [a..z] que le  pasamos como parámetros de entrada y que, a 
 continuación, imprima la mayor de las dos o cero en el caso de 
 que sean iguales.*/
use empresa;
drop function if exists ex17;
delimiter //
create function ex17(letra1 CHAR(1), letra2 CHAR(1)) returns VARCHAR(200)
begin
    declare caracter CHAR(1);

    IF letra1 > letra2 THEN
        SET caracter = letra1;
    ELSEIF letra1 < letra2 THEN
        SET caracter = letra2;
    ELSE
        SET caracter = '0';
    END IF;
    return caracter;
end //
delimiter ;

select ex17('a', 'z');
select ex17('z', 'a');
select ex17('h', 'h');

/*18. Escribe el procedimiento ex18 que compare dos letras 
minúsculas del rango [a..z] que le  pasamos como parámetros 
de entrada y que, a continuación, imprima la mayor de las dos 
o cero en el caso de que sean iguales.*/
use empresa;
drop procedure if exists ex18;
delimiter //
create procedure ex18(in letra1 CHAR(1), in letra2 CHAR(1))
begin
declare caracter CHAR(1);

    IF letra1 > letra2 THEN
        SELECT letra1;
    ELSEIF letra1 < letra2 THEN
        SELECT letra2;
    ELSE
        SELECT '0';
    END IF;
end //
delimiter ;

call ex18('a', 'z');
call ex18('z', 'a');
call ex18('h', 'h');
