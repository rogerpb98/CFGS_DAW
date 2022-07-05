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
    //http://localhost/problemes1/14.php/?price=48&paid=100
    $price=$_GET["price"];
    $paid=$_GET["paid"];
    if ($paid<$price) {
        echo("You didn't pay enough");
    }
    else {
        $cashback=$paid-$price;
        $arrayMoney = array(0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 500);
        $arrayPaid = array();
        while (array_sum($arrayPaid) != $cashback) { // Si la suma dels elements de l'array no supera el canvi a retornar entra
            foreach (array_reverse($arrayMoney) as $money) { // Recorre tots els elements de l'array començant pel final
                if (array_sum($arrayPaid)+$money<=$cashback) {// Si la suma del billet amb el pagat no supera el canvi a retornar entra
                    array_push($arrayPaid, $money); // Afegeix el bitllet/moneda a l'array
                    break;
                }
            }
        }
        print_r($arrayPaid);
    }
    ?>
</body>
</html>