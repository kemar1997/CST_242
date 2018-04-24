package concurrency3;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.stage.Stage;

/**
 * 
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018
 */
public class Concurrency3 extends Application
{

    private Label labelGetFibonacciOf;
    private Label labelMessage;
    private Label labelFibonacci;
    private Label labelNth;
    private Label labelNthFibonacci;

    private TextField textFieldNumber;

    private Button buttonGo;
    private Button buttonNextNumber;

    private GridPane gridPaneWithFibonacciTask;
    private GridPane gridPaneWithoutFibonacciTask;

    private TitledPane titledPaneWithFibonacciTask;
    private TitledPane titledPaneWithoutFibonacciTask;

    private VBox vBoxFibonacciNumbers;
    private VBox vBoxWithFibonacciTaskLabels;

    // Values for calculating Fibonacci without FibonacciTask
    private long n1;
    private long n2;
    private int number;

    /**
     * 
     * 
     * @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage)
    {
        n1 = 0; // initialize with Fibonacci of 0 
        n2 = 1; // initialize with Fibonacci of 1
        number = 1; // current Fibonacci number to display

        labelGetFibonacciOf = new Label("Get Fibonacci of:");
        textFieldNumber = new TextField();
        textFieldNumber.setPrefWidth(150);

        buttonGo = new Button("Go");
        buttonGo.setPrefSize(150, 32);
        buttonGo.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        buttonGo.setOnAction( e -> buttonGoPressed(e) );

        labelMessage = new Label("");
        labelFibonacci = new Label("");

        vBoxWithFibonacciTaskLabels = new VBox(1, labelMessage, labelFibonacci);

        gridPaneWithFibonacciTask = new GridPane();
        gridPaneWithFibonacciTask.setHgap(15);
        gridPaneWithFibonacciTask.setVgap(15);
        GridPane.setHalignment(labelGetFibonacciOf, HPos.RIGHT);

        gridPaneWithFibonacciTask.add(labelGetFibonacciOf, 0, 0);
        gridPaneWithFibonacciTask.add(textFieldNumber, 1, 0);
        gridPaneWithFibonacciTask.add(buttonGo, 0, 1);
        gridPaneWithFibonacciTask.add(vBoxWithFibonacciTaskLabels, 1, 1);

        titledPaneWithFibonacciTask = new TitledPane("With FibonacciTask", gridPaneWithFibonacciTask);
        titledPaneWithFibonacciTask.setCollapsible(false);

        labelNth = new Label("Fibonacci of n:");
        labelNthFibonacci = new Label();

        buttonNextNumber = new Button("Next Number");
        buttonNextNumber.setPrefSize(150, 32);
        buttonNextNumber.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        buttonNextNumber.setOnAction( e -> buttonNextNumberPressed(e) );

        gridPaneWithoutFibonacciTask = new GridPane();
        gridPaneWithoutFibonacciTask.setHgap(15);
        gridPaneWithoutFibonacciTask.setVgap(15);
        GridPane.setHalignment(labelNth, HPos.RIGHT);

        gridPaneWithoutFibonacciTask.add(labelNth, 0, 0);
        gridPaneWithoutFibonacciTask.add(labelNthFibonacci, 1, 0);
        gridPaneWithoutFibonacciTask.add(buttonNextNumber, 0, 1);

        titledPaneWithoutFibonacciTask = new TitledPane("Without FibonacciTask", gridPaneWithoutFibonacciTask);
        titledPaneWithoutFibonacciTask.setCollapsible(false);

        vBoxFibonacciNumbers = new VBox(0, titledPaneWithFibonacciTask, titledPaneWithoutFibonacciTask);

        Scene scene = new Scene(vBoxFibonacciNumbers, 350, 270);

        primaryStage.setTitle("Fibonacci Numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Get the Fibonacci number to calculate from the TextField, instantiate, 
     * configure and launch FibonacciTask (implements Task), and get the result 
     * value from the task and displays it in labelFibonacci when the task 
     * completes successfully.  Catches a NumberFormatException if input to 
     * the TextField is not an 'int'.
     * 
     * @param event the ActionEvent parameter
     */
    private void buttonGoPressed(ActionEvent event)
    {
        try
        {
            int input = Integer.parseInt( textFieldNumber.getText() );

            FibonacciTask task = new FibonacciTask(input);

            // Binds the text of labelMessage to the task's messages 
            labelMessage.textProperty().bind( task.messageProperty() );

            // When the task begins ...
            task.setOnRunning( (succeededEvent) ->
            {
                labelFibonacci.setText("");
                buttonGo.setDisable(true);
            } );
            
            // When the task completes successfully ...
            task.setOnSucceeded( (succeededEvent) ->
            {
                labelFibonacci.setText( String.format("%,d", task.getValue() ) );
                buttonGo.setDisable(false);
            } );
            
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();
        } 
        catch (NumberFormatException ex)
        {
            textFieldNumber.setText("Enter an integer");
            textFieldNumber.selectAll();
            textFieldNumber.requestFocus();
        }
    }

    /**
     * Calculates and displays the next Fibonacci value.
     *
     * @param event the ActionEvent parameter
     */
    private void buttonNextNumberPressed(ActionEvent event)
    {
        labelNth.setText( String.format("Fibonacci of %d:", number) );
        labelNthFibonacci.setText( String.format("%,d", n2) );
        long temp = n1 + n2;
        n1 = n2;
        n2 = temp;
        number++;
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
