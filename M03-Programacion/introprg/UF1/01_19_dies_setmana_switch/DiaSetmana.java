/*
 * Programa que demana un numero per consola i et respon el dia de la setmana corresponent. 
 */
public class DiaSetmana {
    public static void main(String[] args) {
    
        /*Declara la variable*/
        int numero = Integer.parseInt(args[0]);
        /*Entra a la opció que li haguem donat*/
        switch(numero) {
            case 1:
                System.out.println("Dilluns");
            break;
            case 2:
                System.out.println("Dimarts");
            break;
            case 3:
                System.out.println("Dimecres");
            break;
            case 4:
                System.out.println("Dijous");
            break;
            case 5:
                System.out.println("Divendres");
            break;
            case 6:
                System.out.println("Dissabte");
            break;
            case 7:
                System.out.println("Diumenge");
            break;
            /* resposta si no es cap de les anteriors*/
            default:
                System.out.println("Error");
        }
    }
}
