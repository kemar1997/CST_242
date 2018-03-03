 package project04_cst242;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 14.22 (Morse Code) Complete this assignment as a JavaFX application with a 
 * Button event handler; 
 * use regular expressions to test whether the user has entered an English-
 * language phrase (only letters and blank spaces) or a Morse code message
 * (only dots (.), dashes (-) and blank spaces) (display an error message for
 * any other invalid input); then perform the appropriate coding or decoding
 * and display the result.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class Project04_CST242 extends Application {
    
    Label lblHeader;
    
    Label lblEnglishPhrase;
    Label lblMorseCodePhrase;
    
    TextField tfEnglishPhrase;
    TextField tfMorseCodePhrase;
    
    Button btnEncode;
    Button btnDecode;
    
    TextArea taResults;
    
    VBox vBoxLabels;
    VBox vBoxTextFields;
    VBox vBoxResults;
    
    
    @Override
    public void start(Stage primaryStage) {
        lblHeader = new Label("Morse Code");
        lblHeader.setMinWidth(750);
        lblHeader.setAlignment(Pos.CENTER);
        lblHeader.getStyleClass().add("lblHeader");
        
        lblEnglishPhrase = new Label("Enter an English Phrase:");
        lblMorseCodePhrase = new Label("Enter a phrase in Morse Code:");
        lblEnglishPhrase.getStyleClass().addAll("labels");
        lblMorseCodePhrase.getStyleClass().addAll("labels");
        
        vBoxLabels = new VBox(15, lblEnglishPhrase, lblMorseCodePhrase );
        vBoxLabels.setPadding( new Insets(10) );
        vBoxLabels.getStyleClass().addAll("vBox");
        
        tfEnglishPhrase = new TextField();
        tfMorseCodePhrase = new TextField();
        
        vBoxTextFields = new VBox(5, tfEnglishPhrase, tfMorseCodePhrase);
        vBoxTextFields.setPadding( new Insets(10) );
        vBoxTextFields.getStyleClass().addAll("vBox");
        
        taResults = new TextArea();
        taResults.setPrefSize(250, 300);
        taResults.setEditable(false);
        
        btnEncode = new Button("Encode");
        btnEncode.setOnAction( e -> encode(e) );
        
        btnDecode = new Button("Decode");
        btnDecode.setOnAction( e -> decode(e) );
        
        vBoxResults = new VBox(10, taResults, btnEncode, btnDecode);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.getStyleClass().addAll("vBox");
        
        
        GridPane grid = new GridPane();
        grid.addRow(0, lblHeader);
        GridPane.setColumnSpan(lblHeader, 3);
        
        grid.addRow(1, vBoxLabels, vBoxTextFields, vBoxResults);
        
        Scene scene = new Scene(grid, 750, 375);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css")
                .toString());
        
        primaryStage.setTitle("Morse Code Encoding / English Language Conversion");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    /**
     * Checks that the English-language phrase contains only letters and spaces.
     * And encodes the phrase into Morse code.
     * 
     * @param event the ActionEvent parameter
     */
    private void encode(ActionEvent event) {
        StringBuilder output = new StringBuilder();
        
        output.append("");
        
        if (! ValidateInput.validateEnglishPhrase( tfEnglishPhrase.getText() )) {
            output.append("Invalid English Phrase\n");
        }
        
        // Must encode the english phrase to Morse Code
        if (output.toString().length() == 0) {
            String c = tfEnglishPhrase.getText().toLowerCase();
            
            for (int x = 0; x < english.length; x++) {
                for (int y = 0; y < c.length(); y++) {
                    if (english[x] == c.charAt(y)) {
                        output.append(morse[x]);
                        output.append(" ");
                    }
                }
            }
            output.append("\nDone");
        }
        
        taResults.setText( output.toString() );
    }
    
    char [] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z'};
        
    String [] morse = { ".-" , "-..." , "-.-." , "-.." , "." , "..-." ,
        "--." , "...." , ".." , ".---" , "-.-" , ".-.." , "--" , "-." ,
        "---" , ".--." , "--.-" ,  ".-." , "..." , "-" , "..-" , "...-" ,
        ".--" , "-..-" , "-.--" , "--.."};
    
    /**
     * Checks if the phrase entered consists of Morse code only then decodes it
     * into the English-language equivalent
     * 
     * @param event the ActionEvent parameter
     */
    private void decode(ActionEvent event) {
        StringBuilder output = new StringBuilder();
        
        output.append("");
        
        if (! ValidateInput.validateMorseCode( tfMorseCodePhrase.getText() )) {
            output.append("Invalid Morse code");
        }
        
        // Must decode the Morse code to the English-language equivalent
        if (output.toString().length() == 0) {
            String b = tfMorseCodePhrase.getText();
            
            String[] words = b.split(" ");
            for (String word : words) {
                String[] characters = word.split(" ");
                
                for (String character : characters) {
                    if (character.isEmpty()) { continue; }
                    for ( int m = 0; m < morse.length; m++ ) {
                        if (character.equals(morse[m])) {
                            output.append(english[m]);
                        }
                    }
                }
            }
            output.append("\nDone");
        }
        
        taResults.setText( output.toString() );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
