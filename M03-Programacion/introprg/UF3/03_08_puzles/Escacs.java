/* Metodes del puzle */

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Escacs {
    //moduls 11
    //mostra l'estat actual del taulell que reb per argument
    public static void mostraTaulell (char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < taulell[fila].length; columna++) { //bucle que recorre tota la columna
                System.out.print(taulell[fila][columna]); //mostrem tot el taulell
            }
            System.out.println();
        }
    }
    
    //moduls 12
    //Crea un taulell buit (omplert amb '·')
    public static char[][] creaTaulellBuit() {
        char[][] taulell;
        taulell = new char[8][8];
        //Bucle que recorre l'arrai i emplena l'emplena amb el tauler buit
        for (int fila = 0; fila < taulell.length; fila++) {
            String linia = "";
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                taulell[fila][columna] = '·';
            }
        }
        return taulell;
    }

    //moduls 14
    //Recorre totes les figures valides i si alguna coincideix 
    //amb la que reb per argument retorna true
    public static boolean esFiguraValida(char figura) {
        char[] figuresValides = {
            'P', 'T', 'C', 'A', 'D', 'R', 'p', 't', 'c', 'a', 'd', 'r', 
        };
        for (char i : figuresValides) {
            if (figura == i) return true;
        }
        return false;
    }

    //Col·loca una figura a la posició indicada del taulell
    public static boolean posicionaFigura(char[][] taulell, int fila, int columna, char figura) {
        if (fila < 0 || fila > 7 || columna < 0 || columna >7) return false;
        if (taulell[fila][columna]=='·') {
            taulell[fila][columna] = figura;
            return true;
        }
        else return false;
    }

    //moduls 15
    //Mou una figura a la posició indicada del taulell (passa la possició inicial a '·')
    public static boolean mouFigura(char[][] taulell, int fila0, int columna0, int fila1, int columna1) {
        if ((fila0 < 0 || fila0 > 7 || columna0 < 0 || columna0 >7) ||
            (fila1 < 0 || fila1 > 7 || columna1 < 0 || columna1 >7)) return false;
        if (taulell[fila0][columna0]=='·') return false;
        if (taulell[fila1][columna1]=='·') {
            taulell[fila1][columna1] = taulell[fila0][columna0];
            taulell[fila0][columna0] = '·';
            return true;
        }
        else return false;
    }

    //moduls 16
    //Elimina la figura que hi hagi a la posició indicada (si hi ha una)
    public static boolean eliminaFigura(char[][] taulell, int fila, int columna) {
        if (fila < 0 || fila > 7 || columna < 0 || columna >7) return false;
        if (taulell[fila][columna]!='·') {
            taulell[fila][columna] = '·';
            return true;
        }
        else return false;
    }
}