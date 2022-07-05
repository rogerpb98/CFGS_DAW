/*
 * Programa que ens demanará una frase i ens la retornarà amb totes les lletres seguides
 * d'una coma excepte l'ultima.
 */
public class NomesLletres {
    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        if (frase.isEmpty()) {
            System.out.println("Frase buida");
        }
        else{
            for (int inici=0; inici<=(frase.length()-2); inici++) {
                if (Character.isLetter(frase.charAt(inici))) {
                    System.out.print(frase.charAt(inici));
                    if (inici != frase.length()-2){
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