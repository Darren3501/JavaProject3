/**
 * Represents a customer requesting transportation services.
 * A Customer is a type of Person and can have a party size.
 */
public class Customer extends Person 
{
	private int partySize; // Number of people in the customer's party

	/**
	 * Constructs a Customer 
	 */
	public Customer(String name, String email, int age, int partySize)
	{
		super(name, email, age);
		this.setPartySize(partySize);
	}

	/**
	 * Gets the size of the customer's party.
	 */
	public int getPartySize() {
		return partySize;
	}

	/**
	 * Sets the size of the customer's party.
	 */
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	
	/**
	 * Returns a string representation of the customer for display.
	 */
	@Override
	public String toString()
	{
		return super.toString() + "," + partySize;
	}
	
	/**
	 * Returns a CSV-formatted string for the customer.
	 */
	@Override
	public String toCSV()
	{
		return toString();
	}
}