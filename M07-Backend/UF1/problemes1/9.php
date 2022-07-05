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
    //http://localhost/problemes1/9.php/?num=7
    $num=$_GET["num"];
    
    for ($i=0; $i <= 10; $i++) { 
        echo($num."*".$i."=".$num*$i."<br>");
    }
    ?>
</body>
</html>