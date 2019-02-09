package com.flight_manager;

import java.util.ArrayList;

/**
 * Klasa Flight objekta
 * @author Eldar Muminhodzic
 * @version 1.00
 */
public class Flight {
	/**
	 * Polja klase koje objekat sadrzi
	 */
	/**
	 * ID leta, gdje svaki let ima svoj unikatni broj leta
	 */
	//unique ID
	private Integer id;
	
	/**
	 * Odnosi se na avio kompaniju koja odradjuje let
	 */
	//which airline owns this flight
	private String airline;
	
	/**
	 * Odnosi se na aerodrom sa kojeg let polazi
	 */
	//from which airport flight takes of
	private String airport;
	
	/**
	 * Lista koja sadrzi sva sjedista za odredjeni let
	 */
	//all seats in this flight
	private ArrayList<Seat> seats;
	
	/**
	 * Odnosi se na mjesto odakle let polazi
	 */
	//city where it takes off from
	private String origin;
	
	/**
	 * Odnosi se na destinaciju leta
	 */
	//city where the flight is going
	private String destination;
	
	/**
	 * Defaultni konstruktor
	 */
	public Flight() {
		
	}
	
	/**
	 * Konstruktor za kreiranje leta koji prima parametre
	 * @param airline - odnosi se na ime avio kompanije sa kojom se leti
	 * @param airport - odnosi se na aerodrom sa kojeg se leti
	 * @param origin - odnosi se na mjesto odakle let polazi
	 * @param destination - odnosi se na mjesto gdje let treba da stigne
	 * @param id - odnosi se na jedinstveni broj leta. 
	 */
	public Flight(String airline, String airport, String origin, String destination, Integer id) {
		this.airline = airline;
		this.airport = airport;
		this.origin = origin;
		this.destination = destination;
		this.id = id;
		
	}

	/**
	 * Getter za unikatni ID leta
	 * @return - vraca jedinstveni broj leta
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter za jedinstveni broj leta
	 * @param id - odnosi se na jedinstveni broj leta koji se podesava
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter za airline sa kojom let treba biti izvrsen
	 * @return - vraca ime avio kompanije sa kojom se kreira let
	 */
	public String getAirline() {
		return airline;
	}

//	public void setAirline(Airline airline) {
//		this.airline = airline;
//	}

	/**
	 * Getter za listu sjedista kreiranih za odredjeni let
	 * @return - vraca kreirana sjedista za odredjeni let
	 */
	public ArrayList<Seat> getSeats() {
		return seats;
	}

	/**
	 * Setter za dodavanje sjedista na odredjeni let
	 * @param seats - odnosi se na kreirana sjedista
	 */
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	/**
	 * Getter za mjesto polaska
	 * @return - vraca ime lokacije sa koje let polazi
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Setter za mjesto polaska
	 * @param origin - odnosi se na mjesto odakle let polazi
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Getter za mjesto na koje let treba da stigne
	 * @return - vraca ime destinacije na koju let treba stici
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Setter za mjesto na koje let treba da stigne
	 * @param destination - odnosi se na destinaciju koja se setuje
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Geeter za aerodrom sa kojeg se polazi
	 * @return - vraca ime aerodroma sa kojeg let polazi
	 */
	public String getAirport() {
		return airport;
	}

//	public void setAirport(Airport airport) {
//		this.airport = airport;
//	}

	/**
	 * Metoda kojom se overrida toString metoda
	 */
	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", seats=" + seats + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}
	
	

}
