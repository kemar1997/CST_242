package concurrency1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService; 

/**
 * Class that uses an ExecutorService to execute Runnable objects.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2008
 */
public class Concurrency1 
{
    /**
     * Create and name three runnable PrintTask objects, create an 
     * ExecutorService to manage the threads, start the PrintTasks running, 
     * and instruct the ExecutorService to shut down the threads when it 
     * decides to do so.
     * 
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        PrintTask task1 = new PrintTask("Task 1");
        PrintTask task2 = new PrintTask("Task 2");
        PrintTask task3 = new PrintTask("Task 3");
        
        System.out.println("Starting Executor\n"); 
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        
        executorService.shutdown();
        
        System.out.println("Tasks started, main() method completes.\n"); 
    }
    
}
