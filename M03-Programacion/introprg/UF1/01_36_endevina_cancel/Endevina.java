/*
 * Programa que ens demana un nombre i ens el compara amb el que
 * tenia pensat el programa (42 per simplicitat)
 * Si deixem la linea en blanc es cancel·la.
 */
public class Endevina {
    public static void main(String[] args){
        int numAEndevinar = 42;
        int nombre = 0;
        while (nombre != numAEndevinar) {
            System.out.println("Nombre?");
            String nombreStr = (Entrada.readLine());
            if (nombreStr.isEmpty()) {
                System.out.println("Cancel·lat!");
                nombre = numAEndevinar;
            }
            else {
                /*Convertir string a int*/
                nombre = Integer.parseInt(nombreStr.trim());

                if (nombre < 1 || nombre > 100) {
                System.out.println("Fora de rang");
                }
                else if (nombre > numAEndevinar) {
                    System.out.println("Massa gran");
                }
                else if (nombre < numAEndevinar) {
                    System.out.println("Massa petit");
                }
                else {
                    System.out.println("Encertat!");
                }
            }
        }
    }
}
