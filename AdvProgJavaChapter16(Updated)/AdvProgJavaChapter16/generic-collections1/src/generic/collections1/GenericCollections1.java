package generic.collections1;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A JavaFX application that demonstrates elements of the List, ArrayList,
 * Collection and Iterator classes.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections1 extends Application 
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
        vBoxResults.setPadding(new Insets(10));
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 400, 250);

        primaryStage.setTitle("ArrayList and Iterator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * ???
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();

        // Create an ArrayList of Doubles
        double[] numbers = {22.3, 12.7, 40.0, 36.9, 28.8};
        List<Double> list = new ArrayList();

        for (double number : numbers) 
        {
            list.add(number);
        }

        // Create an ArrayList of Doubles to be removed from the first ArrayList
        double[] removeNumbers = {12.7, 40.0, 36.9};
        List<Double> removeList = new ArrayList();

        for (double number : removeNumbers) 
        {
            removeList.add(number);
        }

        // Output the ArrayList to the TextArea
        output.append("ArrayList:\n");

        for (double number : list) 
        {
            output.append(number);
            output.append("  ");
        }

        // Remove from the ArrayList the doubles in the removeList and
        // output the ArrayList to the TextArea again
        removeNumbers(list, removeList);

        output.append("\nArrayList after calling removeNumbers():\n");

        for (double number : list) 
        {
            output.append(number);
            output.append("  ");
        }

        textAreaResults.setText( output.toString() );
    }

    /**
     * Removes the element contained in list2 from list1.
     * 
     * @param list the List of Doubles
     * @param removeList the List of Doubles to be removed from the first List
     */
    private static void removeNumbers( Collection<Double> list, Collection<Double> removeList ) 
    {
        Iterator<Double> iterator = list.iterator();

        while ( iterator.hasNext() ) 
        {
            if ( removeList.contains( iterator.next() ) ) 
            {
                iterator.remove();
            }
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
