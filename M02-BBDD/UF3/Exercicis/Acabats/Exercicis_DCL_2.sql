DROP USER IF EXISTS maria, mariona, pep@CualquierEquipo, francis@'localhost', Administrador@'localhost', Invitado@'CualquierEquipo', Nuria;


/*1. Crea una base de datos dcl2 con las tablas
 empleados y departamentos, y una foreign key entre 
 empleados (cod_dept) y departamentos(cod_dept) 
 empleados: id int primary key auto_increment, nombre VARCHAR(20),   
 apellidos VARCHAR(25), salario double, cod_deptint
 departamentos:cod_dept INT PRIMARY KEY auto_increment,
 nombre VARCHAR(20), direccion VARCHAR(10), objetivos int
*/
DROP DATABASE IF EXISTS dcl2;
CREATE SCHEMA IF NOT EXISTS dcl2 charset utf8;
use dcl2;

CREATE TABLE IF NOT EXISTS dcl2.departamentos (
        cod_dept   INT AUTO_INCREMENT,
        nombre 	   VARCHAR(20),
        direccion  VARCHAR(10),
        objetivos  INT,

        PRIMARY KEY (cod_dept)
);

CREATE TABLE IF NOT EXISTS dcl2.empleados (
        id         INT AUTO_INCREMENT,
        nombre     VARCHAR(20),
        apellidos  VARCHAR(25),
        salario    DOUBLE,
        cod_dept   INT,

        PRIMARY KEY (id),
        FOREIGN KEY (cod_dept) REFERENCES departamentos(cod_dept) ON DELETE CASCADE ON UPDATE CASCADE
);

/*2. Inserta 2 o 3 registros de empleados y departamentos*/
INSERT INTO dcl2.departamentos (nombre, direccion, objetivos) 
    VALUES ('Departamento1',     'asd 123',     3451);
INSERT INTO dcl2.departamentos (nombre, direccion, objetivos) 
    VALUES ('Departamento2',     'bcd 32',     1237);

INSERT INTO dcl2.empleados (nombre, apellidos, salario, cod_dept) 
    VALUES ('Antonia',     'Dominguez Sabadez',     2100.00,  1);
INSERT INTO dcl2.empleados (nombre, apellidos, salario, cod_dept) 
    VALUES ('Mateo',     'García Lorca',     1600.00,  2);

/*3.Crea una vista emp_vista que sea una inner join entre
empleados y departamentos*/
CREATE VIEW emp_vista AS 
select departamentos.cod_dept, departamentos.nombre AS nombre_dep, direccion, objetivos, id, empleados.nombre AS nombre_emp, apellidos, salario from  departamentos inner join empleados;

/*4.Crea el usuario 'maria' que venga de cualquier equipo,
inicialmente sin password*/
CREATE USER maria;

/*5. Agrega el passwod maria al usuario maria*/
alter user maria identified by '123'; 

/*6. Cambia el usuario de maria a mariona. Compruebalo*/
RENAME USER maria TO mariona;

/*7. Cambia el password del usuario mariona a mariona*/
alter user mariona identified by 'mariona'; 

/*8. Asigna privilegios globales de inserción, actualizacion
y borrado a mariona. Compruebalo.*/
grant insert, update, delete on *.* to mariona;

/*9. Puede el usuario mariona visualizar la vista emp_vista. 
Abre una nueva sesión con este usuario y compruebalo.*/

/*Resposta: no, command denied.*/
 
/*10. Concede al usuario mariona permisos para crear y  
ver cualquier vista de la base datos dcl2.
Cuales son los permisos asociados a las vistas? 
Que tablas quedan afectadas?*/
grant SHOW VIEW, CREATE VIEW on dcl2.* to mariona;

/*11. Se puede visualizar la vista emp_vista ahora?
que se deberia de hacer?*/
grant SELECT on dcl2.emp_vista to mariona;

/*12. Crea el usuario pep@CualquierEquipo con
el password 1234*/
CREATE user 'pep'@'CualquierEquipo' identified by '1234'; 
 
/*13. Otorga al usuario 'pep' permisos para consultar las 
tablas empleados y departamentos. 
Comprueba que tablas quedan afectadas*/
grant SELECT on dcl2.departamentos to 'pep'@'CualquierEquipo';
grant SELECT on dcl2.empleados to 'pep'@'CualquierEquipo';

/*14. Que el usuario 'pep' pueda conceder a otros usuarios,  
los privilegios ya adquiridos, aunque no puede crear usuarios.
Mira como quedan las tablas afectadas*/
grant GRANT OPTION on dcl2.* to 'pep'@'CualquierEquipo';

/*15. El usuario 'pep' sÓlo puede realizar un numero máximo de 
consultas de 20 por hora.
que tablas se modifican?*/
alter user 'pep'@'CualquierEquipo' identified by '1234'
    WITH MAX_QUERIES_PER_HOUR 20;

/*16. El usuario pep sólo puede hacer:
- 10 actualizaciones por hora
- 5 conexiones por hora
- 2 conexiones de usuario*/
alter user 'pep'@'CualquierEquipo' identified by '1234'
    WITH MAX_UPDATES_PER_HOUR 10
         MAX_CONNECTIONS_PER_HOUR 5
         MAX_USER_CONNECTIONS 2;

/*17. Crea el usuario francis@localhost con password 'frank' 
que tenga los mismos parámetros de conexion que el usuario pep, 
usando la instruccion create user*/
CREATE user francis@'localhost' identified by 'frank'
    WITH MAX_QUERIES_PER_HOUR 20
         MAX_UPDATES_PER_HOUR 10
         MAX_CONNECTIONS_PER_HOUR 5
         MAX_USER_CONNECTIONS 2; 

/*18. Crea el usuario Administrador@localhost y password 'Admin':
Sera el administrador de esta bbdd. Tendr�, por tanto, permisos para 
crear tablas, vistas, rutinas, modificarlas, eliminarlas, 
bloquearlas y gestionar usuarios de esa bbdd.
Mira que permisos estan en mysql.user y no en mysql.db*/
CREATE user Administrador@'localhost' identified by 'Admin';
GRANT ALL ON dcl2 TO 'Administrador'@'localhost';

/*select * from mysql.user where user='Administrador' \G;
select * from mysql.user where user='Administrador' \G;*/

/*19. Crea Invitado@CualquierEquipo: Otorgale permisos de 
consulta en la columna nombre, apellidos de la tabla empleados 
y nombre y direccion de la tabla departamentos
que tablas se han modificado?*/
CREATE user 'Invitado'@'CualquierEquipo'; 
GRANT SELECT (nombre, apellidos) ON dcl2.empleados TO Invitado@'CualquierEquipo';
GRANT SELECT (nombre, direccion) ON dcl2.departamentos TO Invitado@'CualquierEquipo';

/*20.Cambia el nombre del usuario mariona por 'Nuria' y revocale la 
capacidad de modificar vistas.*/
RENAME USER mariona TO Nuria;
REVOKE CREATE VIEW on dcl2.* FROM Nuria;
