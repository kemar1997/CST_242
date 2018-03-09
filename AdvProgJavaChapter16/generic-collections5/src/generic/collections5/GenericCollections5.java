package generic.collections5;

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
import java.util.Iterator;
import java.util.Collections;

/**
 * A JavaFX application that demonstrates the Comparator interface and the
 * compare() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class GenericCollections5 extends Application 
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
     * Create a List of Age objects and sort using a Comparator object.
     * 
     * @param event the ActionEvent parameter
     */
     private void collectionTest(ActionEvent event) 
     {
         output = new StringBuilder();

         List<Age> list = new ArrayList();
         
         list.add( new Age(21, 0, 10) );
         list.add( new Age(20, 7, 12) );
         list.add( new Age(18, 9, 23) );
         list.add( new Age(20, 3, 5) );
         list.add( new Age(18, 2, 8) );
         list.add( new Age(20, 11, 11) );
         
         output.append("Unsorted array elements:\n");
         displayList(list);
         
         Collections.sort( list, new AgeComparator() );
         
         output.append("\nSorted array elements:\n");
         displayList(list);

         textAreaResults.setText( output.toString() );
     }
    
    public void displayList(List list)
    {
        Iterator ageIterator = list.iterator();
        
         while ( ageIterator.hasNext() )
        {
            output.append( ageIterator.next() );
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
