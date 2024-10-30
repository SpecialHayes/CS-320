package ContactServiceApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContactMethod() {
		// Create Contact 
		ContactService contactService = new ContactService();
		String testID = contactService.generateUniqueId();
		Contact contact = new Contact(testID, "Brittany", "James", "9624870254", "1642 Palm St");
		
		// Add Contact to The List 
		contactService.addContact(contact);
		
		// Confirms Contact is List , Count is Not Zero 
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getContactID()
				.equals(testID));
		assertTrue(contactService.getNumContacts() > 0);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		// Create New Contact 
		Contact contact = new Contact("835926", "Brittany", "James", "9624870254", "1642 Palm St");
		
		// Remove with Null ID 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.removeContact("");
		});
		
		// Remove with ID That's Long 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.removeContact("9624870254");
		});
		
		// Remove From Empty List 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.removeContact("9624870254");
		});
		
		// Add The Contact 
		contactService.addContact(contact);
		
		// Removing Contact That Doesn't Exist 
		contactService.removeContact("835926");
		
		// Contact List Not Empty , Count is Not Zero
		// Contact Not Removed , Contact Doesn't Exist 
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getNumContacts() != 0);
		
		// Remove Correct Contact 
		contactService.removeContact("835926");
		
		// List is Empty , Count is Zero , Contact Removed 
		assertTrue(contactService.getNumContacts() == 0);
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	@Test
	void testUpdateContactMethodErrors() {
		ContactService contactService = new ContactService();
		// Contact List is Empty 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.updateContact("835926" , "Richard" , 1);
		});
		
		// Create New Contact , Add to The List 
		Contact contact = new Contact("835926" , "Brittany" , "James" , "9624870254" , "1642 Palm St" );
		contactService.addContact(contact);
		
		// Check IF Contact was Added 
		assertTrue(!contactService.getContactList().isEmpty());
		
		// ContactID is Too Long 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.updateContact("9624870254" , "Richard" , 1);
		});
		
		// ContactID is Null 
		Assertions.assertThrows(IllegalArgumentException.class ,  () -> {
			contactService.updateContact(null ,  "Richard" , 1);
		});
		
		// Update Value is Null 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.updateContact("835926" , null , 1);
		});
		
		// Value is Less Than Zero 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.updateContact("835926" , "Richard" , -1);
		});
		
		// Prints: Unable to Locate 
		contactService.updateContact("835926" , "Richard" , 1);
		
		// Prints: Unable to Update 
		contactService.updateContact("835926" , "Richard" , 5);
		
	}
		
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("835926" , "Brittany" , "James" , "9624870254" , "1642 Palm St");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		
		// Update First Name 
		contactService.updateContact("835926" , "Richard" , 1);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getName()
				.equals("Richard James"));
		
		// Update Last Name 
		contactService.updateContact("835926" , "Peters" , 2);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getName()
				.equals("Richard Peters"));
		
		// Update Phone Number 
		contactService.updateContact("835926" , "5702506745" , 3);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getNumber()
				.equals("5702506745"));
		
		// Update Address 
		contactService.updateContact("835926" , "4900 Canon Ave" , 4);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getAddress()
				.equals("4900 Canon Ave" ));
		
		// Update First Name , Too Long 
		Assertions.assertThrows(IllegalArgumentException.class , () -> {
			contactService.updateContact("835926" , "RichardMitchell" , 1);
		});
		
		// Check That List Has Been Updated 
		// ONLY One Contact in List , Check Update By Name 
		assertTrue(contactService.getNumContacts() == 1);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getName()
				.equals("Richard Peters"));
	}

}
