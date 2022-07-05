/*
 * Programa que ens demanará una frase i ens la retornarà amb totes les lletres entre parèntesis.
 */
public class Parentitza {

    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        parentitza(frase);
    }
    public static void parentitza(String text) {
        if (text.isEmpty()) {
            System.out.println("Frase buida");
        }
        else{
            for (int inici=0; inici<=(text.length()-2); inici++) {
                if (Character.isLetter(text.charAt(inici))) {
                    System.out.print("("+ text.charAt(inici) +")");
                }
                else {
                    System.out.print(text.charAt(inici));
                }
            }
        }
        System.out.println(".");
    }
}
