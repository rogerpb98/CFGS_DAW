#####################################
Exercici 04_02. En Renat té un accident
#####################################

* autor/a: «Roger Pérez Blanco»

* data: «09/03/2021»

Introducció
===========

En aquest exercici «En Renat té un accident»

Codi
====

El codi a analitzar és el següent:

::

    public class GatRenat {
        public int vides = 7;         // vides disponibles del gat Renat
        public static void main(String[] args) {
            GatRenat renat;           // declarem l'objecte (la referència) al gat
            renat = new GatRenat();   // creem la instància del gat Renat.
            System.out.println("Abans el gat Renat tenia " + renat.vides + " vides");
            renat.vides = renat.vides - 1;  // Renat ha tingut un accident
            System.out.println("Ara el gat Renat té " + renat.vides);
        }
    }

Pregunta 1
==========

Com podem consultar (llegir, obtenir) el valor d’una propietat de la instància?


«Cridantla amb nomObjecte.nomVariable»

Pregunta 2
==========

Com podem canviar (escriure, assignar) el valor d’una propietat de la instància?

«fent una assignacio com a qualsevol altre variable, pero indicant-li que es una variable de
l'objecte que volem modificar
nomObjecte.nomVariable»

Pregunta 3
==========

És possible indicar que el gat Renat té -12 vides? Com? És quelcom desitjable que
pugui passar? En cas que es pugui, com ho podries evitar fent servir els 
coneixements de programació estructurada i modular que hem treballat fins ara?

«Sí, si fem un renat.vides = -12;
No es desitjable que pugui passar, es podria evitar amb un if que comprovi que el 
resultat de l'assignació no pugui ser un nombre negatiu»

