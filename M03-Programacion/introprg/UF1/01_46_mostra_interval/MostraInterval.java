
/*
 * programa que demana dos valors enters i mostra tots els enters que hi ha entre el primer i el segon, 
 * en l’ordre marcat per l’entrada.
 */
public class MostraInterval {
    public static void main(String[] args) {
        System.out.println("inici?");
        int valorInicial = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        if (valorInicial <= valorFinal) {
            for (int numero = valorInicial; numero <= valorFinal; numero = numero + 1) {
                System.out.println(numero);
            }
        }
        else {
            for (int numero = valorInicial; numero >= valorFinal; numero = numero - 1) {
                System.out.println(numero);
            }
        }
    }
}
