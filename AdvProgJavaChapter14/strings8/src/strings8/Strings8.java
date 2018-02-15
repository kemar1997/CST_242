package strings8;

import java.util.Scanner;

/**
 * Testing the String.concat() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2002 - SCCC West
 */
public class Strings8 
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

        output.append( s1.concat(s2) );
        output.append("\n");
        output.append(s1 + s2);
        
        System.out.print(output);
    }
    
}
