package project04_cst242;

/**
 *
 * @author Kemar, Woonnie & Sophia
 */
public class ValidateInput {
    /**
     * Returns a boolean value indicating whether the user has entered an English-
     * language phrase (only letters and blank spaces).
     * 
     * @param engPhrase
     * @return 
     */
    public static boolean validateEnglishPhrase(String engPhrase) {
        return engPhrase.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$");
    }
    
    
    public static boolean validateMorseCode(String morseCode) {
        return morseCode.matches("^[\\-.\\s]*$");
    }
}
