/**
 * Represents a scheduled transportation arrangement.
 * Combines a customer, vehicle, and driver into a single scheduled ride.
 */
public class ScheduledTransportation implements Printable
{
    private Customer customer; // Customer being transported
    private Driver driver;      // Driver assigned to the transportation
    private Vehicle vehicle;    // Vehicle used for transportation

    /**
     * Constructs a ScheduledTransportation with the specified customer, vehicle, and driver.
     *
     */
    public ScheduledTransportation(Customer c, Vehicle v, Driver d)
    {
        this.customer = c;
        this.driver = d;
        this.vehicle = v;
    }

    /**
     * Gets the customer of this scheduled transportation.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer of this scheduled transportation.
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the driver of this scheduled transportation.
     *
     * @return the driver
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Sets the driver of this scheduled transportation.
     *
     * @param driver the driver to set
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Gets the vehicle used for this scheduled transportation.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the vehicle used for this scheduled transportation.
     *
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Returns a string representation combining customer, vehicle, and driver details.
     *
     * @return a comma-separated string of transportation details
     */
    @Override
    public String toString()
    {
        return customer.toCSV() + "," + vehicle.toCSV() + "," + driver.toCSV();
    }

    /**
     * Returns a CSV-formatted string of the scheduled transportation.
     *
     * @return CSV string of scheduled transportation
     */
    @Override
    public String toCSV()
    {
        return toString();
    }
}
