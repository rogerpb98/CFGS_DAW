<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    //http://localhost/problemes2/6.php
    $num=rand(100, 999);
    $numString=(strval($num));
    if ($numString==strrev($numString)) {
        echo ("<p>El numero ".$num." es capicua</p>");
    }
    else {
        echo ("<p>El numero ".$num." no es capicua</p>");
    }
    ?>
</body>
</html>