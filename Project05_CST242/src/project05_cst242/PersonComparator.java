package project05_cst242;

import java.util.Comparator;

/**
 * A custom Comparator class that compares to Person objects.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class PersonComparator implements Comparator<Person> {
    
    @Override
    public int compare(Person per1, Person per2) {
        if (! per1.getLastName().equals(per2.getLastName())) {
            return per1.getLastName().compareTo(per2.getLastName());
        }
        
        if (! per1.getFirstName().equals(per2.getFirstName())) {
            return per1.getFirstName().compareTo(per2.getFirstName());
        }
        
        return per1.getMiddleInitial() - per2.getMiddleInitial();
    }
}
