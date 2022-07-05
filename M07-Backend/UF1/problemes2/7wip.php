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
    //http://localhost/problemes2/7.php/?texte=75Number9
    $texte=$_GET["texte"];
    $longitut=strlen($texte);

    for ($i=0; $i<$longitut; $i++) { 
        if (is_nan(substr($texte, $i, 1))) {
            echo ("<p>si</p>");
        }
        else {
            echo ("<p>no</p>");
        }
    }
    echo ("<p>El numero ".$num." no es capicua</p>");
    ?>
</body>
</html>