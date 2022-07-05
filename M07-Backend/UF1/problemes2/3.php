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
    //http://localhost/problemes2/3.php/?texte=fsda hj bbkglash
    $texte=$_GET["texte"];
    $longitut=strlen($texte);
    $paraules=explode(" ", $texte);
    $contador=0;
    for ($i=0; $i<$longitut; $i++) {
        $lletra=strtolower(substr($texte, $i, 1));
        if ($lletra=="a" ||$lletra=="e" ||$lletra=="i" ||$lletra=="o" ||$lletra=="u") {
            $contador++;
        }
    }
    echo ("<p>En majuscules: ".strtoupper($texte)."</p>");
    echo ("<p>En minuscules: ".strtolower($texte)."</p>");
    echo ("<p>Longitut total: ".$longitut."</p>");
    echo ("<p>Nombre de paraules que te: ".count($paraules)."</p>");
    echo ("<p>Nombre de vocals: ".$contador."</p>");
    for ($i=0; $i<$longitut; $i++) {
        echo ("<p>".substr($texte, 0, $longitut-$i)."</p>");
    }
    ?>
</body>
</html>