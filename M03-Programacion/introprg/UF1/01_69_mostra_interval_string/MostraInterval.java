/*
 * Programa que ens demanará una frase i ens la retornarà amb totes les lletres seguides
 * d'una coma excepte l'ultima.
 */
public class MostraInterval {
    public static void main(String[] args) {
        System.out.println("text?");
        String frase = Entrada.readLine();

        System.out.println("inici?");
        int inici = Integer.parseInt(Entrada.readLine());

        System.out.println("final?");
        int ultima = Integer.parseInt(Entrada.readLine());

        int contador = 0;

        if (inici < 0) {
            inici = 0;
            contador++;
        }
        if (ultima < 0) {
            ultima = 0;
            contador++;
        }        

        if (frase.isEmpty()) {
            System.out.println("Frase buida");
        }
        else if (contador==2) {
            System.out.println("");
        }
        else{
            if (inici < ultima) {
                if (ultima > frase.length()) {
                    ultima = frase.length()-1;
                }
                for (int inicibucle=(inici); inicibucle<=ultima; inicibucle++) {
                    System.out.println(frase.charAt(inicibucle));
                    
                }
            }
            else {
                
                if (inici > frase.length()) {
                    inici = frase.length()-1;
                }
                for (int inicibucle=(inici); inicibucle>=ultima; inicibucle--) {
                    System.out.println(frase.charAt(inicibucle));
                    
                }
            }
        }
    }
}