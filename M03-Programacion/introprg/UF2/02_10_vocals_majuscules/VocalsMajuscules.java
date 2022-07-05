/*
 * programa que demana un text i mostra totes les lletres en minúscules excepte les vocals, 
 * que hauran d’estar en majúscules.
 */
public class VocalsMajuscules {
    public static void main(String[] args) {

        System.out.println("Text?");
        String frase = Entrada.readLine();
        majusculitzaVocals(frase);
    }

    public static void majusculitzaVocals(String text) {
        for (int inici=0; inici<=text.length()-1; inici ++) {
            if (text.charAt(inici)==' ') {
                System.out.print(text.charAt(inici));
            }
            else if (Character.isLetter(text.charAt(inici)) && text.charAt(inici)=='a' || text.charAt(inici)=='e' || text.charAt(inici)=='i' || text.charAt(inici)=='o' || text.charAt(inici)=='u' || text.charAt(inici)=='A' || text.charAt(inici)=='E' || text.charAt(inici)=='I' || text.charAt(inici)=='O' || text.charAt(inici)=='U') {
                System.out.print(Character.toUpperCase(text.charAt(inici)));
            }
            else {
                System.out.print(Character.toLowerCase(text.charAt(inici)));
            }
        }

    }
}
