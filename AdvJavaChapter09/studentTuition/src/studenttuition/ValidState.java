package studenttuition;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * The ValidState class provides static methods for validating state names and abbreviations.
 * 
 * @author Carl B. Struck
 * @version  Copyright 2018 (c) SCCC West
 */ 
public class ValidState
{
    /** 
     * Determines if the state parameter field is contained in the list of
     * 50 valid state abbreviations or the District of Columbia (DC).
     * 
     * @param state the state abbreviation
     * @return A boolean value indicating if the state parameter is a valid
     *         state abbreviation
     */
    public static boolean isValidAbbrevation(String state)
    {
        ArrayList<String> stateAbbreviations = new ArrayList<String>();

        String[] abbreviations =
            {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL",
             "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
             "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
             "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
             "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
             "WY"};

        Collections.addAll(stateAbbreviations, abbreviations);
        
        if ( stateAbbreviations.indexOf(state) == -1 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
