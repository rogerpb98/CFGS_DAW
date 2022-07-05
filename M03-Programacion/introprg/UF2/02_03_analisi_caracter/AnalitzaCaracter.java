/*
 * Programa que ens demana un texte i una posició i ens dirá si el caràcter 
 * corresponent es un nombre, una lletra, un altre caràcter o està fora de rang.
 */
public class AnalitzaCaracter {


    public static void analitzaCaracter(char patata) {
        //Si el caracter es numeric
        if (Character.isDigit(patata)) {
            System.out.println("'" + patata + "' és un nombre");
        }
        //Si el caracter es lletra
        else if (Character.isLetter(patata)) {
            System.out.println("'" + patata + "' és una lletra");
        }
        //Si el caracter es cap altre cosa
        else {
            System.out.println("'" + patata + "' és una altra cosa");
        }
    }

    public static void main(String[] args) {
        System.out.println("Text?");
        String texte = Entrada.readLine();

        System.out.println("Posició?");
        int posicio = Integer.parseInt(Entrada.readLine());
        
        //si el numero es negatiu
        if (posicio < 0) {
            if (texte.length()+posicio < 0) {
                System.out.println("Fora de rang");
            }
            else {
                analitzaCaracter(texte.charAt(texte.length()+posicio));
            }
            
        }
        //si el numero es positiu
        else {
            if (posicio >= texte.length()) {
                System.out.println("Fora de rang");
            }
            else {
                analitzaCaracter(texte.charAt(posicio));
            }
            
        }
    }
        
}

