#####################################
Exercici 04_03. Hi ha dos gats Renat?
#####################################

* autor/a: «Roger Pérez Blanco»

* data: «09/03/2021»

Introducció
===========

En aquest exercici «Hi ha dos gats Renat?»

Codi
====

El codi a analitzar és el següent:

::

    public class GatRenat {
        public int vides = 7;   // vides disponibles del gat Renat

        public static void main(String[] args) {
            GatRenat renat_I;
            renat_I = new GatRenat();               // crea un primer gat Renat
            System.out.println("El gat Renat I té  " + renat_I.vides + " vides");

            GatRenat renat_II = new GatRenat();     // crea un segon gat Renat!
            System.out.println("El gat Renat II té " + renat_II.vides + " vides");

            renat_I.vides++;
            System.out.println("El gat Renat I té  " + renat_I.vides + " vides");
            System.out.println("El gat Renat II té " + renat_II.vides + " vides");

            renat_II = renat_I; // atenció: la instància de Renat II es perd!
            System.out.println("El gat Renat I té  " + renat_I.vides + " vides");
            System.out.println("El gat Renat II té " + renat_II.vides + " vides");

            renat_I.vides++;
            System.out.println("El gat Renat I té  " + renat_I.vides + " vides");
            System.out.println("El gat Renat II té " + renat_II.vides + " vides");
        }
    }

Pregunta 1
==========

Quanta memòria ocupa, com a mínim, una instància de GatRenat?

«Com a mínim 4 bytes»

Pregunta 2
==========

Quantes instàncies hi ha de GatRenat tot just executat el codi fins la línia 5 (inclosa)?

«0»

Pregunta 3
==========

I fins la línia 6?

«1»

Pregunta 4
==========

I fins la línia 9?

«2»

Pregunta 5
==========

Perquè les línies 7 i 10 mostren les mateixes vides pels gats Renat I i Renat II?

«Perque les dos s'han instanciat amb el mateix valor per defecte»

Pregunta 6
==========

Perquè les línies 13 i 14 mostren diferent nombre de vides pels gats Renat I i Renat II?

«Perque hem fet un increment a la vida de Renat I»

Pregunta 7
==========

Què creus que vol dir el comentari de la línia 16?

«Que renat_II passa a tenir el valor que tingui Renat_I, la instancia va al garbage collector, que s'encarrega de eliminar la instancia quan no s'utilitzarà mes.»

Pregunta 8
==========

Perquè les línies 17 i 18 mostren les mateixes vides pels gats Renat I i Renat II?

«Perque son el mateix»

Pregunta 9
==========

Perquè les línies 21 i 22 mostren les mateixes vides pels gats Renat I i Renat II malgrat la instrucció de la línia 20?

«Perque renat_II es el mateix que renat_I, si fem un increment a renat_I, renat_II tambe el reb»

Pregunta 10
==========

Quantes instàncies hi ha quan s’executa la línia 20? Perquè?

«1, perque renat_II i renat_I utilitzen la mateixa instancia»
