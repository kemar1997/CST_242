package javafx.application1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * A JavaFX application that calculates and displays the option values and 
 * total price for that car.  It demonstrates RadioButtons and CheckBoxes along
 * with their related properties and event handlers.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class JavaFXApplication1 extends Application
{
    private RadioButton rbBase;
    private RadioButton rbSport;
    private RadioButton rbDeluxe;
    private ToggleGroup group;

    private CheckBox chkExtend;
    private CheckBox chkRust;

    private Button btnCalculate;

    private Label lblTitle;
    private Label lblBase;
    private Label lblExtra;
    private Label lblTotal;

    private VBox vBoxRadio;
    private VBox vBoxCheck;
    private VBox vBoxResults;
  
    /**
     * Creates a JavaFX window with RadioButtons and CheckBoxes that gets information
     * about ordering a car and calculates and displays the option value prices and 
     * total price for that car.
     * 
     * @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage)
    {
        // Make the heading Label and format

        lblTitle = new Label("Order Your Car Today!");
        lblTitle.setMinWidth(580);
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setFont( new Font("Comic Sans MS", 28) );
        lblTitle.setTextFill( Color.web("#683200") );
        
        // Create the RadioButtons; set their ToggleGroup and event handler
        // Precheck the first RadioButton ("Base Model") as the default
        // Place the RadioButtons into the first VBox

        rbBase = new RadioButton("Base Model $17,500");
        rbBase.setOnAction( e -> handleClickAction(e) );
        rbBase.setSelected(true);

        rbSport = new RadioButton("Sport Model $19,700");
        rbSport.setOnAction( e -> handleClickAction(e) );
        
        rbDeluxe = new RadioButton("Deluxe Model $23,100");
        rbDeluxe.setOnAction( e -> handleClickAction(e) );

        group = new ToggleGroup();
        group.getToggles().addAll(rbBase, rbSport, rbDeluxe);

        vBoxRadio = new VBox(20, rbBase, rbSport, rbDeluxe);
        vBoxRadio.setPadding( new Insets(10) );
        
        // Create the CheckBoxes and the "Calculate" Button, and set their event handler
        // Place the CheckBoxes and Button into the second VBox

        chkExtend = new CheckBox("Extended Warranty: add $500");
        chkExtend.setOnAction( e -> handleClickAction(e) );

        chkRust = new CheckBox("Rust Undercoating: add $850");
        chkRust.setOnAction( e -> handleClickAction(e) );

        btnCalculate = new Button("     Calculate Total     ");
        btnCalculate.setOnAction( e -> handleClickAction(e) );

        vBoxCheck = new VBox(20, chkExtend, chkRust, btnCalculate);
        vBoxCheck.setPadding( new Insets(10) );

        // Make the output Labels and place them into the third VBox

        lblBase = new Label("Base: \t$");
        lblExtra = new Label("Extras: \t$");
        lblTotal = new Label("Total: \t$");

        vBoxResults = new VBox(20, lblBase, lblExtra, lblTotal);
        vBoxResults.setPadding( new Insets(10) );

        // Instantiate the GridPane, format and insert nodes and layout objects into it

        GridPane grid = new GridPane();

        grid.addRow(0, lblTitle);
        GridPane.setColumnSpan(lblTitle, 3);
        GridPane.setHalignment(lblTitle, HPos.CENTER);

        grid.addRow(1, vBoxRadio, vBoxCheck, vBoxResults);

        // Instantiate the Scene, set the properties for the Stage and set the Scene into it

        Scene scene = new Scene(grid, 600, 185);

        primaryStage.setTitle("Car Order Form");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Evaluates which RadioButtons and CheckBoxes are selected, and calculates
     * and displays the base price option values and the total price for a car.
     * 
     * @param event the ActionEvent parameter
     */
     private void handleClickAction(ActionEvent event) 
     {
         int base, extra = 0;

         // RadioButtons for the car "model"
         if ( rbBase.isSelected() ) 
         {
             base = 17500;
         }
         else if ( rbSport.isSelected() ) 
         {
             base = 19700;
         } 
         else // if ( rbDeluxe.isSelected() )
         {
             base = 23100;
         }   
         
        // CheckBoxes for the "extras"
         if ( chkRust.isSelected() ) 
         {
             extra += 850;
         }
         if ( chkExtend.isSelected() ) 
         {
             extra += 500;
         }

         lblBase.setText("Base: \t$" + base);
         lblExtra.setText("Extras: \t$" + extra);
         lblTotal.setText("Total: \t$" + (base + extra) );
     }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * Method main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().

     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
