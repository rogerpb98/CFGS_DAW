/*
 * Programa que ordena dos nombres
 */
public class DosEnOrdre {
    public static void main(String[] args) {
    
        /*Declara las variables i demana un valor per consola*/
        System.out.println("Primer?");
        int primer = Integer.parseInt(Entrada.readLine());
        System.out.println("Segon?");
        int segon = Integer.parseInt(Entrada.readLine());
        
        /*compara el primer i el segon, i amb una instrucció condicional 
          amb if i else mostra el missatge corresponent.*/
        if (primer == segon) {
            System.out.println("" + primer + " i " + segon);
        }
        else if (primer < segon) {
            System.out.println("" + primer + " i " + segon);
        }
        else {
            System.out.println("" + segon + " i " + primer);
        }
    }
}
