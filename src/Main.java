import java.util.*;
import java.io.*;
//Darren Mahin
//N01611733
//April 15, 2025

public class Main 
{
    // Constants for file names
    public static final String VEHICLE_FILE_NAME = "Vehicles.csv";
    public static final String CUSTOMER_FILE_NAME = "Customers.csv";
    public static final String DRIVER_FILE_NAME = "Drivers.csv";
    public static final String LOG_FILE_NAME = "Schedule.csv";

    
    public static void main(String[] args)
    {
    	//Initialize objects
    	ArrayList<Vehicle> vehicles = FileHandler.loadVehicleData(VEHICLE_FILE_NAME);
        Queue<Customer> customers = FileHandler.loadCustomerData(CUSTOMER_FILE_NAME);
        Queue<Driver> drivers = FileHandler.loadDriverData(DRIVER_FILE_NAME);
        ArrayList<ScheduledTransportation> schedule = scheduleAllRides(customers, vehicles, drivers);
        
        //Write schedule to file
        FileHandler.writeScheduleToFile(LOG_FILE_NAME, schedule);
    }

    /**
     * Schedules transportation for all customers based on available vehicles and drivers.
     * Tries to minimize wasted seats and prioritize luxury vehicles for VIPs.
     *
     * @param customers queue of customers to schedule
     * @param vehicles list of available vehicles
     * @param drivers queue of available drivers
     * @return list of scheduled transportations
     */
    public static ArrayList<ScheduledTransportation> scheduleAllRides(Queue<Customer> customers, ArrayList<Vehicle> vehicles, Queue<Driver> drivers)
    {
        ArrayList<ScheduledTransportation> schedule = new ArrayList<>();
        
        // Process each customer
        while (!customers.isEmpty())
        {
            Customer customer = customers.poll();   // Get next customer
            Driver driver = drivers.poll();          // Get next available driver
            drivers.offer(driver);                   // Put driver back into rotation

            Vehicle bestMatch = null; // Best vehicle match for current customer
            
            // Find a suitable vehicle for customer
            for (Vehicle v : vehicles)
            {
                //Vehicle big enough for party
            	if (v.getSeats() >= customer.getPartySize())
                {
                    if (bestMatch == null)
                    {
                        bestMatch = v; //update best vehicle
                    }
                    else
                    {
                        if (customer instanceof VIPCustomer)
                        {
                            // VIPs prefer luxury vehicles
                            if (v.isLuxury() && !bestMatch.isLuxury())
                            {
                                bestMatch = v; //update best vehicle
                            }
                            else if (v.isLuxury() == bestMatch.isLuxury() && v.getSeats() < bestMatch.getSeats())
                            {
                                bestMatch = v; // Choose smaller matching luxury vehicle
                            }
                        }
                        else
                        {
                            // Regular customers prefer non-luxury
                            if (!v.isLuxury() && bestMatch.isLuxury())
                            {
                                bestMatch = v; //update best vehicle
                            }
                            else if (v.isLuxury() == bestMatch.isLuxury() && v.getSeats() < bestMatch.getSeats())
                            {
                                bestMatch = v; // Choose smaller matching non-luxury vehicle
                            }
                        }
                    }
                }
            }
            //No vehicle found
            if (bestMatch == null)
            {
                System.out.println("No available vehicle for customer " + customer.getName());
                continue; // Skip to next customer
            }
            
            // Customer upgraded or downgraded depending on availability 
            if (customer instanceof VIPCustomer && !bestMatch.isLuxury())
            {
                System.out.println("VIP " + customer.getName() + " assigned Non-luxury vehicle");
            }
            else if (!(customer instanceof VIPCustomer) && bestMatch.isLuxury())
            {
                System.out.println("Regular customer " + customer.getName() + " assigned luxury vehicle");
            }
            
            // Schedule ride
            schedule.add(new ScheduledTransportation(customer, bestMatch, driver));
            vehicles.remove(bestMatch); // Vehicle is no longer available
        }
        
        return schedule;
    }
}
