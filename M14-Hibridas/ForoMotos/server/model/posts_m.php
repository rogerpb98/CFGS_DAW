<?php
    Class Posts_model {
        private $db;
        private $posts;
        public function __construct(){
            require_once("./model/connexio.php");
            $this->db=Connexio::connectar();
            $this->posts=array();
        }

        // GET
        public function getPosts(){
            $consulta = "SELECT * FROM posts";
            $result = $this->db->query($consulta);
            while ($fila=$result->fetch(PDO::FETCH_ASSOC)){
                $this->posts[]=$fila;
            }
            return $this->posts;
        }

        // POST
        public function postPost($body){
            $post_owner = $body->owner;
            // $post_owner = $this->getUserFromUUID($body->owner);
            $post_category = $body->category;
            $post_id = guidv4();
            $post_title = $body->title;
            $post_body = $body->body;
            
            $consulta = "INSERT INTO posts (id, title, content, author, category) VALUES (:id, :title , :content , :author, :category);";
            
            $dades = [
                'id'=>$post_id,
                'title'=>$post_title,
                'content'=>$post_body,
                'author'=>$post_owner,
                'category'=>$post_category,
            ];
            $result = $this->db->prepare($consulta);

            if ($result->execute($dades)) {
                $data = array(
                    'result' => 'OK'
                );
                return $data;
            }
            $data = array(
                'result' => 'KO'
            );
            return $data;
            
        }

        // DELETE
        public function deletePost($body){
            $consulta = "DELETE FROM posts WHERE id = :id;";

            $dades = [
                'id'=>$body->post_id
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            if ($result->execute($dades)) {
                $data = array(
                    'result' => 'OK'
                );
                return $data;
            }
            
            $data = array(
                'result' => 'KO'
            );
            return $data;
            
        }
        // UTILS
        public function postExists($post_id) {
            // No tocar
            $consulta = "SELECT * FROM posts WHERE id = :id;";

            $dades = [
                'id'=>$post_id
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $result->fetch(PDO::FETCH_ASSOC);
            if ($data) {
                return true;
            }
            return false;
        }

        public function getUserFromUUID($uuid) {
            $consulta = "SELECT user_name FROM uuid WHERE id = :id;";

            $dades = [
                'id'=>$uuid
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $result->fetch(PDO::FETCH_ASSOC);
            if ($data) {
                return $data;
            }
            return $data;
        }

    }
    function guidv4($data = null) {
        // No tocar
        // Generate 16 bytes (128 bits) of random data or use the data passed into the function.
        $data = $data ?? random_bytes(16);
        assert(strlen($data) == 16);
    
        // Set version to 0100
        $data[6] = chr(ord($data[6]) & 0x0f | 0x40);
        // Set bits 6-7 to 10
        $data[8] = chr(ord($data[8]) & 0x3f | 0x80);
    
        // Output the 36 character UUID.
        return vsprintf('%s%s-%s-%s-%s-%s%s%s', str_split(bin2hex($data), 4));
    }
?>
