/*
 * Programa que ens demanará una frase i ens la retornarà amb totes les lletres seguides
 * d'una coma excepte l'ultima.
 */
public class NomesLletres {
    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        filtraLletres(frase);
    }
    public static void filtraLletres(String text) {
        if (text.isEmpty()) {
            System.out.println("Frase buida");
        }
        else{
            for (int inici=0; inici<=(text.length()-2); inici++) {
                if (Character.isLetter(text.charAt(inici))) {
                    System.out.print(text.charAt(inici));
                    if (inici != text.length()-2){
                        System.out.print(", ");
                    }
                }
                else {
                    System.out.print("");
                }
            }
        }
        System.out.println("");
    }
}
