/*
 * Programa que demana paraules fins que deixem l'espai en blanc per sortir, si 
 * la segona paraula i la penultima coincideixen, t'ho diu, sino, també t'ho diu
 */

public class SegonaIgualPenultima {
    public static void main(String[] args) {
        String paraula = ("Zzz");
        System.out.println("Ves introduïnt texts (finalitza amb enter sol)");
        /* Mentre la paraula que reb no sigui un espai en blanc o un buit, es repeteix el bucle */
        while (!paraula.isBlank()) {
            paraula = Entrada.readLine(); /* Demanem paraula */
            /* Si no hem introduit res, entrem al if, sino, al else */
            if (paraula.isBlank()) {
                System.out.println("Adéu");
                }
            else if (paraula.length()==1){
                System.out.println("Segona diferent de penúltima");
            }
            else {
                char penultimaLletra = paraula.charAt(paraula.length()-2);
                char segonaLletra = paraula.charAt(1);
                if (segonaLletra == penultimaLletra) {
                    System.out.println("Segona igual a penúltima");
                }
                else{
                    System.out.println("Segona diferent de penúltima");
                }
            }
        }
    }
}