/**
 * Represents a VIP customer who earns loyalty points.
 * A VIPCustomer is a specialized type of Customer.
 */
public class VIPCustomer extends Customer
{
    private int points; // Loyalty points associated with the VIP customer

    /**
     * Constructs a VIPCustomer 
     *
     */
    public VIPCustomer(String name, String email, int age, int partySize, int points)
    {
        super(name, email, age, partySize);
        this.setPoints(points);
    }

    /**
     * Gets the loyalty points of the VIP customer.
     *
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the loyalty points of the VIP customer.
     *
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Returns a string representation of the VIP customer for display.
     *
     * @return a comma-separated string of VIP customer details
     */
    @Override
    public String toString()
    {
        return super.toString() + "," + points;
    }

    /**
     * Returns a CSV-formatted string of the VIP customer.
     *
     * @return CSV string of VIP customer details
     */
    @Override
    public String toCSV()
    {
        return toString();
    }
}
