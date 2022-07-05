<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index.php del frmk DAW M7</title>
</head>
<body>
    <h1>Hola</h1>
    <?php
        include_once 'App.php';
        $url = $_GET["url"];
        $url = rtrim($url, "/");
        
        $params = explode('/', $url);

        $app = new App($params);
    ?>
</body>
</html>