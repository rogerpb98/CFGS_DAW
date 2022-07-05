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
    //http://localhost/problemes2/1.php/?text=fsdahjbbkglash
    $text=$_GET["text"];
    $longitut=strlen($text);
    $contadorA=0;
    $contadorB=0;
    for ($i=0; $i<$longitut; $i++) {
        $lletra=strtolower(substr($text, $i, 1));
        if ($lletra=="a") {
            $contadorA++;
        }
        if ($lletra=="b") {
            $contadorB++;
        }
    }
    echo ("<p>Nombre de lletres 'A': ".$contadorA."</p>");
    echo ("<p>Nombre de lletres 'B': ".$contadorB."</p>");
    echo ("<p>Hi ha el mateix nombre de 'A' que de 'B'? ".($contadorA==$contadorB ? 'si' : 'no')."</p>");
    ?>
</body>
</html>