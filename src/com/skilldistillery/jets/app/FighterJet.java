package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.*;

public class FighterJet extends JetsEntities {
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fight() {
		System.out.println(super.getModel() + " FOX2, Fight's On!");
	}
}
