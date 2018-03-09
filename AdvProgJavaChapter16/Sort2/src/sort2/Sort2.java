package sort2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Using a Comparator object with method sort.
 *
 * @author Kemar Golding
 * @version 3/6/18
 */
public class Sort2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // Create and display a list containing the suits array elemens
        List<String> list = Arrays.asList(suits);
        System.out.printf("Unsorted array elements: %s%n", list);
        
        // Sort in descending order using a comparator
        Collections.sort(list, Collections.reverseOrder());
        System.out.printf("Sorted list elements: %s%n", list);
    }
    
}
