import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Dealer here.
 *
 * @author (Lucas Willcuts)
 * @version (2/13/2025)
 */
public class Dealer extends Actor
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Deck deck;
    private ArrayList <Card> cardsOnBoard;
    private ArrayList <Integer> selectedCardsIndex;
    private Card []cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    public boolean shapeType;
    public boolean colorType;
    public boolean numberOfShapesType;
    public boolean shadingType;
   
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
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
        Integer cardsRemaining = new Integer (deck.getNumCardsInDeck());
        Integer score = Scorekeeper.getScore();
        getWorld().showText("" + score, 308, 510);
        getWorld().showText("" + cardsRemaining, 305, 475);
    }
    public void endGame()
    {
       
    }
    public void checkIfTriple(Card []cardsSelected)
    {
        this.cardsSelected = cardsSelected;
        checkShape(cardsSelected);
        checkColor(cardsSelected);
        checkNumberOfShapes(cardsSelected);
        checkShading(cardsSelected);
             if (shapeType || colorType || numberOfShapesType || shadingType)
        {
            actionIfTriple();
        }
         
       
    }
   
    public void checkShape(Card []cardsSelected)
    {
        if(cardsSelected [0].getShape() == cardsSelected [1].getShape()
        && cardsSelected [1].getShape() == cardsSelected [2].getShape())
        {
            shapeType = true;
        }
        else if(cardsSelected [0].getShape() != cardsSelected [1].getShape()
        && cardsSelected [1].getShape() != cardsSelected [2].getShape())
        {
            shapeType = true;
        }
        else
        {
            shapeType = false;
        }
       
    }
        public void checkColor(Card[] cardsSelected)
    {
        if (cardsSelected[0].getColor() == cardsSelected[1].getColor()
            && cardsSelected[1].getColor() == cardsSelected[2].getColor())
        {
            colorType = true;
        }
        else if (cardsSelected[0].getColor() != cardsSelected[1].getColor()
                 && cardsSelected[1].getColor() != cardsSelected[2].getColor())
        {
            colorType = true;
        }
        else
        {
            colorType = false;
        }
    }
   
    public void checkNumberOfShapes(Card[] cardsSelected)
    {
        if (cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes()
            && cardsSelected[1].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes())
        {
            numberOfShapesType = true;
        }
        else if (cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes()
                 && cardsSelected[1].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes())
        {
            numberOfShapesType = true;
        }
        else
        {
            numberOfShapesType = false;
        }
    }
   
    public void checkShading(Card[] cardsSelected)
    {
        if (cardsSelected[0].getShading() == cardsSelected[1].getShading()
            && cardsSelected[1].getShading() == cardsSelected[2].getShading())
        {
            shadingType = true;
        }
        else if (cardsSelected[0].getShading() != cardsSelected[1].getShading()
                 && cardsSelected[1].getShading() != cardsSelected[2].getShading())
        {
            shadingType = true;
        }
        else
        {
            shadingType = false;
        }
    }
   
    public void actionIfTriple()
    {
    
        int[][] cardLocations = new int[5][3]; 
        for (int i = 0; i < cardsSelected.length; i++)
        {
            cardLocations[i][0] = cardsSelected[i].getX(); // X-coordinate
            cardLocations[i][1] = cardsSelected[i].getY(); // Y-coordinate
        }
   
       
   
        // Remove the cards from the board
        for (int i = 0; i < cardsSelected.length; i++)  
        {
            int x = cardLocations[i][0];
            int y = cardLocations[i][1];
        }
   
    
        for (int i = 0; i < cardsSelected.length; i++)
        {
            int x = cardLocations[i][0];
            int y = cardLocations[i][1];
            Card card = deck.getTopCard();
            getWorld().addObject(card, x, y);
        }
   
        // Decrement triplesRemaining
        triplesRemaining--;
   
        // Update the score
        Scorekeeper.updateScore();
   
        cardsOnBoard = new ArrayList<>(getWorld().getObjects(Card.class));
        
        setUI(); 
   
        
        }
   
    public void setCardsSelected(ArrayList <Card> cardList, ArrayList <Integer> numCardsSelected, Card[] selectedCards )
    {
       
    }
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck (numCardsInDeck);
    }
   
}