#####################################
Exercici 04_06. Vides sempre correctes
#####################################

* autor/a: «Roger Pérez Blanco»

* data: «09/03/2021»

Introducció
===========

En aquest exercici «Vides sempre correctes»

Codi
====

El codi a analitzar és el següent:

::

    public class GatRenat {
        private int vides = 7;
        public int getVides() {  //  retorna el nombre de vides
            return vides;
        }
        public void setVides(int novesVides) {   // modifica el nombre de vides si ens donen un de vàlid
            if (novesVides >= 0) {
                vides = novesVides;
            }
        }
    }

Pregunta 1
==========

Què passa si intentes executar el següent codi? Perquè creus?

::

    public class UsaGatRenat {
        public static void main(String[] args) {
            GatRenat renat = new GatRenat();
            System.out.println("El gat Renat té " + renat.vides + " vides");
        }
    }

«Peta, perque vides es privada, hem de fer servir getters per recollir la informació»

Pregunta 2
==========

Què tal si modifiquem lleugerament el codi anterior per aquest?

::

    public class UsaGatRenat {
        public static void main(String[] args) {
            GatRenat renat = new GatRenat();
            System.out.println("El gat Renat té " + renat.getVides() + " vides");
        }
    }

Fixa’t que ara estem fent servir renat.getVides() en comptes de directament renat.vides().
Funciona ara?

«Ara funciona, ja que hem recollit la informació de vides mitjançant un get»

Pregunta 3
==========

Com es pot determinar a UsaGatRenat que renat té 5 vides?
Inclou el codi a la resposta i la sortida que et genera.

::

    public class UsaGatRenat {
        public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        renat.setVides(5);
        System.out.println("El gat Renat té " + renat.getVides() + " vides");
        }
    }

«El gat Renat té 5 vides»

Pregunta 4
==========

Què passa si intentem assignar-li -12 en comptes de 5 vides?
Inclou el codi, la sortida i la teva explicació.

::

    public class UsaGatRenat {
        public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        renat.setVides(-12);
        System.out.println("El gat Renat té " + renat.getVides() + " vides");
        }
    }

«El gat Renat té 7 vides
En aquest cas, mostra el valor per defecte, ja que el setter només funciona si introduim
un valor major que 0»

Pregunta 5
==========

Un cop hem vist què passa des de UsaGatRenat toca experimentar com es comporta aquest 
private des del main() del propi GatRenat.

Experimenta afegint a la darrera versió de GatRenat la mateixa declaració de main() 
que apareixia a la primera versió de UsaGatRenat d’aquesta pàgina. És a dir:

::

public class GatRenat {
    private int vides = 7;
    public int getVides() {  //  retorna el nombre de vides
        return vides;
    }
    public void setVides(int novesVides) {   // modifica el nombre de vides si ens donen un 
    de vàlid
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        renat.vides = -12;
        System.out.println("El gat Renat té " + renat.vides + " vides");
    }
}
Què passa en intentar compilar i executar aquesta versió? Perquè creus? Ho veus coherent?

«S'executa correctament i ens col·loca amb -12 vides.
Això passa perque no ha fet falta que utilitzem el setter per canviarli les vides, per lo tant
no ha hagut d'evaluar la condició que controla que no baixi de 0.
Es coherent»

Pregunta 6
==========

Considerant aquesta darrera versió de GatRenat, és possible aconseguir assignar un nombre 
de vides negatiu a una instància de GatRenat sense modificar el codi de la classe GatRenat? 
Perquè o Com?

«Si executem un java GatRenat si que ens podrà assignar vides negatives al gat Renat»

Pregunta 7
==========

Com descriuries el paper de public i private a les propietats d’una classe?

«public fa la classe accessible per tothom, private nomes per les altres classes 
del mateix fitxer»

Pregunta 8
==========

Per cert, t’has fixat que els mòduls getVides() i setVides() tenen una definició 
lleugerament diferent als mòduls que hem declarat fins ara en aquest curs? 
En concret, no els falta alguna cosa?

Si no se t’acut, considera revisar quan varem veure per primer cop un mòdul que no fos el main().
De moment només cal que identifiquis la petita diferència en la declaració, 
però si tens molta curiositat, experimenta què passa si declares getVides() de la 
mateixa manera que dibuixaQuadrat().


«falta la paraula static, una clase static pot ser invocada sense instanciar un objecte 
de la classe, i a nosaltres no ens interessa això en aquest cas»

