package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	
	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	
	public Airport createAirport(String name) {
		// TODO Implement
		if(isAirportNameUnique(name) && verifyAirportName(name)) {
			Airport airport = new Airport(name);
			listOfAirports.add(airport);
			return airport;
		}else {
		}
		return null;
	}
	
	public Airline createAirline(String name) {
		// TODO implement
		if(isAirlineNameUnique(name) && verifyAirlineName(name)) {
			Airline airline = new Airline(name);
			listOfAirlines.add(airline);
			return airline;
		}else
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
	
	public boolean isAirportNameUnique(String name) {
		boolean uniqueName = true;
		for(int i = 0; i < listOfAirports.size(); i++) {
			if(listOfAirports.get(i).getName().equals(name)) {
				System.out.println("Ime koje ste unijeli vec postoji!");
				uniqueName = false;
			}else {
				uniqueName = true;
			}
		}
		return uniqueName;
	}
	
	public boolean verifyAirlineName(String airlineName){
		boolean validName = false;
		if(airlineName.length() == 0)
			return false;
		for(int i = 0; i < airlineName.length(); i++) {
			char ch = airlineName.charAt(i);
			if(Character.isLetter(ch) && airlineName.length() < 6) {
				validName = true;
			}else {
				System.out.println("Ime za Airline mora sadrzavati manje od 6 slova!");
				return false;
			}
		}
		return validName;
	}
	
	public boolean isAirlineNameUnique(String airlineName) {
		boolean uniqueAirlineName = true;
		for(int i = 0; i < listOfAirlines.size(); i++) {
			if(listOfAirlines.get(i).getName().equals(airlineName)) {
				System.out.println("Ime koje ste unijeli vec postoji!");
				uniqueAirlineName = false;
			}else {
				uniqueAirlineName = true;
			}
		}
		return uniqueAirlineName;
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
