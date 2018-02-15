package strings1;

import java.util.Scanner;

/**
 * Declaring string objects.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings1 
{
    /**
     * Declares String objects with additional user input from the console.
     * Displays program output in a StringBuilder object.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        String firstName = "Martin";
        String middleName = new String();
        String lastName = new String("Jennings");
        String generation = new String( new char[] {'I', 'V'} );

        System.out.print("Enter middle name > ");
        middleName = reader.nextLine();
        
        output.append(firstName);
        output.append(" ");
        output.append(middleName);
        output.append(" ");
        output.append(lastName);
        output.append(" ");
        output.append(generation);

        System.out.println(output);
    }
    
}
