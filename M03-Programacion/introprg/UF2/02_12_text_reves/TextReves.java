/*
 * Programa que ens demanará una frase i ens la retornarà al reves
 * separant cada caracter per coma.
 */
public class TextReves {

    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        mostraReves(frase);
    }
    public static void mostraReves(String text) {
        if (!(text.isEmpty())) {
            for (int inici=(text.length()-1); inici>=0; inici--) {
                System.out.print(text.charAt(inici));
                if (inici>0) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("");
    }
}
