/*
 * Programa que demanará un numero del 1 al 100 (si esta fora de rang ho indica), si endevinem
 * el nombre (per simplicitat sempre es 42) també ho indica, si introduim un espai en blanc ens
 * Calcel·la i si introduim un string es queixa.
 */

public class Endevina {

    public static void main(String[] args) {
        int nombreaEndevinar = 42;
        String nombre="Zzz";
        while (!(nombre.isBlank())) {
            System.out.println("Nombre?");
            nombre = Entrada.readLine();
            boolean esString = false;
            //bucle per saber si el que hem introduit te lletres.
            for (int inici=0; inici<=nombre.length()-1; inici ++) {
                if (Character.isLetter(nombre.charAt(inici))) {
                    esString = true;
                }
            }
            if (nombre.isBlank()){
                System.out.println("Cancel·lat!");
                break;
            }
            else if (esString) {
                System.out.println("Només nombres");
            }
            else {
                int nombreNum = Integer.parseInt(nombre);
                if (nombreNum >100 || nombreNum <=0) {
                    System.out.println("Fora de rang");
                }
                else if (nombreNum > nombreaEndevinar) {
                    System.out.println("Massa gran");
                }
                else if (nombreNum < nombreaEndevinar) {
                    System.out.println("Massa petit");
                }
                else if (nombreNum == nombreaEndevinar){
                    System.out.println("Encertat!");
                    break;
                }
            }
        }
    }
}