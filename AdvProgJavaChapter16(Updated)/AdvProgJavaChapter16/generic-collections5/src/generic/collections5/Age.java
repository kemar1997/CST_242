package generic.collections5;

/**
 * Manages the age of a person, place or thing in years, months and days.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class Age 
{
    private int years;
    private int months;
    private int days;
    
    /**
     * The no parameter constructor that creates the  default Age objects.
     */
    public Age()
    {
        this(0, 0, 0);
    }
    
    /**
     * Initializes the age of an object in years, months and days by calling
     * the set months of the instance variables.
     * 
     * @param years the age of the object in years
     * @param months the additional number of months of the age of the object
     * @param days the additional number of days of the age of the object
     */
    public Age(int years, int months, int days)
    {
        setYears(years);
        setMonths(months);
        setDays(days);
    }
    
    /**
     * Sets the value of the years instance variable if the parameter is zero (0)
     * or greater.
     * 
     * @param years the age of the object in years 
     */
    public void setYears(int years)
    {
        if (years >= 0)
        {
            this.years = years;
        }
    }
    
    /**
     * Sets the value of the months instance variable if the parameter is between
     * zero (0) and 11.
     * 
     * @param months the additional number of months of the age of the object 
     */
    public void setMonths(int months)
    {
        if (months >= 0)
        {
            this.months = months;
        }
    }
    
    /**
     * Sets the value of the days instance variable if the parameter is between
     * zero (0) and 30.
     * 
     * @param days the additional number of days of the age of the object 
     */
    public void setDays(int days)
    {
        if (days >= 0)
        {
            this.days = days;
        }
    }
    
    /**
     * Returns the age of the object in measured in years.
     * 
     * @return the age of the object in years
     */
    public int getYears()
    {
        return years;
    }
    
    /**
     * Returns the additional number of months of the age of the object.
     * 
     * @return the additional number of months of the age of the object
     */
    public int getMonths()
    {
        return months;
    }
    
    /**
     * Returns the additional number of days of the age of the object.
     * 
     * @return the additional number of days of the age of the object
     */
    public int getDays()
    {
        return days;
    }
    
    /**
     * Returns a String representation of an Age object including the age 
     * measured in years, the additional number of months and the additional 
     * number of days of the age of the object.
     * 
     * @return the years, months and days of an Age object
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        
        output.append("Years: ");
        output.append( getYears() );
        output.append("    Months: ");
        output.append( getMonths() );
        output.append("    Days: ");
        output.append( getDays() );
        output.append("\n");
        
        return output.toString();
    }
}
