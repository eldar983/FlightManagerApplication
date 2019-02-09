package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

/**
 * SystemManager klasa u kojoj se nalaze sve metode potrebne za rad System manager-a.
 * Metode za kreiranje Airline-a, Airport-a, Flight-a, Seat, kao i dodatne metode za provjeru 
 * ispunjavanja uslova pri kreiranju odredjenih objekata. 
 * @author Eldar Muminhodzic
 * @version 1.00
 */
public class SystemManager {
	/**
	 * Liste u koje ce se spremati kreirani objekti za Airport, Flights i Airlines
	 */
	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	
	/**
	 * Metoda za kreiranje Airport objekta koja prima parametar ime Aerodroma
	 * @param name - odnosi se na ime aerodroma koji zelimo kreirati
	 * @return - vraca kreiran Aerodrom sa datim imenom ukoliko se ispune svi uvjeti
	 * za kreiranje
	 */
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
	
	/**
	 * Metoda za kreiranje Airline objekta koja prima parametar ime Airline-a
	 * @param name - odnosi se na ime airline-a (aviokompanije) koji zelimo kreirati
	 * @return - vraca kreiran Airline sa datim imenom ukoliko se ispune svi uvjeti
	 * za kreiranje
	 */
	public Airline createAirline(String name) {
		// TODO implement
		if(isAirlineNameUnique(name) && verifyAirlineName(name)) {
			Airline airline = new Airline(name);
			listOfAirlines.add(airline);
			return airline;
		}else
		return null;
	}
	/**
	 * Metoda za kreiranje Flight objekta koja prima odredjene parametre.
	 * @param airline - aviokompanija koja obavlja let
	 * @param airport - aerodrom sa kojeg let polazi
	 * @param origin - mjesto odakle let polazi
	 * @param destination - destinacija na koju let treba stici
	 * @param id - jedinstveni broj leta
	 * @return - vraca kreiran Flight ukoliko se ispune svi dati uslovi za kreiranje
	 */
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
	
	/**
	 * Metoda za provjeru ID broja leta, tj da li vec postoji kreiran ID sa tim brojem,
	 * koji se koristi pri kreiranju leta (Flight)
	 * @param id - odnosi se na jedinstveni broj leta koji se provjerava 
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od parametra koji 
	 * se provjerava
	 */
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
	
	/**
	 * Metoda koja provjerava da li ima Airline kreiran koji ce se koristiti
	 * za kreiranje leta (Flight)
	 * @param airlineName - odnosi se na ime airline-a kojeg treba koristiti 
	 * pri kreiranju leta
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
 	 */
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
	
	/**
	 * Metoda koja provjerava da li ima Airport kreiran koji ce se koristiti
	 * za kreiranje leta (Flight)
	 * @param airportName - odnosi se na ime aerodroma koje se provjerava
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	/**
	 * Metoda koja se koristi za kreiranje sjedista za kreirani let.
	 * @param flightID - odnosi se na jedinstveni broj leta za koji se sjedista kreiraju
	 * @param numberOfSeatsPerRow - odnosi se na broj sjedista po redu
	 * @return - vraca listu sjedista koja su kreirana za odredjeni let
	 */
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
	
	/**
	 * Metoda koja provjerava da li je proslijedjen validan broj leta
	 * za kreiranje sjedista odredjenog leta
	 * @param id - odnosi se na jedinstveni broj leta
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	/**
	 * Metoda koja provjerava dostupne letove i sprema ih u listu
	 * @param origin - odnosi se na mjesto odakle let polazi
	 * @param destination - odnosi se na destinaciju na koju let treba stici
	 * @return - vraca listu dostupnih letova za unesene relacije
	 */
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
	
	/**
	 * Metoda za rezervisanje sjedista na letu
	 * @param flightID - odnosi se na jedinstveni broj leta
	 * @param seatNumber - broj sjedista koje se zeli rezervisati
	 * @param row - red u kojem se sjediste nalazi
	 * @return - vraca true ukoliko se ispune svi uvjeti
	 */
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
		return true;
	}
	
	/**
	 * Metoda koja se koristi za provjeru ispunjenja uslova koji se
	 * moraju ispostovati da bi ime aerodroma bilo uspjesno kreirano
	 * @param name - ime aerodroma
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	/**
	 * Metoda koja provjerava da li vec postoji kreiran aerodrom sa imenom koje se unosi 
	 * za novi aerodrom
	 * @param name - ime aerodroma koje se pokusava kreirati
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	/**
	 * Metoda koja provjerava uvjete koji se moraju ispuniti da bi se uspjesno
	 * kreirao objekat airline
	 * @param airlineName - ime airline-a koji se pokusava kreirati
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	/**
	 * Metoda koja provjerava da li vec postoji aviokompanija kreirana sa imenom
	 * koje se pokusava dodijeliti novom objektu airline
	 * @param airlineName - ime airline-a koje se dodijeljuje novom airline objektu
	 * @return - vraca boolean vrijednost (true ili false) u zavisnosti od rezultata provjere
	 */
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
	
	
	/**
	 * Getter za listu kreiranih aerodroma
	 * @return - vraca listu aerodroma
	 */
	public ArrayList<Airport> getListOfAirports() {
		return listOfAirports;
	}

	/**
	 * Getter za listu kreiranih letova
	 * @return - vraca listu kreiranih letova
	 */
	public ArrayList<Flight> getListOfFlights() {
		return listOfFlights;
	}

	/**
	 * Getter za listu kreiranih aviokompanija
	 * @return - vraca listu kreiranih aviokompanija
	 */
	public ArrayList<Airline> getListOfAirlines() {
		return listOfAirlines;
	}
}
