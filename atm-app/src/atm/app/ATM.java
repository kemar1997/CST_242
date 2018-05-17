package atm.app;

/**
 * Represents an automated teller machine.
 *
 * @author Kemar Golding
 * @version 5/10/2018
 */
public class ATM {
    
    // Instance Variables
    private boolean userAuthenticated;
    private int currentAccountNumber;
    
    // Reference to associated objects
    private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase;
    
    // Constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    
    /**
     * The no arg constructor initializes instance variables.
     */
    public ATM() {
        userAuthenticated = false;
        currentAccountNumber = 0;
        
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();
    }
    
    /**
     * Starts the ATM running.
     */
    public void run() {
        while (true) {
            while (! userAuthenticated) {
                screen.displayMessageLine("\nWelcome");
                authenticateUser();
            }
            
            performTransactions();
            
            userAuthenticated = false;
            currentAccountNumber = 0;
            
            screen.displayMessageLine("\nThank You! Goodbye.");
        }
        
        
    }
    
    /**
     * Attempts to authenticate user against database.
     */
    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number ==> ");
        int accountNumber = keypad.getInt();
        screen.displayMessage("\nEnter your pin ==> ");
        int pin = keypad.getInt();
        
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
        
        if (userAuthenticated) {
            currentAccountNumber = accountNumber;
        } else {
            screen.displayMessageLine("\nInvalid Account Number Or Pin. "
                    + "Please Try Again.");
        }
    }
    
    /**
     * Displays the main menu and performs transactions.
     */
    private void performTransactions() {
    
    }
}
