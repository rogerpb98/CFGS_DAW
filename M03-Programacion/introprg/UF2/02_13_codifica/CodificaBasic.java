/*
 * Programa que ens la mostrará codificada
 */
public class CodificaBasic {

    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        System.out.println("Quants?");
        int quantitat = Integer.parseInt(Entrada.readLine());
        codifica(frase, quantitat);
    }
    public static void codifica(String text, int quants) {
        for (int inici = 0; inici <= text.length()-1; inici++) {
            if (Character.isLetter(text.charAt(inici))) {
                for (char a = 'a'; a <= 'z'; a++) {
                    if (text.charAt(inici)=='z') {
                            System.out.print('a');
                            break;
                    }
                    else if (text.charAt(inici)==a) {
                        System.out.print( (char) (text.charAt(inici)+quants)  );
                    }
                    else if (text.charAt(inici)==Character.toUpperCase(a)){
                        System.out.print(text.charAt(inici));
                    }
                }
            }
            else {
                System.out.print(text.charAt(inici));
            }
        }
        System.out.println("");
    }
}
