/*
 * Programa que por arribar a sumar fins a 3 nombres metres que siguin positius 
 * (en el moment en el que un sigui negatiu, pararà de demanar números
 */ 
public class SumaPositius {
    public static void main(String[] args) {

        // creem la variable on guardarem el resultat de sumar
        int suma = 0;   // inicialment no hem sumat res i per tant és 0

        // demanem valors

        // declarem la variable que contindrà els valors llegits
        int valor;

        // processem el primer valor
        System.out.println("Introdueix el primer valor");
        valor = Integer.parseInt(Entrada.readLine());
        if (valor >= 0) {
            suma = suma + valor;
	    // processem el segon valor
            System.out.println("Introdueix el segon valor");
            valor = Integer.parseInt(Entrada.readLine());
            if (valor >= 0) {
                suma = suma + valor;
		// processem el tercer valor
                System.out.println("Introdueix el segon valor");
                valor = Integer.parseInt(Entrada.readLine());
                if (valor >= 0) {
                    suma = suma + valor;
                }
            }
        }

        // mostrem el resultat
        System.out.println("La suma és " + suma);
    }
}

