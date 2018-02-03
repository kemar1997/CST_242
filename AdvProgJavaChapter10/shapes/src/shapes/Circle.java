package shapes;

/**
 * The Circle class definition.
 * Implements method draw() which is abstract in class Shape.
 * Sets and maintains a radius for the circle.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) 2008 -- SCCC West
 */
public final class Circle extends Shape
{
    // The radius of the circle
    private int radius;

    /**
     * Constructor passes default values to Circle(int, int, int, String) constructor.
     */
    public Circle()
    {
        this(0, 0, 0, "");
    }    
    
    /**
     * Constructor sets radius of the circle and passes the point where it
     * will draw to the Shape superclass constructor.
     * 
     * @param x the x-coordinate where the shape draws
     * @param y the y-coordinate where the shape draws
     * @param radius the radius of the circle
     * @param color a String that represents the color of the circle
     */    
    public Circle(int x, int y, int radius, String color)
    {
        super(x, y, color);
        setRadius(radius);
    }

    /**
     * Sets the radius of the circle. The parameter must be greater than zero (0) 
     * or equal to zero (zero is the default).
     * 
     * @param radius the radius of the circle
     */
    public void setRadius(int radius)
    {
        if (radius >= 0)
        {
            this.radius = radius;
        }
    }

    /**
     * Returns the radius of the circle.
     * 
     * @return the radius of the circle.
     */
    public int getRadius()
    {
        return radius;
    }

    /**
     * Returns the radius of the circle.
     * 
     * @return the dimensions of the circle.
     */
    @Override
    public String dimensions()
    {
        return "Draw circle with radius " + getRadius();
    }
}
