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
    //http://localhost/problemes2/2.php/?texte=fsdahjbbkglash&caracter=a
    $texte=$_GET["texte"];
    $caracter=$_GET["caracter"];
    $longitut=strlen($texte);
    if (strlen($caracter)!=1) {
        echo ("<p>Has d'introduir un caracter</p>");
    }
    else {
        $contador=0;
        for ($i=0; $i<$longitut; $i++) {
            $lletra=strtolower(substr($texte, $i, 1));
            if ($lletra==$caracter) {
                $contador++;
            }
        }
        echo ("<p>Nombre de lletres '".$caracter."': ".$contador."</p>");
    }
    ?>
</body>
</html>