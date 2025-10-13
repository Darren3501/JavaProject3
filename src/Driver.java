/**
 * Represents a driver available for transportation services.
 * A Driver is a type of Person and has a driver's license.
 */
public class Driver extends Person implements Printable
{
    private String license; // Driver's license information

    /**
     * Constructs a Driver 
     *
     */
    public Driver(String name, String email, int age, String license)
    {
        super(name, email, age);
        this.license = license;
    }

    /**
     * Gets the driver's license.
     *
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the driver's license.
     *
     * @param license the license to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * Returns a string representation of the driver for display.
     *
     * @return a comma-separated string of driver details
     */
    @Override
    public String toString()
    {
        return super.toString() + "," + license;
    }

    /**
     * Returns a CSV-formatted string of the driver.
     *
     * @return CSV string of the driver
     */
    @Override
    public String toCSV()
    {
        return toString();
    }
}
