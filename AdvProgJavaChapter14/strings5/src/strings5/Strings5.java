package strings5;

import java.util.Scanner;

/**
 * Testing the String.regionMatches() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings5 
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

        System.out.print("Results of regionMatches() method:  ");

        if ( s1.regionMatches(2, s2, 2, 5) )
        {
            output.append("Region of first string matches region of second");
        }
        else
        {
            output.append("Region of first string does not match region of second");
        }

        output.append("\nResults of regionMatches() method--ignoreCase is True:  ");

        if ( s1.regionMatches(true, 2, s2, 2, 5) )
        {
            output.append("Region of first string matches region of second");
        }
        else
        {
            output.append("Region of first string does not match region of second");
        }
    }
}
