/*
 * Programa que ens demanará una frase i ens la retornarà amb totes les lletres entre parèntesis.
 */
public class Parentitza {

    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        if (frase.isEmpty()) {
            System.out.println("Frase buida");
        }
        else{
            for (int inici=0; inici<=(frase.length()-2); inici++) {
                if (Character.isLetter(frase.charAt(inici))) {
                    System.out.print("("+ frase.charAt(inici) +")");
                }
                else {
                    System.out.print(frase.charAt(inici));
                }
            }
        }
        System.out.println(".");
    }
}