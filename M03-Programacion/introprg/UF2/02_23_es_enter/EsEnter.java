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
            else if (UtilString.esEnter(frase)) {
                System.out.println("És enter");
            }
            else {
                System.out.println("No és enter");
            }
        }
        System.out.println("Adéu");
    }
}