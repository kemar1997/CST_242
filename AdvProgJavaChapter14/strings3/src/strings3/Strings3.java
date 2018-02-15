package strings3;

import java.util.Scanner;

/**
 * Testing the String.equals() and String.equalsIgnoreCase() methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings3 
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

        System.out.print("Case sensitive:  ");

        if ( s1.equals(s2) )
        {
            output.append("First string equals second string");
        }
        else
        {
            output.append("First string does not equal second string");
        }

        output.append("\nCase insensitive:  ");

        if ( s1.equalsIgnoreCase(s2) )
        {
            output.append("First string equals second string");
        }
        else
        {
            output.append("First string does not equal second string");
        }
        
        System.out.println(output);
    }
}
