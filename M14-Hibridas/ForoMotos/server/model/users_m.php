<?php
    Class Users_model {
        private $db;
        private $users;
        public function __construct(){
            require_once("./model/connexio.php");
            $this->db=Connexio::connectar();
            $this->users=array();
        }

        // GET
        public function getUsers(){
            $consulta = "SELECT * FROM users";
            $result = $this->db->query($consulta);
            while ($fila=$result->fetch(PDO::FETCH_ASSOC)){
                $this->users[]=$fila;
            }
            return $this->users;
        }

        // POST
        public function login($body){
            $user_name = $body->user_name;
            $user_pwd = $this->getPasswordFromUser($user_name);
            $password = $body->password;
            if (password_verify($password, $user_pwd)) {
                $uuid = guidv4();
                $this->linkUUIDtoUser($uuid, $user_name);
                
                if ($this->validateUUID($uuid, $user_name)) {
                    $data = array(
                        'x-api-key' => $uuid
                    );
                    return $data;
                }
            }
            return null;
            
        }

        public function register($body){
            $user_name = $body->user_name;
            $password = password_hash($body->password, PASSWORD_BCRYPT);
            $role = 'standard';
            $consulta = "INSERT INTO users (user_name, password, role) VALUES (:user_name , :password , :role);";

            $dades = [
                'user_name'=>$user_name,
                'password'=>$password,
                'role'=>$role
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $this->login($body);
            if ($data) {
                //Returns uuid from the registered user (will be used to auto login)
                return $data;
            }
            return null;
        }

        // DELETE
        public function logout($api_key){
            $consulta = "DELETE FROM uuid WHERE uuid = :uuid;";

            $dades = [
                'uuid'=>$api_key
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            if ($this->uuidExists($api_key)) {
                // return false;
            }
            
            // return true;
            
        }

        public function promote($body) {
            
        }

        
        // UTILS
        public function uuidExists($uuid) {
            // No tocar
            $consulta = "SELECT * FROM uuid WHERE uuid = :uuid;";

            $dades = [
                'uuid'=>$uuid
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $result->fetch(PDO::FETCH_ASSOC);
            if ($data) {
                return true;
            }
            return false;
        }

        public function getPasswordFromUser($user) {
            // No tocar
            $consulta = "SELECT * FROM users WHERE user_name = :user_name;";
            
            $dades = [
                'user_name'=>$user
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $result->fetch(PDO::FETCH_ASSOC);
            if ($data) {
                return $data['password'];
            }
            return null;
        }

        public function linkUUIDtoUser($uuid, $user) {
            // No tocar
            $consulta = "INSERT INTO uuid VALUES (:uuid , :user_name);";

            $dades = [
                'uuid'=>$uuid,
                'user_name'=>$user
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);
        }

        public function validateUUID($uuid, $user) {
            // No tocar
            // If uuid is assigned to user, returns true.
            $consulta = "SELECT * FROM uuid WHERE user_name = :user_name AND uuid = :uuid;";

            $dades = [
                'user_name'=>$user,
                'uuid'=>$uuid
            ];
            $result = $this->db->prepare($consulta);
            $result->execute($dades);

            $data = $result->fetch(PDO::FETCH_ASSOC);
            if ($data) {
                return true;
            }
            return false;
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
