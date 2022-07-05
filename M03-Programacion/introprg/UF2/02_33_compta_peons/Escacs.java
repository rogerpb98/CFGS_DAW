/*
 *  Programa que li passa el tauler i una ficha per arguments al metode per comptar
 * quantes fitxes repetides d'aquest tipus hi ha.
 */
public class Escacs {
    public static int quantesOcurrencies(char[][] cosa, char ficha){
        int repeticions=0;
        for (int fila = 0; fila < cosa.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < cosa[fila].length; columna++) { //bucle que recorre tota la columna
                if (cosa[fila][columna] == ficha) {
                    repeticions++;
                }
            }
        }
        return repeticions;
    }
    public static void main(String[] args){
        // declarem la variable taulell
        char[][] taulell; //files x columnes

        // creem espai per les 8 x 8 cel·les
        taulell = new char[8][8];

        // emplenem tot de blancs
        for (int fila = 0; fila < taulell.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < taulell[fila].length; columna++) { //bucle que recorre tota la columna
                taulell[fila][columna] += '·'; //reemplaçem tots els espais per punts
            }
        }

        // col·loquem les peces
        for (int fila = 0; fila < taulell.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < taulell[fila].length; columna++) { //bucle que recorre tota la columna
                if (fila==1 && columna==0) {
                    taulell[fila][columna] = 'p';
                }
                else if (fila==5 && columna==6) {
                    taulell[fila][columna] = 'P';
                }
                else if (fila==5 && columna==7) {
                    taulell[fila][columna] = 'R';
                }
                else if (fila==6 && columna==5) {
                    taulell[fila][columna] = 'A';
                }
                else if (fila==7 && columna==7) {
                    taulell[fila][columna] = 'r';
                }
            }
        }

        // mostrem el resultat
        for (int fila = 0; fila < taulell.length; fila++) { //bucle que recorre tota la fila
            for (int columna = 0; columna < taulell[fila].length; columna++) { //bucle que recorre tota la columna
                System.out.print(taulell[fila][columna]); //mostrem tot el taulell
            }
            System.out.println();
        }

        System.out.println("Peons negres: " + quantesOcurrencies(taulell, 'p'));
        System.out.println("Peons blancs: " + quantesOcurrencies(taulell, 'P'));
    }
}