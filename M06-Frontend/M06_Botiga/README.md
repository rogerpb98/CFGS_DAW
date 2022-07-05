# M09-Botiga

* Para importar la base de datos (cambiar ruta por la tuya)
psql -f /var/www/html/M06-Botiga/sql/schema.sql

* Dependencias
Ir a la raiz del proyecto e instalar dependencias (Node 13 minimo para poder usar los imports de ES6)
npm i

* Correr el servidor
npm start

La libreria para hashear las contraseñas me da un hash distinto cada vez introduciendo la misma contraseña, asi que si se intenta hacer login nunca coincidirá con la que toca.
Añadir productos tampoco funciona, para probar hay que insertar directamente a la base de datos.