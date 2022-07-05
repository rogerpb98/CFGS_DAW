/*
 * Programa que indica si el número proporcionat com a primer argument
 * és parell o senar.
 * Si no s'especifica cap número, el resultat és indeterminat.
 */
public class ParellSenar {
    public static void main(String[] args) {
        /*Declara la variable numero afegint-li el valor que haguem passat nosaltres com a argument de la comanda*/
        int numero = Integer.parseInt(args[0]);
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " és parell");
        }
        else if (numero % 2 == 1) {
            System.out.println("El número " + numero + " és senar");
        }
        else {
            System.out.println("Indeterminat");
        }
    }
}
