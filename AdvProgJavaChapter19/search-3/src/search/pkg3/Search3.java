package search.pkg3;

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
import static javafx.application.Application.launch;

/**
 * A JavaFX application that demonstrates a binary search.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class Search3 extends Application 
{
    TextField textFieldSearchKey;
    TextArea textAreaResults;
    Button buttonSearch;

    int[] values;
    StringBuilder output;

    /**
     * Creates a JavaFX window with a TextField for input and a TextArea and 
     * a Button with an event handler method that demonstrates a binary search.
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
        textAreaResults.setPrefSize(480, 275);
        textAreaResults.setEditable(false);
        textAreaResults.setStyle("-fx-font-family: 'Courier New'");

        buttonSearch = new Button("Search");
        buttonSearch.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonSearch.setOnAction( e -> start(e) );

        VBox vBoxSort = new VBox(10, hBoxInput, textAreaResults, buttonSearch);
        vBoxSort.setPadding( new Insets(10) );
        vBoxSort.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxSort, 500, 350);

        primaryStage.setTitle("Binary Search");
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
        values = new int[15];

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
            
            output = new StringBuilder();

            int result = search(lookup);
            
            output.append("The number is ");
            output.append(result);
            
            textAreaResults.setText( output.toString() );
        }
           catch (NumberFormatException ex)
        {
            textAreaResults.setText("Must be an integer");
        }

        catch (IndexOutOfBoundsException ex)
        {
            textAreaResults.setText(output + "\nNumber not found");
        }

        catch (Exception ex)
        {
            textAreaResults.setText( ex.getMessage() );
        }
    }

    /**
     * Performs a binary search of the array.  Returns the matching element
     * or throws an IndexOutOfBoundsException if the search fails.
     *
     * @param searchKey the search key to lookup in the array
     *
     * @throws IndexOutOfBoundsException if the search fails
     */
    private int search(int searchKey) throws IndexOutOfBoundsException
    {
        int low = 0;
        int high = values.length - 1;
        int middle = (low + high + 1) / 2;
        int index = -1;

        do
        {
            remainingElements(low, middle, high);
            
            if ( searchKey == values[middle] )
            {
                index = middle;
            }
            else if ( searchKey < values[middle] )
            {
            	high = middle - 1;
            }
            else // if ( lookup > value[middle] )
            {
                low = middle + 1;
            }

            middle = (low + high + 1) / 2;

        } while ( low <= high && index == -1 );

        return values[index];
    }
    
    /**
     * Displays the current elements in the array being searched and the 
     * middle location of those elements.  An asterisk (*) is displayed
     * below the middle location.
     * 
     * @param low current low end of the array being searched
     * @param middle current middle location of the array being searched
     * @param high current high end of the array being searched
     */
    private void remainingElements(int low, int middle, int high)
    {
        for (int index = 0; index < low; index++)
        {
            output.append("   ");
        }
        
        for (int index = low; index <= high; index++)
        {
            output.append( String.format("%02d ", values[index]) );
            //output.append(" ");
        }
        
        output.append("\n");
        
        for (int i = 0; i < middle; i++)
        {
            output.append("   ");
        }
            
        output.append(" * ");
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