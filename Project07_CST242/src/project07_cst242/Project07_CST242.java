package project07_cst242;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Publishes a list of iterations to a ListView control as they are discovered.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class Project07_CST242 extends Application {
    
    private TextField tfInput;
    private Button btnGetIterations;
    private HBox hbInput;
    
    private ListView lvIterations;
    
    private Button btnCancel;
    private ProgressBar pb;
    private Label lblStatus;
    
    private HBox hbStatus;
    
    private VBox vbIterations;
    
    private final ObservableList iterations = FXCollections.observableArrayList();
    private IterationsTask task;
    
    @Override
    public void start(Stage primaryStage) {
        
        tfInput = new TextField();
        tfInput.setPrefWidth(125);
        
        btnGetIterations = new Button("Get Iterations");
        btnGetIterations.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        btnGetIterations.setOnAction( e -> btnGetIterationsPressed(e) );
        
        hbInput = new HBox(15, new Label("Find iterations less than:"), tfInput, btnGetIterations);
        hbInput.setStyle("-fx-padding: 5; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 3; -fx-border-color: rgb(176, 176, 176);");
        
        lvIterations = new ListView();
        lvIterations.setPrefSize(380, 150);
        
        btnCancel = new Button("Cancel");
        btnCancel.setStyle("-fx-text-fill: white; -fx-background-color: tan; -fx-font-weight: bold;");
        btnCancel.setOnAction(e -> btnCancelPressed(e) );
        
        pb = new ProgressBar();
        pb.setPrefWidth(160);
        
        lblStatus = new Label("Found 0 Iterations");
        
        hbStatus = new HBox(18, btnCancel, pb, lblStatus);
        hbStatus.setStyle("-fx-padding: 5; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 3; -fx-border-color: rgb(176, 176, 176);");
        
        vbIterations = new VBox(0, hbInput, lvIterations, hbStatus);
        
        Scene scene = new Scene(vbIterations, 400, 250);
        
        primaryStage.setTitle("Find Iterations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Creates a task that gets iterations from the IterationsTask class
     * and displays the results in a ListView control.
     * 
     * @param event the ActionEvent parameter
     */
    private void btnGetIterationsPressed(ActionEvent event) {
        iterations.clear();
        
        lvIterations.setItems(iterations);
        
        try {
            int input = Integer.parseInt( tfInput.getText() );
            task = new IterationsTask(input);
            
            lblStatus.textProperty().bind( task.messageProperty() );
            
            pb.progressProperty().bind( task.progressProperty() );
            
            task.valueProperty().addListener( (observable, oldValue, newValue) -> {
                if ( (int) newValue != 0 ) {
                    iterations.add(newValue);
                    lvIterations.scrollTo( lvIterations.getItems().size() );
                }
            });
            
            task.setOnRunning( (succeededEvent) -> {
                btnGetIterations.setDisable(true);
                btnCancel.setDisable(false);
            });
            
            task.setOnSucceeded( (succeededEvent) -> {
                btnGetIterations.setDisable(false);
                btnCancel.setDisable(true);
            });
            
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();
        } catch (NumberFormatException ex) {
            tfInput.setText("Enter an integer");
            tfInput.selectAll();
            tfInput.requestFocus();
        }
    }
    
    /**
     * Cancel the task when user presses the Cancel Button.
     * 
     * @param event the ActionEvent parameter
     */
    private void btnCancelPressed(ActionEvent event) {
        if (task != null) {
            task.cancel();
            btnGetIterations.setDisable(false);
            btnCancel.setDisable(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
