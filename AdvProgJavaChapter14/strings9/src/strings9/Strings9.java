package strings9;

import java.util.Scanner;

/**
 * Testing the String.toLowerCase() and String.toUpperCase() methods, and 
 * the String replace() methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings9 
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

        System.out.print("Enter the string > ");
        String s1 = new String( reader.nextLine() );

        output.append("The string converted to lowercase: ");
        output.append( s1.toLowerCase() );
        output.append("\nThe string converted to uppercase: ");
        output.append( s1.toUpperCase() );

        System.out.println(output);
    }
    
}
