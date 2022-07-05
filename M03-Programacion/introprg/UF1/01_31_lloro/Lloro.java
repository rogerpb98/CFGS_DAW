/*
 * programa que va demanant paraules i les repeteix fins que rebi una resposta en blanc o buida. 
 * És a dir, la resposta sigui un return directament o bé només espais.
 */

public class Lloro {
    public static void main(String[] args) {
        String paraula = "Hola"; /* Declarem variable per entrar al bucle */
        /* Mentre la paraula que reb no sigui un espai en blanc o un buit, es repeteix el bucle */
        while (!paraula.isBlank()) {
            System.out.println("El lloro pregunta paraula:");
            paraula = Entrada.readLine(); /* Demanem paraula */
            /* Si no hem introduit res, entrem al if, sino, al else */
            if (paraula.isBlank()) {
                System.out.println("Adéu");
                }
            else {
                System.out.println("El lloro diu: " + paraula);
            }
        }
    }
}
