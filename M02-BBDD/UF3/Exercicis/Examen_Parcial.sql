\! echo "Exercici 1";
\! echo "Els següents exercicis es fan sobre la base de dades World.";
use world;
/*********************************************************************************************************/
\! echo "Apartat a";
\! echo "Dissenyeu un procediment que rebi com a paràmetres d’entrada les columnes de la taula «countrylanguage», i doni d’alta una fila a la taula amb aquesta informació.";
drop procedure if exists apartatA;
delimiter //
create procedure apartatA(in codiCountry char(3), in llengua char(30), in oficial enum('T','F'), in percent float(4,1))
begin
    insert into countrylanguage values(codiCountry, llengua, oficial, percent);
end //
delimiter ;
/*       LLAMADA         */
select * from countrylanguage where language='ZZZZZZZ';
call apartatA('ZWE', 'ZZZZZZZ', 'T', '5.2');
select * from countrylanguage where language='ZZZZZZZ';
/*********************************************************************************************************/
\! echo "Apartat b";
\! echo "Comproveu que el valor per IsOfficial sigui 'T' o 'F' (imprimiu un missatge del tipus «IsOfficial admet tan sols valors 'T' o 'F' »)";
drop procedure if exists apartatB;
delimiter //
create procedure apartatB(in codiCountry char(3), in llengua char(30), in oficial char(1), in percent float(4,1))
begin
    declare exit handler for sqlstate '01000'
    begin
        select 'IsOfficial admet tan sols valors \'T\' o \'F\'' ;
    end;
    insert into countrylanguage values(codiCountry, llengua, oficial, percent);
end //
delimiter ;
/*       LLAMADA         */
call apartatB('YEM', 'espanyol', 'T', '5.2');
/*********************************************************************************************************/
\! echo "Apartat c";
\! echo "Comproveu que CountryCode existeixi a la taula country (imprimiu un missatge del tipus «país no existeix a la taula country»).";
drop procedure if exists apartatC;
delimiter //
create procedure apartatC(in codiCountry char(3), in llengua char(30), in oficial char(1), in percent float(4,1))
begin
    declare exit handler for sqlstate '01000'
    begin
        select 'IsOfficial admet tan sols valors \'T\' o \'F\'' ;
    end;
        declare exit handler for not found
    begin
        select 'país no existeix a la taula country' ;
    end;
    insert into countrylanguage values(codiCountry, llengua, oficial, percent);
end //
delimiter ;
/*       LLAMADA         */
call apartatC('YEM', 'espanyol', 'T', '5.2');
call apartatC('ASD', 'espanyol', 'T', '5.2');
/********************************************************************************************************WIP*/ 
\! echo "Apartat d";
\! echo "Afegiu un paràmetre de sortida que retorni 1 si s’ha fet la inserció correctament, -1 si ha fallat la comprovació de l’apartat b i -2 si ha fallat la de l’apartat c";
drop procedure if exists apartatD;
delimiter //
create procedure apartatD(in codiCountry char(3), in llengua char(30), in oficial char(1), in percent float(4,1), out checkInsert tinyint)
begin
    declare exit handler for sqlstate '01000'
    begin
        select 'IsOfficial admet tan sols valors \'T\' o \'F\'' ;
        set checkInsert=-1;
    end;
    declare exit handler for not found
    begin
        select 'país no existeix a la taula country' ;
        set checkInsert=-2;
    end;
    declare exit handler for sqlstate '23000'
    begin
        set checkInsert=0;
    end;
    insert into countrylanguage values(codiCountry, llengua, oficial, percent);
    if (select count(*) from countrylanguage where countrycode=codiCountry and language=llengua and isofficial=oficial and percentage=percent)=1 then
        set checkInsert=1;
    end if;
end //
delimiter ;
/*       LLAMADA         */
call apartatD('ASD', 'hgfhgf', 'T', '5.2', @sortida);
select @sortida;
call apartatD('YEM', 'hgfhgf', 'H', '5.2', @sortida);
select @sortida;
call apartatD('YEM', 'hgfhgf', 'T', '5.2', @sortida);
select @sortida;
/*********************************************************************************************************/
\! echo "Exercici 2";
\! echo "Fes una funció que retorni un missatge de text segons el número de països en que es parla un llenguatge introduït per paràmetre (Language).  
        Si és exactament 1 «Llenguatge Nacional», amb mes de 10 «Llenguatge Internacional», altrament «Llenguatge popular»."; 
drop function if exists ex2;
delimiter //
create function ex2(llenguatge char(30)) returns char(20)
begin
    declare llenguatgeactual char(30);
    declare contador int default 0;
    declare total int default (select count(*) from countrylanguage);
    declare llenguatges cursor for select * from countrylanguage where language=llenguatge;

    open llenguatges;
    if total is null then
        return 'no languages match this one';
    end if;
    while total>0 do
        fetch llenguatges into llenguatgeActual;
        set total = total - 1;
        set contador = contador + 1;
    end while;
    close llenguatges;
    if contador = 1 then
        return 'Llenguatge Nacional';
    elseif contador > 10 then
        return 'Llenguatge Internacional';
    else then
        return 'Llenguatge popular';
    end if;
end //
delimiter ;
/*       LLAMADA         */
call apartatD('ASD', 'espanyoladssad', 'T', '5.2');