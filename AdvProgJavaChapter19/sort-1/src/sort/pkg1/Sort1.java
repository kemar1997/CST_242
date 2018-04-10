package sort.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * A JavaFX application that demonstrates methods Arrays.sort() and Arrays.toString().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West (First version - 2011)
 */
public class Sort1 extends Application 
{
    TextArea textAreaResults;
    Button buttonSearch;

    int[] values;
    StringBuilder output;

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
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 175);
        textAreaResults.setEditable(false);

        buttonSearch = new Button("Sort");
        buttonSearch.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonSearch.setOnAction( e -> start(e) );

        VBox vBoxSort = new VBox(10, textAreaResults, buttonSearch);
        vBoxSort.setPadding( new Insets(10) );
        vBoxSort.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxSort, 400, 250);

        primaryStage.setTitle("Arrays Class Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Instantiates an 'int' array of ten elements and assigns random values 
     * to each element, after which it calls the toString() method of class 
     * Arrays to display the array, sorts the array and then displays the array
     * once more.
     *
     * @param event the ActionEvent parameter
     */
    private void start(ActionEvent event) 
    {
        values = new int[10];

        for (int ctr = 0; ctr < values.length; ctr++) 
        {
            values[ctr] = (int) Math.floor(1 + Math.random() * 100);
        }
            
        output = new StringBuilder();

        output.append("Before the sort: ");
        output.append( Arrays.toString(values) );
        output.append("\n\n");

        Arrays.sort(values);
        output.append("After the sort: ");
        output.append( Arrays.toString(values) );
            
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