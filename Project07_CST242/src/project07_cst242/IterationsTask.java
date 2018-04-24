package project07_cst242;

import java.util.Arrays;
import javafx.concurrent.Task;

/**
 * Task subclass (extends class Task) calculating n amount of iterations in the 
 * background, publishing them as they are found.
 *
 * @author Kemar, Woonnie & Sophia
 */
public class IterationsTask extends Task {
    
    private final boolean[] iterations;
    
    /**
     * Instantiates the boolean array so the size of the max parameter, and 
     * initializes every iterations element to true.
     * 
     * @param max the maximum number to search for iterations
     */
    public IterationsTask(int max)
    {
        iterations = new boolean[max];
        Arrays.fill(iterations, true);
    }

    @Override
    protected Integer call() throws Exception {
        int count = 0;
        
        for (int i = 0; i < iterations.length; i++) {
            if ( isCancelled() ) {
                updateMessage("Cancelled");
                return 0;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    updateMessage("Interrupted");
                    return 0;
                }
                
                updateProgress(i + 1, iterations.length);
                
                if ( iterations[i] ) {
                    count++;
                    updateMessage( String.format("Found %d iterations", count) );
                    updateValue(i);
                }
            }
        }
        
        return 0;
    }
    
}
