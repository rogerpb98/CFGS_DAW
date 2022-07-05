\! echo "Gestió d'usuaris";
/*
Crea un procediment (de càrrega inicial) amb un cursor que recorri els empleats (taula EMP) 
amb un CURSOR amb HANDLER, i crei un usuari per cada empleat (cas de no existir ja l’usuari) 
amb permisos segons la gestió que es descriu en el punt gestió de permisos (següent apartat).  
Aquest procediment pot esser executat tan sols pel DBA.
*/
drop procedure if exists generarUsuariosDeCadaEmpleado;
delimiter //
create procedure generarUsuariosDeCadaEmpleado()
begin
    DECLARE varApellido VARCHAR(10);
    DECLARE varDept_no VARCHAR(10);
    DECLARE varJefe SMALLINT UNSIGNED;
    DECLARE condicion TINYINT default 1;
    DECLARE empleados CURSOR FOR select apellido, dept_no from EMP;
    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;
    open empleados;
        fetch empleados into varApellido, varDept_no;
        while condicion do
            select varApellido, varDept_no;
            /*Borrar usuarios si existen*/
            set @borrarUsuario := concat('DROP USER IF EXISTS ', varApellido, '@localhost;');
            PREPARE borrarUsuarioEjecutable from @borrarUsuario;
            EXECUTE borrarUsuarioEjecutable;
            DEALLOCATE PREPARE borrarUsuarioEjecutable;
            /*Crear usuarios*/
            set @crearUsuario := concat('CREATE USER ', varApellido, '@localhost IDENTIFIED BY ''123'';');
            PREPARE crearUsuarioEjecutable from @crearUsuario;
            EXECUTE crearUsuarioEjecutable;
            DEALLOCATE PREPARE crearUsuarioEjecutable;
            /*Revocar todos los permisos*/
            set @revocarPermisos := concat('REVOKE ALL ON empresa.* FROM ', varApellido, ';');
            PREPARE revocarPermisosEjecutable from @revocarPermisos;

            IF  varDept_no = 30 THEN
                select "VENTAS pueden actualizar datos de cliente y consultar comanda i detalle";
                EXECUTE revocarPermisosEjecutable; 
            ELSEIF varDept_no = 10 THEN
                select "CONTABILIDAD pueden consultar info de empleados, El jefe puede ver salario, comision, comanda i detalle";
                EXECUTE revocarPermisosEjecutable; 
            ELSEIF varDept_no = 40 THEN
                select "PRODUCCION puede consultar info de producto";
                EXECUTE revocarPermisosEjecutable; 
            ELSEIF varDept_no = 20 THEN
                select "INVESTIGACION puede consultar todo lo anterior";
                EXECUTE revocarPermisosEjecutable; 
            END IF;

            DEALLOCATE PREPARE revocarPermisosEjecutable;

            /*if varJefe = 7839 THEN
                select "un jefe";
            END IF*/

            fetch empleados into varApellido, varDept_no;
        end while;
    close empleados;
end //
delimiter ;

call generarUsuariosDeCadaEmpleado();
/*
Crea un usuari CAP-«NomDepartament» per cada departament (es a dir, els caps tenen el 
seu usuari estàndard com a empleats i aquest especial que tindrà més permisos).
*/
/*
Confeccioneu un procediment per donar d’alta un usuari.  
Tota la creació d’usuaris que fareu a la BD (tret del punt anterior) s’ha de fer a 
través d’aquest procediment.  Feu servir els paràmetres que considereu oportuns.  
Aquest procediment pot esser executat tan sols pels caps.
*/
/*
Crea un procediment que «dupliqui» un usuari donat com a paràmetre (amb un altre nom d’usuari).  
Aquest procediment pot esser executat tan sols pels caps.
*/
/*
Atenció: Tots aquests procediments han de donar els permisos adients (taules, vistes, procediments, ...) 
per cada usuari (veure Gestió permisos).
*/
\! echo "Gestió de permisos";
\! echo "Gestió d'empleats";
\! echo "Gestió de comandes";
\! echo "Crea tabla DEPT";
\! echo "Crea tabla DEPT";
\! echo "Crea tabla DEPT";