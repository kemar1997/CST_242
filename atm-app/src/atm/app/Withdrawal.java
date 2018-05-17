package atm.app;

/**
 * Class Withdrawal represents an ATM withdrawal transaction.
 *
 * @author Kemar Golding
 * @version 5/10/2018
 */
public class Withdrawal extends Transaction {
    
    // Instance Variables
    private int accountNumber;
    private double amount;
    
    // Reference to associated objects
    private Keypad keypad;
    private CashDispenser cashDispenser;
    
    /**
     * No arg constructor.
     */
    public Withdrawal() {
    
    }
    
    /**
     * Operations...
     */
    @Override
    public void execute() {
    
    }
}
