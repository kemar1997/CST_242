package stringsstartend;

/**
 * String methods startsWith and endsWith.
 *
 * @author Kemar Golding
 */
public class StringsStartEnd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] strings = {"started", "starting", "ended", "ending"};
        
        // test method startsWith
        /**
         * Uses the version of method startsWith that takes a String argument. The condition in the 
         * if statement determines whether each String in the array starts with the characters "st".
         * If so, the method returns true and the application prints that String. Otherwise, the
         * method returns false and nothing happens.
         */
        for (String string : strings) {
            if (string.startsWith("st")) {
                System.out.printf("\"%s\" starts with \"st\"%n", string);
            }
        }
        
        System.out.println();
        
        // test method startsWith starting from position 2 of the string
        /**
         * Uses that startsWith method that takes a String and an integer as arguments. The
         * integer specifies the index at which the comparison should begin in the String. The
         * condition in the if statement determines whether each String in the array has the 
         * characters "art" beginning with the third character in each String. If so, the method
         * returns true and the application prints the String.
         */
        for (String string : strings) {
            if (string.startsWith("art", 2)) {
                System.out.printf("\"%s\" starts with \"art\" at position 2%n", string);
            }
        }
        
        System.out.println();
        
        // test method endsWith
        /**
         * Uses method endsWith, which takes a String argument. The condition determines whether
         * each String in the array ends with the characters "ed". If so, the method returns true and
         * the application prints the String.
         */
        for (String string : strings) {
            if (string.endsWith("ed")) {
                System.out.printf("\"%s\" ends with \"ed\"%n", string);
            }
        }
    }
    
}
