/*
Taula de continguts:
1. DDL
   1. Part 1
   2. Part 2
   3. Part 3
2. DML
3. Consultas basicas
4. Funciones dentro de expresiones
5. Funciones de agregación
6. Combinación de tablas
7. Subconsultas
*/

/*DDL
Part 3*/
/*Crea una tabla que llamaremos "GelderlandDist" que contenga las columnas
Name, District, CountryCode para aquellas filas de la tabla City asociadas al
distrito "Gelderland". Confirma que los datos se han copiado correctamente.*/
create table GelderlandDist select name, district, countrycode from city where district="Gelderland";
	

/*Crea una tabla (que llamaremos “GelderlandDist2”) con la misma estructura
que "GelderlandDist". Comprueba que el sistema ha actuado como se
esperaba.*/
create table GelderlandDist2 like GelderlandDist;
/*Todo correcto*/
	

/*Elimina la tabla "GelderlandDist2".*/
drop table GelderlandDist2;
	

/*Modifica la tabla "GelderlandDist" para que el campo Name tenga una
longitud de 20 caracteres. Comprueba que ahora el campo admitirá valores
nulos.*/
alter table GelderlandDist modify column name char(20);
/*Si acepta nulls*/
	

/*Añade una columna a "GelderlandDist" que llamarás Inauguration que contendrá
fechas y no permitirá valores nulos. (Si tu sistema esta trabajando con el modo
NO_ZERO_DATE, te aparecerá un error). ¿Cómo rellena el sistema esta nueva
columna?*/
alter table GelderlandDist add column Inauguration date not null;

/*Para que no pete debemos introducir una fecha por defecto*/
alter table GelderlandDist add column Inauguration date not null default "2000-01-01";
	
/*Convierte el campo Name de "GelderlandDist" en clave primaria.*/
alter table GelderlandDist add primary key (name);
	
/*Crea una nueva tabla que llamarás Big_Cities copiando datos de la tabla City.
Esta nueva tabla contendrá los campos id, name, population y los datos de las
ciudades que tengan más 8 millones de habitantes.*/
create table Big_Cities select id, name, population from city where population > 8000000;
	
/*Añade una nueva columna, que llamarás Founded y que será una fecha que
permite valores nulos, a la tabla Big_Cities. ¿Cómo ha rellenado el sistema la
nueva columna?*/
alter table Big_Cities add column Founded date;
/*La ha rellenado con nulls*/
	
/*Elimina la columna Founded de la tabla Big_Cities*/
alter table Big_Cities drop column Founded;
	
/*Modifica la columna ID de Big_Cities para que admita valores nulos.*/
alter table Big_Cities modify column id int(11) null;
	
/*Convierte el campor ID de Big_Cities en clave primaria*/
alter table Big_Cities add primary key (id);


/*DML*/
/*Añade una fila de datos nueva en la tabla GelderlandDist. La nueva fila contendrá la ciudad de "Sakila" del distrito de Gelderland, el countrycode será 'SQL' y la fecha de inauguración el 1 de julio de 2001.*/
insert into GelderlandDist values ('Sakila', 'Gelderland', 'SQL', '2000-05-01');
	

/*Añade dos filas en un misma instrucción en la tabla GelderlandDist. Los datos serán: ○ Fila1: ciudad 'MySQLland' , countrycode 'MYS' e inauguración el 4 de agosto de 1984. 
○ Fila2: ciudad Fantasia, countrycode 'FNT' e inauguración el 1 de enero de 1950.*/
insert into GelderlandDist values ('MySQLland', '', 'MYS', '1984-08-04'), ('Fantasia', '', 'FNT', '1950-01-01');
	
/*Reemplaza la fila con countrycode 'MYS' por otra con los mismos datos en todos los campos excepto en countrycode que tendrá 'SQL'.*/
update GelderlandDist set countrycode = 'SQL' where countrycode = 'MYS';
	
/*Actualiza la fecha de inauguración de la ciudad de Ede en la tabla GelderlandDist a 17 de mayo de 1980.*/
update GelderlandDist set inauguration = '1980-05-17' where name = 'Ede';
	
/*Modifica en GelderlandDist aquellas filas cuyo countrycode es 'NLD' y cámbialo a 'FOO'. Ordena la actualización por nombre y limita el número de cambios a 2.*/
update GelderlandDist set countrycode = 'FOO' where countrycode = 'NLD' order by name limit 2;
	
/*Elimina solo una fila de GelderlandDist que contenga el countrycode ‘FOO’.*/
delete from GelderlandDist where countrycode = 'FOO' limit 1;
	
/*Crear una tabla con la estructura de City*/
create table test like city;
	
/*Rellenarla con los datos de City pertenecientes a los distritos Ontario y England (Ayuda: mira el manual. Existe una opción de utilizar el insert combinado con select)*/
insert into test select * from city where district = 'Ontario' or district = 'england';
	
/*Actualizar todas las poblaciones de las filas cuyo distrito sea England y darles el valor de la población de la ciudad de Sao Paulo utilizando una consulta para ello.*/
update test set population = (select population from city where name = 'sao paulo') where district = 'england';
	
/*Actualizar la población de la ciudad de Cambridge (England) para que sea igual a la población de la ciudad de Ede (la de mayor población ya que hay dos)*/
update test set population = (select max(population) from city where name = 'ede') where name = 'cambridge' and district = 'england';
	
/*Insertar en la nueva tabla una fila que contenga: ○ id: el valor que le corresponde por ser un autoincremental ○ Name: el nombre de la ciudad con menos habitantes de la tabla city ○ countrycode: que será igual al de cambridge de England ○ district: insertar 'distrito final' ○ Population: que será igual a la división entera de la mayor población de la tabla city entre cinco*/
insert into test values (NULL, (select name from city where population <= all(select population from city)), (select countrycode from city where name = 'cambridge' and district = 'england'), 'distrito final', (select (MAX(population)/5) from city));
	
/*Consultas basicas
TABLA EMPLE y DEPART*/ 
/*Mostrar el apellido, oficio y número de departamento de cada empleado */
select apellido, oficio, dept_no from emple;
	
/*Mostrar el número, nombre y localización de cada departamento. */
select dept_no, dnombre, loc from depart;
	
/*Mostrar todos los datos de todos los empleados. */
select * from emple;
	
/*Datos de los empleados ordenados por apellido. */
select * from emple order by apellido;
	
/*Datos de los empleados ordenados por número de departamento descendentemente. */
select * from emple order by dept_no desc;
	
/*Datos de los empleados ordenados por número de departamento descendentemente y dentro de cada departamento ordenados por apellido ascendentemente. */
select * from emple order by dept_no desc, apellido;
	
/*Mostrar los datos de los empleados cuyo salario sea mayor que 20000. */
select * from emple where salario > 20000;

/*Mostrar los datos de los empleados cuyo oficio sea “ANALISTA". */
select * from emple where oficio = 'analista';
	
/*Seleccionar el apellido y oficio de los empleados del departamento número 20. */
select apellido, oficio from emple where dept_no = '20';
	
/*Seleccionar los empleados cuyo oficio sea ”VENDEDOR". Mostrar los datos ordenados por apellido. */
select * from emple where oficio = 'vendedor' order by apellido;
	
/*Mostrar los empleados cuyo departamento sea 10 y cuyo oficio sea ”ANALISTA". Ordenar el resultado por apellido. */
select * from emple where oficio = 'analista' AND (dept_no = '10') order by apellido;
	
/*Mostrar los empleados que tengan un salario mayor que 2000 o que pertenezcan al departamento número 20. */
select * from emple where salario > 2000 OR (dept_no = 20);
	
/*Ordenar los empleados por oficio, y dentro de oficio por nombre. */
select * from emple order by oficio, apellido;
	
/*Seleccionar los empleados cuyo salario esté entre 1000 y 2000. Utilizar el operador BETWEEN. */
select * from emple where salario BETWEEN 1000 AND 2000;
	
/*Obtener los empleados cuyo oficio sea “VENDEDOR" y tengan una comisión superior a 1000. */
select * from emple where oficio = 'vendedor' AND (comision > 1000);
	
/*Datos de los empleados cuyo oficio sea “EMPLEADO", tengan un salario superior a 1000 y pertenezcan al departamento número 10. */
select * from emple where oficio = 'empleado' AND (salario > 1000) AND (dept_no = 10);
	
/*Mostrar los apellidos de los empleados que no tengan comisión. */
select apellido from emple where comision is null;
	
/*Mostrar los apellidos de los empleados cuyo oficio sea “VENDEDOR", ”ANALISTA" o “EMPLEADO". */
select * from emple where oficio in ('analista', 'empleado', 'vendedor');

/*Mostrar los apellidos de los empleados cuyo oficio no sea ni “ANALISTA" ni “EMPLEADO", y además tengan un salario mayor de 200000. */
select apellido from emple where oficio not in ('analista', 'empleado') AND (salario > 2000);

/*Seleccionar el apellido, salario y número de departamento de los empleados cuyo salario sea mayor que 200000 en los departamentos 10 ó 30. */
select apellido, salario, dept_no from emple where salario > 2000 and (dept_no = 10 or dept_no = 30);

/*Obtener el año de contratación de todos los empleados.*/
select apellido, fecha_alt from emple;
	

Funciones dentro de expresiones
/*Muestra la longitud de todos los nombres de los países de world.Country*/
select char_length(name) from country;
	

/*Muestra la posición del primer espacio en blanco en el nombre de los países.*/
select instr(name,' ') from country;
	

/*Utilizando la función strcmp, ¿existe algún país llamado ‘Armenia’ en el continente asiático?*/
/*Opcion 1:*/
select strcmp(name,'Armenia') from country where continent in('asia');


/*Opcion 2:*/
select name from country where continent in ('asia') AND (strcmp(name, 'Armenia') = 0);
	

/*Muestra el nombre de los países junto a su continente unidos por la expresión ‘pertenece al continente’. (Ayuda: utilizar función concat) */
select concat(name, ' permanece a ' ,continent) from country;
	

/*Muestra en mayúsculas las tres primeras letras del nombre de los países del continente europeo. */
/*Opcion 1:*/
select left(upper(name),3) from country where continent = 'Europe';


/*Opcion 2:*/
select name, substr(upper(name),1,3) from country where continent = 'Europe';
	

/*Muestra el nombre de los países pero si hay algún nombre que contenga algún espacio en blanco, muestra solo la primera parte del nombre. Es decir, si el nombre es ‘pepito mateo’ debe aparecer solo ‘pepito’*/
select substring_index(name, ' ', 1) from country;
	

/*Mostrar los países europeos que empiezan por la letra ‘A’ */
select Name from country where Continent = 'Europe' AND Name like 'A%';
	

/*Mostrar los países africanos que contengan una ‘h’ en su nombre */
select Name from country where Continent = 'Africa' AND Name like '%h%';
	

/*Mostrar los países africanos que contengan una ‘h’ y una ‘m’ en su nombre */
select Name from country where Continent = 'Africa' AND Name like '%h%' AND Name like '%m%';
	

/*¿Existe algún país cuyo nombre esté formado por 5 caracteres y el último sea una ‘r’?*/
select Name from country where Name like '____r';
	

/*Muestra la fecha actual */
select CURDATE();
	

/*Muestra la longitud en caracteres de la fecha actual */
select CHAR_LENGTH(CURDATE());
	

/*Muestra qué día será dentro de 20 días */
SELECT CURDATE()+INTERVAL 20 DAY;
	

/*¿Qué día será si al día actual le quitamos un año y 20 días? */
SELECT CURDATE()-INTERVAL 1 YEAR-INTERVAL 20 DAY;
	

/*¿Qué día será si al 10 de junio de 1990 le añadimos 3 meses y 5 días? */
select '1990-06-10' +interval 3 month +interval 5 day;
	

/*Muestra la fecha actual con el formato: día_numérico + ”de” + nombre_mes + “de” + año.*/
select date_format(curdate(), '%D de %M de %Y');
	

/*¿Cómo podemos conseguir que los nombres de los meses y de los días de la semana aparezcan en castellano?*/
SET lc_time_names = 'es_ES';
	

/*Busca alguna función que permita calcular cuántos días hay entre dos fechas*/
SELECT DATEDIFF('2020-10-30', '2020-10-01') [AS 'Diferencia (dias)'];
	

/*Mostrar la división entera entre número de habitantes y superficie (SurfaceArea) de cada país. Ordenar el resultado de mayor a menor. ¿Cuál es el país más densamente poblado?*/
select name, Population div SurfaceArea from country order by Population div SurfaceArea;
	

/*Mostrar aquellos países que lograron su independencia en un año par. */
select name from country where IndepYear%2=0;
	

/*¿Cuáles son los 5 países con mayor esperanza de vida? Mostrar nombre del país, continente y la esperanza de vida sin valores decimales. */
select name, continent, truncate(lifeexpectancy, 0) from country order by LifeExpectancy desc limit 5;
	

/*Multiplicar IndepYear por SurfaceArea de todos los países europeos y de todos los africanos. */
select name, indepyear * surfacearea from country where continent in('Europe' , 'Africa');
	

/*Mostrar aquellos países que en el campo ‘GNP’ tienen un valor superior a 63 e inferior o igual a 64*/
select name, gnp from country where gnp > 63 and gnp <= 64;
	

/*Mostrar el campo ‘Capital’ de país. No deben aparecer valores nulos: se deben sustituir por la frase ‘sin Capital’*/
select name, ifnull(capital, 'sin Capital') from country;
	

/*Si la superficie de un país es superior a su población, mostrar el nombre del país en minúsculas; en caso contrario, en mayúsculas.*/
/*usando IF*/
select if(surfacearea>Population, lower(name), upper(name)) from country;


/*usando WHEN*/
select surfacearea, population, case when surfacearea>population then lower(name) else upper(name) end from country;
	

/*Funciones de agregación*/
/*Problemas FuncionesAG1*/

select min(population) from country;


select sum(population) from country where continent = 'africa';


select avg(population) from country where continent = 'north america';


/*ej 4 usando separator:*/
select group_concat(name separator ' ') from country where continent = 'asia';
/*ej 4 usando replace:*/
select replace(group_concat(name), ',', ' ') from country where continent = 'asia';


select group_concat(name order by name separator ' ') from country where continent = 'asia';
	



/*Problemas FuncionesAG2*/


select continent, max(population) from country group by continent;


/*2- Da error*/


select avg(lifeexpectancy) as "promedio" , continent from country group by continent order by promedio;


select sum(population) as "poblacion" , continent from country group by continent order by poblacion limit 1;


select sum(population) as "poblacion" , region, continent from country where continent='europe' group by region order by poblacion Desc limit 1;


select group_concat(name), governmentform from country where continent='south america' group by governmentform;


select governmentform, count(*) as cuenta from country group by governmentform order by cuenta desc limit 5;
	

/*Problemas FuncionesAG3*/


select continent, sum(population) as pob from country group by continent having pob>1000000000;


select countrycode from city group by countrycode having avg(population)>500000;


select avg(population), countrycode from city group by countrycode having countrycode like 'A%';


select region, count(name) as paises from country group by region having paises>10;


select governmentform, count(name) as cuenta from country group by governmentform having cuenta>20;


select continent, avg(population), count(name) as cuenta from country group by continent having cuenta>50;
	

/*Combinación de tablas*/
/*1*/


select city.name, country.name from city, country where countrycode=code;


select countrylanguage.language, country.name from countrylanguage, country where countrycode=code;


select city.name, country.name from city, country where countrycode=code order by city.population desc limit 10;


select city.name, country.name from city, country where countrycode=code and country.name='ukraine';


select countrylanguage.language from countrylanguage, country where countrycode=code and country.continent='africa' order by countrylanguage.language asc;


select sum(city.population) from city, country where countrycode=code and country.name='russian federation';


select (country.population)-(sum(city.population)) as pop from city, country where countrycode=code and country.name='russian federation' group by country.population;


/*PORCENTAJE:*/
select (100*(sum(city.population))/(country.population)) as porcentaje from city, country where countrycode=code and country.name='russian federation' group by country.population;
	

/*1*/


select country.name, city.name from city inner join country on country.capital = city.id;


select country.name, city.name from city inner join country on country.capital = city.id where city.countrycode in ('che','ata');


/*3.*/
select country.name, city.name from city left join country on country.capital = city.id where city.countrycode in ('che','ata');
/*La tabla de la izquierda sale todo NULL*/


/*4.*/
select country.name, city.name from city right join country on country.capital = city.id where city.countrycode in ('che','ata');
/*La tabla de la derecha sale todo NULL*/


select country.name, city.district, city.name from city inner join country on city.countrycode = country.code where city.name='san antonio';


select country.name, countrylanguage.language from country left join countrylanguage on country.code = countrylanguage.countrycode where country.name = 'sweden';






select name, language from country left join countrylanguage on country.code = countrylanguage.countrycode where language is null;


select name, language from country right join countrylanguage on country.code = countrylanguage.countrycode where language is null;


select country.name from country inner join countrylanguage on country.code = countrylanguage.countrycode where countrylanguage.language = 'french';


select country.name from country inner join city on country.code = city.countrycode where city.population >= 7000000;


select country.name, count(city.name) as ciudades from country inner join city on country.code = city.countrycode group by country.name order by ciudades desc limit 1;


/*MOSTRAR SOLO LOS PAISES EN LOS QUE SOLO SE HABLE FRANCES*/
select country.name from country inner join countrylanguage on country.code=countrylanguage.countrycode group by countrycode having group_concat(language)='french';
	

/*Subconsultas*/
/*1. */


SELECT EMP.APELLIDO, (SELECT DEPT.DNOM FROM DEPT WHERE EMP.DEPT_NO = DEPT.DEPT_NO) AS DEPARTAMENTO FROM EMP;


SELECT (SELECT DEPT.DNOM FROM DEPT WHERE DEPT.DEPT_NO=EMP.DEPT_NO) AS DEPARTAMENT, (SUM(SALARIO)/COUNT(EMP_NO)) FROM EMP GROUP BY DEPT_NO;


SELECT DEPT.DNOM, (SELECT COUNT(*) FROM EMP WHERE YEAR(FECHA_ALTA)=1981 AND EMP.DEPT_NO = DEPT.DEPT_NO) AS Alta en 1981 from DEPT;


/*SABER LOS PUESTOS DE TRABAJO QUE HAY EN CADA DEPARTAMENTO*/
SELECT (SELECT DNOM FROM DEPT WHERE DEPT_NO = EMP.DEPT_NO) AS NOM_DEPT , GROUP_CONCAT(DISTINCT OFICIO) AS EMPLEOS FROM EMP GROUP BY NOM_DEPT;
	

/*2. */


SELECT NAME FROM city WHERE POPULATION > (SELECT POPULATION FROM city WHERE NAME = 'New York') limit 3;


SELECT NAME, (SELECT COUNT(*) FROM city WHERE C.CODE=COUNTRYCODE) AS NUM_CIUDADES FROM country C WHERE REGION = 'Nordic Countries';


SELECT LANGUAGE FROM countrylanguage WHERE COUNTRYCODE=(SELECT CODE FROM country WHERE NAME='Singapore');


/*(*/
select distinct continent from country c where code=(select countrycode from countrylanguage where percentage > 50 and language = 'english' and countrycode = c.code);
/*o*/
select distinct continent from country where code in (select countrycode from countrylanguage where language='english' and percentage>50);
/*)*/


select name from country where populaton = (select max(population) from city);
