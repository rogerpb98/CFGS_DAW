/*
 * Programa per provar diverses utilitats incluides a java per manipular strings.
 */

public class Manipulant_String {
    public static void main(String[] args) {
        System.out.println("paraula?");
        String principal = Entrada.readLine();
        if (principal.length() >= 4) {

            /* Sortida */
            System.out.println("\"" + principal + "\".charAt(1): " + principal.charAt(1)); //segona lletra
            System.out.println("\"" + principal + "\".length(): " + principal.length()); //longitud de la paraula
            System.out.println("\"" + principal + "\".length(): " + principal.charAt(principal.length()-1)); //última lletra
            System.out.println("\"" + principal + "\".length(): " + principal.charAt(principal.length()-2)); //penúltima lletra
            System.out.println("\"" + principal + "\".toUpperCase(): " + principal.toUpperCase()); //en majúscules
            System.out.print("Quarta lletra moguda al principi: ");
            System.out.print(principal.charAt(3));
            for (int valorInicial=0; valorInicial<=principal.length()-1; valorInicial++) {
                char lletraActual=principal.charAt(valorInicial);
                if ( lletraActual==principal.charAt(3) ) {
                    System.out.print("");
                }
                else {
                    System.out.print(principal.charAt(valorInicial));
                }
            }
            System.out.println("");
            System.out.print("Paraula amb els 3 primers caracters en majuscula: ");
            for (int valorInicial=0; valorInicial<=2; valorInicial++) {
                String lletra = String.valueOf(principal.charAt(valorInicial));
                System.out.print(lletra.toUpperCase());
            }
            for (int valorInicial=3; valorInicial<=principal.length()-1; valorInicial++) {
                String lletra = String.valueOf(principal.charAt(valorInicial));
                System.out.print(lletra.toLowerCase());
            }
            System.out.println("");
        }
        else {
            System.out.println("La paraula es molt curta");
        }
    }
}
