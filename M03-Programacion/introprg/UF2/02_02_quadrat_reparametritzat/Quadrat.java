/*
 * Programa que dibuixa un quadrat amb el costat indicat per args[0]
 * Pressuposa que args[0] conté un valor enter vàlid i que args[1]
 * està definit.
 */

public class Quadrat {
    public static void main(String[] args) {
        int costat = Integer.parseInt(args[0]);
        char caracter = args[1].charAt(0);
        dibuixaQuadrat(costat, caracter);
    }
    /* █████ El teu codi aquí */
    public static void dibuixaQuadrat(int costat, char caracter) {
        for (int linia=1; linia <= costat; linia++) {
            for (int columna=1; columna <= costat; columna++) {
                System.out.print(" " + caracter);
            }
            System.out.println();
        }
    }
}
