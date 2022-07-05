/*Ejercicios Handlers.*/

/*Ejercicio 1
Estudia y ejecuta el siguiente handler de tipo continue*/
-- Paso 1
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

-- Paso 2
CREATE TABLE test.t (s1 INT, PRIMARY KEY (s1));

-- Paso 3
DELIMITER $$
CREATE PROCEDURE handlerdemo ()
BEGIN
  DECLARE CONTINUE HANDLER FOR SQLSTATE '23000' SET @x = 1;
  SET @x = 1;
  INSERT INTO test.t VALUES (1);
  SET @x = 2;
  INSERT INTO test.t VALUES (1);
  SET @x = 3;
END
$$

DELIMITER ;
CALL handlerdemo();
SELECT @x; 

/*¿Qué valor devolvería la sentencia SELECT @x?*/
3


/*Ejercicio 2
Estudia y ejecuta el siguiente handler de tipo exit*/
-- Paso 1
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

-- Paso 2
CREATE TABLE test.t (s1 INT, PRIMARY KEY (s1));

-- Paso 3
DELIMITER $$
CREATE PROCEDURE handlerdemo ()
BEGIN
  DECLARE EXIT HANDLER FOR SQLSTATE '23000' SET @x = 1;
  SET @x = 1;
  INSERT INTO test.t VALUES (1);
  SET @x = 2;
  INSERT INTO test.t VALUES (1);
  SET @x = 3;
END
$$

DELIMITER ;
CALL handlerdemo();
SELECT @x; 
/*¿Qué valor devolvería la sentencia SELECT @x?*/
1


/*Ejercicio 3
Crea una base de datos llamada test que contenga una tabla 
llamada alumno. La tabla debe tener cuatro columnas:
id: entero sin signo (clave primaria).
nombre: cadena de 50 caracteres.
apellido1: cadena de 50 caracteres.
apellido2: cadena de 50 caracteres.
Una vez creada la base de datos y la tabla deberá crear un 
procedimiento llamado insertar_alumno con las siguientes 
características. El procedimiento recibe cuatro parámetros de 
entrada (id, nombre, apellido1, apellido2) y los insertará en 
la tabla alumno. El procedimiento devolverá como salida un 
parámetro llamado error que tendrá un valor igual a 0 si 
la operación se ha podido realizar con éxito y un valor 
igual a 1 en caso contrario.
Deberá manejar los errores que puedan ocurrir cuando se intenta 
insertar una fila que contiene una clave primaria repetida.*/
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE test.alumno (
  id INT,
  nombre varchar(50),
  apellido1 varchar(50),
  apellido2 varchar(50),

  PRIMARY KEY (id)
);

-- Paso 3
DELIMITER $$
CREATE PROCEDURE insertar_alumno (
  in idIn int,
  in nombreIn varchar(50),
  in apellido1In varchar(50),
  in apellido2In varchar(50),
  out error tinyint
)
BEGIN
  DECLARE EXIT HANDLER FOR SQLSTATE '23000' SET error = 1;
  set error = 0;
  insert into alumno values (idIn, nombreIn, apellido1In, apellido2In);
END
$$

DELIMITER ;
CALL insertar_alumno(1, 'roger', 'perez', 'blanco', @x);
SELECT @x; 



/*Ejercicio 4
En la BD World, crear un procedimiento para actualizar la 
población de un determinado país.  Se pasarán dos parámetros, 
la nueva población de tipo float y el nombre del país. 
Realiza el procedimiento primero sin hacer el tratamiento de 
errores y pruébalo con los siguientes valores (Angola, 
1234567891234) ¿Qué ocurre y porqué?
Realiza ahora el tratamiento de los errores de modo que si 
se introduce un valor para la población mayor del permitido, 
se actualizará la población de ese país aumentándola un 10%. 
Si se introduce un país que no existe, se acabará el 
procedimiento con un mensaje indicando que el país no existe.*/
USE world;
DROP PROCEDURE IF EXISTS actualizarPob;
DELIMITER $$
CREATE PROCEDURE actualizarPob (
  in newPopulation float,
  in countryName char(52)
)
BEGIN
  declare poblacionX int(11) default (SELECT population from country where name=countryName);
  declare paisExiste tinyint default (select count(*) from country where name=countryName);
  DECLARE EXIT HANDLER FOR SQLSTATE '22003' 
    update country set population = population+population*10/100 where name = countryName;
  if paisExiste=0 then
    select "El país no existe";
  end if;
  update country set population = newPopulation where name = countryName;
END
$$
DELIMITER ;

CALL actualizarPob(1234567891234, 'Aruba');

select name, population from country limit 5;

/*Ejercicio 5
Crea un procedimiento para añadir un nuevo registro a la tabla 
city haciendo el tratamiento de errores y mostrando los 
mensajes pertinentes.*/
DROP PROCEDURE IF EXISTS añadirRegistro;
DELIMITER $$
CREATE PROCEDURE añadirRegistro (
  in nameIn char(255),
  in countryCodeIn char(255),
  in districtIn char(255),
  in populationIn bigint
)
BEGIN
  DECLARE EXIT HANDLER FOR SQLSTATE '23000' 
    SELECT 'No se ha podido insertar la fila';
  DECLARE EXIT HANDLER FOR SQLSTATE '22003' 
    SELECT 'Población está fuera de rango'; 
  DECLARE EXIT HANDLER FOR SQLSTATE '22001' 
    SELECT 'Una de las columnas tiene mas caracteres de los que deberia'; 
  insert into city (name, countrycode, district, population) values (nameIn, countryCodeIn, districtIn, populationIn);
END
$$
DELIMITER ;

CALL añadirRegistro('aaaaa', 'aaa', 'aaaaaaa', 100); /*No se puede añadir fila*/
CALL añadirRegistro('aaaaa', 'aaaa', 'aaaaaaa', 100); /*Una de las columnas tiene mas caracteres de los que deberia*/
CALL añadirRegistro('aaaaa', 'afg', 'aaaaaaa', 10000000000); /*Población está fuera de rango*/

select name, population from country limit 5;
drop procedure añadirRegistro; 

/*Ejercicio 6
Crea un procedimiento de modo que permita actualizar el 
campo special_features de la tabla film para una determinada 
película. Tendrá como parámetro el identificador del film y 
el parametro para special_features, defínelo como varchar(25).
Prueba el procedimiento con los datos (1, 'Special') 
¿Qué ocurre?¿Porqué? Anota el número del error obtenido y 
realiza el tratamiento para este error.
Prueba ahora el procedimiento para los siguientes valores
(1, 'Trailers')
(1, 'Trailers222')*/

/*Sale un error porque no esta dentro de las posibilidades del ENUM*/
use sakila;

DELIMITER $$
CREATE PROCEDURE actualizarEspecial (
  in idIn smallint(5),
  in sfIn char(30)
)
BEGIN
  DECLARE EXIT HANDLER FOR SQLSTATE '01000' 
    SELECT 'Característica especial no soportada';
  update film set special_features = sfIn where film_id=idIn;
END
$$
DELIMITER ;

CALL actualizarEspecial(1, 'Special'); /*No se puede añadir fila*/
CALL actualizarEspecial(1, 'Trailers');
CALL actualizarEspecial(1, 'Trailers222'); /*No se puede añadir fila*/
drop procedure actualizarEspecial; 


/*Ejercicio 7
Crea un procedimiento para dar de alta un nuevo actor, de modo 
que si la clave para ese nuevo actor ya existe, se pondrá como 
clave el valor inmediatamente superior al valor mayor de las 
claves. Por ejemplo si la clave mayor es 300, se pondrá como 
clave 301. Realiza el procedimiento utilizando el handler para 
el error 1062 se produce cuando se está duplicando una clave 
primaria al hacer una inserción.*/
/*Prueba el procedimiento con los siguientes valores
(193, 'Maria', 'Arnes')
(305, 'Julio', 'Arranz')*/
DELIMITER $$
CREATE PROCEDURE insertar_actor (
  in aidIn int,
  in fnIn varchar(50),
  in lnIn varchar(50)
)
BEGIN
  DECLARE EXIT HANDLER FOR SQLSTATE '23000' 
    BEGIN
      SET aidIn = (select max(actor_id)+1 from actor);
      insert into actor (actor_id, first_name, last_name) values (aidIn, fnIn, lnIn);
    END;
  insert into actor (actor_id, first_name, last_name) values (aidIn, fnIn, lnIn);
END
$$
DELIMITER ;

CALL insertar_actor(193, 'Maria', 'Arnes');
CALL insertar_actor(305, 'Julio', 'Arranz');
