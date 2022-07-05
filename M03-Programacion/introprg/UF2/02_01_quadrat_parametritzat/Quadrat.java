/*
 * Programa que dibuixa un quadrat de X amb el costat indicat per args[0]
 * Pressuposa que args[0] conté un valor enter vàlid
 */

public class Quadrat {

    public static void main(String[] args) {
        int costat = Integer.parseInt(args[0]);
        dibuixaQuadrat(costat);
    }
    
    /* █████ El teu codi aquí */
    public static void dibuixaQuadrat(int costat) {
        for (int linia=1; linia <= costat; linia++) {
            for (int columna=1; columna <= costat; columna++) {
                System.out.print(" X");
            }
            System.out.println();
        }
    }
}
