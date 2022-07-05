use empresa;
/*select user,host from mysql.user;*/
/*Heu d'afegir a les taules una marca d'esborrat.*/
ALTER TABLE CLIENTE
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
ALTER TABLE COMANDA
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
ALTER TABLE DEPT
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
ALTER TABLE DETALLE
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
ALTER TABLE EMP
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
ALTER TABLE PRODUCTO
    ADD COLUMN marca_borrado ENUM('presente', 'borrado') DEFAULT 'presente';
/*Crear tabla para los logs*/
CREATE TABLE empresa.LOGS (
        mensaje  text,
        momento  timestamp
);

/*Crear usuario para el DBA y darle todos los permisos*/
CREATE USER DBA@localhost IDENTIFIED BY '123';
GRANT ALL ON TABLE empresa.* to DBA@localhost WITH GRANT OPTION;

/*CREACION DE VISTAS*/
create view vistaCLIENTE as select cliente_cod, nombre, dirección, ciudad, estado, codi_postal, area, telefono, repr_cod, observaciones from empresa.CLIENTE where marca_borrado='presente';
create view vistaCOMANDA as select com_num, com_fecha, com_tipo, cliente_cod, fecha_tram, total from empresa.COMANDA where marca_borrado='presente';
create view vistaDEPT as select dept_no, dnom , loc from empresa.DEPT where marca_borrado='presente';
create view vistaDETALLE as select com_num, detalle_num, prod_num, precio_venta, cantidad, importe from empresa.DETALLE where marca_borrado='presente';
create view vistaEMP as select emp_no, apellido, oficio, jefe, fecha_alta, dept_no from empresa.EMP where marca_borrado='presente';
create view vistaPRODUCTO as select prod_num, descripción from empresa.PRODUCTO where marca_borrado='presente';

/***********************************************************************************************/
/************************************PROCEDIMIENTOS DE SOPORTE**********************************/
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
/*Cap usuari (tret dels caps de departament) pot accedir directament a les taules.  Les consultes es faran sempre a través de vistes*/
delimiter //
create procedure asignarPermisosEmp(in apellido varchar(10), in dept_no tinyint, in varEmp_no smallint unsigned)
begin
    if dept_no=10 then /*Contabilidad*/
        /*Consultar informacion de empleados excepto salario y comision (usando vista)*/
        SET @darPermiso=CONCAT('GRANT select ON TABLE empresa.vistaEMP TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        /*Actualizar y consultar comanda y detalle*/
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaCOMANDA TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaDETALLE TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);

    elseif dept_no=20 then /*Investigacion*/
        /*Actualizar datos de cliente*/
        SET @darPermiso=CONCAT('GRANT update ON TABLE empresa.vistaCLIENTE TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        /*Actualizar y consultar comanda y detalle*/
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaCOMANDA TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaDETALLE TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        /*Consultar informacion de empleados excepto salario y comision (usando vista)*/
        SET @darPermiso=CONCAT('GRANT select ON TABLE empresa.vistaEMP TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        /*Actualizar y consultar producte*/
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaPRODUCTO TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);

    elseif dept_no=30 then /*Ventas*/
        /*Actualizar datos de cliente*/
        SET @darPermiso=CONCAT('GRANT update ON TABLE empresa.vistaCLIENTE TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        /*Consultar informacion de comanda y detalle*/
        SET @darPermiso=CONCAT('GRANT select ON TABLE empresa.vistaCOMANDA TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
        SET @darPermiso=CONCAT('GRANT select ON TABLE empresa.vistaDETALLE TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);

    elseif dept_no=40 then /*Produccion*/
        /*Actualizar y consultar producte*/
        SET @darPermiso=CONCAT('GRANT select, update ON TABLE empresa.vistaPRODUCTO TO ',apellido,varEmp_no,'@localhost;');
        call ejecutarPrepare(@darPermiso);
    end if;
end //
delimiter ;
/*Crea un usuari CAP-«NomDepartament» per cada departament (es a dir, els caps tenen el 
seu usuari estàndard com a empleats i aquest especial que tindrà més permisos).*/
delimiter //
create procedure crearUsuariosCaps()
begin
    /*Crea un usuario para cada departamento*/
    CREATE USER if not exists 'CAP-CONTABILIDAD'@localhost IDENTIFIED BY "1234";
    CREATE USER if not exists 'CAP-INVESTIGACIÓN'@localhost IDENTIFIED BY "1234";
    CREATE USER if not exists 'CAP-VENTAS'@localhost IDENTIFIED BY "1234";
    CREATE USER if not exists 'CAP-PRODUCCIÓN'@localhost IDENTIFIED BY "1234";
    /*Finaliza dando permisos a todos los jefes*/
    /*Acceso a ver y modificar todas las tablas a todos los jefes*/
    grant SELECT, INSERT, DELETE, UPDATE on empresa.CLIENTE TO 'CAP-CONTABILIDAD', 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    grant SELECT, INSERT, DELETE, UPDATE on empresa.COMANDA TO 'CAP-CONTABILIDAD', 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    grant SELECT, INSERT, DELETE, UPDATE on empresa.DEPT TO 'CAP-CONTABILIDAD', 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    grant SELECT, INSERT, DELETE, UPDATE on empresa.DETALLE TO 'CAP-CONTABILIDAD', 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    grant SELECT, INSERT, DELETE, UPDATE on empresa.PRODUCTO TO 'CAP-CONTABILIDAD', 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    /*Ningún jefe excepto el contable puede ver/actualizar salario ni comision, asi que usan la vista*/
    grant SELECT, INSERT, DELETE, UPDATE on empresa.vistaEMP TO 'CAP-INVESTIGACIÓN', 'CAP-PRODUCCIÓN', 'CAP-VENTAS';
    /*Solo el jefe de contabilidad tiene acceso a empleados*/
    grant SELECT, INSERT, DELETE, UPDATE on empresa.EMP TO 'CAP-CONTABILIDAD';
end //
delimiter ;
/***********************************************************************************************/
/***********************************************************************************************/
/*Confeccioneu un procediment per donar d’alta un usuari.  
Tota la creació d’usuaris que fareu a la BD (tret del punt anterior) s’ha de fer a 
través d’aquest procediment.  Feu servir els paràmetres que considereu oportuns.  
Aquest procediment pot esser executat tan sols pels caps.*/
delimiter //
create procedure crearUsuario(in nomUsuari varchar(10), in numemple smallint unsigned)
begin
    /*Crea el usuario indicado por argumento*/
    SET @sql=CONCAT('CREATE USER if not exists ',nomUsuari,numemple,'@localhost IDENTIFIED BY "1234";');
    call ejecutarPrepare(@sql);
end //
delimiter ;

/*Crea un procediment que «dupliqui» un usuari donat com a paràmetre (amb un altre nom d’usuari).  
Aquest procediment pot esser executat tan sols pels caps.*/
/*SOLO PARA EMPLEADOS*/
delimiter //
create procedure duplicarUsuario(in nomUsuari varchar(10), in copia varchar(10))
begin
    /*extraigo el departamento del usuario a copiar para pasarlo luego al procedimiento 
    encargado de dar de alta la copia del empleado*/
    declare dpt tinyint default (select dept_no from EMP where apellido=nomUsuari);
    call altaEmpleat(copia, dpt);
end //
delimiter ;
/*call duplicarUsuario('ALONSO','AAAA');*/

/*Creu un procediment per donar d’alta un empleat.  El procediment ha de crear un registre a EMP,
i ha de crear també un usuari per aquest empleat (seguint els criteris de gestió de permisos).
Com la resta de procediments, feu servir els paràmetres que considereu adequats.*/
delimiter //
create procedure altaEmpleat(in cognomEmpleat varchar(10), in codDep smallint unsigned)
begin
    declare codEmp smallint unsigned default (select MAX(emp_no)+1 from EMP);
    insert into EMP (emp_no, apellido, dept_no) values (codEmp, cognomEmpleat, codDep);
    call crearUsuario(cognomEmpleat, codEmp);
    call asignarPermisosEmp(cognomEmpleat, codDep, codEmp);
end //
delimiter ;

/*call altaEmpleat();*/

/*Heu de dissenyar una funció que donada una comanda, retorni la suma de tots els imports de totes 
les seves línies (taula DETALLE).*/
/*Heu de dissenyar alguna solució per que l’import total d’una comanda es correspongui sempre al 
sumatori de les seves línies de detall.*/
delimiter //
create function contarImportes(numCom smallint) returns decimal(8,2)
begin
    declare total decimal(8,2);
    set total = (select sum(importe) from DETALLE where numCom=com_num);
    return total;
end //
delimiter ;

/*select contarImportes(606);*/

/***********************************************************************************************/
/********************PROCEDIMIENTOS DE INSERTADO/MODIFICACION/BORRADO***************************/
/******INSERT******/
/*CLIENTE*/
delimiter //
create procedure insertCliente(in cod int unsigned, in  nom varchar(45), in  dire varchar(40), in  ciu varchar(30), in  est varchar(2), in  cpost varchar(9), in  are smallint, in  tlf varchar(9), in  crepr smallint unsigned, in  limcred decimal(9,2) unsigned, in  obs text)
begin
    insert into CLIENTE (cliente_cod, nombre, dirección, ciudad, estado, codi_postal, area, telefono, repr_cod, limit_credito, observaciones) values(cod, nom, dire, ciu, est, cpost, are, tlf, crepr, limcred, obs);
end //
delimiter ;
/*insert into empresa.CLIENTE values(1,'nom','dire','ciu','as','08028',9,'123456789',7369,1234567.89,'asd');*/
/*COMANDA*/
delimiter //
create procedure insertComanda(in comnum smallint unsigned, in  comfecha date, in comtipo char(1), in  ccod int unsigned, in  ftram date, in  tot decimal(8,2) unsigned)
begin
    insert into COMANDA (com_num, com_fecha, com_tipo, cliente_cod, fecha_tram, total) values(comnum, comfecha, comtipo, ccod, ftram, tot);
end //
delimiter ;
/*DEPT*/
delimiter //
create procedure insertDept(in depnum tinyint unsigned, in  depnom varchar(14), in localitat varchar(14))
begin
    insert into DEPT (dept_no, dnom, loc) values(depnum, depnom, localitat);
end //
delimiter ;
/*DETALLE*/
delimiter //
create procedure insertDetalle(in comnum smallint unsigned, in  dnum smallint unsigned, in pnum int unsigned, in pventa decimal(8,2) unsigned, in cant int)
begin
    insert into DETALLE (com_num, detalle_num, prod_num, precio_venta, cantidad, importe) values(comnum, dnum, pnum, pventa, cant, pventa*cant);
end //
delimiter ;
/*EMP*/
delimiter //
create procedure insertEmp(in empnum smallint unsigned, in apell varchar(10), in ofi varchar(10), in boss smallint unsigned, in falta date,  in salari int unsigned, in comi int unsigned, in dnum tinyint unsigned)
begin
    insert into EMP (emp_no, apellido, oficio, jefe, fecha_alta, salario, comisión, dept_no) values(empnum, apell, ofi, boss, falta, salari, comi, dnum);
end //
delimiter ;
/*PRODUCTO*/
delimiter //
create procedure insertProducto(in pnum int unsigned, in descrip varchar(30))
begin
    insert into PRODUCTO (prod_num, descripción) values(pnum, descrip);
end //
delimiter ;

/******UPDATE******/
/*CLIENTE*/
delimiter //
create procedure updateCliente(in cod int unsigned, in  nom varchar(45), in  dire varchar(40), in  ciu varchar(30), in  est varchar(2), in  cpost varchar(9), in  are smallint, in  tlf varchar(9), in  crepr smallint unsigned, in  limcred decimal(9,2) unsigned, in  obs text)
begin
    update CLIENTE
    SET 
        nombre=nom,
        dirección=dire,
        ciudad=ciu,
        estado=est,
        codi_postal=cpost,
        area=are,
        telefono=tlf,
        repr_cod=crepr,
        limit_credito=limcred,
        observaciones=obs
    WHERE cod=cliente_cod;
end //
delimiter ;
/*COMANDA*/
delimiter //
create procedure updateComanda(in comnum smallint unsigned, in  comfecha date, in comtipo char(1), in  ccod int unsigned, in  ftram date, in  tot decimal(8,2) unsigned)
begin
    update COMANDA
    SET 
        com_fecha=comfecha,
        com_tipo=comtipo,
        cliente_cod=ccod,
        fecha_tram=ftram,
        total=tot
    WHERE comnum=com_num;
end //
delimiter ;
/*DEPT*/
delimiter //
create procedure updateDept(in depnum tinyint unsigned, in  depnom varchar(14), in localitat varchar(14))
begin
    update DEPT
    SET 
        dept_no=depnum,
        dnom=depnom,
        loc=localitat
    WHERE depnum=dept_no;
end //
delimiter ;
/*DETALLE*/
delimiter //
create procedure updateDetalle(in comnum smallint unsigned, in  dnum smallint unsigned, in pnum int unsigned, in pventa decimal(8,2) unsigned, in cant int)
begin
    update DETALLE
    SET 
        prod_num=pnum,
        precio_venta=pventa,
        cantidad=cant,
        importe=pventa*cant
    WHERE com_num=comnum and detalle_num=dnum;
end //
delimiter ;
/*EMP*/
delimiter //
create procedure updateEmp(in empnum smallint unsigned, in apell varchar(10), in ofi varchar(10), in boss smallint unsigned, in falta date,  in salari int unsigned, in comi int unsigned, in dnum tinyint unsigned)
begin
    update EMP
    SET 
        apellido=apell,
        oficio=ofi,
        jefe=boss,
        fecha_alta=falta,
        salario=salari,
        comisión=comi,
        dept_no=dnum
    WHERE emp_no=empnum;
end //
delimiter ;
/*PRODUCTO*/
delimiter //
create procedure updateProducto(in pnum int unsigned, in descrip varchar(30))
begin
    update PRODUCTO
    SET 
        prod_num=pnum,
        descripción=descrip
    WHERE prod_num=pnum;
end //
delimiter ;

/******DELETE******/
/*CLIENTE*/
delimiter //
create procedure deleteCliente(in cod int unsigned)
begin
    update CLIENTE
    SET 
        marca_borrado='borrado'
    WHERE cod=cliente_cod;
end //
delimiter ;
/*COMANDA*/
delimiter //
create procedure deleteComanda(in comnum smallint unsigned)
begin
    update COMANDA
    SET 
        marca_borrado='borrado'
    WHERE comnum=com_num;
end //
delimiter ;
/*DEPT*/
delimiter //
create procedure deleteDept(in depnum tinyint unsigned)
begin
    update DEPT
    SET 
        marca_borrado='borrado'
    WHERE depnum=dept_no;
end //
delimiter ;
/*DETALLE*/
delimiter //
create procedure deleteDetalle(in comnum smallint unsigned, in  dnum smallint unsigned)
begin
    update DETALLE
    SET 
        marca_borrado='borrado'
    WHERE com_num=comnum and detalle_num=dnum;
end //
delimiter ;
/*EMP*/
delimiter //
create procedure deleteEmp(in empnum smallint unsigned)
begin
    update EMP
    SET 
        marca_borrado='borrado'
    WHERE emp_no=empnum;
end //
delimiter ;
/*PRODUCTO*/
delimiter //
create procedure deleteProducto(in pnum smallint unsigned)
begin
    update PRODUCTO
    SET 
        marca_borrado='borrado'
    WHERE prod_num=pnum;
end //
delimiter ;
/***********************************************************************************************/
/*************************TRIGGERS DE INSERTADO/MODIFICACION/BORRADO****************************/
/******INSERT******/
DELIMITER //
CREATE TRIGGER triggerInsertCliente after insert on CLIENTE for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla CLIENTE'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerInsertComanda after insert on COMANDA for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla COMANDA'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerInsertDept after insert on DEPT for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla DEPT'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerInsertDetalle after insert on DETALLE for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla DETALLE'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerInsertEmp after insert on EMP for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla EMP'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerInsertProducto after insert on PRODUCTO for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha insertado una fila en la tabla PRODUCTO'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
/*Heu d'afegir a les taules una marca d'esborrat. Quan s'esborra un registre (a través del 
procediment corresponent) realment es marca com esborrat */
/******UPDATE******/
DELIMITER //
CREATE TRIGGER triggerUpdateCliente after update on CLIENTE for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla CLIENTE'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla CLIENTE'), CURRENT_TIMESTAMP);
    END IF;
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerUpdateComanda after insert on COMANDA for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla COMANDA'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla COMANDA'), CURRENT_TIMESTAMP);
    END IF;end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerUpdateDept after insert on DEPT for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla DEPT'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla DEPT'), CURRENT_TIMESTAMP);
    END IF;
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerUpdateDetalle after insert on DETALLE for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla DETALLE'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla DETALLE'), CURRENT_TIMESTAMP);
    END IF;
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerUpdateEmp after insert on EMP for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla EMP'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla EMP'), CURRENT_TIMESTAMP);
    END IF;
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerUpdateProducto after insert on PRODUCTO for each row
begin
    IF new.marca_borrado='borrado' then
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla PRODUCTO'), CURRENT_TIMESTAMP);
    ELSE
        insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha modificado una fila en la tabla PRODUCTO'), CURRENT_TIMESTAMP);
    END IF;
end //
DELIMITER ;
/******DELETE******/
DELIMITER //
CREATE TRIGGER triggerDeleteCliente after insert on CLIENTE for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla CLIENTE'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerDeleteComanda after insert on COMANDA for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla COMANDA'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerDeleteDept after insert on DEPT for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla DEPT'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerDeleteDetalle after insert on DETALLE for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla DETALLE'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerDeleteEmp after insert on EMP for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla EMP'), CURRENT_TIMESTAMP);
end //
DELIMITER ;
DELIMITER //
CREATE TRIGGER triggerDeleteProducto after insert on PRODUCTO for each row
begin
    insert into empresa.LOGS values(CONCAT('El usuario ', USER() ,' ha eliminado una fila en la tabla PRODUCTO'), CURRENT_TIMESTAMP);
end //
DELIMITER ;

/***********************************************************************************************/
/**********************************PROCEDIMIENTO DE CARGA INICIAL********************************
Crea un procediment (de càrrega inicial) amb un cursor que recorri els empleats (taula EMP) 
amb un CURSOR amb HANDLER, i crei un usuari per cada empleat (cas de no existir ja l’usuari) 
amb permisos segons la gestió que es descriu en el punt gestió de permisos (següent apartat).  
Aquest procediment pot esser executat tan sols pel DBA.
************************************************************************************************/
delimiter //
create procedure generarUsuariosDeCadaEmpleado()
begin
    DECLARE varApellido VARCHAR(10);
    DECLARE varDept_no VARCHAR(10);
    DECLARE varEmp_no smallint unsigned;
    DECLARE condicion TINYINT default 1;
    DECLARE empleados CURSOR FOR select apellido, dept_no, emp_no from EMP;
    DECLARE continue HANDLER FOR SQLSTATE '02000' set condicion = 0;
    open empleados;
        fetch empleados into varApellido, varDept_no, varEmp_no;
        while condicion do
            /*Crear usuarios para cada empleado*/
            call crearUsuario(varApellido, varEmp_no);
            /*Asignar los permisos correspondientes al usuario recien creado*/
            call asignarPermisosEmp(varApellido, varDept_no, varEmp_no);

            fetch empleados into varApellido, varDept_no, varEmp_no;
        end while;
    close empleados;
end //
delimiter ;
/***************************************//*MAIN*//**********************************************/
call generarUsuariosDeCadaEmpleado();
drop procedure if exists generarUsuariosDeCadaEmpleado;
call crearUsuariosCaps();

/*varchar(10), smallint unsigned*/
call altaEmpleat('Pepito',10);

/*varchar(10), smallint unsigned*/
call crearUsuario('Pepe',3421);

/*varchar(10), varchar(10)*/
call duplicarUsuario('Pepito', 'nuevoemp');

/*in cod int unsigned, in  nom varchar(45), in  dire varchar(40), in  ciu varchar(30), in  est varchar(2), in  cpost varchar(9), in  are smallint, in  tlf varchar(9), in  crepr smallint unsigned, in  limcred decimal(9,2) unsigned, in  obs text*/
call insertCliente(23, 'Rogelio', 'calle 123', 'barcelona', 'ES', '08028', 20, 645355264, 7844, 1234567.89, 'Lorem Ipsum');

/*in comnum smallint unsigned, in  comfecha date, in comtipo char(1), in  ccod int unsigned, in  ftram date, in  tot decimal(8,2) unsigned*/
call insertComanda(42, '2000-12-30', 'A', 23, '2001-12-30', 123456.78);

/*in depnum tinyint unsigned, in  depnom varchar(14), in localitat varchar(14)*/
call insertDept(50, 'DEPTEST', 'Tarragona');

/*in empnum smallint unsigned, in apell varchar(10), in ofi varchar(10), in boss smallint unsigned, in falta date,  in salari int unsigned, in comi int unsigned, in dnum tinyint unsigned*/
call insertEmp(9235, 'Perez', 'TEST', 7936, '2001-12-30', 2100, 320, 50);

/*in pnum int unsigned, in descrip varchar(30)*/
call insertProducto(534, 'producto test');

/*in comnum smallint unsigned, in  dnum smallint unsigned, in pnum int unsigned, in pventa decimal(8,2) unsigned, in cant int, in import decimal(8,2)*/
call insertDetalle(42, 50, 534, 123456.78, 3);

/*in cod int unsigned, in  nom varchar(45), in  dire varchar(40), in  ciu varchar(30), in  est varchar(2), in  cpost varchar(9), in  are smallint, in  tlf varchar(9), in crepr smallint unsigned, in  limcred decimal(9,2) unsigned, in  obs text*/
call updateCliente(23, 'Rogelio', 'nueva calle', 'madrid', 'ES', '08028', 20, 645355264, 7844, 1234567.89, 'Lorem Ipsum');

/*in comnum smallint unsigned, in  comfecha date, in comtipo char(1), in  ccod int unsigned, in  ftram date, in  tot decimal(8,2) unsigned*/
call updateComanda(42, '2000-12-30', 'B', 23, '2001-12-30', 123456.78);

/*in depnum tinyint unsigned, in  depnom varchar(14), in localitat varchar(14)*/
call updateDept(50, 'dep updated', 'Tarragona');

/*in empnum smallint unsigned, in apell varchar(10), in ofi varchar(10), in boss smallint unsigned, in falta date,  in salari int unsigned, in comi int unsigned, in dnum tinyint unsigned*/
call updateEmp(9235, 'Perez', 'Ofi actu', 7936, '2001-12-30', 2100, 320, 50);

/*in pnum int unsigned, in descrip varchar(30)*/
call updateProducto(534, 'producto test actualizado');

/*in comnum smallint unsigned, in  dnum smallint unsigned, in pnum int unsigned, in pventa decimal(8,2) unsigned, in cant int, in import decimal(8,2)*/
call updateDetalle(42, 50, 534, 234.78, 9);

/*in empnum smallint unsigned*/
call deleteProducto(534);
/*in empnum smallint unsigned*/
call deleteEmp(9235);
/*in comnum smallint unsigned, in  dnum smallint unsigned*/
call deleteDetalle(42, 9235);
/*in depnum tinyint unsigned*/
call deleteDept(50);
/*in comnum smallint unsigned*/
call deleteComanda(42);
/*in cod int unsigned*/
call deleteCliente(23);

/*
select user, host from mysql.user;
*/
/*
source /home/roger/M02/UF3/Proyecto/limpieza.sql
source /home/roger/M02/UF3/Proyecto/BBDD/empresa.sql
source /home/roger/M02/UF3/Proyecto/RogerPerezBlanco.sql
*/