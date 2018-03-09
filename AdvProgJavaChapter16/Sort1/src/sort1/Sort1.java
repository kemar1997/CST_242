package sort1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections method sort.
 *
 * @author Kemar
 * @version 3/6/18
 */
public class Sort1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // Create and display a list containing the suits array elemens
        List<String> list = Arrays.asList(suits);
        System.out.printf("Unsorted array elements: %s%n", list);
        
        Collections.sort(list); // sort ArrayList
        System.out.printf("Sorted array elements: %s%n", list);
    }
    
}
