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
    //http://localhost/problemes1/16.php/

    echo ("<table border=1px solid black>");
    for ($i=1; $i <= 10; $i++) { 
        echo ("<tr>");
        for ($o=1; $o <= 10; $o++) { 
                echo ("<td style='text-align:center; padding:3px'>".$i*$o."</td>");
        }
        echo ("</tr>");
    }
    echo ("</table>");
    ?>
</body>
</html>