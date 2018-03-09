package project05_cst242;

/**
 * Manages the full name of a person including their first name, middle initial,
 * and last name.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class Person {
    private String firstName;
    private char middleInitial;
    private String lastName;
    
    /**
     * The no parameter constructor that creates the  default Person objects.
     */
    public Person() {
        this("", ' ', "");
    }
    
    /**
     * Initializes the Person object with a firstName, middleInitial, and
     * lastName instance variables while eliminating the need for set methods
     * by assigning the parameters directly to the instance variables.
     * 
     * @param firstName first name of a person
     * @param middleInitial a person's middle initial
     * @param lastName last name of a person
     */
    public Person(String firstName, char middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }
    
    /**
     * Returns the first name.
     * 
     * @return First name of a person.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Returns the middle initial of a person's name.
     * 
     * @return A person's middle initial.
     */
    public char getMiddleInitial() {
        return middleInitial;
    }
    
    /**
     * Returns the last name.
     * 
     * @return Last name of a person.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * String representation of a person's full name.
     * 
     * @return String representation of a person's full name.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        
        output.append(getFirstName()).append(" ").append(getMiddleInitial())
                .append(". ").append(getLastName());
        
        return output.toString();
    }
}
