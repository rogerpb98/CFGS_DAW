<?php
    require_once("./model/posts_m.php");
    class Posts{    
        public function __construct($params, $body){
            $method = array_shift($params);
            $x_api_key = array_shift($params);
            switch ($method){
                case "GET":
                    $this->getPost($params);
                    break;
                case "POST":
                    $this->postPost($params, $body);
                    break;
                case "DELETE":
                    $this->deletePost($params, $body);
                    break;
                default:
                    $this->notImplementedMethodPost($params, $body, $method);
                    break;
            }
        }
        
        private function getPost($params){
            $model = new Posts_model();
            if (count($params) == 0){
                //curl localhost/ForoMotos/server/posts
                $response = $model->getPosts();
            }else{
                switch (strtolower($params[0])){
                    case "username":
                        $response = null;
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/posts_v.php");
        }

        private function postPost($params, $body){
            $model = new Posts_model();
            if (count($params) != 0) {
                switch (strtolower($params[0])){
                    case "upload":
                        //curl -X POST -v -d "{\"owner\": \"pepito\", \"category\": 1, \"title\": \"titulo post\", \"body\": \"body del post jajaxD\"}" localhost/ForoMotos/server/posts/upload
                        $response = $model->postPost($body);
                        if ($response) {
                            http_response_code(200);
                        } else {
                            http_response_code(403);
                        }
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/posts_v.php");
        }

        private function deletePost($params, $body){
            $model = new Posts_model();
            if (count($params) == 0){
                echo "bad request";
            }else{
                switch (strtolower($params[0])){
                    case "delete":
                        //curl -X DELETE -v -d "{\"post_id\": \"1\"}" localhost/ForoMotos/server/posts/delete
                        $response = $model->deletePost($body);
                        if ($response) {
                            http_response_code(200);
                        } else {
                            http_response_code(403);
                        }
                        break;
                    default:
                        echo "bad request";
                }
            }
            require_once("./vista/posts_v.php");
        }

        private function notImplementedMethodPost($params, $method){
            header('Content-Type: application/json');
            echo json_encode(array("error"=> "Not implemented method!", "method" => $method, "params" => $params)).PHP_EOL;
        }
    }
?>
