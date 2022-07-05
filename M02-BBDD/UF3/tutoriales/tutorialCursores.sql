declare nombre_cursor cursor for consulta;

open nombre_cursor;

fetch nombre_cursor into nombre_var [nombre_var2, ...];

close nombre_cursor;

use mysql;

/* mostrar tantos usuarios con su host como le indiquemos por parametro */
drop procedure if exists exCursor;
delimiter //
create procedure exCursor(in numUsuarios int)
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare contador int default 0;
    declare cursorUsuarios cursor for select user, host from user order by user, host;

    open cursorUsuarios;
    while numUsuarios>0 do

        fetch cursorUsuarios into nombreUsuario, hostUsuario;
        select nombreUsuario;
        set contador = contador - 1;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor(2);

/*  */
drop procedure if exists exCursor;
delimiter //
create procedure exCursor()
begin
    declare nombreUsuario char(32);
    declare hostUsuario char(32);
    declare contador int default (select count(*) from user);
    declare cursorUsuarios cursor for select user, host from user order by user, host;

    open cursorUsuarios;
    while contador>0 do

        fetch cursorUsuarios into nombreUsuario, hostUsuario;
        select nombreUsuario;
        set contador = contador - 1;
    
    end while;
    close cursorUsuarios;
end //
delimiter ;

call exCursor();