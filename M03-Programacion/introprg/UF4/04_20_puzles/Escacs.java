/* Metodes del puzle, contindrá totes les funciona per modificar el contingut d'un puzle */

import java.io.IOException;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Escacs {
    private char[][] taulell = {
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'},
        {'·','·','·','·','·','·','·','·'}
    };

    public Escacs() { }

    public Escacs(char[][] nouTaulell) {
        if (esTaulellValid(nouTaulell)) {
            char[][] taulellClonat = clonaTaulell(nouTaulell);
            taulell = taulellClonat;
        }
    }

    public char[][] getTaulell() {
        char[][] taulellClonat = clonaTaulell(taulell);
        return taulellClonat;
    }

    public void mostraTaulell() {
        for (int fila = 7; fila >= 0; fila--) {
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                System.out.print(taulell[fila][columna]);
            }
            System.out.println();
        }
    }

    public boolean posicionaFigura(int fila, int columna, char figura) {
        if (fila < 0 || fila > 7 || columna < 0 || columna >7) return false;
        if (taulell[fila][columna]=='·') {
            taulell[fila][columna] = figura;
            return true;
        }
        return false;
    }

    public boolean mouFigura(int fila0, int columna0, int fila1, int columna1) {
        if ((fila0 < 0 || fila0 > 7 || columna0 < 0 || columna0 >7) || //caselles fora de rang
            (fila1 < 0 || fila1 > 7 || columna1 < 0 || columna1 >7)) return false;
        if (taulell[fila0][columna0]=='·') return false; //casella inicial buida
        if (taulell[fila1][columna1]=='·') {
            taulell[fila1][columna1] = taulell[fila0][columna0];
            taulell[fila0][columna0] = '·';
            return true;
        }
        return false;
    }

    public boolean eliminaFigura(int fila, int columna) {
        if (fila < 0 || fila > 7 || columna < 0 || columna >7) return false;
        if (taulell[fila][columna]!='·') {
            taulell[fila][columna] = '·';
            return true;
        }
        else return false;
    }

    
    private static char[][] clonaTaulell(char[][] taulellACopiar) {
        char[][] duplicat = new char[8][8];
        for (int fila = 7; fila >= 0; fila--) {
            for (int columna = 0; columna < taulellACopiar[fila].length; columna++) {
                //if (esFiguraValida(taulellACopiar[fila][columna]))
                duplicat[fila][columna] = taulellACopiar[fila][columna];
            }
        }
        return duplicat;
    }
    

    public static boolean esFiguraValida(char figura) {
        char[] figuresValides = {
            'P', 'T', 'C', 'A', 'D', 'R', 'p', 't', 'c', 'a', 'd', 'r',
        };
        for (char i : figuresValides) {
            if (figura == i) return true;
        }
        return false;
    }

    // Extras
    private boolean esTaulellValid(char[][] taulell) {
        if (taulell.length==8) { //totes les files tenen 8 caselles
            for (int fila = 0; fila < 8; fila++) {
                if (taulell[fila].length!=8) return false; //totes les columnes tenen 8 caselles
                //assegurarme de que totes les figures siguin valides
                for (int columna = 0; columna < 8; columna++) {
                    if (!(esFiguraValida(taulell[fila][columna]) 
                        || taulell[fila][columna]=='·')) return false;
                }
            }
            return true; // si passa totes les verificacions del bucle es un taulell valid
        }
        return false;
    }

    @Override
    public String toString() {
        return "Escacs [taulell= \n" + Arrays.deepToString(taulell) + "\n]";
    }
}