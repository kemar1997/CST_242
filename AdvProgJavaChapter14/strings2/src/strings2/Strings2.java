package strings2;

import java.util.Scanner;

/**
 * Testing the String.length and String.charAt methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings2 
{
    /**
     * Gets a String from the user and asks the user which char to display.
     * Displays the String and found char in a StringBuilder object.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        System.out.print("Enter the string > ");
        String s1 = new String( reader.nextLine() );

        int stringLength = s1.length();

        System.out.print(
            "Enter character location from zero (0) up to "
            + (stringLength - 1) + " > " );

        int stringPosition = reader.nextInt();

        output.append("Character at position ");
        output.append(stringPosition);
        output.append(" is '");
        output.append( s1.charAt(stringPosition) );
        output.append("'");
        
        System.out.println(output);
    }
}
