<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    //http://localhost/problemes1/4.php/?num1=4
    $num1=$_GET["num1"];

    $result=($num1*2+34)/2-$num1;
    if ($result==17) {
        echo("es cert");
    }
    else echo ("es fals, resultat = ".$result);
    ?>
</body>
</html>