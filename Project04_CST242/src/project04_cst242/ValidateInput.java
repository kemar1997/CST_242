package project04_cst242;

/**
 * Contains the necessary regular expressions to limit what the user inputs as a
 * valid input.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class ValidateInput {
    /**
     * Returns a boolean value indicating whether the user has entered an English-
     * language phrase (only letters and blank spaces).
     * 
     * @param engPhrase the English language phrase
     * @return A boolean value needed to validate whether the input matches the
     * regex.
     */
    public static boolean validateEnglishPhrase(String engPhrase) {
        return engPhrase.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$");
    }
    
    /**
     * Returns a boolean value indicating whether the user inputted a Morse code
     * phrase (allows only dots, dashes and spaces)
     * 
     * @param morseCode the Morse code phrase
     * @return a boolean value needed to validate whether the input matches the
     * regex.
     */
    public static boolean validateMorseCode(String morseCode) {
        return morseCode.matches("^[\\-.\\s]*$");
    }
}
