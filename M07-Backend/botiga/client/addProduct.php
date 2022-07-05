<!DOCTYPE html>
<html lang="es">
<?php
    $title = "Productos";
    include 'templates/head.php';
?>
<body>
    <?php
    session_start();
    if (!(isset($_SESSION['user']))) {
        header("Location: productos.php"); 
        exit();
    }
    ?>
    <?php
        include 'templates/header.php';
    ?>
    <hr>
    <main class="log-reg-main">
        <div>
            <h3>Add Product</h3>
            <br>
            <p>Nombre *</p><input type="text" id="nombre" name="nombre">
            <p>Categoria *</p><input type="text" id="categoria" name="categoria">
            <p>Descripción *</p><input type="text" id="descripcion" name="descripcion">
            <p>Precio (€) *</p><input type="text" id="precio" name="precio">
            <p>Imagen 1</p><input type="file" id="imagen1" name="imagen1">
            <p>Imagen 2</p><input type="file" id="imagen2" name="imagen2">
            <p>Imagen 3</p><input type="file" id="imagen3" name="imagen3">
            <div id="btns">
                <button class="header-user" onclick="addProduct()">Add Product</button>
            </div>
            <a href="productos.php">Volver a productos</a>
        </div>
    </main>
</body>
</html>