package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.SystemManager;
import com.flight_manager.*;

public class SystemManagerTest {

	SystemManager test;
	
	@Before
	public void setUp() {
		test = new SystemManager();
	}
	@Test
	public void shouldReturnTrueIfAirportNameIsExactly3Letters() {
		assertTrue(test.verifyAirportName("ABC"));
	}
	@Test
	public void shouldReturnFalseIfAirportNameIsLessThan3Letters() {
		assertFalse(test.verifyAirportName("AB"));
	}
	@Test
	public void shouldReturnFalseIfAirportNameIsMoreThan3Letters() {
		assertFalse(test.verifyAirportName("ABCD"));
	}
	@Test
	public void shouldReturnFalseIfAirportNameContainsCharsOtherThanLetters() {
		assertFalse(test.verifyAirportName("A2B"));
	}
	
	@Test
	public void shouldReturnTrueIfAirportNameDoesNotExistsAlready() {
		test.getListOfAirports().add(new Airport("DXB"));
		assertTrue(test.isAirportNameUnique("TUZ"));	
	}
	
	@Test
	public void shouldReturnFalseIfAirportNameAlreadyExists() {
		test.getListOfAirports().add(new Airport("DXB"));
		assertFalse(test.isAirportNameUnique("DXB"));
	}
	@Test
	public void shouldCreateCreateAirportObjectWhenAllConditionsAreMet() {
		assertNotNull(test.createAirport("TUZ"));
	}
	@Test
	public void shouldFailCreatingAirportObjectWhenNameVerificationFails() {
		assertNull(test.createAirport("T2Z"));
	}
	@Test
	public void shouldFailCreatingAirportObjectWhenObjectAlreadyExists() {
		test.getListOfAirports().add(new Airport("TUZ"));
		assertNull(test.createAirport("TUZ"));
	}
	
	@Test
	public void shouldReturnTrueIfAllConditionsAreMetWhenCreatingAirlineName() {
		assertTrue(test.verifyAirlineName("FlyBH"));
	}
	
	@Test
	public void shouldReturnFalseIfMoreThan5CharsWhenCreatingAirlineName() {
		assertFalse(test.verifyAirlineName("Lufthansa"));
	}
	
	@Test
	public void shouldReturnFalseIfNameContainsNumbersWhenCreatinfAirlineName() {
		assertFalse(test.verifyAirlineName("Let01"));
	}
	
	@Test
	public void shouldReturnFalseIfNameIsEmptyWhenCreatingAirlineName() {
		assertFalse(test.verifyAirlineName(""));
	}
	
	@Test
	public void shouldReturnTrueIfAirlineNameDoesNotExistsAlreadyWhenCreatingAirline() {
		test.getListOfAirlines().add(new Airline("ABCDE"));
		assertTrue(test.isAirlineNameUnique("FGHIJ"));
	}
	
	@Test
	public void shouldReturnFalseIfAirlineNameAlreadyExistsWhenCreatingAirline() {
		test.getListOfAirlines().add(new Airline("FlyBH"));
		assertFalse(test.isAirlineNameUnique("FlyBH"));
	}
	
	@Test
	public void shouldCreateAirlineObjectIfAllConditionsAreMet() {
		assertNotNull(test.createAirline("FlyBH"));
	}
	
	@Test
	public void shouldFailCreatingAirlineObjectWhenNameVerificationFails() {
		assertNull(test.createAirline("FlyBH1"));
	}
	
	@Test
	public void shouldFailCreatingAirlineObjectWhenObjectAlreadyExists() {
		test.getListOfAirlines().add(new Airline("FlyBH"));
		assertNull(test.createAirline("FlyBH"));
	}
	
	@Test
	public void shouldReturnTrueIfFlightIdIsUniqueWhenCreatingFlight() {
		test.getListOfFlights().add(new Flight("Wizz", "Tuz", "Tuzla", "Dubai", 22));
		assertTrue(test.isFlightIdUnique(10));
	}
	
	@Test
	public void shouldReturnFalseIfFlightIdAlreadyExistsWhenCreatingFlight() {
		test.getListOfFlights().add(new Flight("Wizz", "Tuz", "Tuzla", "Dubai", 22));
		assertFalse(test.isFlightIdUnique(22));
	}
	
	@Test
	public void shouldReturnTrueIfAirlineIsAvailableWhenCreatingFlight() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		assertTrue(test.isAirlineAvailableForFlight("Wizz"));
	}
	
	@Test
	public void shouldReturnFalseIfAirlineIsNotAvailableWhenCreatingFlight() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		assertFalse(test.isAirlineAvailableForFlight("Bizz"));
	}
	
	@Test
	public void shouldReturnTrueIfAirportIsAvailableWhenCreatingFlight() {
		test.getListOfAirports().add(new Airport("ABC"));
		assertTrue(test.isAirportAvailableForFlight("ABC"));
	}
	
	@Test
	public void shouldReturnFalseIfAirportIsNotAvailableWhenCreatingFlight() {
		test.getListOfAirports().add(new Airport("ABC"));
		assertFalse(test.isAirportAvailableForFlight("DEF"));
	}
	
	@Test
	public void shouldCreateFlightObjectIfAllConditionsAreMet() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		test.getListOfAirports().add(new Airport("ABC"));
		assertNotNull(test.createFlight("Wizz", "ABC", "Tuzla", "Dubai", 50));
	}
	
	@Test
	public void shouldNotCreateFlightObjectIfAirlineNameIsNotCorrect() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		test.getListOfAirports().add(new Airport("ABC"));
		assertNull(test.createFlight("Bizz", "ABC", "Tuzla", "Dubai", 50));
	}
	
	@Test
	public void shouldNotCreateFlightObjectIfAirportNameIsNotCorrect() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		test.getListOfAirports().add(new Airport("ABC"));
		assertNull(test.createFlight("Wizz", "DEF", "Tuzla", "Dubai", 50));
	}
	
	@Test
	public void shouldNotCreateFlightObjectIfFlightIdIsDuplicate() {
		test.getListOfAirlines().add(new Airline("Wizz"));
		test.getListOfAirports().add(new Airport("ABC"));
		test.createFlight("Wizz", "ABC", "Tuzla", "Dubai", 50);
		test.getListOfAirlines().add(new Airline("Bizz"));
		test.getListOfAirports().add(new Airport("DEF"));
		assertNull(test.createFlight("Bizz", "DEF", "Tuzla", "Dubai", 50));
	}
	

}
