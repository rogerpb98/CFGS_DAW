/*
 *  programa que demana un text i un nombre enter, i mostri 
 * tants caràcters del text com indica el nombre enters, 
 * començant pel primer. En cas que en faltin, el programa 
 * tornarà a mostrar el text a partir del primer caràcter 
 * fins que hagi aconseguit tots els caràcters demanats.
 */
public class CadenaContinua {
    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        if (frase.isBlank()) { //si possem un string buit ens mata el programa
            System.out.println("error");
            return;
        }
        System.out.println("Nombre?");
        int nombre = Integer.parseInt(Entrada.readLine());

        for (int inici=0; inici <= nombre-1; inici++) {
            System.out.print(frase.charAt(inici));
            //Quan arrivem al final de la paraula, reinicia el bucle i resta
            //La condició de sortida per restar-li els caracters que ja hem
            //printat.
            if (inici+1 == frase.length()) {
                inici = inici-frase.length();
                nombre = (nombre - frase.length());
            }
        }
        System.out.println();
    }
}