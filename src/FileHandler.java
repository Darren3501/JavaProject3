import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Handles reading and writing data to and from CSV files for vehicles, drivers, and customers.
 */
public class FileHandler 
{
    /**
     * Loads vehicle data from a CSV file into a list of Vehicle objects.
     *
     * @param fileName the name of the CSV file
     * @return an ArrayList of Vehicles
     */
    public static ArrayList<Vehicle> loadVehicleData(String fileName)
    {
        ArrayList<Vehicle> newVehicle = new ArrayList<>();
        File file = new File(fileName); 
        
        try
        {
            Scanner readFile = new Scanner(file);
            String header = readFile.nextLine(); // Skip header line
            
            // Read each line and create a Vehicle object
            while (readFile.hasNext()) 
            {
                String line = readFile.nextLine();
                String[] data = line.split(",");
                
                String vehicleName = data[0];
                int seats = Integer.parseInt(data[1]);
                boolean isLuxury = Boolean.parseBoolean(data[2]);
                
                Vehicle vehicle = new Vehicle(seats, isLuxury, vehicleName);
                newVehicle.add(vehicle);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading vehicle file: " + e.getMessage());
        }
        
        return newVehicle;
    }
    
    /**
     * Loads driver data from a CSV file into a queue of Driver objects.
     *
     * @param fileName the name of the CSV file
     * @return a Queue of Drivers
     */
    public static Queue<Driver> loadDriverData(String fileName)
    {
        Queue<Driver> newQueue = new LinkedList<>();
        File file = new File(fileName);
        
        try
        {
            Scanner readFile = new Scanner(file);
            String header = readFile.nextLine(); // Skip header line
            
            // Read each line and create a Driver object
            while (readFile.hasNext()) 
            {
                String line = readFile.nextLine();
                String[] data = line.split(",");
                
                String name = data[0];
                String email = data[1];
                int age = Integer.parseInt(data[2]);
                String license = data[3];
                
                Driver newDriver = new Driver(name, email, age, license);
                newQueue.offer(newDriver);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading driver file: " + e.getMessage());
        }
        
        return newQueue;
    }
    
    /**
     * Loads customer data (including VIPCustomers) from a CSV file into a queue of Customer objects.
     *
     * @param fileName the name of the CSV file
     * @return a Queue of Customers and VIPCustomers
     */
    public static Queue<Customer> loadCustomerData(String fileName)
    {
        Queue<Customer> customerQueue = new LinkedList<>();
        File file = new File(fileName);
        
        try
        {
            Scanner readFile = new Scanner(file);
            String header = readFile.nextLine(); // Skip header line
            
            // Read each line and create either a Customer or VIPCustomer
            while (readFile.hasNext())
            {
                String line = readFile.nextLine();
                String[] data = line.split(",");
                
                String name = data[0];
                String email = data[1];
                int age = Integer.parseInt(data[2]);
                int partySize = Integer.parseInt(data[3]);
                int vipStatus = Integer.parseInt(data[4]);
                
                //Regular Customer
                if (vipStatus == -1)
                {
                    Customer customer = new Customer(name, email, age, partySize);
                    customerQueue.offer(customer);
                }
                //VIP customer
                else
                {
                    VIPCustomer vipCustomer = new VIPCustomer(name, email, age, partySize, vipStatus);
                    customerQueue.offer(vipCustomer);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error reading customer file: " + e.getMessage());
        }
    
        return customerQueue;
    }
    
    /**
     * Writes a list of scheduled transportations to a CSV file.
     *
     * @param fileName the name of the CSV file to write
     * @param schedule the list of scheduled transportations
     */
    public static void writeScheduleToFile(String fileName, ArrayList<ScheduledTransportation> schedule)
    {
        try
        {
            PrintWriter writer = new PrintWriter(fileName);
            // Write header
            writer.println("CustomerName,CustomerEmail,Age,PartySize,Points,Seats,Luxury,Description,DriverName,DriverEmail,DriverAge,License");

            // Write each scheduled transportation
            for (ScheduledTransportation st : schedule)
            {
                writer.println(st.toCSV());
            }
            writer.flush(); //empty buffer
        }
        catch (Exception e)
        {
            System.out.println("Error writing to schedule file: " + e.getMessage());
        }
    }
}
