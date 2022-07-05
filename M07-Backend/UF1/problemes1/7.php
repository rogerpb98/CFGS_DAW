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
    //http://localhost/problemes1/7.php/?date=03121997
    $date=$_GET["date"];

    $day= substr($date, 0, 2);
    $month= substr($date, 2, 2);
    $year= substr($date, 4, 4);

    if ($day<01 || $day>30) {
        echo("Wrong day");
    }
    elseif ($month<01 || $month>12) {
        echo("Wrong month");
    }
    else {
        echo($day."/".$month."/".$year);
    }
    ?>
</body>
</html>