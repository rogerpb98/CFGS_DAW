SET AUTOCOMMIT=0;

BEGIN;

\! echo "1. Incrementa un 5% el precio recomendado (pvr) para todos los modelos de aquellas marcas con más de 3 modelos comercializados (ofertados, puestos a la venta).";
 UPDATE MODELO SET pvr = ((pvr*5/100)+pvr) WHERE MARCA IN (SELECT marca FROM CATALOGO GROUP BY marca HAVING count(modelo)>=3);
/*filas a aumentar*/
/*SELECT pvr FROM MODELO WHERE MARCA IN (SELECT marca FROM CATALOGO GROUP BY marca HAVING count(modelo)>=3);*/
/*marcas con mas de 3 coches a la venta*/
/*SELECT marca FROM CATALOGO GROUP BY marca HAVING count(modelo)>=3;*/
\! echo "2. Modifica (actualiza) el nombre de una marca. Dada la marca ‘a’, cambia su nombre por un nuevo valor ‘b’ inexistente hasta ese momento. Tén en cuenta que dicha columna es la clave primaria de la tabla MARCA y es clave extranjera en otras tablas.";
UPDATE MARCA SET nombre = 'AmiShawarma' WHERE nombre = 'Ford';

\! echo "3. Crea un nuevo concesionario como copia de otro existente. Esto es, dada la marca ‘a’, introduce en las tablas adecuadas un nuevo concesionario ‘c’ (inexistente hasta este momento) como una copia del concesionario principal de la marca ‘a’. A continuación, haz que el nuevo concesionario ‘c’ sea ahora el concesionario principal de la marca ‘a’. "; 
CREATE TEMPORARY TABLE concesionario_tmp SELECT CONCESIONARIO.* FROM CONCESIONARIO, MARCA WHERE CONCESIONARIO.codigo=MARCA.concesionario_principal AND MARCA.nombre='AmiShawarma';
UPDATE concesionario_tmp SET codigo = (SELECT MAX(CONCESIONARIO.codigo)+1 FROM CONCESIONARIO);
INSERT INTO CONCESIONARIO SELECT * FROM concesionario_tmp;
DROP TEMPORARY TABLE IF EXISTS concesionario_tmp;

\! echo "4. Realiza la siguiente secuencia:";

\! echo "4.1. Muestra por pantalla la clave primaria de los coches junto con su número de puertas.";
SELECT marca, modelo, numero, puertas FROM COCHE;

\! echo "4.2. Intercambia el número de puertas de los coches, de forma que los de 5 puertas pasen a tener 3 puertas y viceversa.";
/*Coger todos los coches de 3 puertas y cambiarlos a 5 en tabla temporal*/
CREATE TEMPORARY TABLE coche_tmp_1 SELECT COCHE.* FROM COCHE WHERE COCHE.puertas='3';
UPDATE coche_tmp_1 SET puertas = '5';
/*Coger todos los coches de 5 puertas y cambiarlos a 3 en tabla temporal*/
CREATE TEMPORARY TABLE coche_tmp_2 SELECT COCHE.* FROM COCHE WHERE COCHE.puertas='5';
UPDATE coche_tmp_2 SET puertas = '3';

/*Reemplazar las filas con el valor de puertas actualizado*/
REPLACE INTO COCHE SELECT coche_tmp_1.* FROM coche_tmp_1, COCHE WHERE coche_tmp_1.numero=COCHE.numero AND coche_tmp_1.marca=COCHE.marca AND coche_tmp_1.modelo=COCHE.modelo;
REPLACE INTO COCHE SELECT coche_tmp_2.* FROM coche_tmp_2, COCHE WHERE coche_tmp_2.numero=COCHE.numero AND coche_tmp_2.marca=COCHE.marca AND coche_tmp_2.modelo=COCHE.modelo;
DROP TEMPORARY TABLE IF EXISTS coche_tmp_1, coche_tmp_2;

\! echo "4.3. Vuelve a mostrar los datos para comprobar que se han intercambiado.";
SELECT marca, modelo, numero, puertas FROM COCHE;

\! echo "4.4. Por último, haz ROLLBACK para dejar los datos como estaban al principio y comprobar que así ha sido.";

ROLLBACK;
SELECT marca, modelo, numero, puertas FROM COCHE;