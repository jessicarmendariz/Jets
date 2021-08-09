package com.skilldistillery.jets.entities;

public abstract class JetsEntities {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public JetsEntities(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		
	}
	
	public void fly() {
		System.out.println(this.model + " has a maximum speed of " + this.speed + " and a combat range of " + this.range + " can fly for " + (Math.round((this.range/this.speed) * 10) / 10.0) + " hours at a time.");
	}
	
	public double getMachSpeed() {
		return this.speed / 767.2;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ",range=" + range + ", price=" + price + "]";
	}

}
