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
    //http://localhost/problemes2/13.php/?ean=65989522
    $ean=$_GET["ean"];
    $tipus="";
    $longitud=strlen($ean);
    $suma=0;
    if ($longitud<=8) {
        $tipus="ean8";
        $ean=str_pad($ean, 8, "0", STR_PAD_LEFT);
        $longitud=strlen($ean);
    }else if ($longitud<=13){
        $tipus="ean13";
        $ean=str_pad($ean, 13, "0", STR_PAD_LEFT);
        $longitud=strlen($ean);
    }
    $numerito=strrev(substr($ean, 0, $longitud-1));
    for ($i = 0; $i < $longitud; $i++) {
        if ($i%2==0) {//posicion impar
            $suma+=($numerito[$i]*3);
        } else {
            $suma+=$numerito[$i];
        }
        echo $numerito[$i];
        echo "<br>";
    }
    echo ($suma."<br>");
    if ((int)(substr($ean, -1))==10-$suma%10) {
        echo ($ean."-->Correcto");
        if ($longitud==13) {
            if ((int)substr($ean, 0, 1)==0) {
                echo (" (EEUU)");
            }elseif (((int)substr($ean, 0, 3)==380)) {
                echo (" (Bulgaria)");
            }
            elseif (((int)substr($ean, 0, 2)==50)) {
                echo (" (Inglaterra)");
            }
            elseif (((int)substr($ean, 0, 3)==539)) {
                echo (" (Irlanda)");
            }
            elseif (((int)substr($ean, 0, 3)==560)) {
                echo (" (Portugal)");
            }
            elseif (((int)substr($ean, 0, 2)==50)) {
                echo (" (Noruega)");
            }
        }
    }else {
        echo ($ean."-->Incorrecto");
    }
    ?>
</body>
</html>