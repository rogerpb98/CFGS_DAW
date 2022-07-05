/*
 *  Programa que mira si hi ha una dama negra al tauler (D)
 */
public class Escacs {

    public static boolean teDamaNegra(char[][] cosa){
        for (int fila = 0; fila < cosa.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < cosa[fila].length; columna++) { //bucle que recorre tota la columna
                if (cosa[fila][columna] == 'D') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        // declarem la variable taulell
        char[][] taulell; //files x columnes

        // creem espai per les 8 x 8 cel·les
        taulell = new char[8][8];

        teDamaNegra(taulell);
    }
}