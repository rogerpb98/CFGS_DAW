
/*
 * Programa que mostra els nombres parells que hi ha de l'1 al 10
 */
public class EntersIniciFi {
    public static void main(String[] args) {
        System.out.println("Valor inicial?");
        int valorInicial = Integer.parseInt(Entrada.readLine());
        System.out.println("Valor final?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        System.out.println("Salt?");
        int salt = Integer.parseInt(Entrada.readLine());
        while (valorInicial <= valorFinal) {
            if (! (valorInicial > valorFinal)) {
                System.out.println(valorInicial);
                valorInicial = valorInicial + salt;
            }
        }
    }
}
