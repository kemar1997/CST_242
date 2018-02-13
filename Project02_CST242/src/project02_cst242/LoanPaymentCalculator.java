package project02_cst242;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Kemar, Woonnie, Sophia
 */
public class LoanPaymentCalculator extends Application {
    
    // Using TextField's for the Amount of Loan and Interest Rate which need to be converted using a parse method
    private TextField amountOfLoan;
    private TextField interestRate;
    
    // Using RadioButton's to assign the years for the college loan repayment
    private RadioButton fiveYears;
    private RadioButton tenYears;
    private RadioButton fifteenYears;
    private RadioButton twentyYears;
    private RadioButton twentyFiveYears;
    private RadioButton thirtyYears;
    private ToggleGroup groupRadioButtons; // Using ToggleGroup to add all the RadioButtons in one section
    
    private VBox vBoxRadio;
    private VBox vBoxMonthlyPayment;
    private VBox vBoxInputs;
    
    // Label that holds the calculation for each of the radio buttons
    private Label lblResult;
    
    // Header Label for application
    private Label lblHeader;
    
    // Button that has an event handler that executes the calculation depending on the amount of years chosen
    private Button btnCalculate;
    
    @Override
    public void start(Stage primaryStage) {
        // Adding the TextFields into a VBox
        amountOfLoan = new TextField("Type amount of loan here...");
        interestRate = new TextField("Enter interest rate here");
        
        vBoxInputs = new VBox(10, amountOfLoan, interestRate);
        vBoxInputs.setPadding( new Insets(10)  );
        
        // Making a header for the application
        lblHeader = new Label("Loan Payment Calculator");
        lblHeader.setPrefWidth(370);
        lblHeader.setAlignment(Pos.CENTER);
        lblHeader.getStyleClass().add("lblHeader");
        
        // Create Radio Buttons and set ToggleGroup
        fiveYears = new RadioButton("5 years");
        tenYears = new RadioButton("10 years");
        fifteenYears = new RadioButton("15 years");
        twentyYears = new RadioButton("20 years");
        twentyFiveYears = new RadioButton("25 years");
        thirtyYears = new RadioButton("30 years");
        
        groupRadioButtons = new ToggleGroup();
        groupRadioButtons.getToggles().addAll(fiveYears, tenYears, fifteenYears, twentyYears, twentyFiveYears, thirtyYears);
        
        vBoxRadio = new VBox(20, fiveYears, tenYears, fifteenYears, twentyYears, twentyFiveYears, thirtyYears);
        vBoxRadio.setPadding( new Insets(10) );
        
        // Create the calculate button and sets its event handler
        btnCalculate = new Button("    Calculate    ");
        btnCalculate.getStyleClass().add("btnCalculate");
        btnCalculate.setOnAction( e -> handleClickAction(e) );
        
        // Create output label and add it in a VBox with the button
        lblResult = new Label();
        
        vBoxMonthlyPayment = new VBox(50, lblResult, btnCalculate);
        vBoxMonthlyPayment.setPadding( new Insets(10) );
        
        // Instantiate the GridPane and format it
        GridPane grid = new GridPane();
        
        grid.addRow(0, lblHeader);
        GridPane.setColumnSpan(lblHeader, 2);
        GridPane.setHalignment(lblHeader, HPos.CENTER);
        
        grid.addRow(1, vBoxInputs);
        grid.addRow(2, vBoxRadio, vBoxMonthlyPayment);
        
        Scene scene = new Scene(grid, 370, 350);
         scene.getStylesheets().add(getClass().getResource("LoanPaymentCalculator.css")
                .toString());
        
        primaryStage.setTitle("Loan Payment Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void handleClickAction(ActionEvent e) {
        int loanAmount = Integer.parseInt( amountOfLoan.getText() );
        double rateOfInterest = Double.parseDouble( interestRate.getText() );
        double monthlyInterestRate = rateOfInterest / 12000;
        double a;
        double result = 0;
        if ( fiveYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 5 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } else if ( tenYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 10 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } else if ( fifteenYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 15 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } else if ( twentyYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 20 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } else if ( twentyFiveYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 25 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } else if ( thirtyYears.isSelected() ) {
            a = loanAmount * monthlyInterestRate / ( 1 - (1 / Math.pow(1 + monthlyInterestRate, 30 * 12)));
            result = Math.round(a * 100.0) / 100.0;
        } 
        
        lblResult.setText("Monthly Payment: $" + result);
    }
    
}
