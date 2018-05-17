package atm.app;

/**
 * Class Account represents one bank account.
 * 
 * @author Kemar Golding
 * @version 5/15/2018
 */
public class Account {
    // Attributes
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    
    /**
     * Constructor initializes the instance variables
     * 
     * @param accountNumber the account number for this account.
     * @param pin the pin number for this account.
     * @param availableBalance the funds available to withdraw.
     * @param totalBalance the funds available plus pending deposits
     */
    public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }
    
    /**
     * Determines whether the user input pin matches the pin of the account.
     * 
     * @param pin the input pin from the keypad
     * @return A boolean value that validates if the input pin matches the pin 
     * of the account.
     */
    public boolean validatePin(int pin) {
        return (this.pin == pin);
    }
    
    /**
     * Returns the account number for this account.
     * 
     * @return the account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Returns the funds available to withdraw.
     * 
     * @return the available balance for this account.
     */
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    /**
     * Returns funds available plus pending deposits.
     * 
     * @return the total balance for this account.
     */
    public double getTotalBalance() {
        return totalBalance;
    }
    
    /**
     * Credits the amount by adding the deposit amount to the total balance.
     * 
     * @param amount the amount credited to the account.
     */
    public void credit(double amount) {
        totalBalance += amount;
    }
    
    /**
     * Debits the amount by subtracting the withdrawal amount from the available
     * balance and the total balance.
     * 
     * @param amount the amount debited from the account
     */
    public void debit(double amount) {
        availableBalance -= amount;
        totalBalance -= amount;
    }
}
