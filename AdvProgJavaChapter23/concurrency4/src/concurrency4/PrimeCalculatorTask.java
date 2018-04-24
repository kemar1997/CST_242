package concurrency4;

import java.util.Arrays;
import javafx.concurrent.Task;

/**
 * Task subclass (extends class Task) calculating the first n primes in the 
 * background, publishing them as they are found.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018
 */
public class PrimeCalculatorTask extends Task
{
    private final boolean[] primes; // boolean array for finding primes
    
    /**
     * Instantiates the boolean array so the size of the max parameter, and 
     * initializes every primes element to true.
     * 
     * @param max the maximum number to search for primes
     */
    public PrimeCalculatorTask(int max)
    {
        primes = new boolean[max];
        Arrays.fill(primes, true);
    }
    
    /**
     * The long-running code to be run in a worker thread.
     * 
     * @return 
     */
    @Override
    protected Integer call()
    {
        int count = 0;
        
        // starting at index 2 (the first prime number), cycle through and 
        // set to false elements with indices that are multiples of i 
        for (int i = 2; i < primes.length; i++) 
        {
            if ( isCancelled() ) 
            {
                // if calculation has been canceled
                updateMessage("Cancelled");
                return 0;
            }
            else 
            {
                try 
                {
                    Thread.sleep(100); // slow the thread
                }
                catch (InterruptedException ex)
                {
                    updateMessage("Interrupted");
                    return 0;
                }
                
                updateProgress(i + 1, primes.length);
                
                if ( primes[i] ) 
                { // i is prime
                    count++;
                    updateMessage( String.format("Found %d primes", count) );
                    updateValue(i); // intermediate result
                    
                    // eliminate multiples of i
                    for (int j = i + i; j < primes.length; j += i) 
                    {
                        primes[j] = false; // i is not prime
                    }
                }
            } 
        }
        
        return 0;
    } // the number of primes found
}
