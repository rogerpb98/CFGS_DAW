#####################################
Exercici 04_04. Renat també des de fora
#####################################

* autor/a: «Roger Pérez Blanco»

* data: «09/03/2021»

Introducció
===========

En aquest exercici «Renat també des de fora»

Codi
====

El codi a analitzar és el següent:

::

    public class UsaGatRenat {
        public static void main(String[] args) {
            GatRenat renat = new GatRenat();
            System.out.println("Al gat Renat li queden " + renat.vides + " vides");
        }
    }

Pregunta 1
==========

Quin és el nom del fitxer on està definit el punt d’entrada main() d’aquest programa?

«UsaGatRenat.java»

Pregunta 2
==========

Ara tenim dos fitxers amb main(). Com pot saber Java quin és el main() a executar?

«ho indiquem al utilitzar la comanda java, la clase que li passem per argument será on anirà
a buscar el main»

Pregunta 3
==========

A quin fitxer està definida la classe del gat Renat?

«a GatRenat.java»

Pregunta 4
==========

Quants programes es podrien construir fent ús de la definició del gat Renat?

«Tants com vulguem mentres els definim amb un nom diferent»

Pregunta 5
==========

Què passaria si el fitxer amb el codi anterior i el que conté la definició de la classe 
del Renat estiguessin en directoris diferents?

«no es trobarien entre si»

Pregunta 6
==========

Elimina el main() de GatRenat. Continua funcionant UsaGatRenat? Què ha deixat de poder-se 
executar?

«UsaGatRenat funciona correctament, el que canvia es que ja no podrém executar GatRenat, 
ja que no te main»

