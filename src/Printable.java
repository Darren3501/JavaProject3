/**
 * Interface that defines the ability to export an object to CSV format.
 * Classes implementing Printable must provide a toCSV() method.
 */
public interface Printable 
{
    /**
     * Returns a CSV-formatted string representation of the object.
     *
     */
    public abstract String toCSV();
}
