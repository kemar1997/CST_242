package concurrency2;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executes two Runnable objects to add elements to a shared SimpleArray.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2008
 */
public class Concurrency2 
{
    /**
     * Constructs the shared array object, create two Runnable tasks to write 
     * to the shared SimpleArray object, execute the tasks with an ExecutorService
     * object and prints the print contents of the array when the tasks are
     * complete.  Displays an error message if it takes one minute for both 
     * writers to finish executing.  May throw an InterruptedException for 
     * the ExecutorService's awaitTermination() method.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        SimpleArray sharedSimpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown();

        try 
        {
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) 
            {
                System.out.println(sharedSimpleArray);
            }
            else 
            {
                System.out.println("Timed out while waiting for tasks to finish.");
            }
        } 
        catch (InterruptedException ex) 
        {
            System.out.println("Interrupted while waiting for tasks to finish.");
        }
    }
}
