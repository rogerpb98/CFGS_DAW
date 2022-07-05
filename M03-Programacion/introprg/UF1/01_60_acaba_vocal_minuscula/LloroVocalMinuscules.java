/*
 * Programa que demana paraules fins que deixem l'espai en blanc per sortir, 
 * quan la paraula acabi en vocal minuscula, repeteix, sino, torna a preguntar.
 */

public class LloroVocalMinuscules {
    public static void main(String[] args) {
        String paraula = ("Zzz");
        /* Mentre la paraula que reb no sigui un espai en blanc o un buit, es repeteix el bucle */
        while (!paraula.isBlank()) {
            System.out.println("El lloro pregunta paraula que finalitzi per vocal en minúscules");
            paraula = Entrada.readLine(); /* Demanem paraula */
            /* Si no hem introduit res, entrem al if, sino, al else */
            if (paraula.isBlank()) {
                System.out.println("Adéu");
                }
            else {
                String primeraLletra = String.valueOf(paraula.charAt(paraula.length()-1));
                if (primeraLletra.equals("a") || primeraLletra.equals("e") ||primeraLletra.equals("i") ||primeraLletra.equals("o") ||primeraLletra.equals("u")){
                    System.out.println("El lloro diu: " + paraula);
                }
            }
        }
    }
}
