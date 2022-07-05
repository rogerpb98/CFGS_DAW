<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        header, #user{
            display:flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>
    <?php
    if (!(isset($_COOKIE['user']) && isset($_COOKIE['password']))) {
        header("Location: login.php"); 
        exit();
    }
    ?>
    <header>
        <nav>
        </nav>
        <div id="user">
            <?php echo "<p>Benvingut ".$_COOKIE['user']."</p>" ?>
            <a href="logout.php">Log out</a>
        </div>
    </header>
    <body>
        <form method="post" action="updateCarrito.php">
            Article:
            <input type="text" id="article" name="article" pattern="\w*"><br><br>
            Preu:
            <input type="text" id="price" name="price" pattern="\d*"><br><br>
            <input type="submit" value="Submit">
        </form><br>
        <a href="finalizarCompra.php">Finalitzar Compra</a>
    </body>
    <footer>
        <p>Pàgina de Roger Pérez Blanco</p>
    </footer>
</body>
</html>