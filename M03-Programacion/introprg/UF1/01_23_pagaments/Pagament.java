
/*
 * Programa que demana un preu, et pregunta quant pagues i et diu el canvi restant.
 */
public class Pagament {
    public static void main(String[] args) {
    
        /*Declara las variables i demana un valor per consola*/
        System.out.println("Preu?");
        int preu = Integer.parseInt(Entrada.readLine());
        System.out.println("Paga?");
        int paga = Integer.parseInt(Entrada.readLine());
        
        int canvi = preu - paga;
        
        if ( canvi < 0 ) {
            System.out.println("Sobren " + canvi * (-1) + "€");
        }
        else if ( canvi == 0 ) {
            System.out.println("No sobra ni falta res");
        }
        else {
            System.out.println("Falten " + canvi + "€");
        }
    }
}
