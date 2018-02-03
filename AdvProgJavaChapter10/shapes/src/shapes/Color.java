package shapes;

/**
 * Methods and constants to be used for colors in a system.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) 2018 -- SCCC West
 */
public interface Color 
{
    //Methods for the color attribute to be implemented in a system.

    void setColor(String color);
    String getColor();

    // String constants for a system's valid colors.

    String[] VALID_COLORS =
    {
        "red", "blue", "green", "yellow", "light blue", "pink"
    };
}
