package generic.collections14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * A JavaFX application that demonstrates the Map interface and the HashMsp, 
 * TreeMap and LinkedHashMap classes.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections14 extends Application
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
        textAreaResults.setPrefSize(780, 125);
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Collection Test");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 800, 200);

        primaryStage.setTitle("Set Collections");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create three objects of the Map interface, one each from the HashMsp, 
     * TreeMap and LinkedHashMap class constructors. The generic types for
     * the Map are String (key is town names) and Integer (key is ZIP codes).
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();
        
        // Create Map object from the HashMap constructor
        Map<String, Integer> map1 = new HashMap();
        
        map1.put("Brentwood", 11717);
        map1.put("Hauppaugue", 11788);
        map1.put("Bayshore", 11706);
        map1.put("Deer Dark", 11729);
        map1.put("Islip", 11751);
        
        output.append("HashMap:  ");
        displayMap(map1);
        
        // Create Map object from the TreeMap constructor
        Map<String, Integer> map2 = new TreeMap();
        
        map2.put("Brentwood", 11717);
        map2.put("Hauppaugue", 11788);
        map2.put("Bayshore", 11706);
        map2.put("Deer Dark", 11729);
        map2.put("Islip", 11751);
        
        output.append("TreeMap:  ");
        displayMap(map2);
        
        // Create Map object from LinkedHashMap constructor
        Map<String, Integer> map3 = new LinkedHashMap();
        
        map3.put("Brentwood", 11717);
        map3.put("Hauppaugue", 11788);
        map3.put("Bayshore", 11706);
        map3.put("Deer Dark", 11729);
        map3.put("Islip", 11751);
        
        output.append("LinkedHashMap:  ");
        displayMap(map3);
        
        textAreaResults.setText( output.toString() );
    }
    
    /**
     * Iterate through and display the elements of a Map object with Strings 
     * (town names) and Integers (ZIP codes).
     * 
     * @param map a Map object of Strings (town names) and Integers (ZIP codes).
     */
    public void displayMap( Map<String, Integer> map )
    {
        Set<String> keys = map.keySet();
     
        for (String key : keys)
        {
            output.append(key);
            output.append("-");
            output.append( map.get(key) );
            output.append("   ");
        }

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
