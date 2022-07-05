
/*
 * Programa que mostra els nombres parells que hi ha de l'1 al 10
 */
public class DeuPrimersParells {
    public static void main(String[] args) {
        int numero = 1;         // variable de recorregut assignada al primer valor
        while (numero <= 10) {  // condició de sortida en passar del darrer valor
            if (numero % 2 == 0){
                System.out.println(numero);
            }
            numero = numero + 1;    // passem el número al següent
        }
    }
}
