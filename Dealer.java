import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    // instance variables - replace the example below with your own
    private Deck deck;
    private int numCardsInDeck;
    private int triplesRemaining;
    private ArrayList <Card> cardsOnBoard;
    private ArrayList <Integer> selectedCardsIndex;
    private Card []cardSelected;
    
   
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck (numCardsInDeck);
    }
    private boolean isaTriple(Card card1, Card card2, Card card3)
    {
        return true;
    }
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
        deck.getTopCard();
        
    }
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        getWorld().addObject(deck.getTopCard(), 100, 50);
        getWorld().addObject(deck.getTopCard(), 100, 120);
        getWorld().addObject(deck.getTopCard(), 100, 190);
        getWorld().addObject(deck.getTopCard(), 100, 260);
        getWorld().addObject(deck.getTopCard(), 100, 330);
        getWorld().addObject(deck.getTopCard(), 230, 50);
        getWorld().addObject(deck.getTopCard(), 230, 120);
        getWorld().addObject(deck.getTopCard(), 230, 190);
        getWorld().addObject(deck.getTopCard(), 230, 260);
        getWorld().addObject(deck.getTopCard(), 230, 330);
        getWorld().addObject(deck.getTopCard(), 360, 50);
        getWorld().addObject(deck.getTopCard(), 360, 120);
        getWorld().addObject(deck.getTopCard(), 360, 190);
        getWorld().addObject(deck.getTopCard(), 360, 260);
        getWorld().addObject(deck.getTopCard(), 360, 330);
    }
    public void setUI()
    {
        Integer cardsRemaining = new Integer (numCardsInDeck - 15);
        Integer score = new Integer (0);
        getWorld().getBackground().drawString(cardsRemaining.toString(), 305, 475);
        getWorld().getBackground().drawString(score.toString(), 308, 510);
    }
    public void endGame()
    {

    }
    public void checkIfTriple()
    {
        
    }
    public void actionIfTriple()
    {
        
    }
    public void setCardsSelected(ArrayList <Card> cardList, ArrayList <Integer> numCardsSelected, Card[] selectedCards)
    {
        
    }
}
    