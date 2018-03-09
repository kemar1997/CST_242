package generic.collections2;

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
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A JavaFX application that demonstrates elements of the List, LinkedList and
 * LinkedIterator classes.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class GenericCollections2 extends Application 
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
        textAreaResults.setPrefSize(950, 325);
        textAreaResults.setEditable(false);
        
        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vBoxResults, 970, 400);
        
        primaryStage.setTitle("LinkedList");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Create two LinkedList String objects of state names, merge them and perform
     * a series of operations on the merged list.  Operations include converting
     * the Strings to all uppercase, deleting elements from the list and displaying
     * the list in reverse order.
     * 
     * @param event the ActionEvent parameter
     */
     private void collectionTest(ActionEvent event) 
     {
         output = new StringBuilder();
         
         // Create a LinkedList of Strings (states)
         String[] states = {"california", "new york", "maryland", "georgia", "wisconson", "virginia"};
         List<String> list1 = new LinkedList();
         
         for (String state : states)
         {
             list1.add(state);
         }
         
         // Create a second LinkedList of Strings (states) and merge them into the first LinkedList
         
         String[] states2 = {"illinois", "oregon", "maine", "south dakota", "alaska", "hawaii"};
         List<String> list2 = new LinkedList();
         
         for (String state : states2)
         {
             list2.add(state);
         }
         
         // Add the second LinkedList to the end of the first LinkedList and print the list
         list1.addAll(list2);
         list2 = null;
         
         output.append("List:\n");
         printList(list1);
         
         // Convert the LinkedList to all uppercase and print the list again
         convertToUppercaseStrings(list1);
         output.append("List to uppercase:\n");
         printList(list1);
         
         // Delete elements from the LinkedList and print the list again
         removeItems(list1, 4, 7);
         output.append("Deleting elements 4 to 6...\nList:\n");
         printList(list1);
         
         // Print the list in reversed order
         output.append("Reversed List:\n");
         printReversedList(list1);
         
         textAreaResults.setText( output.toString() );
     }
     
     /**
      * Outputs the elements of the LinkedList to a StringBuilder object.
      * 
      * @param list1 the LinkedList of Strings (states)
      */
     private void printList( List<String> list1 )
     {
         for (String state : list1)
         {
             output.append(state);
             output.append("  ");
         }
         
         output.append("\n\n");
     }

     /**
      * Converts all the elements of the LinkedList to uppercase
      * 
      * @param list1 the LinkedList of Strings (states) 
      */
     private void convertToUppercaseStrings( List<String> list1 )
     {
         ListIterator<String> iterator = list1.listIterator();
         
         while ( iterator.hasNext() )
         {
             String state = iterator.next();
             iterator.set( state.toUpperCase() );
         }
     }
     
     /**
      * Removes a range of elements from the LinkedList.
      * 
      * @param list1 the LinkedList of Strings (states) 
      * @param start the first element to be removed from the list
      * @param end the last element (exclusive) to be removed from the list
      */
     public void removeItems(List<String> list1, int start, int end)
     {
         list1.subList(start, end).clear();
     }
     
     /**
      * Outputs the elements of the LinkedList in reverse order to a StringBuilder object.
      * 
      * @param list1 the LinkedList of Strings (states) 
      */
     public void printReversedList( List<String> list1 )
     {
         ListIterator<String> iterator = list1.listIterator(list1.size() );
         
         while ( iterator.hasPrevious() )
         {
             output.append( iterator.previous() );
             output.append("  ");
         }
         
         output.append("\n\n");             
     }
     
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
