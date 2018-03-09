package generic.collections9;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * A JavaFX application that demonstrates the List control and method
 * Collections.sort().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections9 extends Application 
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
        
        Random random = new Random();
        
        Integer[] numbers = new Integer[5];
        
        for (int ctr = 0; ctr < numbers.length; ctr++)
        {
            numbers[ctr] = random.nextInt(10) + 1;
        }
        
        List<Integer> list1 = Arrays.asList(numbers);
        output.append("Before addAll() list1 contains: ");
        output.append(list1);

        ArrayList<Integer> list2 = new ArrayList();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        output.append("\nBefore addAll() list2 contains: ");
        output.append(list2);

        boolean disjoint = Collections.disjoint(list1, list2);
        String haveOrNot = (disjoint ? "do not have" : "have");
        output.append( String.format("%n%nlist1 and list2 %s elements in commom%n", haveOrNot) );
        
        Collections.addAll(list2, numbers);
        output.append("\nAfter addAll() list1 contains: ");
        output.append(list1);
        output.append("\nAfter addAll() list2 contains: ");
        output.append(list2);
        
        int frequency = Collections.frequency(list2, 2);
        output.append( String.format("%n%nFrequency of %d in list2: %d", 2, frequency) );
        
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
