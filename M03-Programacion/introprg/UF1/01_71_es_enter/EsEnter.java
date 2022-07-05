/*
 * Programa que ens anirà demanant nombres enters, podem incluir espais en blanc 
 * i signes de suma/resta, no compten a l'hora de saber si es enter o string.
 * Si la cadena es buida, s'atura el programa.
 */
public class EsEnter {
    public static void main(String[] args) {
        String frase = "patata";
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        while (!(frase.isBlank())) { //si possem un string buit ens mata el programa
            frase = Entrada.readLine();
            if (frase.isEmpty()) {
                break;
            }
            int contador = 0;
            for (int inici=0; inici <= frase.length()-1; inici++) {
                if (!(Character.isDigit(frase.charAt(inici)) || frase.charAt(inici)=='-' || frase.charAt(inici)=='+')) {
                    contador++;
                }
            }
            if (contador > 0) {
                System.out.println("No és enter");
            }
            else {
                System.out.println("És enter");
            }
        }
        System.out.println("Adéu");
    }
}