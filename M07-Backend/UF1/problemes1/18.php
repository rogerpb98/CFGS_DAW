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
    //http://localhost/problemes1/18.php/?num1=7
    $num1=$_GET["num1"];
    if ($num1%2==0) {
        echo ("Ha de ser senar");
    }
    else {
        echo ("<table border=1px solid black>");
        for ($i=ceil($num1/2); $i >=1 ; $i--) { 
            echo ("<tr>");
            for ($o=1; $o <= $num1/2; $o++) { //la meitat de pujada
                if ($i>$o) {
                    echo ("<td>".$i.".".$o."</td>");
                }
                else {
                    echo ("<td style='background-color: red'>".$i.".".$o."</td>");
                }
            }
            for ($o=ceil($num1/2); $o <= $num1; $o++) { //la meitat de baixada
                if ($i+$o>$num1+1) { //si introduim 7, la suma dels dos ha de ser 8 o menys per ser vermell
                    echo ("<td>".$i.".".$o."</td>");
                }
                else {
                    echo ("<td style='background-color: red'>".$i.".".$o."</td>");
                }
            }
            echo ("</tr>");
        }
        /******************** */
        for ($i=2; $i <=ceil($num1/2) ; $i++) { 
            echo ("<tr>");
            for ($o=1; $o <= $num1/2; $o++) { //la meitat de pujada
                if ($i>$o) {
                    echo ("<td>".$i.".".$o."</td>");
                }
                else {
                    echo ("<td style='background-color: red'>".$i.".".$o."</td>");
                }
            }
            for ($o=ceil($num1/2); $o <= $num1; $o++) { //la meitat de baixada
                if ($i+$o>$num1+1) { //si introduim 7, la suma dels dos ha de ser 8 o menys per ser vermell
                    echo ("<td>".$i.".".$o."</td>");
                }
                else {
                    echo ("<td style='background-color: red'>".$i.".".$o."</td>");
                }
            }
            echo ("</tr>");
        }
        echo ("</table>");
    }
    ?>
</body>
</html>