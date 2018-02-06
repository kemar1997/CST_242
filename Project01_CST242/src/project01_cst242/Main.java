package project01_cst242;

/**
 * Driver class to test that all of the corresponding classes are working
 * properly.
 *
 * @author kemar
 */
public class Main {
    public static void main(String[] args) {
    
        Computer[] computer = 
        {
            new Desktop(3.0, 4, 500, "DVD", 24),
            new LapTop(2.0, 3, 160, "CD-RW", 14)
        };
        
        for (Computer c : computer) {
            System.out.println(c);
        }
    }
}
