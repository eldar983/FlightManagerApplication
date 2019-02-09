package com.flight_manager;
/**
 * Klasa za Airport objekat
 * @author Eldar Muminhodzic
 * @version 1.00
 */
public class Airport {
	/**
	 * Polje airport klase tipa String i odnosi se na ime airporta
	 */
	private String name;
	
	/**
	 * Defaultni konstruktor
	 */
	public Airport() {
		
	}
	/**
	 * Airport konstruktor koji prima parametar name tipa String
	 * @param name - odnosi se na ime Airporta
	 */
	public Airport(String name) {
		this.name = name;
	}

	/**
	 * Getter za ime kreiranog airport objekta
	 * @return - vraca ime airport objekta
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter za ime objekta tipa Airport
	 * @param name - ime airport-a
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metoda za overridanje toString metode
	 */
	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}
}
