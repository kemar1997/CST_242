package collectiontest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Uses an ArrayList to demonstrate several capabilities of interface Collection.
 * The program places two Color arrays in ArrayLists and uses an Iterator to
 * remove elements in the second ArrayList collection from the first.
 *
 * @author Kemar Golding
 * @version 3/1/18
 */
public class CollectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // add elements in colors array to list
        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<String>();
        
        for (String color : colors) {
            list.add(color); // adds color to end of list
        }
        
        // add elements in removeColors array to removeList
        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<String>();
        
        for (String color : removeColors) {
            removeList.add(color);
        }
        
        // output list contents
        System.out.println("ArrayList: ");
        
        for (int count = 0; count < list.size(); count++) {
            System.out.printf("%s ", list.get(count));
        }
        
        // remove from list the colors contained in removeList
        removeColors(list, removeList);
        
        // output list contents
        System.out.printf("%n%nArrayList after calling removeColors:%n");
        
        for (String color : list) {
            System.out.printf("%s ", color);
        }
        
    }
    
    // remove colors specified in collection2 from collection1
    private static void removeColors(Collection<String> collection1, 
        Collection<String> collection2) {
        // get iterator
        Iterator<String> iterator = collection1.iterator();
        
        // loop while collection as items
        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
                iterator.remove(); // remove current elements
            }
        }
    }
    
}
