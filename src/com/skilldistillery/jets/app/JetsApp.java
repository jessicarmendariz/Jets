package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.JetsEntities;
import com.skilldistillery.jets.entities.JetImpl;
import com.skilldistillery.jets.entities.AirField;

import java.util.InputMismatchException;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JetsApp {

	private AirField airField;
	private Scanner input;
	
	public JetsApp() {
		this.airField = new AirField();
		this.input = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		JetsApp jetApp = new JetsApp();
		jetApp.launch();
	}
	
	private void launch() {
		List<JetsEntities> jets = airField.getJets();
		boolean quit = false;
		addInitialJets();
		do {
			
			displayMenu();
			int choice = 0;
			try {
				System.out.println("User Input: ");
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid Entry");
				input.nextLine();
			}
			switch (choice) {
			case 1:
				listFleet(jets);
				break;
			case 2:
				flyAllJets(jets);
				break;
			case 3:
				viewFastestJets(jets);
				break;
			case 4:
				viewMachSpeed(jets);
				break;
			case 5:
				viewJetsWithLongestRange(jets);
				break;
			case 6:
				loadAllCargoJets(jets);
				break;
			case 7:
				dogFight(jets);
				break;
			case 8:
				addJetToFleet();
				break;
			case 9:
				removeAJetFromFleet(jets);
				break;
			case 10:
				quit = true;
				System.out.println("Thanks for Flying with Us!");
				break;
			default:
				System.err.println("Invalid Entry. Please Choose from the Menu.");
			}
			
		} while (!quit);
		this.input.close();
	}
	
	private void displayMenu() {
		System.out.println("");
		System.out.println("|>>-->>-->>-->>-->>-- MENU --<<--<<--<<--<<--<<|");
		System.out.println("     1) List Fleet");
		System.out.println("     2) Fly All Jets");
		System.out.println("     3) View Fastest Jet");
		System.out.println("     4) View Fastest Jet in MACH SPEED");
		System.out.println("     5) View Jet with Longest Combat Range");
		System.out.println("     6) Load All Cargo Planes");
		System.out.println("     7) DOGFIGHT!");
		System.out.println("     8) Add Jet");
		System.out.println("     9) Remove Jet");
		System.out.println("     10) Quit");
		System.out.println("|>>-->>-->>-->>-->>-->>--<<--<<--<<--<<--<<--<<|");
		System.out.println("");
	}
	
	private void addInitialJets() {
		File f = new File("FightOrFlight.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] info = line.split("\t");
				if (line.charAt(0) == 'C') {
					airField.addJet(new CargoPlane(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]),
							Long.parseLong(info[3])));
				} else {
					airField.addJet(new FighterJet(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]),
							Long.parseLong(info[3])));
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void listFleet(List<JetsEntities> jets) {
		System.out.println("Current Fleet");
		for (JetsEntities jet : jets) {
			System.out.println(jet);
		}
	}
	
	private void flyAllJets(List<JetsEntities> jets) {
		System.out.println("How Long Can They Fly?");
		for (JetsEntities jet : jets) {
			jet.fly();
		}
	}
	
	private void viewFastestJets(List<JetsEntities> jets) {
		double speed = Double.MIN_VALUE;
		for(JetsEntities jet : jets) {
			if (jet.getSpeed() > speed) {
				speed = jet.getSpeed();
			}
		}
		for (JetsEntities jet : jets) {
			if (jet.getSpeed() == speed) {
				System.out.println(jet.getModel() + " has a speed of " + jet.getSpeed() + "MPH");
			}
		}
	}
	
	private void viewMachSpeed(List<JetsEntities> jets) {
		double machSpeed = Double.MIN_VALUE;
		for(JetsEntities jet : jets) {
			if (jet.getMachSpeed() > machSpeed) {
				machSpeed = jet.getMachSpeed();
			}
		}
		for (JetsEntities jet : jets) {
			if (jet.getMachSpeed() == machSpeed) {
				System.out.println(jet.getModel() + " has a mach speed of " + jet.getMachSpeed() + "M");
			}
		}
	}
	
	
	private void viewJetsWithLongestRange(List<JetsEntities> jets) {
		double range = Integer.MIN_VALUE;
		for (JetsEntities jet : jets) {
			if (jet.getRange() > range) {
				range = jet.getRange();
			}
		}
		for (JetsEntities jet : jets) {
			if (jet.getRange() == range) {
		System.out.println(jet.getModel() + " with the Combat Range of " + jet.getRange() + " miles.");
	}
		}
			}

	
	private void loadAllCargoJets(List<JetsEntities> jets) {
		for (JetsEntities jet : jets) {
			if (jet.getClass().getSimpleName().equals("CargoPlane")) {
				CargoPlane cargo = (CargoPlane) jet;
				cargo.loadCargo();
			}
		}
	}
	
	private void dogFight(List<JetsEntities> jets) {
		System.out.println("Jets Entering Simulation");
		for (JetsEntities jet : jets) {
			if (jet.getClass().getSimpleName().equals("FighterJet")) {
				FighterJet fighter = (FighterJet) jet;
				fighter.fight();
			}
		}
	}
	
	private void addJetToFleet() {
		System.out.println("Model: ");
		String model = input.next();
		System.out.println("Speed (in MPH): ");
		double speed = input.nextDouble();
		System.out.println("Range (in Miles): ");
		int range = input.nextInt();
		System.out.println("Price: ");
		long price = input.nextLong();
		String type = new StringBuilder(model).substring(0, 2).toString().toUpperCase();
		if (type.equals("C-")) {
			airField.addJet(new CargoPlane(model, speed, range, price));
		} else if (type.equals("F-") || type.equals("A-")) {
			airField.addJet(new FighterJet (model, speed, range, price));
		} else {
			airField.addJet(new JetImpl(model, speed, range, price));
		}
	}
	
	private void removeAJetFromFleet(List<JetsEntities> jets) {
		int userChoice = 0;
		System.out.println("Which Jet Would You Like to Remove?");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ") " + jets.get(i).getModel());
		}
		while (true) {
			System.out.print("User Input: ");
			try {
				userChoice = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid Entry");
				input.nextLine();
			}
			if (userChoice > 0 && userChoice <= jets.size()) {
				jets.remove(userChoice - 1);
				break;
			} else {
				System.out.println("Please Choose a Number from the List.");
			}
		}
	}
	
	
}
