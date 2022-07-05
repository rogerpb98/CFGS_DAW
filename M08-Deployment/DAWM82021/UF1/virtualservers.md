* Crear carpetas m8/ y api/ en /var/www
* Crear ficheros de configuracion en sites-available y crear un hard link en sites-enables (001-m8.conf) (002-api.conf)
* Añadir las rutas de las nuevas carpetas en sus ficheros correspondientes
```
<VirtualHost *:80>
    ServerName m8.localhost
    DocumentRoot "/var/www/m8"
</VirtualHost>

<VirtualHost *:80>
    ServerName api.localhost
    DocumentRoot "/var/www/api"
</VirtualHost>
```
* Añadimos fichero index.html en ambas carpetas y al abrir con esa ruta se cargará este fichero
(api.localhost)(m8.localhost)
* systemctl restart apache2