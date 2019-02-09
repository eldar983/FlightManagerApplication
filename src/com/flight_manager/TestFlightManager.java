package com.flight_manager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestFlightManager {
	static Scanner input = new Scanner (System.in);


	public static void main(String[] args) throws Exception {
		// TODO create UI

		menu();

	}
	
	public static void menu() throws Exception {
		SystemManager manager = new SystemManager();

		
		System.out.println("Welcome to Flight Manager Aplication");
		System.out.println("Choose an option: " + 
	"\n**************************" +
	"\n 1.Create airport" + 
	"\n 2.Create airline" + 
	"\n 3.Create flight" + 
	"\n 4.Book a seat on a flight" +
	"\n 5.Exit");
		System.out.println("**************************");
		
		/**
		 * Kroz while petlju odrediti da li je validan unos korisnika za ponudjene opcije
		 * ukoliko nije validan unos ispisati poruku korisniku da unese odgovarajuci broj
		 */
		int korisnikovUnos = reTry();
		while(korisnikovUnos < 1 || korisnikovUnos > 5) {
			System.out.println("Unesite validan broj (1 - 5): ");
			korisnikovUnos = reTry();
		}
		/**
		 * Kroz switch selekciju izvrsiti potrebne radnje u zavisnosti od toga koju opciju korisnik unese
		 */
		switch(korisnikovUnos) {
		case 1: 
			System.out.println("Enter airport name (has to be exactly 3 letters long: ");
			String name = input.next();
			manager.createAirport(name); break;
		case 2:
			System.out.println("Enter airline name (name cannot be longer than 5 characters): ");
			name = input.next();
			manager.createAirline(name); break;
		case 3:
			System.out.println("Welcome to create flight option: ");
			System.out.println("Enter airline name: ");
			String airlineName = input.next();
			System.out.println("Enter airport name: ");
			String airportName = input.next();
			System.out.println("Enter flight origin: ");
			String origin = input.next();
			System.out.println("Enter flight destination: ");
			String destination = input.next();
			System.out.println("Enter flight ID: ");
			int id = reTry();
			//manager.getListOfFlights().add(new Flight(airlineName,airportName,origin,destination,id));
			manager.createFlight(airlineName, airportName, origin, destination, id); break;
		case 4: 
			System.out.println("Enter flight ID: ");
			id = reTry();
			System.out.println("Enter seat number: ");
			int seatNumber = reTry();
			System.out.println("Enter row letter (A B C D E F): ");
			String row = input.next();
			manager.bookSeat(id, seatNumber, row); break;
		case 5:
		System.out.println("Izabrali ste izlaz iz aplikacije.\nHvala na povjerenju!\nDodjite nam ponovo.");
		System.exit(korisnikovUnos);					
		}
		menu();
	}		

/**
 * Metoda koja zahtjeva unos integer tip podatka i hvata InputMismatchException u slucaju da korisnik unese drugaciji tip podatka
 * @return ispisuje poruku kojom se naglasava da unos treba biti tipa integer te vraca ponovo poziv metode
 */
public static int reTry() {
	 try {
	     return input.nextInt();
	 } catch (InputMismatchException ex) {
	     input.nextLine(); //Ova linija prebacuje kursor na sljedecu liniju
	     System.out.println("Unos treba biti tipa integer, pokusajte ponovo:");
	     return reTry();
	 }
}

}
