package strings.miniquiz.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        btn.setAlignment(Pos.CENTER);
        btn.setPadding( new Insets(5) );
        btn.setText("Execute Strings");
        btn.setOnAction( e -> handleClickAction(e) );
        
        GridPane grid = new GridPane();
        grid.addRow(0, tArea);
        grid.addRow(1, btn);
        
        Scene scene = new Scene(grid, 400, 250);
        
        primaryStage.setTitle("String Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * The string method event handler.
     * @param e the ActionEvent parameter
     */
    public void handleClickAction(ActionEvent e) {
        System.out.println("Button Clicked");
    
        StringBuilder output = new StringBuilder();
        
        String s1 = " Welcome ";
        String s2 = " welcome ";
        
        output.append("s1 = \"");
        output.append(s1);
        output.append("\"");
        output.append("\ns2 = \"");
        output.append(s2);
        output.append("\"");
        
        // Test equals() and equalsIgnoreCase()
        output.append("\ns1 equals s2 is ");
        output.append(s1.equals(s2));
        
        output.append("\ns1 equals s2 ignore case is ");
        output.append(s1.equalsIgnoreCase(s2));
        
        // Test compareTo() and compareToIgnoreCase()
        output.append("\ns1 compare to s2 is ");
        output.append(s1.compareTo(s2));
        
        output.append("\ns1 compare to s2 ignore case is ");
        output.append(s1.compareToIgnoreCase(s2));
        
        // Test regionMatches (case sensitive) and regionMatches (ignore case)
        if (s1.regionMatches(0, s2, 0, 5)) {
            output.append("\nFirst five characters of s1 and s2 match");
        } else {
            output.append("\nFirst five characters of s1 and s2 do not match");
        }
        
        if (s1.regionMatches(true, 0, s2, 0, 5)) {
            output.append(
                    "\nFirst five characters of s1 and s2 match with case ignored");
        } else {
            output.append("\nFirst five characters of s1 and s2 do not match");
        }
        
        // Test indexOf and lastIndexOf
        //String s3 = " W";;
        output.append("\ns1 starts with \" W\" is ");
        if (s1.indexOf(" W") == 0) {
            output.append("true");
        }  else {
            output.append("false");
        }
        
        output.append("\ns1 ends with \"e \" is ");
        if (s1.lastIndexOf("e ") == s1.length() - 2) {
            output.append("true");
        } else {
            output.append("false");
        }
        //output.append(s1.indexOf("AAA"));
        
        // More regionMatches() examples
        String s3 = "e ";
        
        output.append("\ns1 starts with ");
        output.append(s3);
        output.append(" is ");
        output.append( s1.regionMatches(0, s3, 0, 3) );
        
        output.append("\ns1 ends with ");
        output.append(s3);
        output.append(" is ");
        output.append( s1.regionMatches( s1.length() - 3 , s3, 0, 3) );
        
        // Test length() and charAt()
        output.append("\ns1 length is ");
        output.append( s1.length() );
        output.append("\ns1 char at 3 is ");
        output.append( s1.charAt(2) );
        
        // Test toUpperCase() and toLowerCase
        output.append("\ns1 converted to lowercase: ");
        output.append( s1.toLowerCase() );
        output.append("\ns1 converted to uppercase: ");
        output.append( s1.toUpperCase() );
        
        // Test the trim() method
        output.append("\ns1 trimmed is |");
        output.append( s1.trim() );
        output.append("|");
        
        /*
        The split() Method
        - Splits a String object into tokens
        - format: stringObject.split(regExpession);
        - regExpression = a demiliter (could be a space or comma)
        - ex: String[] t1 = s1.split(" ");
        */
        
        
        tArea.setText( output.toString() );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
