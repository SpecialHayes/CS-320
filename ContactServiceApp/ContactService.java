package ContactServiceApp;

import java.util.Vector;
import java.util.Random;

public class ContactService {
	
	// Vector to Store Contacts 
	private Vector <Contact> myContacts = new Vector <Contact>();
	
	// Int Counter to Store The Number of Contacts 
	private int numContacts = 0;
	
	// Get For numContacts 
	public int getNumContacts() {
		return numContacts;
	}
	
	// Get For The List of Contacts
	public Vector <Contact> getContactList() {
		return myContacts;
	}
	
	// Get For The List of Contacts 
	public void addContact (String contactID, String firstName, String lastName, String number, String address) {
		
		// Create a New Contact 
		Contact newContact = new Contact(contactID, firstName, lastName, number, address);
		
		// Add The Contact to The List of Contacts 
		myContacts.add(newContact);
		
		// Add The Number of Contacts
		numContacts++;
	}

	public void addContact(Contact contact) {
		
		// Add The Contact to The Lists of Contacts
		myContacts.add(contact);
		
		// Add The Number of Contacts
		numContacts++;
	}
	
	// Function to Add a Contact to The List 
	public void removeContact(String contactID) {
		
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("No Contacts Available");
		}
		
		int index = -1;
		for (Contact c: myContacts) {
			if (c.getContactID() == contactID) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Unable to Locate");
			return;
		}
		
		else {
				myContacts.remove(index);
				numContacts--;
				System.out.println("Deleted");
		}
	}
	public void removeContact(Contact contact) {
		myContacts.remove(contact);
		numContacts--;
	}
	
	// Update Contact 
	void updateContact(String ContactID, String update, int selection) {
		if (ContactID == null || ContactID.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Error");
		}
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("Error - No Contacts to Update");
		}
		
		int index = -1;
		
		for (Contact c: myContacts) {
			if (c.getContactID() == ContactID) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Unable to Locate");
			return;
		}
		
		Contact updatedContact = myContacts.get(index);
		
		switch(selection) {
		
			case 1:{
				updatedContact.setFirstName(update);
				break;
		}
		
			case 2:{
				updatedContact.setLastName(update);
				break;
			}
			
			default:{
				removeContact(myContacts.elementAt(index));
				addContact(updatedContact);
			}
		
		}
	}
	
	public void updatedContact(String ContactID, String FirstName, String LastName, String Number, String Address) {
		if (ContactID == null || ContactID.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("No Contacts Available");
		}
		
		int index = -1;
		
		for (Contact c: myContacts) {
			if (c.getContactID() == ContactID) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Unable to Locate");
			return;
		}
		
		Contact tempContact = myContacts.get(index);
		
		tempContact.setFirstName(FirstName);
		tempContact.setFirstName(LastName);
		tempContact.setFirstName(Number);
		tempContact.setFirstName(Address);
		
		myContacts.remove(index);
		myContacts.add(tempContact);
	}
	
	public String generateUniqueId() {
		Random rand = new Random();
		int newContactID = rand.nextInt(1000000000);
		String uniqueContactID = Integer.toString(newContactID);
		
		for (Contact c: myContacts) {
			while(c.getContactID() == uniqueContactID) {
				newContactID = rand.nextInt(1000000000);
				uniqueContactID = Integer.toString(newContactID);
			}
		}
		
		System.out.println("New Contact ID Created: " + uniqueContactID);
		return uniqueContactID;
	}

}
