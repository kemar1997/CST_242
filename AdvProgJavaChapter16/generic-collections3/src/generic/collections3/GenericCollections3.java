package generic.collections3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Arrays;

/**
 * A JavaFX application that demonstrates methods of the LinkedList control 
 * and method Arrays.asList().
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class GenericCollections3 extends Application 
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
        
        primaryStage.setTitle("LinkedList and toArray()");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a LinkedList of Double values from an array and add elements to the
     * list using methods of the class LinkedList.  Afterwards the LinkedList
     * is copied back to the array and displayed to the TextArea.
     * 
     * @param event the ActionEvent parameter
     */
     private void collectionTest(ActionEvent event) 
     {
         output = new StringBuilder();

         // Create a LinkedList of Double values using method Arrays.asList()
         Double[] numbers = {3.1, 4.9, 8.8};
         LinkedList<Double> links = new LinkedList( Arrays.asList(numbers) );
         
         links.addFirst(1.5);
         links.add(9.2);
         links.addLast(10.0);
         links.add(2, 4.0);
         
         numbers = links.toArray( new Double[ links.size() ] );
         
         for (double number : numbers)
         {
             output.append(number);
             output.append("\n");
         }
         
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