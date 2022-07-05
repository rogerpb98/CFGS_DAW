/*Este script lo puedes ignorar, solo lo iba usando para cargarme los procedimientos y demás y 
volver a cargarlos sin tener que volver a cargar toda la base de datos*/
DROP USER IF EXISTS DBA@localhost;
/*Eliminar usuarios de todos los jefes*/
DROP USER IF EXISTS 'CAP-CONTABILIDAD'@localhost;
DROP USER IF EXISTS 'CAP-INVESTIGACIÓN'@localhost;
DROP USER IF EXISTS 'CAP-VENTAS'@localhost;
DROP USER IF EXISTS 'CAP-PRODUCCIÓN'@localhost;
/*Borrar tabla LOGS*/
DROP TABLE IF EXISTS empresa.LOGS;
/*Borrar marcas de borrado*/
ALTER TABLE CLIENTE
    DROP COLUMN marca_borrado;
ALTER TABLE COMANDA
    DROP COLUMN marca_borrado;
ALTER TABLE DEPT
    DROP COLUMN marca_borrado;
ALTER TABLE DETALLE
    DROP COLUMN marca_borrado;
ALTER TABLE EMP
    DROP COLUMN marca_borrado;
ALTER TABLE PRODUCTO
    DROP COLUMN marca_borrado;
/*Procedimientos/Funciones*/
drop procedure if exists ejecutarPrepare;
drop procedure if exists asignarPermisosEmp;
drop procedure if exists crearUsuariosCaps;
drop procedure if exists crearUsuario;
drop procedure if exists duplicarUsuario;
drop procedure if exists altaEmpleat;
drop function if exists contarImportes;

drop procedure if exists insertCliente;
drop procedure if exists insertComanda;
drop procedure if exists insertDept;
drop procedure if exists insertDetalle;
drop procedure if exists insertEmp;
drop procedure if exists insertProducto;

drop procedure if exists updateCliente;
drop procedure if exists updateComanda;
drop procedure if exists updateDept;
drop procedure if exists updateDetalle;
drop procedure if exists updateEmp;
drop procedure if exists updateProducto;

drop procedure if exists deleteCliente;
drop procedure if exists deleteComanda;
drop procedure if exists deleteDept;
drop procedure if exists deleteDetalle;
drop procedure if exists deleteEmp;
drop procedure if exists deleteProducto;
/*Procedimiento de carga inicial*/
drop procedure if exists generarUsuariosDeCadaEmpleado;
/*Triggers*/
drop trigger if exists triggerInsertCliente;
drop trigger if exists triggerInsertComanda;
drop trigger if exists triggerInsertDept;
drop trigger if exists triggerInsertDetalle;
drop trigger if exists triggerInsertEmp;
drop trigger if exists triggerInsertProducto;

drop trigger if exists triggerUpdateCliente;
drop trigger if exists triggerUpdateComanda;
drop trigger if exists triggerUpdateDept;
drop trigger if exists triggerUpdateDetalle;
drop trigger if exists triggerUpdateEmp;
drop trigger if exists triggerUpdateProducto;

drop trigger if exists triggerDeleteCliente;
drop trigger if exists triggerDeleteComanda;
drop trigger if exists triggerDeleteDept;
drop trigger if exists triggerDeleteDetalle;
drop trigger if exists triggerDeleteEmp;
drop trigger if exists triggerDeleteProducto;

/*Procedimiento para ejecutar prepares*/
delimiter //
create procedure ejecutarPrepare(in stringConcatenado varchar(255))
begin
    set @stringConcatenadotmp = stringConcatenado;
    PREPARE darPermisoEjecutable FROM @stringConcatenadotmp;
    EXECUTE darPermisoEjecutable;
    DEALLOCATE PREPARE darPermisoEjecutable;
end //
delimiter ;
/*Eliminar usuarios de todos los empleados*/
drop procedure if exists eliminarUsuariosDeCadaEmpleado;
delimiter //
create procedure eliminarUsuariosDeCadaEmpleado()
begin
    DECLARE varApellido VARCHAR(10);
    DECLARE varEmp_no smallint unsigned;
    DECLARE condicion TINYINT default 1;
    DECLARE empleados CURSOR FOR select apellido,emp_no from EMP;
    DECLARE continue HANDLER FOR SQLSTATE '02000' set condicion = 0;
    open empleados;
        fetch empleados into varApellido,varEmp_no;
        while condicion do
            /*Borrar usuarios si existen*/
            set @borrarUsuario := concat('DROP USER IF EXISTS ', varApellido,varEmp_no, '@localhost;');
            call ejecutarPrepare(@borrarUsuario);

            fetch empleados into varApellido,varEmp_no;
        end while;
    close empleados;
end //
delimiter ;

call eliminarUsuariosDeCadaEmpleado();

drop procedure if exists ejecutarPrepare;
drop procedure if exists eliminarUsuariosDeCadaEmpleado;