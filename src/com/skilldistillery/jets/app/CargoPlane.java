package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.*;

public class CargoPlane extends JetsEntities{
	public CargoPlane (String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void loadCargo() {
		System.out.println(super.getModel() + " is prepared to accept Paratroopers! Airborne!");
				
}
}