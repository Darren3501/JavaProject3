/**
 * Represents a vehicle available for transportation services.
 * Each vehicle has a number of seats, a luxury status, and a description.
 */
public class Vehicle implements Printable
{
    private int seats;          // Number of passenger seats (excluding driver seat)
    private boolean isLuxury;   // Indicates if the vehicle is luxury
    private String description; // Description of the vehicle

    /**
     * Constructs a Vehicle
     *
     */
    public Vehicle(int seats, boolean isLuxury, String description)
    {
        this.setSeats(seats);
        this.setLuxury(isLuxury);
        this.setDescription(description);
    }

    /**
     * Gets the number of passenger seats.
     *
     * @return the number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of passenger seats.
     *
     * @param seats the number of seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Returns whether the vehicle is luxury.
     *
     * @return true if luxury, false otherwise
     */
    public boolean isLuxury() {
        return isLuxury;
    }

    /**
     * Sets the luxury status of the vehicle.
     *
     * @param isLuxury true if luxury, false otherwise
     */
    public void setLuxury(boolean isLuxury) {
        this.isLuxury = isLuxury;
    }

    /**
     * Gets the description of the vehicle.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the vehicle.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the vehicle for display.
     *
     * @return a comma-separated string of vehicle details
     */
    @Override
    public String toString()
    {
        return seats + "," + isLuxury + "," + description;
    }

    /**
     * Returns a CSV-formatted string of the vehicle.
     *
     * @return CSV string of the vehicle
     */
    @Override
    public String toCSV()
    {
        return toString();
    }
}
