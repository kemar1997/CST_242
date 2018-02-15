package strings10;

import java.util.Scanner;

/**
 * Testing the String.trim() and String.toString() methods.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings10 
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

        System.out.print("Enter a string with leading spaces > ");
        String s1 = new String( reader.nextLine() );

        String s2 = s1.trim();

        output.append("s1: ");
        output.append(s1);
        output.append("\ns2: ");
        output.append(s2);
        
        System.out.println(output);
    }
    
}
