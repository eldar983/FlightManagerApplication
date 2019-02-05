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
	

}
