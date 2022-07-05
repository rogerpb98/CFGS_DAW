SET AUTOCOMMIT=0;

BEGIN;

\! echo "Borrado de la Marca Opel:";
DELETE FROM MARCA WHERE nombre='Opel';

COMMIT;
