package ContactServiceApp;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;

	// Constructors 
	public Contact(String ContactID, String FirstName,
			String LastName, String Number, String Address) {
		if (ContactID == null || ContactID.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		if (FirstName == null || FirstName.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		if (LastName == null || LastName.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		if (Number == null || Number.length() > 10 || Number.length() < 10) {
			throw new IllegalArgumentException("Error");
		}
		if (Address == null || Address.length() > 30) {
			throw new IllegalArgumentException("Error");
		}
		
		this.contactID = ContactID;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.number = Number;
		this.address = Address;
	}
	// Get & Set For ContactID 
	public String getContactID() {
		return this.contactID;
	}
	public void setContactID(String newContactID) {
		if (newContactID == null || newContactID.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		contactID = newContactID;
	}
	// Get & Set For FirstName / LastName 
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Error");
		}
		firstName = newFirstName;
	}

		public void setLastName(String newLastName) {
			if (newLastName == null || newLastName.length() > 10) {
				throw new IllegalArgumentException("Error");
			}
			lastName = newLastName;
		}
	// Get & Set For Number
		public String getNumber() {
			return this.number;
	}
		public void setNumber(String newNumber) {
			if (newNumber == null || newNumber.length() > 10 || newNumber.length() < 10) {
				throw new IllegalArgumentException("Error");
			}
			number = newNumber;
		}
	// Get & Set For Address
		public String getAddress() {
			return this.address;
		}
		public void setAddress(String newAddress) {
			if (newAddress == null || newAddress.length() > 30) {
				throw new IllegalArgumentException("Error");
			}
			address = newAddress;
		}
		
	}


