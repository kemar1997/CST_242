package concurrency3;

import javafx.concurrent.Task;

/**
 * The Task subclass (extends class Task) for calculating Fibonacci numbers 
 * in the background.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018
 */
public class FibonacciTask extends Task<Long>
{
    private final int n; // Fibonacci number to calculate
    
    /**
     * Initializes the Fibonacci number to calculate.
     * 
     * @param n the Fibonacci number to calculate
     */
    public FibonacciTask(int n)
    {
        this.n = n;
    }
    
    /**
     * The long-running code to run in a worker thread.
     * 
     * @return the Fibonacci result
     */
    @Override
    protected Long call()
    {
        // Passes message to Graphical User Interface
        updateMessage("Calculating…");
        long result = fibonacci(n);
        updateMessage("Done calculating.");
        return result;
    }
    
    /**
     * Recursive method that calculates nth Fibonacci number.
     * 
     * @param n the Fibonacci number for this recursive instance to calculate
     * @return the Fibonacci result for this recursive instance
     */
    public long fibonacci (long n)
    {
        if (n == 0 || n == 1)
        {
            return n;
        }
        else
        {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
