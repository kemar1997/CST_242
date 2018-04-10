package multidimensional.arrays;

import javax.swing.JOptionPane;

/**
 * Description:  Double-subscripted arrays and mileages between cities
 *
 * @author Carl B. Struck
 * @version Copyright (c) 2002 SCCC West
 */
public class MultidimensionalArrays 
{
    // A multidimensional array of mileages between cities
    // First bracket is the rows and the second is the columns
    private static final int[][] mileage =
    {
        {  0, 160, 390,  40},
        {160,   0, 240, 200},
        {390, 240,   0, 440},
        { 40, 200, 440,   0}
    };
    
    /**
     * Inputs the codes for two cities and displays the distances between them.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        String textMessage =
            "in which city?:\n\n"
              + "    1 = New York City\n"
              + "    2 = Albany\n"
              + "    3 = Buffalo\n"
              + "    4 = Brentwood\n\n";

        try
        {
            int begin = Integer.parseInt(
                JOptionPane.showInputDialog("Starting " + textMessage) );

            int end = Integer.parseInt(
                JOptionPane.showInputDialog("Ending  " + textMessage) );

            JOptionPane.showMessageDialog(null,
                "Mileage between cities is " + mileage[begin - 1][end - 1] );
        }

        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Must be an integer");
        }

        catch (IndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(null, "Number codes must be between 1 and 4");
        }

        catch (RuntimeException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
