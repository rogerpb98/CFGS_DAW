package cuentacorriente;

public class CuentaCorriente {
	//Atributos
	private String titular;			//Numero del titular de la cuenta
	private int numero;				//Numero de la cuenta
	private double saldo;			//Cantidad de euros en la cuenta
	private double limiteCredito;	//Maximo saldo negativo permitido
	
	/* Constructor */
	public CuentaCorriente(String titular, int numero, double saldo, double limiteCredito) {
		this.titular		= titular;
		this.numero			= numero;
		this.saldo			= saldo;			//this no necesario
		this.limiteCredito	= limiteCredito;	//this no necesario
	}
	
	public CuentaCorriente() {
		this.titular		= "";
		this.numero			= 0;
		this.saldo			= 0;
		this.limiteCredito	= 0;
	}
	
	// Metodos de acceso. En los 4 casos this no es necesario
	// No hay posibilidad de conflicto
	//metodos getters and setters     
	public String getTitular() {         
		return titular;     
		}       
	public void setTitular(String titular) {         
		this.titular = titular;     
		}       
	public int getNumero() {         
		return numero;     
		}       
	public void setNumero(int numero) {         
		this.numero = numero;     
		}       
	public double getSaldo() {         
		return saldo;     
		}       
	public void setSaldo(double saldo) {         
		this.saldo = saldo;     
		}       
	public double getLimiteCredito() {         
		return limiteCredito;     
		}
	
	public void setLimitCredit (double limiteCredito) {
		if (limiteCredito>=0) {
			this.limiteCredito = limiteCredito;		//this necesario
		}
	}
	
	public void ingresar (double cuanto) {
		if (cuanto>0) {
			this.saldo = this.saldo + cuanto;		//this no necesario
		}
	}
	
	public boolean retirar (double cuanto) {
		double saldo;
		boolean ok;
		if (cuanto > 0) {
			saldo = this.saldo - cuanto; //this necesario
			if (saldo<0) {
				if (this.valAbs(saldo) <= this.limiteCredito) {
					//this no es necesario
					ok = true;
					this.saldo = saldo; //this necesario
				}
				else {
					ok = false;
				}
			}
			else {
				ok = true;
				this.saldo = saldo; //this necesario
			}
		}
		else {
			ok = false;
		}
		return ok;
	}
	private double valAbs (double n) {
		if (n>=0.0) {
			return n;
		}
		else {
			return -n;
		}
	}
}
