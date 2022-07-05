/*
 * Programa que mostra els nombres parells de l'1 al 10
 */
public class DeuPrimersNaturals {
    public static void main(String[] args) {
        for (int numero = 1; numero <= 10; numero = numero + 1) {
            if ((numero % 2) == 0){
                System.out.println(numero);
            }
        }
    }
}
