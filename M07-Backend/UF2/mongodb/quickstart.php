<?php

    require '/vendor/autoload.php';

    $host = "localhost:27017";
    $user = "roger";
    $pass = "roger";
    $db = "dbtest";

    $client = new MongoDB\Client('mongodb://'.$user.':'.$pass.'@'.$host.'/'.$db);

    $collection = $client->bbdd->cosas;
    $result = $collection->insertOne( [ 'item' => 'producto1', 'cantidad' => '200' ] );

    //echo "Inserted with Object ID '{$result->getInsertedId()}'";

    /*
    $customers = $client->selectCollection('sample_analytics', 'customers');
    $document = $customers->findOne(['username' => 'wesley20']);
    */
    
    var_dump($document);

?>