package atm.app;

/**
 * Abstract class Transaction represents an ATM transaction. This class is 
 * "immutable" since there are no set methods, and thus all instance
 * variables can be defined as final.
 *
 * @author Kemar Golding
 * @version 5/10/2018
 */
public abstract class Transaction {
    
    // Instance Variables
    private final int accountNumber;
    
    // Reference to associated objects
    private final Screen screen;
    private final BankDatabase bankDatabase;
    
    /**
     * Gets parameters from the subclass and assigns them to the instance
     * variables.
     * 
     * @param accountNumber the account number for the current transaction
     * @param screen an ATM Screen object
     * @param bankDatabase an ATM BankDatabase object
     */
    public Transaction(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
    }
    
    /**
     * Returns the account number for the current account.
     * 
     * @return the account number for the current account
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Returns a reference to the Screen object.
     * 
     * @return the Screen object
     */
    public Screen getScreen() {
        return screen;
    }
    
    /**
     * Returns a reference to the BankDatabase object.
     * 
     * @return the BankDatabase object
     */
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }
    
    public abstract void execute();
}
