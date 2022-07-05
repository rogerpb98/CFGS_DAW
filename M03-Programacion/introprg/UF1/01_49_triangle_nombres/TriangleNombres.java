
/*
 * programa que demana un nombre positiu més gran que 0. El programa escriurà una línia per 
 * nombre entre el 1 i el nombre introduït (es a dir, creixentment). A cada línia escriurà 
 * tots els nombres des del nombre corresponent a la línia fins al 1.
 */
public class TriangleNombres {
    public static void main(String[] args) {
        System.out.println("Nombre?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        if (valorFinal < 1) {
            System.out.println("");
        }
        else{
            for (int linia=1; linia <= valorFinal; linia++) {
                for (int columna=linia; columna >= 1; columna--) {
                    System.out.print(" " + columna);
                }
                System.out.println();
            }
        }
    }
}
