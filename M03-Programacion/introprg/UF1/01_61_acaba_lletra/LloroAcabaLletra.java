/*
 * Programa que demana paraules fins que deixem l'espai en blanc per sortir, quan la 
 * paraula acabi en vocal minuscula, repeteix, sino, torna a preguntar.
 */

public class LloroAcabaLletra {
    public static void main(String[] args) {
        String paraula = ("Zzz");
        /* Mentre la paraula que reb no sigui un espai en blanc o un buit, es repeteix el bucle */
        while (!paraula.isBlank()) {
            System.out.println("El lloro pregunta paraula que finalitzi per lletra");
            paraula = Entrada.readLine(); /* Demanem paraula */
            /* Si no hem introduit res, entrem al if, sino, al else */
            if (paraula.isBlank()) {
                System.out.println("Adéu");
                }
            else {
                char primeraLletra = paraula.charAt(paraula.length()-1);
                if (Character.isLetter(primeraLletra)) {
                    System.out.println("El lloro diu: " + paraula);
                }
            }
        }
    }
}