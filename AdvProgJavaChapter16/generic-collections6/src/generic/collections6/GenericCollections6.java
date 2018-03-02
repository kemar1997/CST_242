package generic.collections6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * A JavaFX application with a TextArea and a Button that displays a shuffled 
 * deck of cards.
 *
 * @author Prof. Carl B. Struck
 * @version Copyright (c) SCCC Spring 2018 - SCCC West
 */
public class GenericCollections6 extends Application 
{

    TextArea textAreaResults;
    Button buttonCollectionTest;
    StringBuilder output;
    
    /**
     * A nested class that represents one Card in a deck of cards.  The class is
     * static to allow declaration of the Face and Suit enum objects.
     */
    public static class Card
    {
        /**
         * Creates an enum for the Face of all cards in a deck.
         */
        public enum Face 
        {
            Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten,
            Jack, Queen, King
        }
        
        /**
         * Creates an enum for the Suit of all cards in a deck.
         */
        public enum Suit
        {
            Clubs, Diamonds, Hearts, Spades
        }
        
        private final Face face;
        private final Suit suit;
        
        /**
         * Sets the values for the Face and Suit enums which are final.
         * 
         * @param face the face of the Card.
         * @param suit the suit of the Card.
         */
        public Card(Face face, Suit suit)
        {
            this.face = face;
            this.suit = suit;
        }
        
        /**
         * Returns the face of the card.
         * 
         * @return the face of the card.
         */
        public Face getFace()
        {
            return face;
        }

        /**
         * Returns the suit of the card.
         * 
         * @return the suit of the card.
         */
        public Suit getSuit()
        {
            return suit;
        }
        
        /**
         * Returns a String representation of a card.
         * 
         * @return a Card from the deck.
         */
        @Override
        public String toString()
        {
            return String.format("%s of %s", face, suit);
        }
    }
    
    /**
     * A nested class that represents a deck of 52 cards that have been shuffled.
     */
    public class DeckOfCards
    {
        private final List<Card> list;  // List that stores the 52 cards
        
        /**
         * Creates an array of a deck of cards from the Suit and Face enums, 
         * copies the array to a List object and then shuffles the List.
         * Demonstrates the method Collections.shuffle() for the List parameter.
         */
        public DeckOfCards()
        {
            Card[] deck = new Card[52];
            int ctr = 0;
            
            // A for loop with a nested for loop that creates the deck
            for ( Card.Suit suit : Card.Suit.values() )
            {
                for ( Card.Face face : Card.Face.values() )
                {
                    deck[ctr] = new Card(face, suit);
                    ctr++;
                }
            }
            
            // Create the (final) List from the Card[] array and shuffles the deck
            list = Arrays.asList(deck);
            Collections.shuffle(list);
        }
        
        /**
         * Outputs the List of the deck of cards to the StringBuilder.  
         * Advances to a new line after every four cards are drawn.
         */
        public void printCards()
        {
            for (int ctr = 0; ctr < list.size(); ctr++)
            {
                output.append( String.format("%-21s", list.get(ctr) ) );

                if ( (ctr + 1) % 4 == 0)
                {
                    output.append("\n");
                }
            }
        }
    }

    /**
     * Creates a JavaFX window with a TextArea and a Button with an event
     * handler method that demonstrates test output for collections operations.
     *
     * @param primaryStage a Stage window object
     */
    @Override
    public void start(Stage primaryStage) 
    {
        textAreaResults = new TextArea();
        textAreaResults.setPrefSize(780, 325);
        textAreaResults.setStyle("-fx-font-family: 'Courier New'; font-size: large");
        textAreaResults.setEditable(false);

        buttonCollectionTest = new Button("Shuffle");
        buttonCollectionTest.setStyle("-fx-text-fill: white; -fx-background-color: midnightblue; -fx-font-weight: bold;");
        buttonCollectionTest.setOnAction( e -> collectionTest(e) );

        VBox vBoxResults = new VBox(10, textAreaResults, buttonCollectionTest);
        vBoxResults.setPadding(new Insets(10));
        vBoxResults.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBoxResults, 800, 400);

        primaryStage.setTitle("Deck of Card Shuffling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates a shuffled DeckOfCards and displays the list to the TextArea..
     *
     * @param event the ActionEvent parameter
     */
    private void collectionTest(ActionEvent event) 
    {
        output = new StringBuilder();
        
        DeckOfCards cards = new DeckOfCards();
        cards.printCards();

        textAreaResults.setText(output.toString());
    }

    /**
     * @param args the command line String[] array arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
