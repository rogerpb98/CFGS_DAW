SET AUTOCOMMIT=1;

\! echo "Modifica las tablas para añadir una nueva columna con este campo de “no borrado /borrado”";
ALTER TABLE CATALOGO ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE CLIENTE ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE COCHE ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE CONCESIONARIO ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE MARCA ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE MODELO ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE VENDEDOR ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';
ALTER TABLE VENTA ADD COLUMN estado ENUM('borrado','no borrado') NOT NULL DEFAULT 'no borrado';

\! echo "Genera vistas que muestren la información “no borrada”";
CREATE VIEW CATALOGO_UP AS SELECT * FROM CATALOGO WHERE estado='no borrado';
CREATE VIEW CLIENTE_UP AS SELECT * FROM CLIENTE WHERE estado='no borrado';
CREATE VIEW COCHE_UP AS SELECT * FROM COCHE WHERE estado='no borrado';
CREATE VIEW CONCESIONARIO_UP AS SELECT * FROM CONCESIONARIO WHERE estado='no borrado';
CREATE VIEW MARCA_UP AS SELECT * FROM MARCA WHERE estado='no borrado';
CREATE VIEW MODELO_UP AS SELECT * FROM MODELO WHERE estado='no borrado';
CREATE VIEW VENDEDOR_UP AS SELECT * FROM VENDEDOR WHERE estado='no borrado';
CREATE VIEW VENTA_UP AS SELECT * FROM VENTA WHERE estado='no borrado';

\! echo "Haz una nueva versión del script del ejercicio 4, pero ahora en lugar de eliminar los registros, los marque como borrados (es decir, hace updates en vez de deletes).";
/*REVISAR POR QUE NO MARCA COMO BORRADO DE FORMA RECURSIVA*/
UPDATE MARCA SET estado = 'borrado' WHERE nombre='Toyota';
/*DELETE FROM MARCA WHERE nombre='Opel';*/

\! echo "Repite alguna consulta del ejercicio 2 pero ahora utilizando las vistas, y donde se vea claro que no aparece la información “borrada”.";
SELECT 
    /*el siguiente select muestra los concesionarios cuyo ID coincida con el ID del concesionario correspondiente al ID del vendedor en cada venta*/
    (SELECT CONCESIONARIO.nombre FROM CONCESIONARIO, VENDEDOR WHERE CONCESIONARIO.codigo=VENDEDOR.concesionario AND VENDEDOR.codigo = VENTA.vendedor) AS concesionario, 
    MODELO_UP.*, 
    VENTA.precio, 
    (pvr-precio) AS Diferencia 
    FROM MODELO_UP, VENTA WHERE VENTA.modelo = MODELO_UP.modelo;
