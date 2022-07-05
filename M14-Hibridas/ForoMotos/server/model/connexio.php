<?php
    // No tocar
    class Connexio {
        public static function connectar(){
            try {
                $db = new PDO("mysql:host=localhost;dbname=foromotos", "roger", "roger");
                $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $db->exec("SET CHARACTER SET UTF8");
            }
            catch(Exception $e){
                die("Error de conexión:" . $e->getMessage());
            }
            return $db;
        }
    }
?>
