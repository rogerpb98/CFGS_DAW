/*
 * Programa que ens demanará una frase i ens la retornarà al reves
 * separant cada caracter per coma.
 */
public class MajusculitzaInicials {

    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        majusculitzaInicials(frase);
    }
    public static void majusculitzaInicials(String text) {
        //Si la entrada no esta buida executa el codi
        if (!(text.isEmpty())) {
        //Estableix una variable que utilitzarem per senyal·litzar quan ha de ser maj.
            boolean majuscula = true;
            //Recorrem la frase
            for (int inici=0; inici<=(text.length()-1); inici++) {
                if (Character.isLetter(text.charAt(inici))) {
                    //Si l'anterior caracter no era una lletra, entrarem a aquest if
                    if (majuscula) {
                        System.out.print(Character.toUpperCase(text.charAt(inici)));
                    }
                    else {
                        System.out.print(Character.toLowerCase(text.charAt(inici)));
                    }
                    //Un cop hem printat una lletra, majuscula torna a ser false
                    majuscula = false;
                }
                else {
                    System.out.print(text.charAt(inici));
                    majuscula = true;
                }
            }
        }
        System.out.println("");
    }
}
