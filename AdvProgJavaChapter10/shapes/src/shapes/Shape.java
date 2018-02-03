package shapes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Shape abstract class definition.
 * All classes that extend from Shape must implement abstract method draw().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) 2008 -- SCCC West
 */
public abstract class Shape extends Object implements Color
{
    // The x- and y-coordinates where the shape draws.
    // The color is the 'fill" color.
    private int x;
    private int y;
    private String color;

    /**
     * Constructor sets point where the shape draws.
     * 
     * @param x the x-coordinate where the shape draws
     * @param y the y-coordinate where the shape draws
     * @param color a String that represents the color of the shape 
     */
    public Shape(int x, int y, String color)
    {
        setX(x);
        setY(y);
        setColor(color);
    }

    /**
     * Sets the x-coordinate where the shape draws.
     * 
     * @param x the x-coordinate where the shape draws
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Sets the y-coordinate where the shape draws.
     * 
     * @param y the y-coordinate where the shape draws
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Sets the color of the shape as a valid String name.
     * 
     * @param color a String that represents the color of the shape
     */
    @Override
    public void setColor(String color)
    {
        ArrayList<String> validColors = new ArrayList();
        Collections.addAll(validColors, VALID_COLORS);
        
        if ( validColors.indexOf( color.toLowerCase() ) >= 0 )
        {
            this.color = color.toLowerCase();
        }
    }

    /**
     * Returns the x-coordinate where the shape draws.
     * 
     * @return The x-coordinate where the shape draws.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns the y-coordinate where the shape draws.
     * 
     * @return The y-coordinate where the shape draws.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Returns the color of the shape as a valid String name.
     * 
     * @return the color of the shape.
     */
    @Override
    public String getColor()
    {
        return color;
    }

    /**
     * Abstract method definition to return dimension(s) of a subclass shape.
     * 
     * @return dimensions of a shape.
     */
    public abstract String dimensions();

    /**
     * Prints the statistics of a shape to the terminal window.  Calls 
     * this class's method position() to print the position of the shape.
     * Calls a subclass method draw() to print the dimensions of a shape 
     * subclass object to the terminal window (demonstrates 'late binding').
     */
    @Override
    public String toString()
    {
	return 
            dimensions() 
            + "\nPosition at x = " + getX() + ", y = " + getY() 
            + " -- color is " + getColor() + "\n";
    }
}

