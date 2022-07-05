/*
 * Programa que calcula la nota de les notes que hi escriguim sempre que estiguin dintre del rang (0-100)
 */

public class NotaMitja {
    public static void main(String[] args) {

        // creem la variable on guardarem el resultat de sumar
        int suma = 0;   // inicialment no hem sumat res i per tant és 0
        int valides = 0; // aquesta variable guarda la quanitat de notes vàlides
        // demanem valors

        // declarem la variable que contindrà els valors llegits
        int valor;

        // processem el primer valor amb un bucle de manera que sempre que 
	// ens doni un valor per sobre de 0 entri al bucle
        System.out.println("Introdueix una nota");
        valor = Integer.parseInt(Entrada.readLine());
        while (valor >= 0 && valor <= 100) {
            suma = suma + valor; //suma de les notes totals
            valides += 1;
	    System.out.println("Introdueix una nota");
            valor = Integer.parseInt(Entrada.readLine());
        }

        if (valides > 0) {
            //processem les dades per treure la mitja
            int mitja = suma / valides;
            // mostrem el resultat
            System.out.println("La mitja de les notes vàlides és " + mitja);
        } 
        else {
            System.out.println("Cap nota vàlida introduïda");
        }
    }
}

