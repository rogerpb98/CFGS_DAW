package Practica4;

import java.io.*;

class CalculoFactorial {
	public static void main(String[] args) throws IOException {
		int numero = pedirNumero();
		int factorial = calcularFactorial(numero);
		
		System.out.println(factorial);
	}
	public static int pedirNumero() throws IOException {
		//Instanciar un buffer de lectura
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Entra número ");
		//Leer entrada
		int numero = Integer.parseInt(reader.readLine());
		//Forzar numero positivo
		while(numero<=0){
			System.out.println("Error");
			System.out.print("Entra: ");
			numero = Integer.parseInt(reader.readLine());
		}
		return numero;
	}
	public static int calcularFactorial(int numero) {
		int factorial=1;
		int i=1;
		while(i<=numero){
			factorial=factorial*i;
			i++;
		}
		return factorial;
	}
}
/*
 * Responeu aquestes preguntes:

    És llegible?
    no
    És un codi net?
    no
    Sabeu que fa?
    Et fa introduir un nombre fins que el nombre introduit es positiu.
	Després calcula el factorial d'aquest
    Valoreu quins elements us ajuden o dificulten l'entesa del codi:
        Variables - Dificulten lectura
        Format - Dificulta lectura
        Estructures de control - Ajuda a entendre
        Comentaris - No hi habia cap
 *
 */