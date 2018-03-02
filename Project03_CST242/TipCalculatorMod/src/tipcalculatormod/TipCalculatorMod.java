/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculatormod;

import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author goldk55
 */
public class TipCalculatorMod extends Application {
    
    private Label lblHeader;
    private Label lblResults;
    private Label lblTipPercent;
    
    private DecimalFormat twoDecimals;
    
    private Slider sliderTipPercentage;
    
    private Button btnCalculate;
    
    private ListView listView;
    
    private VBox vBoxListView;
    private VBox vBoxResults;
    private VBox vBoxSliders;
    
    private ObservableList<String> items;
    private ObservableList<Integer> prices;
    
    @Override
    public void start(Stage primaryStage) {
        // Make heading label
        lblHeader = new Label("Get Order Data");
        lblHeader.setMinWidth(790);
        lblHeader.setAlignment(Pos.CENTER);
        
        // Instantiate Decimal Format
        twoDecimals = new DecimalFormat("0.00%");
        
        // Instantiate 10 Order objects
        
        Order ord1 = new Order("White Rice", 3);
        Order ord2 = new Order("Orange Chicken", 6);
        Order ord3 = new Order("Beef & Broccoli", 3);
        Order ord4 = new Order("Chicken Teriyaki Stir Fry", 7);
        Order ord5 = new Order("Vegatable Fried Rice", 4);
        Order ord6 = new Order("Shrimp Egg Roll", 2);
        Order ord7 = new Order("Fried Baby Shrimp", 6);
        Order ord8 = new Order("Brown Rice", 3);
        Order ord9 = new Order("Pork Fried Rice", 5);
        Order ord10 = new Order("Shrimp Fried Rice", 7);
        
        // Instantiate on ObservableList of items from the Order class
        // Instantiate an ObservableList of prices from the Order class
        
        items = FXCollections.observableArrayList( ord1.getItem(),
                ord2.getItem(), ord3.getItem(), ord4.getItem(),
                ord5.getItem(), ord6.getItem(), ord7.getItem(),
                ord8.getItem(), ord9.getItem(), ord10.getItem());
        
        prices = FXCollections.observableArrayList(
                ord1.getPrice(), ord2.getPrice(), ord3.getPrice(), 
                ord4.getPrice(), ord5.getPrice(), ord6.getPrice(), 
                ord7.getPrice(), ord8.getPrice(), ord9.getPrice(), 
                ord10.getPrice());
        
        // Create a ListView of Strings from the ObservableList populated from 
        // get methods of the Orders object
        
        listView = new ListView(items);
        
        // Place the ListView into the "ListView" VBox
        vBoxListView = new VBox(0, listView);
        vBoxListView.setPadding( new Insets(10) );
        vBoxListView.setPrefWidth(300);
        
        // Instantiate the tip percentage Slider
        sliderTipPercentage = new Slider(.15,.20, 1.0);
        sliderTipPercentage.setShowTickMarks(true);
        sliderTipPercentage.setShowTickLabels(true);
        sliderTipPercentage.setOnMouseDragged( e -> updatePercentSlider(e) );
        
        lblTipPercent = new Label( twoDecimals.format(sliderTipPercentage.getValue()) );
        
        vBoxSliders = new VBox(8, sliderTipPercentage, lblTipPercent);
        vBoxSliders.setPadding( new Insets(10) );
        vBoxSliders.setMaxWidth(400);
        
        // Instantiate a button to calculate the "total bill" and a result 
        // Label
        
        btnCalculate = new Button("    Calculate    ");
        btnCalculate.setOnAction(e -> handleClickAction(e) );
        btnCalculate.setAlignment(Pos.CENTER);
        
        lblResults = new Label( "Total: " );
        
        vBoxResults = new VBox(5, btnCalculate, lblResults);
        vBoxResults.setPadding( new Insets(10) );
        
        GridPane grid = new GridPane();
        grid.addRow(0, lblHeader);
        grid.addRow(1, vBoxListView);
        grid.addRow(2, vBoxSliders);
        grid.addRow(3, vBoxResults);
        
        Scene scene = new Scene(grid, 800, 250);
        
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void updatePercentSlider(javafx.scene.input.MouseEvent e) {
        lblTipPercent.setText( twoDecimals.format( sliderTipPercentage.getValue() ) );
    }
    
    private void handleClickAction(ActionEvent e) {
        double salesTax = 0.8625;
        
        int index = listView.getSelectionModel().getSelectedIndex();
        double a = (prices.get(index) * salesTax) + (sliderTipPercentage.getValue() * prices.get(index));
        double result = Math.round(a * 100.0) / 100.0;
        
        lblResults.setText("Total Bill: " + result);
    }
    
}
