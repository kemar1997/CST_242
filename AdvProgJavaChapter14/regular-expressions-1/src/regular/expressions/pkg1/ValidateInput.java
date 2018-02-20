package regular.expressions.pkg1;

/**
 *
 * @author Carl
 */
public class ValidateInput 
{
    /**
     * Returns a boolean value indicating if the firstName parameter begins with
     * an uppercase letter and then continues with only zero (0) or more uppercase 
     * and/or lowercase letters.
     * 
     * @param firstName the first name of a user
     * @return a boolean value indicating if the first name is valid.
     */
    public static boolean validateFirstName(String firstName)
    {
        return firstName.matches("[A-Z][a-zA-Z]*");
    }

    /**
     * Returns a boolean value indicating if the lastName parameter begins with
     * either an uppercase or lowercase letter, and then continues with only zero (0)
     * of more uppercase and/or lowercase letters and a possible hyphen (-) or 
     * apostrophe (').
     * 
     * @param lastName the last name of a user
     * @return a boolean value indicating if the last name is valid.
     */
    public static boolean validateLastName(String lastName)
    {
        return lastName.matches("[a-zA-Z]+(['-][a-zA-Z]+)*");
    }

    /**
     * Returns a boolean value indicating if the userID parameter contains at least
     * eight (8) characters which only include uppercase and/or lowercase letters.
     * 
     * @param userID the user ID of a user
     * @return a boolean value indicating if the user ID is valid.
     */
    public static boolean validateUserID(String userID)
    {
        return userID.matches("[a-zA-Z]{8,}");
    }

    /**
     * Returns a boolean value indicating if the password parameter contains at 
     * least eight (8) characters of any type.
     * 
     * @param password the password of a user
     * @return a boolean value indicating if the password is valid.
     */
    public static boolean validatePassword(String password)
    {
        return password.matches(".{8,}");
    }

    /**
     * Returns a boolean value indicating if the password parameter matches the
     * passwordAgain parameter.
     * 
     * @param password the password of a user
     * @param passwordAgain the password to compare for equality to the password
     * @return a boolean value indicating if the password is valid.
     */
    public static boolean validatePasswordAgain(String password, String passwordAgain)
    {
        return password.equals(passwordAgain);
    }

    /**
     * Returns a boolean value indicating if the phone parameter is in a valid
     * format with the area code separated from the rest of the number by either 
     * parentheses or a dash.
     * 
     * @param phone the phone number of a user
     * @return a boolean value indicating if the phone number is valid.
     */
    public static boolean validatePhone(String phone)
    {
        return phone.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
    }

    /**
     * Returns a boolean value indicating if the socSecNumber parameter is in the
     * format of a valid social security number (999-99-9999).
     * 
     * @param socSecNumber the social security number of a user
     * @return a boolean value indicating if the social security number is valid.
     */
    public static boolean validateSocSecNumber(String socSecNumber)
    {
        return socSecNumber.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    /**
     * Returns a boolean value indicating if the email parameter is in a valid 
     * email address format.
     * 
     * @param email the e-mail address of a user
     * @return a boolean value indicating if user the email address is valid.
     */
    public static boolean validateEmail(String email)
    {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    /**
     * Returns a boolean value indicating if the dob (date of birth) parameter 
     * is a valid date including number of specific days in a month and with 
     * February 29th leap year checking.  This format String also can check for 
     * valid time of day entry.
     * 
     * @param dob the date of birth of a user
     * @return a boolean value indicating if the date of birth is valid
     */
    public static boolean validateDOB(String dob)
    {
        return dob.matches("^(?=\\d)(?:(?:(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})|(?:0?2(\\/|-|\\.)29\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))|(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2}))($|\\ (?=\\d)))?(((0?[1-9]|1[012])(:[0-5]\\d){0,2}(\\ [AP]M))|([01]\\d|2[0-3])(:[0-5]\\d){1,2})?$");
    }
}
