package character1;

import java.util.Scanner;

/**
 * Testing methods of the Character class.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Character1 
{
    /**
     * Gets two char values from the Scanner and copies one of those char values
     * to a third char, examines those char values using methods of the Character
     * class, and displays the results to the console.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        System.out.print("Enter the first character: ");
        char c1 = reader.nextLine().charAt(0);

        System.out.print("Enter the second character: ");
        char c2 = reader.nextLine().charAt(0);

        Character c3 = new Character(c1);

        output.append("The charValue() is : '");
        output.append( c3.charValue() );
        output.append("'\n");

        output.append("The first char == the second char: ");
        output.append( c3.equals(c2) );
        output.append("\nThe first char < or > or == the second char: ");
        output.append( c3.compareTo(c2) );
        output.append("\n");

        output.append("\nIs it defined?:  ");
        output.append( Character.isDefined(c1) );

        output.append("\nIs it a digit?:  ");
        output.append( Character.isDigit(c1) );

        output.append("\nIs it a letter?:  ");
        output.append( Character.isLetter(c1) );

        output.append("\nIs it a letter or digit?:  ");
        output.append( Character.isLetterOrDigit(c1) );

        output.append("\nIs it lower case?:  ");
        output.append( Character.isLowerCase(c1) );

        output.append("\nIs it upper case?:  ");
        output.append( Character.isUpperCase(c1) );

        output.append("\nTo lower case:  ");
        output.append( Character.toLowerCase(c1) );

        output.append("\nTo upper case:  ");
        output.append( Character.toUpperCase(c1) );

        System.out.println(output);
    }
}
