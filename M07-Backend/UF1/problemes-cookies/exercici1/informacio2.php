<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        header {
            display:flex;
            justify-content: space-between;
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
            <a href="informacio1.php">Informació 1</a>
            <a href="#">Informació 2</a>
        </nav>
        <div>
            <?php echo "<p>Benvingut ".$_COOKIE['user']."</p>" ?>
        </div>
    </header>
    <body>
        <h2>Informació 2</h2>
        <p>Si has arribat aquí es que has fet login correctament</p>
    </body>
    <footer>
        <p>Pàgina de Roger Pérez Blanco</p>
    </footer>
</body>
</html>