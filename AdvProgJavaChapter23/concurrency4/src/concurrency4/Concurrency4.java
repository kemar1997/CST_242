package concurrency4;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Publishes a list of primes to a ListView control as they are discovered.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018
 */
public class Concurrency4 extends Application
{
    private TextField textFieldInput;
    private Button buttonGetPrimes;
    private HBox hBoxInput;
    
    private ListView listViewPrimes;
    
    private Button buttonCancel;
    private ProgressBar progressBar;
    private Label labelStatus;
    
    private HBox hBoxStatus;
    
    private VBox vBoxPrimes;
    
    // Stores the list of primes received from PrimeCalculatorTask
    private final ObservableList primes = FXCollections.observableArrayList();
    private PrimeCalculatorTask task; // finds prime numbers
    
    /**
     * 
     ** @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage)
    {
        textFieldInput = new TextField();
        textFieldInput.setPrefWidth(125);
        
        buttonGetPrimes = new Button("Get Primes");
        buttonGetPrimes.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        buttonGetPrimes.setOnAction(e -> buttonGetPrimesPressed(e) );
        
        hBoxInput = new HBox(15, new Label("Find primes less than:"), textFieldInput, buttonGetPrimes);
        hBoxInput.setStyle("-fx-padding: 5; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 3; -fx-border-color: rgb(176, 176, 176);");
        
        listViewPrimes = new ListView();
        listViewPrimes.setPrefSize(380, 150);
        
        buttonCancel = new Button("Cancel");
        buttonCancel.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        buttonCancel.setOnAction(e -> buttonCancelPressed(e) );
        
        progressBar = new ProgressBar();
        progressBar.setPrefWidth(160);
        
        labelStatus = new Label("Found 0 primes");
        
        hBoxStatus = new HBox(18, buttonCancel, progressBar, labelStatus);
        hBoxStatus.setStyle("-fx-padding: 5; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 3; -fx-border-color: rgb(176, 176, 176);");
        
        vBoxPrimes = new VBox(0, hBoxInput, listViewPrimes, hBoxStatus);
        
        Scene scene = new Scene(vBoxPrimes, 400, 250);
        
        primaryStage.setTitle("Find Primes");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates a task that gets primes from the PrimeCalculatorTask class
     * and displays the results in a ListView control.
     * 
     * @param event the ActionEvent parameter
     */
    private void buttonGetPrimesPressed(ActionEvent event)
    {
        // Empties previous contents of the ObservableList primes
        primes.clear();
        // Binds listViewPrimes's items to the ObservableList primes
        listViewPrimes.setItems(primes);
        
        try
        {
            int input = Integer.parseInt( textFieldInput.getText() );
            task = new PrimeCalculatorTask(input);
            
            // Display task's messages in labelStatus
            labelStatus.textProperty().bind( task.messageProperty() );
            
            // Update progressBar based on task's progressProperty
            progressBar.progressProperty().bind( task.progressProperty() );
            
            // Store intermediate results in the ObservableList primes
            task.valueProperty().addListener( (observablee, oldValue, newValue) -> 
            {
                if ( (int) newValue != 0 ) // task returns 0 when it terminates
                {
                    primes.add(newValue);
                    listViewPrimes.scrollTo( listViewPrimes.getItems().size() );
                }
            } );

            // When the task begins ...
            task.setOnRunning( (succeededEvent) -> 
            {
                buttonGetPrimes.setDisable(true);
                buttonCancel.setDisable(false);
            } );
         
            // When the task completes successfully
            task.setOnSucceeded((succeededEvent) -> 
            {
                buttonGetPrimes.setDisable(false);
                buttonCancel.setDisable(true);
            } );
            
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();
        }
        catch (NumberFormatException ex)
        {
            textFieldInput.setText("Enter an integer");
            textFieldInput.selectAll();
            textFieldInput.requestFocus();
        }
    }    
    
    /**
     * Cancel the task when user presses the Cancel Button.
     * 
     * @param event the ActionEvent parameter
     */
    private void buttonCancelPressed(ActionEvent event)
    {
        if (task != null)
        {
            task.cancel(); //terminate the task
            buttonGetPrimes.setDisable(false); 
            buttonCancel.setDisable(true);
        }
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * Method main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     * 
     * @param args the String[] args command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
