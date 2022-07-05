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
    //http://localhost/problemes2/14.php/?c1=2&c2=3&p1=-2&p2=5
    $c1=$_GET["c1"];
    $c2=$_GET["c2"];
    $p1=$_GET["p1"];
    $p2=$_GET["p2"];
    echo ("<table border=1px solid black>");
    for ($i=5; $i >= -5; $i--) { 
        echo ("<tr>");
        for ($j=-5; $j <= 5; $j++) { 
            $stringFinal="";
            //concatenar con bg color si coincide con las coordenadas dadas
            $stringFinal.=($i==$c1 && $j==$c2 || $i==$p1 && $j==$p2)?"<td style='background-color: red'>":"<td>";

            $stringFinal.=($i==0 || $j==0)?$i.".".$j." </td>":" </td>";

            echo($stringFinal);
        }
        echo ("</tr>");
    }
    echo ("</table>");
    ?>
</body>
</html>