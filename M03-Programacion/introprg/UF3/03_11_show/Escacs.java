/* Metodes del puzle */

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
}
