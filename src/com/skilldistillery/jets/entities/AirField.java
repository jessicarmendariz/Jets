package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<JetsEntities> jets;
	
	public AirField() {
		this.jets = new ArrayList<JetsEntities>();
	}
	
	public void addJet(JetsEntities jet) {
		this.jets.add(jet);
	}
	
	public List<JetsEntities> getJets() {
		return jets;
	}
	
	public void setJets(List<JetsEntities> jets) {
		this.jets = jets;
	}
}
