package project05_cst242;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A JavaFX application that demonstrates the Comparator interface and the
 * compare() method.
 * 
 * @author Kemar, Woonnie, Sophia
 */
public class Project05_CST242 extends Application {
    
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
    public void start(Stage primaryStage) {
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(380, 375);
        textAreaResults.setEditable(false);
        
        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; "
                + "-fx-background-color: midnightblue; -fx-font-weight: bold;");
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
     * Create a List of Person objects and sort using a Comparator object.
     * 
     * @param event the ActionEvent parameter
     */
     private void collectionTest(ActionEvent event) {
         output = new StringBuilder();

         List<Person> list = new ArrayList();
         
         list.add( new Person("John", 'W', "Doe") );
         list.add( new Person("Jane", 'H', "Doe") );
         list.add( new Person("Lacy", 'D', "Jones") );
         list.add( new Person("Kemar", 'T', "Golding") );
         
         output.append("Unsorted array elements:\n");
         displayList(list);
         
         Collections.sort( list, new PersonComparator() );
         
         output.append("\nSorted array elements:\n");
         displayList(list);

         textAreaResults.setText( output.toString() );
     }
     
     public void displayList(List list) {
        Iterator personIterator = list.iterator();
        
         while ( personIterator.hasNext() )
        {
            output.append( personIterator.next() );
            output.append(" ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
