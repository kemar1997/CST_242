package javafx.application3;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A JavaFX application that calculates and displays gross pay for an employee.  
 * It demonstrates Sliders along with their related properties and event handlers.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 

 */
public class JavaFXApplication3 extends Application 
{
    private DecimalFormat twoDecimals;

    private Label lblHeader;
    private Label lblHoursHeader;
    private Label lblHours;
    private Label lblRateHeader;
    private Label lblRate;
    private Label lblResults;
    
    private Slider sliderHours;
    private Slider sliderRate;
    
    private FlowPane flowHours;
    private FlowPane flowRate;
    
    private VBox vBoxSliders;
    private VBox vBoxResults;
    
    private Button btnCalculate;
  
    /**
     * Creates a JavaFX window with Sliders that get information about an employee's
     * hours worked and pay rate, and calculates the employee's gross pay.
     * 
     * @param primaryStage a Stage window object

     */
    @Override
    public void start(Stage primaryStage) 
    {
        // Instantiates a DecimalFormat object to format the Labels linked to the Sliders
        
        twoDecimals = new DecimalFormat("0.00");
        
        // Make the heading Label and format

        lblHeader = new Label("Calculate Gross Pay");
        lblHeader.setMinWidth(595);
        lblHeader.setAlignment(Pos.CENTER);
        lblHeader.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 28px; -fx-text-fill: white; -fx-background-color: rgb(104, 50, 0); -fx-font-weight: bold; ");

        // Instantiate and format the "hours worked" Slider and the elements linked to it
        // The "hours worked" Slider and Label are placed side by side in a FlowPane
        
        lblHoursHeader = new Label("Hours worked");
        
        sliderHours = new Slider(0.0, 60.0, 40.0);
        sliderHours.setShowTickMarks(true);
        sliderHours.setShowTickLabels(true);
        sliderHours.setMajorTickUnit(5.0);
        sliderHours.setMinorTickCount(4);
        sliderHours.setPrefWidth(350);
        sliderHours.setOnMouseDragged( e -> updateHoursSlider(e) );
        
        lblHours = new Label( twoDecimals.format( sliderHours.getValue() ) );
        
        flowHours = new FlowPane(sliderHours, lblHours);
        flowHours.setHgap(10);
        
        // Instantiate and format the "rate of pay" Slider and the elements linked to it
        // The "rate of pay" Slider and Label are placed side by side in a FlowPane
        
        lblRateHeader = new Label("Rate of pay");
        
        sliderRate = new Slider(10.00, 25.00, 15.00);
        sliderRate.setShowTickMarks(true);
        sliderRate.setShowTickLabels(true);
        sliderRate.setMajorTickUnit(3.0);
        sliderRate.setPrefWidth(350);
        sliderRate.setOnMouseDragged( e -> updateRateSlider(e) );
        
        lblRate = new Label( twoDecimals.format( sliderRate.getValue() ) );
        
        flowRate = new FlowPane(sliderRate, lblRate);
        flowRate.setHgap(10);
        
        // Place the Sliders and related elements into the "sliders" VBox
        
        vBoxSliders = new VBox(7, lblHoursHeader, flowHours, lblRateHeader, flowRate);
        vBoxSliders.setMinWidth(400);
        vBoxSliders.setPadding( new Insets(10) );
        
        // Instantiate the "results" Label and "calculate" Button
        // Place those elements into the "results" VBox and format
        
        lblResults = new Label("Gross pay:");
        
        btnCalculate = new Button("Calculate Pay");
        btnCalculate.setStyle("-fx-background-color: tan; -fx-font-weight: bold; -fx-text-fill: white;");
        btnCalculate.setOnAction( e -> handleClickAction(e) );

        vBoxResults = new VBox(35, lblResults, btnCalculate);
        vBoxResults.setPadding( new Insets(15) );
        vBoxResults.setPrefWidth(175);
        vBoxResults.setStyle("-fx-background-color: cornsilk; -fx-border-color: black; -fx-border-radius: 10;");

        // Instantiate the GridPane
        // Insert the heading Label into the first row
        // Insert the "slider" and "result" VBoxes into the second row
        
        GridPane grid = new GridPane();

        grid.addRow(0, lblHeader);
        GridPane.setColumnSpan(lblHeader, 2);
        GridPane.setHalignment(lblHeader, HPos.CENTER);

        grid.addRow(1, vBoxSliders, vBoxResults);
        
        // Instantiate the Scene, set the properties for the Stage and set the Scene into it
        // Show the PrimaryStage
        
        Scene scene = new Scene(grid, 590, 200);
        
        primaryStage.setTitle("Payee Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Updates the Label for hours worked when a MouseDragged event occurs for 
     * the "hours worked" Slider.
     * 
     * @param event the MouseEvent parameter
     */
    private void updateHoursSlider(MouseEvent e)
    {
        lblHours.setText( twoDecimals.format( sliderHours.getValue() ) );
    }
    
    /**
     * Updates the Label for rate of pay when a MouseDragged event occurs for 
     * the "rate of pay" Slider.
     * 
     * @param event the MouseEvent parameter
     */
    private void updateRateSlider(MouseEvent event)
    {
        lblRate.setText( twoDecimals.format( sliderRate.getValue() ) );
    }
    
    /**
     * Gets input from the hours worked and rate of pay Sliders, calculates
     * gross pay with or without overtime.  Displays gross pay in the "result"
     * Label.
     * 
     * @param event the ActionEvent parameter

     */
    private void handleClickAction(ActionEvent e)
    {
        double hoursWorked = sliderHours.getValue();
        double rateOfPay = sliderRate.getValue();
        double grossPay;
        
        if (hoursWorked > 40)
        {
            grossPay = (40 * rateOfPay * 1.5) + ( (hoursWorked - 40) * rateOfPay);
        }
        else
        {
            grossPay = hoursWorked * rateOfPay;
        }
        
        lblResults.setText( String.format("Gross pay: $%.2f", grossPay) );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
