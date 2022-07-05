SET AUTOCOMMIT=1;

\! echo "Modifica la definición de la columna que almacena el número de puertas de los coches, para que su valor por defecto sea 5.";
ALTER TABLE COCHE MODIFY COLUMN puertas ENUM('3', '5') NOT NULL DEFAULT '5';

\! echo "Establece que la columna que almacena los teléfonos de los clientes debe, a partir de ahora, ser opcional, es decir, admitir NULL como valor.";
ALTER TABLE CLIENTE MODIFY COLUMN telefono CHAR(9) NULL;

\! echo "Supuesta la existencia de una restricción de integridad sobre la columna que almacena el tipo de cliente, que limita su valor a ‘particular’ y ‘empresa’ (Nota: si no existe ya, debe crearse dicha restricción al principio de este ejercicio) altera dicha restricción de forma que un organismo público pueda registrarse como cliente, esto es, que la columna admita también el valor ‘org_publ’.";
ALTER TABLE CLIENTE MODIFY COLUMN tipo ENUM('Particular','Empresa','org_publ') NOT NULL;

\! echo "Altera la tabla que almacena las marcas para añadir la columna num_conces. A continuación rellena dicha columna con el número actual de concesionarios que tiene cada marca.";
/*FALTA COMPROBAR QUE ESTA FUNCIONE BIEN*/
ALTER TABLE MARCA ADD COLUMN num_conces TINYINT UNSIGNED NOT NULL;

/*Rellenar la columna con los valores que toca (FALLA)*/
REPLACE INTO MARCA (num_conces) (SELECT (SELECT COUNT(*) FROM CONCESIONARIO WHERE MARCA.nombre = CONCESIONARIO.marca) AS Apariciones FROM MARCA order by Apariciones);
\! echo "HE CONSEGUIDO EXTRAER LA INFORMACIÓN QUE IRIA EN EL REPLACE, PERO NO HE SABIDO HACERLO FUNCIONAR";
SELECT (SELECT COUNT(*) FROM CONCESIONARIO WHERE MARCA.nombre = CONCESIONARIO.marca) AS Apariciones FROM MARCA order by Apariciones;

\! echo "Elimina la columna num_conces de la tabla que almacena las marcas, de forma que dicha tabla quede tal y como estaba originalmente (en estructura, contenido y restricciones de integridad).";
ALTER TABLE MARCA DROP COLUMN num_conces;
