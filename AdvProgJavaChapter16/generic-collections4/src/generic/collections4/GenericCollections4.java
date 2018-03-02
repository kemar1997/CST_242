package generic.collections4;

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

/**
 * A JavaFX application that demonstrates the List control 
 * and method Collections.sort().
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class GenericCollections4 extends Application 
{
    TextArea textAreaResults;
    Button buttonCollectionTest;
    StringBuilder output;
    
    /**
     * Creates a JavaFX window with a TextArea and a Button with an event handler
     * method that demonstrates test output for collections operations.
     * 
     * @param primaryStage a Stage window object 
     */
    @Override
    public void start(Stage primaryStage) 
    {
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 175);
        textAreaResults.setEditable(false);
        
        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vBoxResults, 400, 250);
        
        primaryStage.setTitle("Collections.sort()");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a List of Double values from an array and sort it both in forward
     * and reverse.  Display the List before sorting and then again at each 
     * operation sort (forward and reverse).
     * 
     * @param event the ActionEvent parameter
     */
     private void collectionTest(ActionEvent event) 
     {
         output = new StringBuilder();
         
         // Create and display a List of Double values
         Double[] numbers = {3.1, 4.9, 8.8, 9.2, 1.5, 4.0};
         List<Double> list = Arrays.asList(numbers);
         output.append("Unsorted array elements: ");
         output.append(list);
         
         // Sort (Collections.sort() method) and display the List again
         Collections.sort(list);
         output.append("\nSorted array elements: ");
         output.append(list);
         
         // Sort in reverse and display the List again
         Collections.sort(list, Collections.reverseOrder() );
         output.append("\nSorted in reverse order: ");
         output.append(list);
         
         textAreaResults.setText( output.toString() );
     }
    
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}