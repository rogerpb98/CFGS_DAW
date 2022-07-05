
/*
 * Programa que demana un mes, un any i escriu el mes anterior i el mes següent
 */
public class MesosAnys {
    public static void main(String[] args) {
    
        /*Declara las variables i demana un valor per consola*/
        System.out.println("Mes?");
        int mes = Integer.parseInt(Entrada.readLine());
        System.out.println("Any?");
        int any = Integer.parseInt(Entrada.readLine());
        
        /*Si es gener, pasa a desembre i resta un any per l'anterior i suma un mes per el posterior.*/
        switch(mes) {
            /*Si es gener, pasa a desembre i resta un any per l'anterior i suma un mes per el posterior.*/
            case 1:
                System.out.println("Anterior " + (mes + 11) + "/" + (any - 1) + " i posterior " + (mes + 1) + "/" + any + "");
            break;
            /*Si es decembr resta un mes per l'anterior, suma un any i torna a gener per el posterior.*/
            case 12:
                System.out.println("Anterior " + (mes - 1) + "/" + (any) + " i posterior " + (mes - 11) + "/" + (any + 1) + "");
            break;
            /*Resposta per la resta de messos, suma un mes al posterior i resta un mes a l'anterior*/
            default:
                System.out.println("Anterior " + (mes - 1) + "/" + (any) + " i posterior " + (mes + 1) + "/" + (any) + "");
        }
    }
}
