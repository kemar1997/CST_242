
package javafx.application2;

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
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A JavaFX application that calculates and displays the option values and 
 * total price for that car.  It demonstrates RadioButtons and CheckBoxes along
 * with their related properties and event handlers as well as the TitledPane
 * control.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West 
 */
public class JavaFXApplication2 extends Application 
{
    private RadioButton rbBase;
    private RadioButton rbSport;
    private RadioButton rbDeluxe;
    private ToggleGroup group;

    private CheckBox chkExtend;
    private CheckBox chkRust;

    private Button btnCalculate;

    private Label lblBase;
    private Label lblExtra;
    private Label lblTotal;
    private Label lblHeader;

    private VBox vBoxRadio;
    private VBox vBoxCheck;
    private VBox vBoxInputs;
    private VBox vBoxResults;
    
    private TitledPane titledPaneRadio;
    private TitledPane titledPaneCheck;

    /**
     * Creates a JavaFX window with RadioButtons and CheckBoxes within TitledPanes 
     * that gets information about ordering a car and calculates and displays the 
     * option values and total price for that car.
     * 
     * @param primaryStage a Stage window object
     */
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Make the header Label and format using CSS formatting

        lblHeader = new Label("Order Your Car Today!");
        lblHeader.setMinWidth(350);
        lblHeader.setAlignment(Pos.CENTER);
        lblHeader.setStyle("-fx-font-family: 'Comic Sans MS'; "
                + "-fx-font-size: 28px; -fx-text-fill: white; "
                + "-fx-background-color: rgb(104, 50, 0); "
                + "-fx-font-weight: bold; ");

        // Create the RadioButtons and set their ToggleGroup
        // Precheck the first RadioButton ("Base Model") as the default
        // Place the RadioButtons into the first VBox and the VBox into a TitledPane

        rbBase = new RadioButton("Base $17,500");
        rbSport = new RadioButton("Sport $19,700");
        rbDeluxe = new RadioButton("Deluxe $23,100");

        group = new ToggleGroup();
        group.getToggles().addAll(rbBase, rbSport, rbDeluxe);
        
        rbBase.setSelected(true);

        vBoxRadio = new VBox(20, rbBase, rbSport, rbDeluxe);
        vBoxRadio.setPadding( new Insets(10) );

        titledPaneRadio = new TitledPane("Model", vBoxRadio);
        
        // Create the CheckBoxes and place them into the second VBox
        // Place the VBox into a second TitledPane
        // Place the two TitledPanes into the VBox on the left side of the GridPane

        chkExtend = new CheckBox("Extended Warranty $500");
        chkRust = new CheckBox("Rust Undercoating $850");
        
        vBoxCheck = new VBox(20, chkExtend, chkRust);
        vBoxCheck.setPadding( new Insets(10) );
        
        titledPaneCheck = new TitledPane("Extras", vBoxCheck);

        vBoxInputs = new VBox(0, titledPaneRadio, titledPaneCheck);

        // Create the "Calculate" Button, and set its event handler
        // Format the Button using CSS formatting
        // Place the Button into the third VBox

        btnCalculate = new Button("    Calculate    ");
        btnCalculate.setStyle("-fx-background-color: tan; -fx-font-weight: bold; -fx-text-fill: white;");
        btnCalculate.setOnAction( e -> handleClickAction(e) );
        
        // Create the output Labels and place them into the third VBox along with the Button
        // Format the VBox using CSS formatting

        lblBase = new Label("Base: \t$");
        lblExtra = new Label("Extras: \t$");
        lblTotal = new Label("Total: \t$");

        vBoxResults = new VBox(50, lblBase, lblExtra, lblTotal, btnCalculate);
        vBoxResults.setPrefWidth(140);
        vBoxResults.setPrefHeight(270);
        vBoxResults.setPadding( new Insets(10) );
        vBoxResults.setStyle("-fx-background-color: cornsilk; -fx-border-color: black; -fx-border-radius: 10;");

        // Instantiate the GridPane and format it
        // Insert the heading Label into the first row
        // Insert the "input" and "result" VBoxes into the second row

        GridPane grid = new GridPane();

        grid.addRow(0, lblHeader);
        GridPane.setColumnSpan(lblHeader, 3);
        GridPane.setHalignment(lblHeader, HPos.CENTER);

        grid.addRow(1, vBoxInputs, vBoxResults);

        // Instantiate the Scene, set the properties for the Stage and set the Scene into it
        // Show the PrimaryStage
       
        Scene scene = new Scene(grid, 350, 310);

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
