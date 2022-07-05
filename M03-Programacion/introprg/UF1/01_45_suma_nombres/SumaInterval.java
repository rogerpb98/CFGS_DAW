
/*
 * Programa que mostra la suma de tots els numeros entre
 * el numero inicial i el numero final que li indiquem
 * utilitzant el for
 */
public class SumaInterval {
    public static void main(String[] args) {
        System.out.println("inici?");
        int valorInicial = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        int total = 0;
        if (valorInicial <= valorFinal) {
            for (int numero = valorInicial; numero <= valorFinal; numero = numero + 1) {
                total = total + numero;
            }
        }
        else {
            for (int numero = valorInicial; numero >= valorFinal; numero = numero - 1) {
                total = total + numero;
            }
        }
        System.out.println(total);
    }
}
