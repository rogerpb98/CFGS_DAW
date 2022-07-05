/* 
 * Introduïm un nombre per consola i el programa ens diu si 
 * coincideix amb el que ell ha pensat (42 sempre per simplicitat)
 */
public class Endevina {
    public static void main(String[] args){
        int numAEndevinar = 42;
        int nombre = 0;
        while (nombre != numAEndevinar) {
            System.out.println("Nombre?");
            nombre = Integer.parseInt(Entrada.readLine());
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
