package com.flight_manager;

import java.util.ArrayList;

public class Flight {
	//unique ID
	private Integer id;
	
	//which airline owns this flight
	private String airline;
	
	//from which airport flight takes of
	private String airport;
	
	//all seats in this flight
	private ArrayList<Seat> seats;
	
	//city where it takes off from
	private String origin;
	
	//city where the flight is going
	private String destination;
	
	public Flight() {
		
	}
	
	public Flight(String airline, String airport, String origin, String destination, Integer id) {
		this.airline = airline;
		this.airport = airport;
		this.origin = origin;
		this.destination = destination;
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

//	public void setAirline(Airline airline) {
//		this.airline = airline;
//	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getAirport() {
		return airport;
	}

//	public void setAirport(Airport airport) {
//		this.airport = airport;
//	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", seats=" + seats + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}
	
	

}
