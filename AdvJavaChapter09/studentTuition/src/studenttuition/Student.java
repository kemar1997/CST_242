package studenttuition;

/** 
 * The Student class definition which manages student first name, last name,
 * grade and credits fields.
 * 
 * @author Carl B. Struck
 * @version  Copyright 2001 (c) SCCC West
 */ 
public class Student extends Object
{
    private String firstName;  // The student's first name
    private String lastName;   // The student's last name
    private String grade;      // The letter grade
    private int credits;       // The number of credits carried by the student

    /** 
     * Constructor sets default values for student first name, last name,
     * grade and credits fields.
     */
    public Student()
    {
        this("", "", "", 0);
    }

    /** 
     * Constructor sets initial values for student first name, last name,
     * grade and credits fields.
     * 
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param grade the student's letter grade
     * @param credits the number of credits carried by the student
     */
    public Student(String firstName, String lastName,String grade, int credits)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setCredits(credits);
    }

    /** 
     * Sets value for student first name field.
     * 
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /** 
     * Sets value for student last name field.
     * 
     * @param lastName the student's last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /** 
     * Sets value for student grade field which must be from the list 
     * A, B+, B, C+, C, D+, D or F.
     * 
     * @param grade the student's letter grade
     */
    public void setGrade(String grade)
    {
        String[] validGrades = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};

        int index;

        for (index = 0;
             index < validGrades.length 
                && ! grade.equalsIgnoreCase( validGrades[index] );
             index ++);

        if (index < validGrades.length)
        {
            this.grade = grade;
        }
    }

    /** 
     * Sets value for the student's credits field which must not be negative.
     * 
     * @param credits the number of credits carried by the student
     */
    public void setCredits(int credits)
    {
        if (credits >= 0)
        {
            this.credits = credits;
        }
    }

    /** 
     * Returns the student's first name field as a String
     * 
     * @return student's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /** 
     * Returns the student's last name field as a String
     * 
     * @return student's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /** 
     * Returns the student's grade field as a String, 
     * either A, B+, B, C+, C, D+, D or F.
     * 
     * @return student's letter grade
     */
    public String getGrade()
    {
        return grade;
    }

    /** 
     * Returns the student's credits field as an <code>int</code> value.
     * 
     * @return student's number of credits carried
     */
    public int getCredits()
    {
        return credits;
    }

    /** 
     * Returns a String representation of the Student class which is the 
     * formatted first name, last name, grade and credits fields with 
     * labels and the return value of the getTuitionString() method of 
     * all its subclasses.
     *  
     * @return formatted first name, last name, grade and credits fields 
     *         with labels as a String.
     */
    @Override
    public String toString()
    {
        return "Student: " + getFirstName() + " " + getLastName()
            + "\nGrade: " + getGrade()
            + "\nCredits: " + getCredits();
    }
}
