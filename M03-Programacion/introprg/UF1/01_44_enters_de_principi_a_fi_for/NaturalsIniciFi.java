
/*
 * Programa que mostra els nombres del numero inicial al numero
 * final fent els salts amb el número que li indiquem
 * utilitzant el for
 */
public class NaturalsIniciFi {
    public static void main(String[] args) {
        System.out.println("Valor inicial?");
        int valorInicial = Integer.parseInt(Entrada.readLine());
        System.out.println("Valor final?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        System.out.println("Salt?");
        int salt = Integer.parseInt(Entrada.readLine());
        for (int numero = valorInicial; numero <= valorFinal; numero = numero + salt) {
            System.out.println(numero);
        }
    }
}
