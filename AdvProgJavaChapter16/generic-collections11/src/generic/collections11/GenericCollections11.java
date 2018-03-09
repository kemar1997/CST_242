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

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A JavaFX application that demonstrates the SortedTree and TreeSet classes.
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
     * Creates a SortedSet interface from a TreeSet class and demonstrates 
     * its methods.
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();
        
        Integer[] numbers = {8, 3, 6, 4, 7, 10, 14, 13, 6, 1, 8};

        // Instantiate a SortedSet tree and display it
        SortedSet<Integer> tree = new TreeSet( Arrays.asList(numbers) );
        output.append("Sorted Set:   ");
        printSet(tree);
        
        // Display the head of the SortedSet tree starting a 8
        output.append("Head set at 8:   ");
        printSet( tree.headSet(8) );

        // Display the tail of the SortedSet tree starting a 8
        output.append("Tail set at 8:   ");
        printSet( tree.tailSet(8) );
        
        // Display the first and last elements of the SortedSet tree
        output.append("First:   ");
        output.append( tree.first() );
        output.append("\nLast:   ");
        output.append( tree.last() );
        
        textAreaResults.setText( output.toString() );
    }
    
    /**
     * Iterates through and displays the elements of a SortedSet object.
     * 
     * @param set a SortedSet object instantiated from a TreeSet constructor.
     */
    public void printSet(SortedSet<Integer> set)
    {
        for (int value : set)
        {
            output.append(value);
            output.append("   ");
        }
        
        output.append("\n");
    }
    
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
