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
    //http://localhost/problemes2/4.php/?texte1=holaaaaholall&texte2=hola
    $texte1=$_GET["texte1"];
    $texte2=$_GET["texte2"];
    $longitutTexte1=strlen($texte1);
    $longitutTexte2=strlen($texte2);
    $contador=0;
    for ($i=0; $i<$longitutTexte1; $i++) {
        //per cada lletra, extreiem les seguents lletres potencialment iguals a la paraula que busquem
        $possibleMatch=strtolower(substr($texte1, $i, $longitutTexte2));
        if ($possibleMatch==strtolower($texte2)) {
            $contador++;
        }
    }
    echo ("<p>Nombre de cops que es repeteix la paraula: ".$contador."</p>");
    ?>
</body>
</html>