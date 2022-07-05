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
    //http://localhost/problemes2/5.php/?texte=hola&posicio=3
    $texte=$_GET["texte"];
    $posicio=$_GET["posicio"]-1; //restem 1 perque la posició comença per 0
    $longitutTexte1=strlen($texte);
    $resultat=substr_replace($texte, '', $posicio, 1);
    echo ("<p>Resultat: ".$resultat."</p>");
    ?>
</body>
</html>