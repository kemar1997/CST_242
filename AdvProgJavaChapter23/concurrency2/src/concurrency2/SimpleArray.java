package concurrency2;

import java.util.Random;
import java.util.Arrays;

/**
 * A class that manages an integer array to be shared by multiple threads 
 * with synchronization.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2008
 */
public class SimpleArray 
{
    private final int array[]; // The shared integer array
    private int writeIndex;    // The index of next element to be written
    private final Random randomGenerator;

    /**
     * Constructs a SimpleArray object of type 'int' of a specified size and
     * initializes the writeIndex to zero (0).
     * 
     * @param size the size of the array
     */
    public SimpleArray(int size)
    {
        array = new int[size];
        writeIndex = 0;
        
        randomGenerator = new Random();
    }

    /**
     * Adds a value to an element of the shared array after the thread is put 
     * to sleep for between zero (0) to 499 milliseconds. The method is synchronized 
     * so the next task must wait until the current method is finished with the 
     * method and releases the lock.
     * 
     * @param value the value added to the shared array
     */
    public synchronized void add(int value)
    {
        int position = writeIndex; 

        try
        {
            Thread.sleep( randomGenerator.nextInt(500) );
        }

        catch (InterruptedException ex)
        {
            System.out.printf("%n%sterminated prematurely due to interruption%n", Thread.currentThread().getName() );
            Thread.currentThread().interrupt(); // re-interrupt the thread 
        }

        array[position] = value;

        System.out.printf("%s wrote %d to element %d%n%n", Thread.currentThread().getName(), value, position);

        writeIndex++;
    }

    /**
     * Returns the contents of the array as a String.
     * 
     * @return the array values
     */
    @Override
    public String toString()
    {
        return Arrays.toString(array);
    }
}
