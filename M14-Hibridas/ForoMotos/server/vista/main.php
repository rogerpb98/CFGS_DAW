    <h3>Benvingut a la pàgina principal del framework picat a pedra!</h3>
    <p>Dessitjo que sigui del teu gust</p>
    <table id=users>
        <tr>
            <th>user_name</th>
            <th>password</th>
            <th>created_at</th>
            <th>role</th>
        </tr>
    </table>
    <script>
        function procesa_users(data){
            for (var i=0;i < data.length; i++){
                var row = document.getElementById("users").insertRow(1 + i);
                if (i%2==0){
                    row.classList.add("fila_parell");
                }else{
                    row.classList.add("fila_senar");
                }
                var cell_user_name = row.insertCell(0);
                cell_user_name.innerHTML = data[i].user_name;
                cell_user_name.classList.add("cell_user_name");
                var cell_password = row.insertCell(1).innerHTML = data[i].password;
                var cell_public_name = row.insertCell(2).innerHTML = data[i].created_at;
                var cell_email = row.insertCell(3).innerHTML = data[i].role;
            }
        }

        function init(){
            fetch("http://localhost/ForoMotos/server/users")
                .then(response => response.json())
                .then(data => procesa_users(data));
        }
        setTimeout(init, 1000);
    </script>
</body>
</html>
