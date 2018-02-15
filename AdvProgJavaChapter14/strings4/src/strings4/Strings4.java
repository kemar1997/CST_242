package strings4;

import java.util.Scanner;

/**
 * Testing the String.compareTo() and String.compareToIgnoreCase() methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings4 
{
    /**
     * ???.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        System.out.print("Enter the first string > ");
        String s1 = new String( reader.nextLine() );

        System.out.print("Enter the second string > ");
        String s2 = new String( reader.nextLine() );

        output.append("Results of compareTo() method:  ");

        if ( s1.compareTo(s2) == 0 )
        {
            output.append("First string equals second string");
        }
        else if ( s1.compareTo(s2) > 0 )
        {
            output.append("First string is greater than second string");
        }
        else
        {
            output.append("First string is less than second string");
        }

        output.append("\nResults of compareToIgnoreCase() method:  ");

        if ( s1.compareToIgnoreCase(s2) == 0 )
        {
            output.append("First string equals second string");
        }
        else if ( s1.compareToIgnoreCase(s2) > 0 )
        {
            output.append("First string is greater than second string");
        }
        else
        {
            output.append("First string is less than second string");
        }
        
        System.out.println(output);
    }
    
}
