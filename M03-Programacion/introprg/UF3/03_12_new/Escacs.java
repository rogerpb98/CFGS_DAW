/* Metodes del puzle */

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Escacs {
    //moduls 11
    public static void mostraTaulell (char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < taulell[fila].length; columna++) { //bucle que recorre tota la columna
                System.out.print(taulell[fila][columna]); //mostrem tot el taulell
            }
            System.out.println();
        }
    }
    //moduls 12
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
}
