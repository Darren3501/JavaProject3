/**
 * Represents a person with a name, email, and age.
 * Person implements Printable to allow CSV export.
 */
public class Person implements Printable
{
    private String name;   // Person's name
    private String email;  // Person's email address
    private int age;       // Person's age

    /**
     * Constructs a Person 
     *
     */
    public Person(String name, String email, int age)
    {
        this.setName(name);
        this.setEmail(email);
        this.setAge(age);
    }

    /**
     * Gets the name of the person.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the person.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the person.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the age of the person.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the person for display.
     *
     * @return a comma-separated string of name, email, and age
     */
    @Override
    public String toString()
    {
        return name + "," + email + "," + age;
    }

    /**
     * Returns a CSV-formatted string of the person.
     *
     * @return CSV string of the person
     */
    @Override
    public String toCSV()
    {
        return toString();
    }
}
