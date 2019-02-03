package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	
	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	
	public Airport createAirport(String name) {
		// TODO Implement
		return null;
	}
	
	public Airline createAirline(String name) {
		// TODO implement
		return null;
	}
	
	public Flight createFlight(String name,String origin, String destination, Integer id) {
		// TODO implement
		return null;
	}
	
	public void createSeats(String airline,Integer flightID, Integer numberOfSeatsPerRow) {
		// TODO implement
	}
	
	public List<Flight> findAvailableFlights(String origin, String destination){
		// TODO implement
		return null;
	}
	
	public boolean bookSeat(String airline, String flightName,int seatNumber,String row) {
		// TODO implement
		
		return false;
	}
	
	public boolean verifyAirportName(String name) {
		boolean validName = false;
		for(int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if(Character.isLetter(ch) && name.length() == 3) {
				validName = true;
			}else {
				System.out.println("Ime mora imati tacno 3 slova!");
				return false;
			}
		}
		return validName;
	}
	
	
	public ArrayList<Airport> getListOfAirports() {
		return listOfAirports;
	}

	public ArrayList<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public ArrayList<Airline> getListOfAirlines() {
		return listOfAirlines;
	}
}
