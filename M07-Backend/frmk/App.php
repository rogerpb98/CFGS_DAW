<?php
class App{
    
    public function __construct($input) {

        $archivo="./controlador/".$input[0].".php";
        if (file_exists($archivo)){
            require_once $archivo;
            $control = new $input[0];
        }

    }

}
?>