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
    //http://localhost/problemes1/3.php/?num1=4&num2=7
    $num1=$_GET["num1"];
    $num2=$_GET["num2"];

    if (abs(100-$num1)>abs(100-$num2)) {
        echo $num2;
    }
    else echo $num1;
    ?>
</body>
</html>
