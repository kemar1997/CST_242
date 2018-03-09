package generic.collections13;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * A Java console application that demonstrates the put() and get() methods of 
 * a Map interface instantiated from a TreeMap constructor.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections13 
{
    /**
     * Instantiate and create a Map<String, Integer> object of town names and 
     * ZIP codes, get a search key from the user and retrieve a matching ZIP 
     * code from the input town name.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        // Create Map object from HashMap class
        Map<String, Integer> map = new TreeMap();
        
        map.put("brentwood", 11717);
        map.put("hauppaugue", 11788);
        map.put("bayshore", 11706);
        map.put("deer Dark", 11729);
        map.put("islip", 11751);
        
        String town = JOptionPane.showInputDialog("Enter a town");
        JOptionPane.showMessageDialog(null, "ZIP code is " + map.get( town.toLowerCase() ) );
    }
}
