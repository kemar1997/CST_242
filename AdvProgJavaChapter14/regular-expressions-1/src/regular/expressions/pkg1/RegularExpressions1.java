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
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Carl
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
    
    VBox vBoxLabels;
    VBox vBoxTextFields;
    VBox vBoxResults;
    
    TextArea textAreaResults;
    
    Button buttonResults;
    
    @Override
    public void start(Stage primaryStage) 
    {
        labelHeader = new Label("Enter New User Account Info");
        labelHeader.setMinWidth(750);
        labelHeader.setAlignment(Pos.CENTER);
        labelHeader.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 24px; -fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        
        labelFirstName = new Label("First name:");
        labelLastName = new Label("Last name:");
        labelUserID = new Label("User ID:");
        labelPassword = new Label("Password (>= 8 chars):");
        labelPasswordAgain = new Label("Password again:");
        labelPhone = new Label("Phone:");
        labelSocSecNumber = new Label("Social security #:");
        labelEmail = new Label("E-mail:");
        labelDOB = new Label("Date of birth:");
        
        vBoxLabels = new VBox(15, labelFirstName, labelLastName, labelUserID, 
                labelPassword, labelPasswordAgain, labelPhone, labelSocSecNumber, 
                labelEmail, labelDOB);
        vBoxLabels.setPadding( new Insets(10) );
        
        textFieldFirstName = new TextField();
        textFieldLastName = new TextField();
        textFieldUserID = new TextField();
        passwordFieldPassword = new PasswordField();
        passwordFieldPasswordAgain = new PasswordField();
        textFieldPhone = new TextField();
        textFieldSocSecNumber = new TextField();
        textFieldEmail = new TextField();
        textFieldDOB = new TextField();
        
        vBoxTextFields = new VBox(5, textFieldFirstName, textFieldLastName, 
                textFieldUserID, passwordFieldPassword, passwordFieldPasswordAgain, 
                textFieldPhone, textFieldSocSecNumber, textFieldEmail, textFieldDOB);
        vBoxTextFields.setPadding( new Insets(10) );
        
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(250, 300);
        textAreaResults.setEditable(false);
        
        buttonResults = new Button("Submit");
        buttonResults.setStyle("-fx-text-fill: white; -fx-background-color: black; -fx-font-weight: bold;");
        buttonResults.setOnAction( e -> createAccount(e) );

        vBoxResults = new VBox(10, textAreaResults, buttonResults);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();
        
        grid.addRow(0, labelHeader);
        GridPane.setColumnSpan(labelHeader, 3);

        grid.addRow(1, vBoxLabels, vBoxTextFields, vBoxResults);
        
        Scene scene = new Scene(grid, 750, 375);
        
        primaryStage.setTitle("New User Input Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Evaluates ... .
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
