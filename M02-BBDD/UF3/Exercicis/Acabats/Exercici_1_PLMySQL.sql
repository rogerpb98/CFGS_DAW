/*1. Crea un procedimiento "x5" con dos parametros enteros:
- uno IN int y el otro OUT, de manera que el de salida
sea el de la entrada, multiplicado por 5*/
use world;
drop procedure if exists multiplica;
delimiter //
create procedure multiplica(in entrada int,out salida int)
begin
SET salida = entrada*5;
end //
delimiter ;


/*2. Realiza la llamada y la comprobacion del procedure*/
call multiplica (5, @hola);
select @hola;

/*3. Crea un procedimiento 'num_users1' que cuente el n�mero de 
usuarios distintos del sistema y lo muestre por pantalla,
sin usar par�metros de entrada. Realiza la llamada*/
use world;
drop procedure if exists num_users1;
delimiter //
create procedure num_users1()
begin
select count(distinct User) from mysql.user;
end //
delimiter ;

call num_users1;
/*4. Crea un procedimiento 'num_users2' que cuente el n�mero de 
usuarios distintos del sistema y lo muestre por pantalla,
usando un par�metro de entrada OUT. Realiza la llamada*/
use world;
drop procedure if exists num_users2;
delimiter //
create procedure num_users2(out salida int)
begin
set salida = (select count(distinct User) from mysql.user);
end //
delimiter ;

call num_users2(@test);

select @test;

/*5. Crea un procedimiento dividir con 3 parametros de entrada
que haga la division entera de 2 numero 5/3 = 1 resto 2
- inout dividendo int -> aqui se devolvera el cociente entero
- int Divisor int
- out resto*/
use world;
drop procedure if exists multiplica;
delimiter //
create procedure multiplica(inout dividendo int,in divisor int,out resto int)
begin
SET resto = dividendo%divisor;
SET dividendo = dividendo/divisor;
end //
delimiter ;

set @dividendo=50;

call multiplica(@dividendo,3,@resto);
select @dividendo;
select @resto;

/*6. Crea un procedimiento 'ADDCLI' que inserte un cliente en la 
tabla CLIENTES. Recibirá dos parámetros internos que serán el 
nombre y el código de cliente.*/
use empresa;
drop procedure if exists ADDCLI;
delimiter //
create procedure ADDCLI(in nombrein varchar(45),in codigoin int unsigned, in direccionin varchar(40), in ciudadin varchar(30), in codipostalin varchar(9))
begin
insert into CLIENTES (cliente_cod, nombre, direccion, ciudad, codi_postal) values (codigoin, nombrein, direccionin, ciudadin, codipostalin);
end //
delimiter ;

call ADDCLI();


/*7. Crea un procedimiento que cree usuario 'Pepe', que sin 
permisos para insertar en la tabla CLIENTE pueda llamar a el 
procedimiento anterior y realizar la inserción a través de él.*/
use empresa;
drop procedure if exists crearPepe;
delimiter //
create procedure crearPepe()
begin
    drop user if exists Pepe;
    create user Pepeidentifies by 1234;
    grant execute on *.* to Pepe;
end //
delimiter ;

call crearPepe();


/*8. ¿Qué permisos son necesarios para ejecutar un procedimiento?
 ¿Y para crearlo?*/
El permiso necesario para ejecutarlo es el execute
Para crearlo el create

/*9. Trataremos de averiguar para qué sirve la característica 
SQL SECURITY.
Crea un procedimiento show_users que muestre por pantalla el 
resultado de consultar la tabla mysql.user. Observa que el DEFINER 
queda definido como root@localhost. Asegúrate de que la característica 
SQL SECURITY queda como DEFINER*/
use empresa;
drop procedure if exists show_users;
delimiter //
create procedure show_users(in nombrein varchar(45),in codigoin int) sql SECURITY DEFINER
begin
select * from mysql.user;
end //
delimiter ;

call show_users();


/*10. Ahora concede al usuario Maria@'%'' permisos para ejecutar 
rutinas*/
grant execute on *.* to Maria@'%';

/*11. Accede al sistema como María y trata de ejecutar el 
procedimiento anterior.*/
sudo mysql -uMaria -p123
call show_users;

/*12. Vuelve a logearte como root y modifica el procedimiento 
anterior: cambia la  característica SQL SECURITY a INVOKER.*/
sudo mysql -uroot -paustria
alter procedure show_users sql SECURITY INVOKER;

/*13. Vuelve a convertirte en María y trata de nuevo de ejecutar 
el procedimiento.*/
sudo mysql -uMaria -p123
call show_users;

/*14.¿Qué permisos habría de tener María para poder llamar el 
procedimiento?*/
permisos de lectura en la db mysql

/*15. Crea un porcedimiento con un parametro de entrada: 
fecha_var tipo DATE, de manera que calcule la diferencia en 
días entre la fecha actual y la fecha_var.
Mostrar por pantalla fecha_var en formato 'día de la semana 
dd/mm/aaaa'.
Mostrar también la diferencia de fechas en días calculada 
previamente.*/
use empresa;
drop procedure if exists mostraData;
delimiter //
create procedure mostraData(in fecha_var date)
begin
set diferencia=(DATEDIFF(CURDATE(), fecha_var));
select DATE_FORMAT(fecha_var,%d%m%Y);
select diferencia;
end //
delimiter ;

call mostraData(2008-06-24);