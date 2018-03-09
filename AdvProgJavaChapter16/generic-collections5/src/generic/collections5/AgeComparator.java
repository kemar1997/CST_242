package generic.collections5;

import java.util.Comparator;

/**
 * A custom Comparator class that compares to Age objects.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class AgeComparator implements Comparator<Age>
{
    @Override
    public int compare(Age age1, Age age2)
    {
        int yearsDifference = age1.getYears() - age2.getYears();
        
        if (yearsDifference != 0)
        {
            return yearsDifference;
        }
        
        int monthsDifference = age1.getMonths() - age2.getMonths();
        
        if (monthsDifference != 0)
        {
            return monthsDifference;
        }
        
        int daysDifference = age1.getDays() - age2.getDays();
        return daysDifference;
    }
}
