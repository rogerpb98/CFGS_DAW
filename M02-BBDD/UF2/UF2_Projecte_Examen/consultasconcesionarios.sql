SET AUTOCOMMIT=1;

\! echo "1. Listado ordenado de los modelos según unidades vendidas:";
select DISTINCT marca, modelo, (select count(modelo) from VENTA where VENTA.modelo = COCHE.modelo) AS Modelos_Vendidos from COCHE ORDER BY Modelos_Vendidos DESC;

\! echo "2. Listado de concesionarios ordenado por número de vehículos vendidos:";
SELECT CONCESIONARIO.nombre, COUNT(*) FROM CONCESIONARIO, VENDEDOR, VENTA WHERE CONCESIONARIO.codigo=VENDEDOR.concesionario AND VENDEDOR.codigo = VENTA.vendedor GROUP BY CONCESIONARIO.nombre ORDER BY COUNT(*);

\! echo "3. Listado de modelos ordenados por el número de catálogos en los que aparece:";
SELECT *, (SELECT COUNT(*) FROM CATALOGO WHERE MODELO.modelo = CATALOGO.modelo) AS Apariciones FROM MODELO order by Apariciones;


\! echo "4. Queremos conocer los tres mejores clientes (nombre, apellido, teléfono y tipo) junto con el total facturado a cada uno:";
SELECT nombre, apellido, telefono, tipo, precio FROM CLIENTE, VENTA WHERE VENTA.cliente=CLIENTE.identificador ORDER BY precio DESC LIMIT 3;


\! echo "5. Para cada año queremos conocer el mejor vendedor (nombre, teléfono, jefe y nombre del concesionario donde trabaja), junto con el total facturado (ese año):";
\! echo "He conseguido sacar la mejor venta de cada año, pero no he sabido como adjuntar los datos del vendedor a éstas.";
SELECT YEAR(fecha) AS Año, MAX(precio) from VENDEDOR, VENTA WHERE VENDEDOR.codigo=VENTA.vendedor GROUP BY Año;


\! echo "6. Listado de concesionarios ordenados por la diferencia que han aplicado entre el precio de venta recomendado, y el precio al que han facturado cada vehículo:";
SELECT 
    /*el siguiente select muestra los concesionarios cuyo ID coincida con el ID del concesionario correspondiente al ID del vendedor en cada venta*/
    (SELECT CONCESIONARIO.nombre FROM CONCESIONARIO, VENDEDOR WHERE CONCESIONARIO.codigo=VENDEDOR.concesionario AND VENDEDOR.codigo = VENTA.vendedor) AS concesionario, 
    MODELO.*, 
    VENTA.precio, 
    (pvr-precio) AS Diferencia 
    FROM MODELO, VENTA WHERE VENTA.modelo = MODELO.modelo;
