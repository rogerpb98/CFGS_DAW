package ascensor;

public class Ascensor {
		
	private int max;
	private int min;
	private int piso;
	
	public void subir() {
		if (piso < max) {
			piso++;
		}
	}
	
	public void bajar() {
		if (piso > min) {
			piso--;
		}
	}
	
	public void ir(int objetivo) {
		if (objetivo >= min && objetivo <= max) {
			piso=objetivo;
		}
	}
	
	//Default constructor
	public Ascensor(int min, int max) {
		super();
		this.max = max;
		this.min = min;
		this.piso = min;
	}
	//Getters / Setters
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
}
