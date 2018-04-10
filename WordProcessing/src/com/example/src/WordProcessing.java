/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author kemar
 */
public class WordProcessing extends Application {
    
    TextArea taWordProcessing;
    
    TextField tfFind;
    TextField tfReplace;
    
    Label lblFind;
    Label lblReplace;
    
    Button btnFind;
    Button btnReplace;
    
    VBox vbTextArea;
    VBox vbTextFields;
    
    HBox hb1;
    HBox hb2;
    
    HBox hbButtons;
    
    @Override
    public void start(Stage primaryStage) {
        
        taWordProcessing = new TextArea();
        taWordProcessing.setPrefSize(380, 375);
        taWordProcessing.setPadding( new Insets(10) );
        
        vbTextArea = new VBox(15, taWordProcessing);
        vbTextArea.setPadding( new Insets(10) );
        
        tfFind = new TextField();
        tfReplace = new TextField();
        
        lblFind = new Label("Find: ");
        lblReplace = new Label("Replace: ");
        
        hb1 = new HBox();
        hb1.getChildren().addAll(lblFind, tfFind);
        hb1.setSpacing(10);
        
        hb2 = new HBox();
        hb2.getChildren().addAll(lblReplace, tfReplace);
        hb2.setSpacing(10);
        
        vbTextFields = new VBox(10, hb1, hb2);
        vbTextFields.setPadding( new Insets(10) );
        
        btnFind = new Button();
        btnFind.setText("Find");
        btnFind.setOnAction((ActionEvent e) -> {
            try {
                FindStringEvent(e);
            } catch (EmptyStringException ex) {}
        });
        btnReplace = new Button();
        btnReplace.setText("Replace");
        
        hbButtons = new HBox(10, btnFind, btnReplace);
        hbButtons.setPadding( new Insets(10) );
        
        
        GridPane grid = new GridPane();
        grid.addRow(0, vbTextArea, vbTextFields);
        grid.addRow(1, hbButtons);
        
        Scene scene = new Scene(grid, 650, 500);
        
        primaryStage.setTitle("Word Processor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void FindStringEvent(ActionEvent e) throws EmptyStringException {
        FindAndReplace findAndReplace;
        findAndReplace = new FindAndReplace();
        
        int ex = findAndReplace.findString();
        
        JOptionPane.showMessageDialog(null, ex);
    }
}
