package regular.expressions.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A JavaFX application that gets information from a user for a new account.  It 
 * demonstrates validation with regular expressions and the String.matches() method.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class RegularExpressions1 extends Application 
{
    Label labelHeader;

    Label labelFirstName;
    Label labelLastName;
    Label labelUserID;
    Label labelPassword;
    Label labelPasswordAgain;
    Label labelPhone;
    Label labelSocSecNumber;
    Label labelEmail;
    Label labelDOB;
    
    Label lblResults;
    
    TextField textFieldFirstName;
    TextField textFieldLastName;
    TextField textFieldUserID;
    PasswordField passwordFieldPassword;
    PasswordField passwordFieldPasswordAgain;
    TextField textFieldPhone;
    TextField textFieldSocSecNumber;
    TextField textFieldEmail;
    TextField textFieldDOB;
    
    TextArea textAreaResults;
    
    Button buttonResults;
    
    /**
     * Creates a JavaFX window with TextFields and PasswordFields that gets 
     * information from a user for a new account.
     * 
     * @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage) 
    {
        labelHeader = new Label("Enter New User Account Info");
        labelHeader.setMinWidth(750);
        labelHeader.setAlignment(Pos.CENTER);
        labelHeader.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 24px; -fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        
        labelFirstName = new Label("First name:");
        labelFirstName.setPrefWidth(175);
        labelLastName = new Label("Last name:");
        labelLastName.setPrefWidth(175);
        labelUserID = new Label("User ID:");
        labelUserID.setPrefWidth(175);
        labelPassword = new Label("Password (>= 8 chars):");
        labelPassword.setPrefWidth(175);
        labelPasswordAgain = new Label("Password again:");
        labelPasswordAgain.setPrefWidth(175);
        labelPhone = new Label("Phone:");
        labelPhone.setPrefWidth(175);
        labelSocSecNumber = new Label("Social security #:");
        labelSocSecNumber.setPrefWidth(175);
        labelEmail = new Label("E-mail:");
        labelEmail.setPrefWidth(175);
        labelDOB = new Label("Date of birth:");
        labelDOB.setPrefWidth(175);
        
        textFieldFirstName = new TextField();
        textFieldLastName = new TextField();
        textFieldUserID = new TextField();
        passwordFieldPassword = new PasswordField();
        passwordFieldPasswordAgain = new PasswordField();
        textFieldPhone = new TextField();
        textFieldSocSecNumber = new TextField();
        textFieldEmail = new TextField();
        textFieldDOB = new TextField();
        
        GridPane gridInputs = new GridPane();
        gridInputs.setVgap(5);
        
        gridInputs.addRow(0, labelFirstName, textFieldFirstName);
        gridInputs.addRow(1, labelLastName, textFieldLastName);
        gridInputs.addRow(2, labelUserID, textFieldUserID);
        gridInputs.addRow(3, labelPassword, passwordFieldPassword);
        gridInputs.addRow(4, labelPasswordAgain, passwordFieldPasswordAgain);
        gridInputs.addRow(5, labelPhone, textFieldPhone);
        gridInputs.addRow(6, labelSocSecNumber, textFieldSocSecNumber);
        gridInputs.addRow(7, labelEmail, textFieldEmail);
        gridInputs.addRow(8, labelDOB, textFieldDOB);
        
        VBox vBoxInputs = new VBox(5, gridInputs);
        vBoxInputs.setPadding( new Insets(10) );
        
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(340, 325);
        textAreaResults.setEditable(false);
        
        buttonResults = new Button("Submit");
        buttonResults.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-font-weight: bold;");
        buttonResults.setOnAction( e -> createAccount(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonResults);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();
        
        grid.addRow(0, labelHeader);
        GridPane.setColumnSpan(labelHeader, 3);

        grid.addRow(1, vBoxInputs, vBoxResults);
        
        Scene scene = new Scene(grid, 750, 375);
        
        primaryStage.setTitle("New User Input Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Evaluates input from the TextField and PasswordField input boxes against
     * the static method of class ValidateInput.  Displays error messages inside
     * a TextArea object.
     * 
     * @param event the ActionEvent parameter
     */
     private void createAccount(ActionEvent event) 
     {
         StringBuilder output = new StringBuilder();
         
         output.append("");
         
         if (! ValidateInput.validateFirstName( textFieldFirstName.getText() ) )
         {
             output.append("Invalid first name\n");
         }
         
         if (! ValidateInput.validateLastName( textFieldLastName.getText() ) )
         {
             output.append("Invalid last name\n");
         }
         
         if (! ValidateInput.validateUserID( textFieldUserID.getText() ) )
         {
             output.append("User ID must be 8 or more alphabetic characters\n");
         }
         
         if (! ValidateInput.validatePassword( passwordFieldPassword.getText() ) )
         {
             output.append("Password must be 8 or more characters\n");
         }

         if (! ValidateInput.validatePasswordAgain(passwordFieldPassword.getText(), 
                 passwordFieldPasswordAgain.getText() ) )
         {
             output.append("Passwords do not match\n");
         }
         
         if (! ValidateInput.validatePhone( textFieldPhone.getText() ) )
         {
             output.append("Invalid phone number\n");
         }
         
         if (! ValidateInput.validateSocSecNumber( textFieldSocSecNumber.getText() ) )
         {
             output.append("Soc sec # must be in the format 999-99-9999\n");
         }
         
         if (! ValidateInput.validateEmail( textFieldEmail.getText() ) )
         {
             output.append("Invalid e-mail address\n");
         }
         
         if (! ValidateInput.validateDOB( textFieldDOB.getText() ) )
         {
             output.append("Invalid date of birth\n");
         }
         
         if (output.toString().length() == 0)
         {
             output.append("Account created");
         }
         
         textAreaResults.setText( output.toString() );
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
