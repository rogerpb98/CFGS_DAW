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
    //http://localhost/problemes2/8.php/?n1=2000&n2=2050
    $n1=$_GET["n1"];
    $n2=$_GET["n2"];
    $contador=0;
    $resultat="Ninguno de los años del rango tiene un 1 de enero que cae en miercoles";
    for ($i=$n1; $i <= $n2; $i++) { 
        $data=date_create_from_format('m-d-Y', "01-01-".$i);
        if(date_format($data,'w')==3) {
            $contador++;
            $resultat="el primer de gener de l'any ".$i." cau a dimecres<br>";
            break;
        }        
    }
    echo($resultat);
    ?>
</body>
</html>