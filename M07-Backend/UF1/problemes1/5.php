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
    //http://localhost/problemes1/5.php/?num1=4&num2=7
    $num1=$_GET["num1"];
    $num2=$_GET["num2"];

    echo("Divisió real: ".$num1/$num2."<br>");
    echo("Divisió acotada a 2 decimals: ".number_format($num1/$num2, 2, '.', '')."<br>");
    echo("Divisió sencera: ".$num1/$num2."<br>");
    echo("Residu: ".$num1%$num2."<br>");
    ?>
</body>
</html>