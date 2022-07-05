/*
 * programa que va demanant enters positius i que, en el moment que rebi un 
 * de negatiu, mostra el nombre de valors parells introduïts i finalitzi l’execució.
 */

public class ComptaParells {
    public static void main(String[] args) {

        // creem la variable on guardarem el resultat de sumar
        int parells = 0;   // inicialment no hem sumat res i per tant és 0

        // demanem valors

        // declarem la variable que contindrà els valors llegits
        int valor;

        // processem el primer valor amb un bucle de manera que sempre que 
	// ens doni un valor per sobre de 0 entri al bucle
        System.out.println("Introdueix un valor");
        valor = Integer.parseInt(Entrada.readLine());
        while (valor >= 0) {
            if (valor%2 == 0){
	        parells += 1;
            }
	    System.out.println("Introdueix un valor");
            valor = Integer.parseInt(Entrada.readLine());
        }

        // mostrem el resultat
        System.out.println("Parells introduïts: " + parells);
    }
}

