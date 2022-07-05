/*
    Comparació de l'operació remove() en ArrayList i LinkedList
    eliminant per l'inici, pel final i pel mig.

    Els resultats obtinguts han estat:

    Primera execució:
    =================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     18502078
test remove(0) ArrayList:      1021870015

Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 28090458
test remove(últim) ArrayList:  6071903

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:   4662110692
test remove(mig) ArrayList:    523493550

        Segona execució:
        ================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     18413051
test remove(0) ArrayList:      1080134298

Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 23306326
test remove(últim) ArrayList:  5429811

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:   4924553815
test remove(mig) ArrayList:    514943244

        Tercera execució:
        =================

Comparant l'eficiència de les llistes

Comparació quan eliminem sempre de l'inici
test remove(0) LinkedList:     19144478
test remove(0) ArrayList:      1058181390

Comparació quan eliminem sempre del final
test remove(últim) LinkedList: 24572979
test remove(últim) ArrayList:  6039742

Comparació quan eliminem sempre del mig
test remove(mig) LinkedList:   4917775396
test remove(mig) ArrayList:    542046648

        Resultats
        =========

========== ================== ================== ======================================================
**prova**  **linkedList**      **ArrayList**      **resultat**
---------- ------------------ ------------------ ------------------------------------------------------
inici       18.686.535          1.053.395.234      56
final       25.323.254          17.541.456         1
mig         4.834.813.301       526.827.814        9
========== ================== ================== ======================================================

    Per calcular cada columna:

    * la cel·la (1, 1) correspon al temps mig de la implementació LinkedList eliminant des de l'inici
      Es calcula sumant els valors obtinguts a les tres execucions i dividint-los per 3

    * el resultat per la fila inici indica quantes vegades és més ràpid un que l'altre. Per fer-ho, dividim
      el valor més petit pel més gran i arrodonim a l'enter.

    Conclusions
    ===========

    En vistes als resultats, en cas que hagi de fer servir una List per eliminar molts valors, escolliré LinkedList per esborrar desde el principi, ArrayList per eliminar del mig o del final.

     */
    import java.util.List;
    import java.util.ArrayList;
    import java.util.LinkedList;
    public class ComparaRemove {
        private static final int LONGITUD = 100000;
        private static List<Integer> emplena(List<Integer> llista) {
            // codi que emplena la llista amb enters del 0 a LONGITUD - 1
            for (int i = 0; i < LONGITUD-1; i++) {
                llista.add(i);
            }
            return llista;
        }
        private static long testRemove0(List<Integer> llista) {
            long tempsInicial = System.nanoTime();
            // codi que elimina un a un tots els elements de la llista per la posició 0
            boolean llistaBuida;
            if (llista.isEmpty()) 
                llistaBuida=true;
            else
                llistaBuida=false;
            while (! llistaBuida) {
                // elimina el primer element de la llista
                llista.remove(0);
                // actualitza el valor de llistaBuida
                if (llista.isEmpty()) 
                    llistaBuida=true;
            }
            return System.nanoTime() - tempsInicial;
        }
        private static long testRemove(List<Integer> llista) {
            long tempsInicial = System.nanoTime();
            // codi que elimina un a un tots els elements de la llista per la darrera posició
            boolean llistaBuida;
            if (llista.isEmpty()) 
                llistaBuida=true;
            else
                llistaBuida=false;
            while (! llistaBuida) {
                // elimina el primer element de la llista
                llista.remove(llista.size()-1);
                // actualitza el valor de llistaBuida
                if (llista.isEmpty()) 
                    llistaBuida=true;
            }
            return System.nanoTime() - tempsInicial;
        }
        private static long testRemoveMig(List<Integer> llista) {
            long tempsInicial = System.nanoTime();
            // codi que elimina un a un tots els elements de la llista per la posició mig
            boolean llistaBuida;
            if (llista.isEmpty()) 
                llistaBuida=true;
            else
                llistaBuida=false;
            while (! llistaBuida) {
                // elimina el primer element de la llista
                llista.remove(llista.size()/2);
                // actualitza el valor de llistaBuida
                if (llista.isEmpty()) 
                    llistaBuida=true;
            }
            return System.nanoTime() - tempsInicial;
        }
        public static void main(String[] args) {
            System.out.println("Comparant l'eficiència de les llistes");
            System.out.println();
    
            System.out.println("Comparació quan eliminem sempre de l'inici");
            System.out.printf("test remove(0) LinkedList:     %10d%n", testRemove0(emplena(new LinkedList<Integer>())));
            System.out.printf("test remove(0) ArrayList:      %10d%n", testRemove0(emplena(new ArrayList<Integer>())));
            System.out.println();
    
            System.out.println("Comparació quan eliminem sempre del final");
            System.out.printf("test remove(últim) LinkedList: %10d%n", testRemove(emplena(new LinkedList<Integer>())));
            System.out.printf("test remove(últim) ArrayList:  %10d%n", testRemove(emplena(new ArrayList<Integer>())));
            System.out.println();
    
            System.out.println("Comparació quan eliminem sempre del mig");
            System.out.printf("test remove(mig) LinkedList:   %10d%n", testRemoveMig(emplena(new LinkedList<Integer>())));
            System.out.printf("test remove(mig) ArrayList:    %10d%n", testRemoveMig(emplena(new ArrayList<Integer>())));
            System.out.println();
        }
    }