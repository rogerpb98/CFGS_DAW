/*
 * Programa que demana un color de semafor i ens respongui segons el color indicat. 
 */
public class Semafor {
    public static void main(String[] args) {
    
        /*Declara la variable*/
        System.out.println("Color?");
        String color = Entrada.readLine();
        /*Entra a la opció que li haguem donat*/
        switch(color) {
            case "groc":
                System.out.println("corre!");
            break;
            case "vermell":
                System.out.println("espera");
            break;
            case "verd":
                System.out.println("passa");
            break;
            /* resposta si no es cap de les anteriors*/
            default:
                System.out.println("ves a l'oculista");
        }
    }
}
