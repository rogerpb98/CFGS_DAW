create table Concessionari(
    ID_Concessionari tinyint unsigned auto_increment primary key,
    Adreca varchar(50),
    Ciutat_Concessionari varchar(20)
);

create table Client( 
    DNI char(9) primary key,
    Nom varchar(40), 
    Ciutat_Client varchar(20),
    Concessionari tinyint unsigned, 

    foreign key (Concessionari) references Concessionari(Id_Concessionari)
);

--Inserts
insert into Concessionari values (default, 'Antoni de Capmany 123', 'Barcelona');
insert into Concessionari values (default, 'Sepúlveda 12', 'Barcelona');
insert into Concessionari values (default, 'Anlemany 32', 'Barcelona');
insert into Concessionari values (default, 'Gipuzcua 43', 'Madrid');
insert into Concessionari values (default, 'Antoni de Capmany 12', 'Barcelona');
--Ex 1
drop procedure if exists ex1;
delimiter //
create procedure ex1(in noudni char(9), in nounom varchar(40), in novaciutat varchar(20), in nouconc tinyint unsigned, out sortida varchar(100))
begin
    declare mateixaCiutat tinyint default (select count(*) from Concessionari where ID_Concessionari=nouconc and Ciutat_Concessionari=novaciutat);
    if mateixaCiutat then
        insert into Client values (noudni, nounom, novaciutat, nouconc);
        select 'OK' into sortida;
    else
        select 'La ciutat indicada no correspon amb la ciutat del concessionari';
    end if;
end //
delimiter ;

select * from Client;
call ex1(123456789, 'Manuel', 'Barcelona', 1, @sortida);
call ex1(123456723, 'Manuel', 'Barcelona', 4, @sortida);
call ex1(123456723, 'Manuel', 'Madrid', 3, @sortida);
call ex1(123456723, 'Manuel', 'Madrid', 4, @sortida);
select * from Client;

--Ex 2
drop user ajudantcomercial;
drop user capcomercial;

create user ajudantcomercial@'%';
create user capcomercial@'%';

grant SELECT, INSERT, EXECUTE on examen.* to capcomercial@'%';
grant EXECUTE on examen.* to ajudantcomercial@'%';

drop procedure if exists ex1;
delimiter //
create definer=capcomercial@'%' procedure ex1(in noudni char(9), in nounom varchar(40), in novaciutat varchar(20), in nouconc tinyint unsigned, out sortida varchar(100))
begin
    declare mateixaCiutat tinyint default (select count(*) from Concessionari where ID_Concessionari=nouconc and Ciutat_Concessionari=novaciutat);
    if mateixaCiutat then
        insert into Client values (noudni, nounom, novaciutat, nouconc);
        select 'OK' into sortida;
    else
        select 'La ciutat indicada no correspon amb la ciutat del concessionari';
    end if;
end //
delimiter ;

--Ex 3
drop function if exists ex3;
delimiter //
create function ex3(conc tinyint unsigned) returns smallint unsigned
begin
    declare numeroClients int;
    set numeroClients = (select count(*) from Client where Concessionari=conc);
    return numeroClients;
end //
delimiter ;

select ex3(1);
select ex3(2);
select ex3(3);
select ex3(4);
select ex3(5);

--Ex 4
drop procedure if exists ex4;
delimiter //
create procedure ex4()
begin
    declare idconc tinyint;
    declare condicion int default 1;
    declare cursorUsuarios cursor for select ID_Concessionari from Concessionari order by ID_Concessionari;
    DECLARE continue HANDLER FOR SQLSTATE '02000' 
    BEGIN 
        set condicion = 0; 
    END;

    open cursorUsuarios;
    fetch cursorUsuarios into idconc;
    while condicion do
        select idconc, ex3(idconc);
        fetch cursorUsuarios into idconc;
    end while;
    close cursorUsuarios;
end //
delimiter ;

call ex4();

--Ex 5
create table Estadistica( 
    Ciutat varchar(20) primary key,
    Numconces int unsigned
);

DROP TRIGGER IF EXISTS InsertConcessionari;
DELIMITER //
CREATE TRIGGER InsertConcessionari after insert on Concessionari for each row
begin
    declare existeix tinyint default (select count(ciutat) from Estadistica where ciutat=new.Ciutat_Concessionari);
    declare quants smallint default (select count(*) from Concessionari where Ciutat_Concessionari=new.Ciutat_Concessionari);
    if existeix then
        update Estadistica set numconces=numconces+1 where Ciutat=new.Ciutat_Concessionari;
    else
        insert into Estadistica values (new.Ciutat_Concessionari, quants);
    end if;
end //
DELIMITER ;

select * from Estadistica;
insert into Concessionari values (default, 'TestTrigger1', 'Barcelona');
insert into Concessionari values (default, 'TestTrigger2', 'Madrid');
select * from Estadistica;
insert into Concessionari values (default, 'TestTrigger3', 'Barcelona');
insert into Concessionari values (default, 'TestTrigger4', 'Madrid');
select * from Estadistica;

--delete from Concessionari where adreca='TestTrigger1';
--delete from Concessionari where adreca='TestTrigger2';
--delete from Concessionari where adreca='TestTrigger3';
--delete from Concessionari where adreca='TestTrigger4';