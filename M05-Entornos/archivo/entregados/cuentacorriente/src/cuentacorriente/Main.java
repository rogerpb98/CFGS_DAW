package cuentacorriente;

import java.util.Random;

public class Main {

	
	
	public static void main(String[] args) {
		/*
		CuentaCorriente c1 = new CuentaCorriente("Pepe", 100, 500, 100);
		CuentaCorriente c2 = new CuentaCorriente("Jose", 200, 1000, 100);
		System.out.println(igualaSaldo(c1, c2));
		*/
		
		// EJERCICIO 7
		/*
		CuentaCorriente c1 = new CuentaCorriente("Maria", 1111, 1000, 0);
		CuentaCorriente c2 = new CuentaCorriente("Jose", 2222, 500, 0);
		CuentaCorriente c3 = new CuentaCorriente("Jesus", 3333, 250, 0);
		
		
		if (igualaSaldo(c1,c2)) { //igualaSaldo retorna boolean
			System.out.print("Las cuentas c1 y c2 se han igualado");
		}
		else {
			System.out.print("Las cuentas c1 y c2 no se han igualado");
		}
		
		if (igualaSaldo(c2,c3)) { //igualaSaldo retorna boolean
			System.out.print("Las cuentas c2 y c3 se han igualado");
		}
		else {
			System.out.print("Las cuentas c2 y c3 no se han igualado");
		}
		
		if (mismo_saldo(c1, c2, c3)) {
			System.out.print("c1 c2 y c3 tienen el mismo saldo");
		}
		else {
			System.out.print("c1 c2 y c3 no tienen el mismo saldo");
		}*/
		
		//EJERCICIO 8
		CuentaCorriente c1 = new CuentaCorriente("Juana", 1001, 0, 0);
		CuentaCorriente c2 = new CuentaCorriente("Maria", 1002, 0, 0);
		CuentaCorriente c3 = new CuentaCorriente("Raquel", 1003, 0, 0);
		
		c1.setSaldo(aleaJactaEst(100,200));
		c2.setSaldo(aleaJactaEst(100,200));
		c3.setSaldo(aleaJactaEst(100,200));
		
		CuentaCorriente afortunada = rollTheDice(c1,c2,c3);
		CuentaCorriente malaPata = rollTheDice(c1,c2,c3);
		
		darIntereses(afortunada,10);
		if(malaPata.retirar(150))
			System.out.print("No se pudo retirar");
	}
	

	public static int aleaJactaEst (int min, int max) {
		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
		//nextInt(10)-->numero aleatorio entre 0 y 9
	}
	
	public static CuentaCorriente rollTheDice (CuentaCorriente c1, CuentaCorriente c2, CuentaCorriente c3) {
		CuentaCorriente c;
		int num = aleaJactaEst(1,3);
		if (num==1)
			c=c1;
		else if (num==2)
			c=c2;
		else
			c=c3;
		return c;
	}
	
	public static void darIntereses(CuentaCorriente c, int n) {
		double saldo = c.getSaldo();
		saldo = saldo + saldo*n/100;
		c.setSaldo(saldo);
	}
	

	
	public static boolean mismo_saldo(CuentaCorriente c1, CuentaCorriente c2, CuentaCorriente c3) {
		boolean mismo = false;
		if (c1.getSaldo()==c2.getSaldo() && c1.getSaldo()==c3.getSaldo()) {
			mismo=true;
		}
		return mismo;
	}
	
	public static boolean igualaSaldo(CuentaCorriente c1, CuentaCorriente c2, CuentaCorriente c3) {
		double s1 = c1.getSaldo();
		double s2 = c2.getSaldo();
		double s3 = c3.getSaldo();
		boolean mismo = false;
		
		if (s1 == s2 && s2 == s3) {
			mismo = true;
		}
		return mismo;
	}
	
	public static boolean igualaSaldo(CuentaCorriente c1, CuentaCorriente c2) {
		double s1 = c1.getSaldo();
		double s2 = c2.getSaldo();
		boolean es_posible;
		double dinero_a_sacar = 0;
		
		if (s1 > s2) {
			dinero_a_sacar = s1-(s1+s2)/2;
			es_posible = c1.retirar(dinero_a_sacar);
			if (es_posible) c2.ingresar(dinero_a_sacar);
		}
		else {
			dinero_a_sacar = s2-(s1+s2)/2;
			es_posible = c2.retirar(dinero_a_sacar);
			if (es_posible) c1.ingresar(dinero_a_sacar);
		}
		return es_posible;
	}

}
