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
    //http://localhost/problemes1/15.php/?num1=4&num2=7
    $num1=$_GET["num1"];
    $num2=$_GET["num2"];
    echo ("<table border=1px solid black>");
    for ($i=1; $i <= $num1; $i++) { 
        echo ("<tr>");
        for ($o=1; $o <= $num2; $o++) { 
            echo ("<td>".$i.".".$o."</td>");
        }
        echo ("</tr>");
    }
    echo ("</table>");
    ?>
</body>
</html>
