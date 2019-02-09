package com.flight_manager;
/**
 * Airline klasa za kreiranje Airline objekta sa getterima i setterima za name field
 * @author Eldar Muminhodzic
 * @version 1.00
 */
public class Airline {
	/**
	 * polje klase tipa String
	 */
	private String name;
	/**
	 * Default constructor
	 */
	public Airline() {
		
	}
	/**
	 * Kontstruktor za Airline objekat koji prima parametar tipa String
	 * @param name - parametar koji se koristi za kreiranje Airline objekta (Ime Airline-a)
	 */
	public Airline(String name) {
		this.name = name;
	}

	/**
	 * Getter za ime airline-a
	 * @return - vraca ime airline-a tipa String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter za ime airline-a
	 * @param name - setuje ime Airline-a
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metoda za overridanje toString metode
	 */
	@Override
	public String toString() {
		return "Airline [name=" + name + "]";
	}
	
	

}
