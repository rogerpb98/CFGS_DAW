<?php
    require_once("./model/users_m.php");
    class Users{    
        public function __construct($params, $body){
            $method = array_shift($params);
            $x_api_key = array_shift($params);
            switch ($method){
                case "GET":
                    $this->getUser($params);
                    break;
                case "POST":
                    $this->postUser($params, $body);
                    break;
                case "DELETE":
                    $this->deleteUser($params, $body, $x_api_key);
                    break;
                default:
                    $this->notImplementedMethodUser($params, $body, $method);
                    break;
            }
        }
        
        private function getUser($params){
            $model = new Users_model();
            if (count($params) == 0){
                //curl localhost/ForoMotos/server/users
                $response = $model->getUsers();
            }else{
                switch (strtolower($params[0])){
                    case "username":
                        $response = null;
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/users_v.php");
        }

        private function postUser($params, $body){
            $model = new Users_model();
            if (count($params) != 0) {
                switch (strtolower($params[0])){
                    case "login":
                        //curl -X POST -v -d "{\"user_name\": \"pepito\", \"password\": \"password123\"}" localhost/ForoMotos/server/users/login
                        $response = $model->login($body);
                        // $users = $model->login($body);
                        if ($response) {
                            http_response_code(201);
                        } else {
                            http_response_code(404);
                        }
                        break;
                    case "register":
                        //curl -X POST -v -d "{\"user_name\": \"pepito\", \"password\": \"password123\"}" localhost/ForoMotos/server/users/register
                        $response = $model->register($body);
                        // $users = $model->register($body);
                        if ($response) {
                            http_response_code(201);
                        } else {
                            http_response_code(400);
                        }
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/users_v.php");
        }

        private function deleteUser($params, $body, $x_api_key){
            $model = new Users_model();
            if (count($params) == 0){
                echo "bad request";
            }else{
                switch (strtolower($params[0])){
                    case "logout":
                        //curl -X DELETE -v --header "x-api-key: 0df4db8b-6c08-4e4f-83a1-29d5099702e7" localhost/ForoMotos/server/users/logout
                        $response = $model->logout($x_api_key);
                        if ($response) {
                            http_response_code(201);
                        } else {
                            http_response_code(403);
                        }
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/users_v.php");
        }

        private function notImplementedMethodUser($params, $method){
            header('Content-Type: application/json');
            echo json_encode(array("error"=> "Not implemented method!", "method" => $method, "params" => $params)).PHP_EOL;
        }
    }
?>
