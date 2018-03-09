package generic.collections11;

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
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

/**
 * A JavaFX application that demonstrates the Set interface and HashSet class.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections11 extends Application 
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
        textAreaResults.setPrefSize(380, 125);
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 400, 200);

        primaryStage.setTitle("Set Collections");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates a SortedSet object from a TreeSet constructor and demonstrates 
     * its methods.
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();
        
        Integer[] numbers = {8, 3, 6, 4, 7, 10, 14, 13, 6, 1, 8, 10, 3};
        List<Integer> list = Arrays.asList(numbers);
        
        output.append("List: ");
        output.append(list);
        output.append("\n");

        // Instantiate a SortedSet tree and display it
        
        printNonDuplicates(list);
        
        textAreaResults.setText( output.toString() );
    }
    
    /**
     * Create and display a Set object from a Collection interface  
     * to eliminate duplicates.
     * 
     * @param values the Collection<Integer> object
     */
    public void printNonDuplicates(Collection<Integer> values)
    {
        Set<Integer> set = new HashSet(values);
        
        output.append("Nonduplicates are: ");
        
        for (Integer value : set)
        {
            output.append(value);
            output.append("  ");
        }
    }
    
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
