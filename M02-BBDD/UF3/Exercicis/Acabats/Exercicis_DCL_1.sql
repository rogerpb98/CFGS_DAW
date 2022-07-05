/*Cambiar contraseña a un usuario*/
alter user pepe identified by 'asdasd'; 
/*1. Obten la lista de usuarios de mysql*/
SELECT user FROM user;
/*2. Crea el usuario pepe sin ningun tipo de privilegio*/
CREATE USER pepe;
/*3. Consulta las tablas user, db y tables_priv de myql. 
Indica que acciones puede realizar este usuario recien creado*/
SELECT * FROM user WHERE user='pepe' and host='%' \G;
/*4. Cual es el host por defecto de usuario pepe?*/
select host from user where user='pepe';
/*5. Indica formas equivalentes de crear este mismo usuario*/
CREATE USER pepe@'%';
CREATE USER pepe;
/*6. Una vez creado el usuario pepe, se podria crear el mismo
usuario pero ahora para el host localhost? Compruebalo*/
CREATE USER pepe@localhost;
/*7. Indica el comando que da el numero de puerto y el hostname
de la conexi�n*/
SHOW VARIABLES WHERE variable_name IN ('hostname', 'port');
/*8. Busca los usuarios que actualmente este activos*/
SHOW PROCESSLIST;
/*9. �Como se borrarias los dos usuarios creados?*/
DROP USER pepe@'%', pepe@localhost;
/*10. Crea el usuario maria de localhost*/
CREATE user maria@localhost;
/*11. Mediante un comando comprueba sus permisos*/
SHOW GRANTS FOR maria@localhost;
/*12. Que significa GRANT USAGE*/
que se puede conectar y nada más
/*13. Abre otra sesión con el usuario María y realiza una consulta sobre
la tabla clientes.  Puede hacerse? */
no
/*14. Cual es el usuario activo en ambas sesiones*/
select user();
maria@localhost en la sesion de maria
root@localhost en la sesion de root
/*15. Cuales son sus permisos?*/
Usage en maria@localhost
todos los privilegios en root
/*16. Asigna al usuario maria permisos globales de selecci�n,
actualizaci�n y ejecuci�n*/
grant select, update, execute on *.* to maria@localhost;
/*17. Observa las tablas user y db. 
Donde se han producido cambios?*/
se han cambiado a Y los permisos que le acabamos de conceder a maria
/*18. Asigna al usuario maria todos los permisos globales
Hay alguno que no se haya concedido? Como se arreglaria*/
grant all on *.* to maria@localhost;
falta el Grant_priv
GRANT GRANT OPTION ON *.* TO maria@localhost;
/*19. Revoca del usuario maria los permisos globales de 
seleccion, insercion y borrado y creacion. 
Comprueba como han quedado las tablas*/
revoke select, insert, delete, create on *.* from maria@localhost;
/*20. Revoca todos los permisos del usuario maria */
/*Visualiza todos los cambios en user y db*/
revoke all privileges, grant option from maria@localhost;
select * from user where user='maria' and host='localhost';