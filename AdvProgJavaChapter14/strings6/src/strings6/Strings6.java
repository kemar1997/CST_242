package strings6;

import java.util.Scanner;

/**
 * Testing the String.indexOf() and String.lastIndexOf() methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings6 
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

        System.out.print("Enter characters to search for > ");
        String s2 = new String( reader.nextLine() );

        output.append("The first time starting at position ");
        output.append( s1.indexOf(s2) );
        output.append("\nThe last time starting at position ");
        output.append( s1.lastIndexOf(s2) );
        
        System.out.println(output);

        System.out.print("\nStart search at which location up to "
            + (s1.length() - 1) + " > ");
        int startPosition = reader.nextInt();

        output.delete(0, output.length() );

        output.append("Starting after position ");
        output.append(startPosition);
        output.append(" located at ");
        output.append( s1.indexOf(s2, startPosition) );

        output.append("\nStarting before position ");
        output.append(startPosition);
        output.append(" located at ");
        output.append( s1.lastIndexOf(s2, startPosition) );
        
        System.out.println(output);
    }
}
