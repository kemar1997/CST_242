package time2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections method sort with a custom Comparator object.
 *
 * @author Kemar
 */
public class Sort3 {
    public static void main(String[] args) {
        List<Time2> list = new ArrayList<>(); // create list
        
        list.add(new Time2(6, 24, 34));
        list.add(new Time2(18, 14, 58));
        list.add(new Time2(6, 5, 34));
        list.add(new Time2(12, 14, 58));
        list.add(new Time2(6, 24, 22));
        
        // output list elements
        System.out.printf("Unsorted array elements:%n%s%n", list);
        
        // sort in order using a comparator
        Collections.sort(list, new TimeComparator());
        
        // output list elements
        System.out.printf("Sorted list elements:%n%s%n", list);
    }
}
