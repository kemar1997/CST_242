package stringindexmethods;

/**
 * String searching methods indexOf and lastIndexOf
 *
 * @author Kemar Golding
 */
public class StringIndexMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String letters = "abcdefghijklmabcdefghijklm";
        
        // test indexOf to locate a character in a string
        /**
         * Uses method indexOf to locate the first occurrence of a character in a String. If the 
         * method finds the character, it returns the character's index in the String - otherwise,
         * it returns -1. There are two versions of indexOf that search for characters in a String.
         * The first expression uses the version of method indexOf that takes an integer
         * representation of the character to find. The second expression uses another version
         * of method indexOf, which takes two integer arguments - the character and the
         * starting index at which the search of the String should begin.
         */
        System.out.printf("'c' is located at index %d%n", letters.indexOf('c'));
        System.out.printf("'a' is located at index %d%n", letters.indexOf('a', 1));
        System.out.printf("'$' is located at index %d%n%n", letters.indexOf('$'));
        
        // test lastIndexOf to find a character in a string
        /**
         * Uses method lastIndexOf to locate the last occurrence of a character in a String.
         * The method searches from the end of the String toward the beginning. If it finds
         * the character, it returns the character's index in the String - otherwise, it returns
         * -1. There are two versions of lastIndexOf that search for characters in a String.
         * The first expression uses the version that takes the integer representation of the
         * character. The second expression uses the version that takes two integer arguments
         * - the integer representation of the character and the index from which to begin searching
         * backward.
         */
        System.out.printf("Last 'c' is located at index %d%n", letters.lastIndexOf('c'));
        System.out.printf("Last 'a' is located at index %d%n", letters.lastIndexOf('a', 25));
        System.out.printf("Last '$' is located at index %d%n%n", letters.lastIndexOf('$'));
        
        /**
         * These last few lines demonstrate versions of methods indexOf() and lastIndexOf()
         * that each take a String as the first argument. These versions perform identically to
         * those described above except that they search for sequences of characters (or 
         * substrings) that are specified by their String arguments. If the substring is found,
         * these methods return the index in the String of the first character in the substring.
         */
        // test indexOf to locate a substring in a string 
        System.out.printf("\"def\" is located at index %d%n", letters.indexOf("def"));
        System.out.printf("\"def\" is located at index %d%n", letters.indexOf("def", 7));
        System.out.printf("\"hello\" is located at index %d%n%n", letters.indexOf("hello"));
        
        // test lastIndexOf to find a substring in a string
        System.out.printf("Laat \"def\" is located at index %d%n", letters.lastIndexOf("def"));
        System.out.printf("Laat \"def\" is located at index %d%n", letters.lastIndexOf("def", 25));
        System.out.printf("Laat \"hello\" is located at index %d%n", letters.lastIndexOf("hello"));
    }
}
