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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

        primaryStage.setTitle("Collections Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a List of random Double values and after displaying it once call 
     * methods reverse() copy() and fill() on the list.
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
            numbers[ctr] = 1 + random.nextDouble() * 10;
        }
        
        List<Double> list = Arrays.asList(numbers);
        outputList("The original list:", list);
        
        Collections.reverse(list);
        outputList("\nAfter calling method reverse():", list);
        
        List<Double> copyList = new ArrayList();
        copyList.add(1.0);  // Comment this out for a smaller list
        copyList.add(2.0);
        copyList.add(3.0);

        Collections.copy(list, copyList);
        outputList("\nAfter calling method copy():", list);
        
        Collections.fill(list, 47.0);
        outputList("\nAfter calling method fill():", list);

        textAreaResults.setText( output.toString() );
    }
    
    /**
     * Output the elements of a List of Doubles with a descriptive message.
     * 
     * @param message the descriptive message
     * @param list the List of Doubles
     */
    private void outputList(String message, List<Double> list)
    {
        output.append(message);
        output.append("\n   The list is: ");
        
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
