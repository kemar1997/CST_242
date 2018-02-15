package strings.miniquiz.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Test string methods in a JavaFX form with a TextArea and Button.
 *
 * @author Kemar
 * @version 2/15/18
 */
public class StringsMiniQuiz1 extends Application {
    
    private TextArea tArea;
    private Button btn;
    
    @Override
    public void start(Stage primaryStage) {
        tArea = new TextArea();
        tArea.setEditable(false);
        
        btn = new Button();
        btn.setText("Execute Strings");
        btn.setOnAction( e -> handleClickAction(e) );
        
        GridPane grid = new GridPane();
        grid.addRow(0, tArea);
        grid.addRow(1, btn);
        
        Scene scene = new Scene(grid, 300, 250);
        
        primaryStage.setTitle("String Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * The string method event handler.
     * @param e the ActionEvent parameter
     */
    public void handleClickAction(ActionEvent e) {
    
        StringBuilder output = new StringBuilder();
        
        String s1 = " Welcome ";
        String s2 = " welcome ";
        
        output.append("s1 = \"");
        output.append(s1);
        output.append("\"");
        output.append("\ns2 = \"");
        output.append(s2);
        output.append("\"");
        
        tArea.setText( output.toString() );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
