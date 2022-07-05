
/*
 * programa que demana un enter positiu més gran que 0 i «dibuixa» un quadrat amb els nombres 
 * del 1 fins el valor de l’entrada utilitzan recorreguts niuats.
 */
public class QuadratNombres {
    public static void main(String[] args) {
        System.out.println("Valor final?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        if (valorFinal < 1 || valorFinal > 9) {
            System.out.println("Valor inadequat");
        }
        else{
            for (int linia=1; linia <= valorFinal; linia++) {
                for (int columna=1; columna <= valorFinal; columna++) {
                    System.out.print(" " + columna);
                }
                System.out.println();
            }
        }
    }
}
