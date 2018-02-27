package pattern.matches1;
 
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Testing the Pattern and Matcher classes.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class PatternMatches1 
{
    /**
     * Create Pattern and Matcher objects, test several similar elements within 
     * a String against the Matcher object and display the matching elements from
     * the Pattern to the console window.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        // Birthdays that do not occur in April but names start with "J"
        Pattern pattern = Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");
        
        StringBuilder birthdayList = new StringBuilder();
        birthdayList.append("Jane's birthday is 05-12-75\n");
        birthdayList.append("Dave's birthday is 11-04-68\n");
        birthdayList.append("John's birthday is 04-28-73\n");
        birthdayList.append("Joe's birthday is 12-17-77");
        
        String birthdays = birthdayList.toString();
        
        Matcher matcher = pattern.matcher(birthdays);
        
        while ( matcher.find() )
        {
            System.out.println( matcher.group() );
        }
    }
}
