
/*
 * Programa que demana tres nombres i els mostra per pantalla en ordre ascendent.
 */
public class TresEnOrdre {
    public static void main(String[] args) {
    
        /*Declara las variables i demana un valor per consola*/
        System.out.println("Primer?");
        int primer = Integer.parseInt(Entrada.readLine());
        System.out.println("Segon?");
        int segon = Integer.parseInt(Entrada.readLine());
        System.out.println("Tercer?");
        int tercer = Integer.parseInt(Entrada.readLine());
        
        /*Ordena els nombres evaluant quins son menors que quins.*/
        if (primer <= segon && segon <= tercer) {
            System.out.println("" + primer + ", " + segon + " i " + tercer + "");
        }
        else if (primer <= tercer && tercer <= segon) {
            System.out.println("" + primer + ", " + tercer + " i " + segon + "");
        }
        else if (segon <= primer && primer <= tercer) {
            System.out.println("" + segon + ", " + primer + " i " + tercer + "");
        }
        else if (segon <= tercer && tercer <= primer) {
            System.out.println("" + segon + ", " + tercer + " i " + primer + "");
        }
        else if (tercer <= primer && primer <= segon) {
            System.out.println("" + tercer + ", " + primer + " i " + segon + "");
        }
        else if (tercer <= segon && segon <= primer) {
            System.out.println("" + tercer + ", " + segon + " i " + primer + "");
        }
    }
}
