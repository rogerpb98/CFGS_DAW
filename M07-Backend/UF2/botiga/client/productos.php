<!DOCTYPE html>
<html lang="es">
<?php
    $title = "Productos";
    include 'templates/head.php';
?>
<body onload="showAllProducts()">
    <?php
        include 'templates/header.php';
    ?>
    <hr>
    <main id="prod-main">
        <section id="filtros">
            <div id="busqueda">
                <div>
                    <input type="text" id="categoria" name="categoria" placeholder="categoria">
                </div>
                <div>
                    <input type="text" id="name" name="name" placeholder="nombre">
                </div>
                <div>
                    <input type="text" id="descripcion" name="descripcion" placeholder="descripcion">
                </div>
                <div>
                    <input type="text" id="minprice" name="minprice" placeholder="precio minimo">
                    <input type="text" id="maxprice" name="maxprice" placeholder="precio maximo">
                </div>
                <button id="filtrar" onclick="filtrar()">Filtrar</button>
            </div>
            <div id="order-by">
                <button onclick="ordenarPrecio()">Ordenar por precio</button>
                <button onclick="ordenarFecha()">Ordenar por fecha</button>
            </div>
        </section>
        <hr>
        <section id="articles">
        </section>
    </main>
</body>
</html>