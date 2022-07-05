package refactoring2;

import java.util.Date;

public class Lloguer {
	private static final double DIES_DE_LLOGUER_BASIC = 3;
	private static final double DIES_DE_LLOGUER_GENERAL = 2;
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data=data;
		this.dies=dies;
		this.vehicle = vehicle;
	}

	public int getDies() {
		return dies;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public double quantitat() {
    	double quantitat = 0;
    	switch (this.getVehicle().getCategoria()) {
        case Vehicle.BASIC:
            quantitat += 3;
            if (this.getDies() > DIES_DE_LLOGUER_BASIC) {
                quantitat += (this.getDies() - DIES_DE_LLOGUER_BASIC) * 1.5;
            }
            break;
        case Vehicle.GENERAL:
            quantitat += 4;
            if (this.getDies() > DIES_DE_LLOGUER_GENERAL) {
                quantitat += (this.getDies() - DIES_DE_LLOGUER_GENERAL) * 2.5;
            }
            break;
        case Vehicle.LUXE:
            quantitat += this.getDies() * 6;
            break;
    	}
    	return quantitat;
    }
	public int bonificacions() {
    	int bonificacions = 0;
    	double quantitat = this.quantitat();
        
        // afegeix lloguers freqüents
        bonificacions ++;

        // afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
                this.getDies()>1 ) {
            bonificacions ++;
        }
        return bonificacions;
    }
}
