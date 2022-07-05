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
    //http://localhost/problemes1/8.php/?date=03121997
    $date=$_GET["date"];
    
    if (strlen($date)==6) {
        $day= substr($date, 0, 1);
        $month= substr($date, 1, 1);
        $year= substr($date, 2, 4);
        //Add 0 to day and month
        $day = substr(str_repeat(0, 1).$day, - 1);
    }
    elseif (strlen($date)==7) {
        # code...
    }
    elseif (strlen($date)==8) {
        $day= substr($date, 0, 2);
        $month= substr($date, 2, 2);
        $year= substr($date, 4, 4);
    }

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