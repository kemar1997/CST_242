package generic.collections7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A JavaFX application that demonstrates the List control and method
 * Collections.sort().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections7 extends Application 
{
    TextArea textAreaResults;
    Button buttonCollectionTest;
    StringBuilder output;

    /**
     * Creates a JavaFX window with a TextArea and a Button with an event
     * handler method that demonstrates test output for collections operations.
     *
     * @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage) 
    {
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 375);
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 400, 450);

        primaryStage.setTitle("Collections.sort()");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a List of Double values from an array and sort it both in forward
     * and reverse. Display the List before sorting and then again at each
     * operation sort (forward and reverse).
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();
        
        Random random = new Random();
        
        Double[] numbers = new Double[3];
        
        for (int ctr = 0; ctr < numbers.length; ctr++)
        {
            numbers[ctr] = random.nextDouble();
        }
        
        List<Double> list = Arrays.asList(numbers);
        outputList("The list contains:\n", list);
        
        Collections.reverse(list);
        outputList("\nAfter calling reverse(), the list contains:\n", list);
        
        Double[] numbersCopy = new Double[3];
        List<Double> copyList = Arrays.asList(numbersCopy);
        Collections.copy(copyList, list);
        outputList("\nAfter calling copy(), new List copyList contains:\n", copyList);
        
        double number = Double.parseDouble(JOptionPane.showInputDialog("Enter a final number") );
        Collections.fill(list, number);
        outputList("\nAfter calling fill(), the list contains:\n", list);

        textAreaResults.setText( output.toString() );
    }
    
    /**
     * 
     * @param list 
     */
    private void outputList(String message, List<Double> list)
    {
        output.append(message);
        output.append("    The list is: ");
        
        for (double element : list)
        {
            output.append( String.format("%.2f  ", element) );
        }
        
        output.append( String.format("%n    Max: %.2f  ", Collections.max(list) ) );
        output.append( String.format("Min: %.2f%n", Collections.min(list) ) );
    }

    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
