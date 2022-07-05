/*
 * programa que demana les notes que han obtingut els alumnes de la teva classe i les suma fins que 
 * rebi un nombre negatiu
 */

public class SumaNotes {
    public static void main(String[] args) {

        // creem la variable on guardarem el resultat de sumar
        int suma = 0;   // inicialment no hem sumat res i per tant és 0

        // demanem valors

        // declarem la variable que contindrà els valors llegits
        int valor;

        // processem el primer valor amb un bucle de manera que sempre que 
	// ens doni un valor per sobre de 0 entri al bucle
        System.out.println("Introdueix una nota");
        valor = Integer.parseInt(Entrada.readLine());
        while (valor >= 0 && valor <= 100) {
            suma = suma + valor;
	    System.out.println("Introdueix una nota");
            valor = Integer.parseInt(Entrada.readLine());
        }

        // mostrem el resultat
        System.out.println("La suma de les notes vàlides és " + suma);
    }
}

