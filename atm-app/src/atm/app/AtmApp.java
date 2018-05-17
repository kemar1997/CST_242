package atm.app;

/**
 *
 * @author Kemar Golding
 * @version 5/10/2018
 */
public class AtmApp {

    /**
     * Instantiates an ATM object and starts it running.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
    
}
