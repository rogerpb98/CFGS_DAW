public class AnalitzaCaracter {
    public static void main(String[] args) {
        System.out.println("Text?");
        String texte = Entrada.readLine();

        System.out.println("Posició?");
        int posicio = Integer.parseInt(Entrada.readLine());
        //si el numero es negatiu
        if (posicio < 0) {
            if (posicio*(-1)+1 > texte.length()) {
                System.out.println("fora de rang");
            }
            else {
                System.out.println(texte.charAt(texte.length()-posicio));
            }
        }
        //si el numero es positiu
        else {
            if (posicio+1 > texte.length()) {
                System.out.println("fora de rang");
            }
            else {
                System.out.println(texte.charAt(posicio));
            }
        }
        
    }
}

