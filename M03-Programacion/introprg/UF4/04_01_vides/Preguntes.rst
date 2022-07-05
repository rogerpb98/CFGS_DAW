#####################################
Exercici 04_01. En Renat té set vides
#####################################

* autor/a: «Roger Pérez Blanco»

* data: «09/03/2021»

Introducció
===========

En aquest exercici «En Renat té set vides»

Codi
====

El codi a analitzar és el següent:

::

    public class GatRenat {
        public int vides = 7;         // vides disponibles del gat Renat
        public static void main(String[] args) {
            GatRenat renat;           // declarem la referència al gat
            renat = new GatRenat();   // creem la instància del gat Renat.
            System.out.println("Al gat Renat li queden " + renat.vides + " vides");
        }
    }

Pregunta 1
==========

Quin ha de ser el nom del fitxer que contingui aquest codi perquè
funcioni?


«GatRenat.java»

Pregunta 2
==========

A quina línia està declarada la variable ``renat`` que apareix a la
línia 6?

«linia 4»

Pregunta 3
==========

A quina línia s’assigna el valor que es mostra per pantalla?

«linia 2»

Pregunta 4
==========

Quin valor apareix si a aquesta línia no s’assigna cap valor?

«0»

Pregunta 5
==========

Què passaria sí la línia 5 no hi fos? Perquè creus?

«Peta, perque no s'ha creat cap instancia de variable anomenada "renat"»

Pregunta 6
==========

Perquè creus que el comentari de la línia 4 parla de referència? 

«Perque quan declares la variable es un punt de referencia per trobarla després»

Quina relació té amb el concepte de variable?

«Directa»

Pregunta 7
==========

La línia 5 parla d”instància. En aquest context, una instància es pot entendre 
com el contingut real al que fa referència la variable renat. Es diu que la 
instància es construeix amb l’operador new i això implica bàsicament que es 
reserva espai de memòria per a allotjar tota la informació relativa a la instància.
Descriu, respecte aquesta línia quina és la instància, quina la variable, 
quina la referència, quin el valor i quina la classe.

«renat es la referencia i la variable
vides el valor
GatRenat() es la clase»

Pregunta 8
==========

Pel que hem estudiat fins ara, vides podria ser considerat una variable 
global dins de la classe GatRenat però hi ha dues diferències respecte a 
les variables globals que varem veure a Variables i mòduls. Sabries indicar quines?


Ah, i no té a veure amb el public. D’això ja en parlarem més tard.


Vinga, t’ajudo amb una d’elles amb una pregunta: pots accedir a vides directament des de main() sense posat-hi davant renat.?

«no es estatica»