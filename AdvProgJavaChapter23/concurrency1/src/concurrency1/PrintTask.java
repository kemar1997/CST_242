package concurrency1;

import java.util.Random;

/**
 * A PrintTask object sleeps for a random time between 0 and 5 seconds.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2008
 */
public class PrintTask implements Runnable
{
    private final String taskName;
    private final int sleepTime;
    /**
     * Gives the PrintTask object a name and picks a random sleep time 
     * between 0 and 5 seconds (measured in milliseconds).
     * 
     * @param taskName the name given to the task
     */
    public PrintTask(String taskName)
    {
        this.taskName = taskName;
        
        Random randomGenerator = new Random();
        sleepTime = randomGenerator.nextInt(5001);
    }
    
    /**
     * This method contains the code that a thread will execute, in which each 
     * thread is put to sleep for a specified random amount of time and then displays 
     * a message to the console when it is completed.  May throw an InterruptedException 
     * if if the sleeping thread’s interrupt() method is called.
     */
    @Override
    public void run()
    {
        try
        {
            System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException ex)
        {
            System.out.printf("%n%sterminated prematurely due to interruption%n", taskName);
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }
        
        System.out.printf("%s done sleeping%n", taskName);
    }
}
