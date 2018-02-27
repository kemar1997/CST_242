package strings11;

import java.util.Scanner;

/**
 * Testing the String.split() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings11 
{
    /**
     * Get a String from the Scanner, split the String into an array of "tokens"
     * and display each element in the array separately to the console.  Also 
     * count the number of tokens and display that count to the console.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        System.out.print("Enter the string > ");
        String s1 = reader.nextLine();

        String[] t1 = s1.split(" ");

        output.append("String array has ");
        output.append( t1.length );
        output.append(" elements\n");

        for (String t: t1)
        {
            output.append(t);
            output.append("\n");
        }
        
        System.out.println(output);
    }
}
