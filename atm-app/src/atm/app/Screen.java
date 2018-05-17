package atm.app;

/**
 * Represents the screen of the ATM.
 *
 * @author Kemar Golding
 * @version 5/10/2018
 */
public class Screen {
    
    /**
     * Display a message without a carriage return.
     * 
     * @param msg the message to display
     */
    public void displayMessage(String msg) {
        System.out.print(msg);
    }
    
    /**
     * Display a message with a carriage return.
     * 
     * @param msg the message to display
     */
    public void displayMessageLine(String msg) {
        System.out.println(msg);
    }
    
    /**
     * Displays a dollar amount.
     * 
     * @param amount an amount to be displayed in Currency format
     */
    public void displayDollarAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    }
}
