package javafx.application4;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
public class JavaFXApplication4 extends Application 
{
    private Label lblHeader;
    private Label lblResults;
    
    private ObservableList<String> titles;
    private ObservableList<Book> books;
    
    private ListView<Book> listView;
    
    private VBox vBoxListView;
    private VBox vBoxResults;
        
    @Override
    public void start(Stage primaryStage) 
    {
        // Make the heading Label and format

        lblHeader = new Label("Get Book Data");
        lblHeader.setMinWidth(790);
        lblHeader.setAlignment(Pos.CENTER);
        lblHeader.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 28px; -fx-text-fill: white; -fx-background-color: rgb(104, 50, 0); -fx-font-weight: bold;");

        // Instantiate 10 Book objects
        
        Book book1 = new Book("Ace the IT Resume", "Paula Moreira", 236);
        Book book2 = new Book("C# Tutorial for Beginners", "Joe Sample", 275);
        Book book3 = new Book("Concepts of Database Management", "Philip J. Pratt & Mary Z. Last", 432);
        Book book4 = new Book("Data Structures and Algorithms", "William McAllister", 580);
        Book book5 = new Book("Introduction to IT", "Pearson Computer Science", 275);
        Book book6 = new Book("Introduction to Java Programming", "Y. Daniel Liang", 758);
        Book book7 = new Book("Java How To Program", "Deitel & Deitel", 1390);
        Book book8 = new Book("Learning Processing", "Daniel Shiffman", 564);
        Book book9 = new Book("Murach’s ASP.NET Web Programming", "Mary Delamater and Anne Boehm", 826);
        Book book10 = new Book("Murach's HTML5 and CSS3", "Zak Ruvalcaba and Anne Boehm", 636);
        
        // Instantiate on ObservableList of titles from the Book class
        // Instantiate an ObservableList of Book objects
        
        titles = FXCollections.observableArrayList( book1.getTitle(), 
                book2.getTitle(), book3.getTitle(), book4.getTitle(), 
                book5.getTitle(), book6.getTitle(), book7.getTitle(), 
                book8.getTitle(), book9.getTitle(), book10.getTitle() );

        books = FXCollections.observableArrayList(book1, book2, book3, book4, 
                book5, book6, book7, book8, book9, book10);
        
        // Create a ListView from the "book title" ObservableList 
        // Place the ListView into the "ListView" VBox
        
        listView = new ListView(titles);
        listView.setOnMouseClicked( e -> updateSelectedBook(e) );
        
        vBoxListView = new VBox(0, listView);
        vBoxListView.setPadding( new Insets(10) );
        vBoxListView.setPrefWidth(300);
        
        // Create a "result" Label and place it into the "result" VBox
        
        lblResults = new Label();
        lblResults.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 18px; -fx-font-weight: bold;");
        
        vBoxResults = new VBox(lblResults);
        vBoxResults.setPadding( new Insets(15) );
        vBoxResults.setStyle("-fx-background-color: cornsilk; -fx-border-color: black; -fx-border-radius: 10;");
        
        // Instantiate the GridPane
        // Insert the "heading" Label into the first row
        // Insert the "ListView" and "result" VBoxes into the second row
        
        GridPane grid = new GridPane();

        grid.addRow(0, lblHeader);
        GridPane.setColumnSpan(lblHeader, 2);
        GridPane.setHalignment(lblHeader, HPos.CENTER);

        grid.addRow(1, vBoxListView, vBoxResults);
        
        // Instantiate the Scene, set the properties for the Stage and set the Scene into it
        // Show the PrimaryStage
        
        Scene scene = new Scene(grid, 800, 200);
        
        primaryStage.setTitle("Book Viewer");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Gets the index from the Book "author" ListView control and uses it to
     * access a matching element from the "book" ObservableList and displays
     * that element in the "results" Label.
     * 
     * @param event the ActionEvent parameter
     */
    private void updateSelectedBook(MouseEvent e)
    {
        int index = listView.getSelectionModel().getSelectedIndex();
        lblResults.setText( books.get(index).toString() );
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
