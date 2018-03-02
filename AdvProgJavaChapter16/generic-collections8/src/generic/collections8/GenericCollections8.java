package generic.collections8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

/**
 * A JavaFX application that demonstrates the List control and method
 * Collections.sort().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections8 extends Application 
{
    Label labelSearch;
    TextField textFieldSearch;
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
        labelSearch = new Label("Guess a name: ");
        
        textFieldSearch = new TextField();
        
        HBox hBoxSearch = new HBox(labelSearch, textFieldSearch);
                
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 175);
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Search ArrayList");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, hBoxSearch, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 400, 250);

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
        
        String[] names = {"philip", "sarah", "darleen", "karen", "bobby", "aaron", "patty"};
        List<String> list = new ArrayList( Arrays.asList(names) );
        
        output.append(list);

        String key = textFieldSearch.getText();
        output.append( String.format("%nSearching for %s%n", key) );
        int result = Collections.binarySearch(list, key);
        
        if (result >= 1)
        {
            output.append( String.format("Found at index %d%n", result) );
        }
        else
        {
            output.append( String.format("Not found (%d)", result) );
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
