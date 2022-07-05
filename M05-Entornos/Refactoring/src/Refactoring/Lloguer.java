package Refactoring;

import java.util.ArrayList;
import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Lloguer(Date data, int dies, ArrayList<Vehicle> vehicles) {
		this.data=data;
		this.dies=dies;
		this.vehicles=vehicles;
	}
	public Lloguer(Date data, int dies, Vehicle vehicleBasic) {
		this.data=data;
		this.dies=dies;
		this.vehicles.add(vehicleBasic);
	}
	
	public int getDies() {
		return dies;
	}
	public void setDies(int dies) {
		this.dies = dies;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
