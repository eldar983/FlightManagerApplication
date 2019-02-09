package com.flight_manager;

/**
 * Klasa upravljanje Seat objektima
 * @author Eldar Muminhodzic
 * @version 1.00
 */
public class Seat {
	/**
	 * Polja podataka koje sadrzi Seat klasa
	 */
	/**
	 * Odnosi se na red u kojem se sjediste nalazi (A, B, C, D, E, F)
	 */
	// row ("A", "B", "C", "D", "E", "F")
	private String row;
	
	/**
	 * Odnosi se na broj sjedista u kreiranom letu
	 */
	// seat number ex. 1,5,16
	private Integer seatNumber;
	
	/**
	 * Odnosi se na status sjedista, da li je slobodno ili zauzeto
	 */
	//is it booked, or it is available
	private boolean available;
	
	/**
	 * Defaultni konstruktor Seat klase
	 */
	public Seat() {
		
	}
	
	/**
	 * Konstruktor Seat klase koji prima odredjene parametre
	 * @param row - odnosi se na red u kojem se sjediste nalazi
	 * @param seatNumber - odnosi se na broj sjedista
	 */
	public Seat(String row, Integer seatNumber) {
		this.row = row;
		this.seatNumber = seatNumber;
		this.available = true;
	}
	
	/**
	 * Getter za red u kojem se sjediste nalazi
	 * @return - vraca red kreiranog sjedista
	 */
	public String getRow() {
		return row;
	}
	/**
	 * Setter za red sjedista
	 * @param row - odnosi se na red koji treba podesiti pri kreiranju sjedista
	 */
	public void setRow(String row) {
		this.row = row;
	}
	/**
	 * Getter za broj kreiranog sjedista
	 * @return - vraca broj sjedista
	 */
	public Integer getSeatNumber() {
		return seatNumber;
	}
	/**
	 * Setter za broj sjedista
	 * @param seatNumber - odnosi se na broj sjedista koje se setuje
	 */
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * metoda kojom se provjerava dostupnost sjedista
	 * @return - vraca boolean vrijednost, da li je sjediste slobodno ili zauzeto
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * Setter za podesavanje dostupnosti sjedista
	 * @param available - odnosi se na dostupnost sjedista true ili false
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Metoda kojom se overrida toString metoda
	 */
	@Override
	public String toString() {
		return "Seat [row=" + row + ", seatNumber=" + seatNumber + ", available=" + available + "]";
	}
	
	
	

}
