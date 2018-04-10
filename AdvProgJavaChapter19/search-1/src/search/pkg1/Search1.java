package search.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * A JavaFX application that demonstrates a linear search.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West (First version - 2011)
 */
public class Search1 extends Application 
{
    TextField textFieldSearchKey;
    TextArea textAreaResults;
    Button buttonSearch;

    int[] values;

    /**
     * Creates a JavaFX window with a TextField for input and a TextArea and 
     * a Button with an event handler method that demonstrates a linear search.
     * Starts by instantiating an 'int' array of ten elements.
     * 
     * @param primaryStage a Stage window object 
     */
    @Override
    public void start(Stage primaryStage) 
    {
        initArray();
        
        textFieldSearchKey = new TextField();
        textFieldSearchKey.setPrefWidth(100);
        
        HBox hBoxInput = new HBox(10, new Label("Enter search value"), textFieldSearchKey);
        hBoxInput.setPadding( new Insets(10) );
        hBoxInput.setAlignment(Pos.CENTER);
        
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 175);
        textAreaResults.setEditable(false);

        buttonSearch = new Button("Search");
        buttonSearch.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonSearch.setOnAction( e -> start(e) );

        VBox vBoxSearch = new VBox(10, hBoxInput, textAreaResults, buttonSearch);
        vBoxSearch.setPadding( new Insets(10) );
        vBoxSearch.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxSearch, 400, 250);

        primaryStage.setTitle("Linear Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Instantiates an 'int' array of ten elements and assigns random values 
     * to each element.  Sorts the array and then calls the toString() method 
     * of class Arrays which returns and displays a String representation of 
     * the 'values' array.
     */
    private void initArray()
    {
        values = new int[10];

        for (int ctr = 0; ctr < values.length; ctr++)
        {
            values[ctr] = (int) Math.floor( 1 + Math.random() * 100 );
        }
        
        Arrays.sort(values);
        
        System.out.println( Arrays.toString(values) );
    }

    /**
     * Gets a search key value from a TextField, searches for a matching value
     * in the 'values' array and displays the value if found in the TextArea.
     * Displays an error message if the array search fails. 
     *
     * @param event the ActionEvent parameter
     * 
     * @throws NumberFormatException if input from the TextField is not an 'int'
     * @throws Exception for any other unforeseen exception
     */
    private void start(ActionEvent event) 
    {
        try
        {
            int lookup = Integer.parseInt( textFieldSearchKey.getText() );
            
            int index = search(lookup);
            
            textAreaResults.setText( 
                    String.format("The number at index %d is %d ", index, values[index]) );            
        }
           catch (NumberFormatException ex)
        {
            textAreaResults.setText("Must be an integer");
        }

        catch (IndexOutOfBoundsException ex)
        {
            textAreaResults.setText("Number not found");
        }

        catch (Exception ex)
        {
            textAreaResults.setText( ex.getMessage() );
        }
    }

    /**
     * Performs a linear search of the array.  Returns the matching element
     * or throws an IndexOutOfBoundsException if the search fails.
     *
     * @param lookup the search key to lookup in the array
     *
     * @throws IndexOutOfBoundsException if the search fails
     */
    private int search(int lookup) throws IndexOutOfBoundsException
    {
        int index = 0;

        while (index < values.length && lookup != values[index] )
        {
             index ++;
        }

        return values[index];
    }
    
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}