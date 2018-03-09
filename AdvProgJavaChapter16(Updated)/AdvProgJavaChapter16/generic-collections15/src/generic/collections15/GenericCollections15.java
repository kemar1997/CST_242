package generic.collections15;

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

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * A JavaFX application that demonstrates the List control and method
 * Collections.sort().
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections15 extends Application
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
        labelSearch = new Label("Sentence: ");
        
        textFieldSearch = new TextField();
        textFieldSearch.setPrefWidth(350);
        
        HBox hBoxSearch = new HBox(labelSearch, textFieldSearch);
                
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(430, 275);
        textAreaResults.setStyle("-fx-font-family: 'Courier New'");
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Search ArrayList");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, hBoxSearch, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 450, 350);

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
        
        Map<String, Integer> map = new HashMap();
        
        createMap(map);
        displayMap(map);
        
        textAreaResults.setText( output.toString() );
    }

    /**
     * 
     * @param map 
     */
    public void createMap(Map<String, Integer> map)
    {
        String[] tokens = textFieldSearch.getText().toLowerCase().split(" ");
        
        for (String word : tokens)
        {            
            if ( map.containsKey(word) )
            {
                int count = map.get(word);
                map.put(word, count + 1);
            }
            else
            {
                map.put(word, 1);
            }
        }
    }
    
    /**
     * 
     * @param map 
     */
    public void displayMap(Map<String, Integer> map)
    {
        Set<String> keys = map.keySet();
        
        TreeSet<String> sortedKeys = new TreeSet(keys);
        
        for (String key : sortedKeys)
        {
            output.append( String.format("%-10s%10s%n", key, map.get(key) ) );
        }
        
        output.append("\nmap.size: ");
        output.append( map.size() );
        output.append("    map.isEmpty(): ");
        output.append( map.isEmpty() );
        
    }
    
    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
