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
	
	public Flight createFlight(String airline, String airport, String origin, String destination, Integer id) {
		Flight flight = new Flight();
		if(isAirlineAvailableForFlight(airline) && isAirportAvailableForFlight(airport) && isFlightIdUnique(id)) {
			flight = new Flight(airline,airport, origin, destination, id);
			listOfFlights.add(flight);
			flight.setSeats(createSeats(id, 20));
			System.out.println("Success");


			return flight;
		}else {
			System.out.println("Nije moguce kreirati flight!");
		return null;
		}
	}
	
	public boolean isFlightIdUnique(Integer id) {
		boolean flightIdUnique = true;
		for(int i = 0; i < listOfFlights.size(); i++) {
			if(id == listOfFlights.get(i).getId().intValue()) {
				System.out.println("Broj leta (flight ID) vec postoji!");
				flightIdUnique = false;
			}else {
				flightIdUnique = true;
				
			}

		}
		return flightIdUnique;
	}
	
	public boolean isAirlineAvailableForFlight(String airlineName) {
		boolean isAirlineAvailable = false;
		for(int i = 0; i < listOfAirlines.size(); i++) {
			if(listOfAirlines.get(i).getName().equals(airlineName)){
				isAirlineAvailable = true;
				}else {
					System.out.println("Airline koji ste unijeli ne postoji!");
					return false;
				}
			}
		return isAirlineAvailable;
	}
	
	public boolean isAirportAvailableForFlight(String airportName) {
		boolean isAirportAvailable = false;
		for(int i = 0; i < listOfAirports.size(); i++) {
			if(listOfAirports.get(i).getName().equals(airportName)) {
				isAirportAvailable = true;
			}else {
				System.out.println("Airport koji ste unijeli ne postoji!");
				return false;
			}
		}
		return isAirportAvailable;
	}
	
	public ArrayList<Seat> createSeats(Integer flightID, Integer numberOfSeatsPerRow) {
		ArrayList<Seat> listOfSeats = new ArrayList<>();
		if(isFlightIdValidToCreateSeats(flightID)) {
			char row=64;
			for(int i=0; i<6; i++) {
				row++;
				for(int j=1; j<=numberOfSeatsPerRow; j++)
					listOfSeats.add(new Seat("" + row, j));
			}
		}
		return listOfSeats;
	}
	
	public boolean isFlightIdValidToCreateSeats(Integer id) {
		boolean flightIdValid = false;
		for(int i = 0; i < listOfFlights.size(); i++) {
			if(id == listOfFlights.get(i).getId().intValue()) {
				flightIdValid = true;
			}else {
				System.out.println("Broj leta (flight ID) nevazeci!");
				return false;
			}
		}
		return flightIdValid;
	}
	
	public List<Flight> findAvailableFlights(String origin, String destination){
		ArrayList<Flight> availableFlights = new ArrayList<Flight>();
		for(int i = 0; i < listOfFlights.size(); i++) {
			if(listOfFlights.get(i).getOrigin().equals(origin) && listOfFlights.get(i).getDestination().equals(destination) && listOfFlights.get(i).getSeats().get(i).isAvailable()) {
				availableFlights.add(listOfFlights.get(i));
			}
			System.out.println("No flights available!");
		}
		return availableFlights;
	}
	
	public boolean bookSeat(Integer flightID, int seatNumber, String row) {
		for (int i = 0; i < listOfFlights.size(); i++) {
		    if (listOfFlights.get(i).getId().intValue() == flightID) {
			for (int j = 0; j <listOfFlights.get(i).getSeats().size(); j++) {
			    if (seatNumber == listOfFlights.get(i).getSeats().get(j).getSeatNumber().intValue()
				    && row.equals(listOfFlights.get(i).getSeats().get(j).getRow())) {
				if (listOfFlights.get(i).getSeats().get(j).isAvailable()) {
				    listOfFlights.get(i).getSeats().get(j).setAvailable(false);
				    return true;
				} else {
				    System.out.println("Seat already booked");
				}
			    }
			}
		    }
		}		
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
