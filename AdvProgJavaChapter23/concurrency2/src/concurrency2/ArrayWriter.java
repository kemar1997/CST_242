package concurrency2;

/**
 * Adds integers to an array shared with other Runnable objects.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2008
 */
public class ArrayWriter implements Runnable 
{
    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    /**
     * Initializes the starting value for this thread and the array shared 
     * between the threads.
     * 
     * @param startValue the starting value for this thread
     * @param sharedSimpleArray the array shared between the threads
     */
    public ArrayWriter(int startValue, SimpleArray sharedSimpleArray) 
    {
        this.startValue = startValue;
        this.sharedSimpleArray = sharedSimpleArray;
    }

    /**
     * Adds an element to the shared array.
     */
    @Override
    public void run() 
    {
        for (int value = startValue; value < (startValue + 3); value++)
        {
            sharedSimpleArray.add(value);
        }
    }
}
