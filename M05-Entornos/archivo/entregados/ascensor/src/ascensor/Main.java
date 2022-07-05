package ascensor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Problema 1
		// Caso de uso 1
		/* 
		Ascensor a1, a2;
		a1 = new Ascensor(0,10);
		a2 = a1;
		a1.ir(6);
		a2.bajar();
		a1 = new Ascensor(-1, a1.getMax()/2);
		
		a1.ir(a2.getPiso());
		a1.subir();
		a2.bajar();
		System.out.println("El ascensor 1 está en el piso: " + a1.getPiso());
		System.out.println("El ascensor 2 está en el piso: " + a2.getPiso());
		*/
		
		//Caso de uso 2
		/*
		Ascensor a1, a2, a3;
		a1 = new Ascensor(10,20);
		a3 = a1;
		a2 = new Ascensor(a3.getPiso()/2, a1.getMin());
		a3.subir();
		a2.ir(a1.getPiso());
		a3 = a2;
		a2 = new Ascensor(a3.getMin()-1, a2.getMax());
		System.out.println(a1.getPiso()+a2.getPiso()+a3.getPiso());
		*/
		
		//Problema 3
		//Caso de uso 1
		/*
		Ascensor asc1, asc2;
		int veces;
		asc1 = new Ascensor(0, 4);
		asc2 = new Ascensor(-2, 7);
		asc1.ir(2);
		asc2.ir(asc1.getPiso()+2);
		veces = 0;
		while (veces < 5) {
			asc1.subir();
			asc2.bajar();
			veces++;
		}
		System.out.println("El ascensor 1 está en el piso: " + asc1.getPiso());
		System.out.println("El ascensor 2 está en el piso: " + asc2.getPiso());
		*/
		
		//Caso de uso 2
		/*
		Ascensor asc1, asc2, asc3;
		int veces;
		asc1 = new Ascensor(0, 19);
		asc2 = new Ascensor(-4, 4);
		asc3 = new Ascensor(-2, 10);
		asc1.ir(5);
		asc2.ir(asc1.getPiso()-10);
		asc3.ir(asc1.getPiso()+asc2.getPiso());
		
		while (asc1.getPiso()>0) {
			asc1.bajar();
			asc2.bajar();
			asc3.bajar();
		}
		
		System.out.print("Primer ascensor: ");
		escribirPiso(asc1.getPiso());
		System.out.print("Primer ascensor: ");
		escribirPiso(asc2.getPiso());
		System.out.print("Primer ascensor: ");
		escribirPiso(asc3.getPiso());
		*/
		
		//Caso de uso 3
		/*
		Ascensor a1;
		a1 = new Ascensor(10, 30);
		a1.ir(28);
		for(int inicio=0; inicio<15; inicio++) {
			a1.bajar();
		}
		System.out.print("El ascensor esta en: " + a1.getPiso());
		*/
		
		//Caso de uso 4
		Ascensor a1;
		Ascensor a2;
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Indica el piso menor de a1: ");
		int min=reader.nextInt();
		
		System.out.print("Indica el piso mayor de a1: ");
		int max=reader.nextInt();
		a1 = new Ascensor(min, max);
		a1.ir(max/2);
		
		
		a2 = new Ascensor((max/2), max);
		for(int inicio=(a2.getPiso()); inicio<max; inicio++) {
			a1.subir();
		}
		
		System.out.println("Primer ascensor; Min: " + min + "; Max: " + max);
		System.out.println(a1.getPiso());
		System.out.println("Segundo ascensor; Min: " + max/2 + "; Max: " + max);
	}
	
	public static void escribirPiso(int piso) {
		if (piso < 0) {
			System.out.println("se encuentra en el subterraneo " + piso);
		}
		else if (piso > 0) {
			System.out.println("se encuentra en la planta " + piso);
		}
		else {
			System.out.println("se encuentra en la planta baja");
		}
	}
}
