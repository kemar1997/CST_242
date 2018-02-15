package strings7;

import java.util.Scanner;

/**
 * Testing the String.substring() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings7 
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

        System.out.print("Enter where the substring begins > ");
        int beginIndex = reader.nextInt();

        System.out.print("Enter where the substring ends > ");
        int endIndex = reader.nextInt();

        output.append("The substring to the end is: ");
        output.append( s1.substring( beginIndex ) );

        output.append("\nThe substring to the end index exclusive is: ");
        output.append( s1.substring( beginIndex, endIndex ) );

        System.out.println(output);
    }
    
}
