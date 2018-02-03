package shapes;

/**
 * The Rectangle class definition.
 * Implements method draw() which is abstract in class Shape.
 * Sets and maintains a length and width for the rectangle.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) 2008 -- SCCC West
 */
public final class Rectangle extends Shape
{
    // The length and width of the rectangle
    private int length;
    private int width;

    /**
     * Constructor passes default values of all zeros to 
     * Rectangle(int, int, int, int, String) constructor.
     */
    public Rectangle()
    {
        this(0, 0, 0, 0, "");
    }
    
    /**
     * Constructor sets length and width of the rectangle and passes the point 
     * where it will draw to the Shape superclass constructor.
     * 
     * @param x the x-coordinate where the shape draws
     * @param y the y-coordinate where the shape draws
     * @param length the length of the rectangle
     * @param width the width of the rectangle
     * @param color a String that represents the color of the rectangle
     */      
    public Rectangle(int x, int y,int length, int width, String color)
    {
        super(x, y, color);
        setLength(length);
        setWidth(width);
    }

    /**
     * Sets the length of the rectangle. The parameter must be greater than zero (0) 
     * or equal to zero (zero is the default).
     * 
     * @param length the radius of the rectangle
     */
    public void setLength(int length)
    {
        if (length >= 0)
        {
            this.length = length;
        }
    }

    /**
     * Sets the width of the rectangle. The parameter must be greater than zero (0) 
     * or equal to zero (zero is the default).
     * 
     * @param width the radius of the rectangle
     */
    public void setWidth(int width)
    {
        if (width >= 0)
        {
            this.width = width;
        }
    }

    /**
     * Returns the length of the rectangle.
     * 
     * @return the length of the rectangle.
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Returns the width of the rectangle.
     * 
     * @return the width of the rectangle.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Returns the length and width of the rectangle.
     * 
     * @return the dimensions of the rectangle.
     */
    @Override
    public String dimensions()
    {
        return "Draw rectangle with sides " + getLength () + "\u00D7" + getWidth();
    }
}
