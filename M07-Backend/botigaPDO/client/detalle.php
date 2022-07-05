<?php $id=$_GET["id"] ?>
<!DOCTYPE html>
<html lang="es">
<?php
    $title = "Detalle";
    include 'templates/head.php';
?>
<body onload="showDetalle(<?php echo $id ?>)">

    
    <?php
        include 'templates/header.php';
    ?>
    <hr>
    <main id="prod-main">
        <article id="article">

        </article>
    </main>


</body>
</html>