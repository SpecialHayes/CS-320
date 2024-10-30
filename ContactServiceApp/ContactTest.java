package ContactServiceApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, null, null, null, null);
		});
		}
	
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("835926", "Mia", "Johnson", "5558526575", "250 Pebble St.");
		assertTrue(contact.getContactID().equals("835926"));
		assertTrue(contact.getName().equals("Mia Johnson"));
		assertTrue(contact.getNumber().equals("5558526575"));
		assertTrue(contact.getAddress().equals("250 Pebble St."));
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("835926", "Mia", "Johnson", "5558526575", "250 Pebble St.");
		contact.setNumber("5558526575");
		contact.setAddress("250 Pebble St.");
		assertTrue(contact.getNumber().equals("5558526575"));
		assert(contact.getAddress().equals("250 Pebble St."));
	}
	
	@Test 
	void testNullSetAttributes() {
		Contact contact = new Contact("835926", "Mia", "Johnson", "5558526575", "250 Pebble St.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber(null);
		});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact ("835926", "Mia", "Johnson", "5558526575", "250 Pebble St.");
		assertTrue(contact.getName().equals("Mia Johnson"));
		assertTrue(contact.getContactID().equals("835926"));
		assertTrue(contact.getNumber().equals("5558526575"));
		assertTrue(contact.getAddress().equals("250 Pebble St."));
	}

}
