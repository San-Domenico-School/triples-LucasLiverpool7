import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    
    private final int NUM_CARDS_IN_DECK = 27;
    
    public GameBoard() {   
        super(430, 600, 1, false); 
        
        // Create and instantiate the dealer
        Dealer dealer = new Dealer(81);
        
        // Add the dealer to the world at position (30, -30)
        addObject(dealer, 30, -30);
        
        // Create and instantiate the player, passing the dealer object
        Player player = new Player(dealer);
        
        // Add the player to the world at position (-30, -30) (out of view)
        addObject(player, -30, -30);
        Scorekeeper scorekeeper = new Scorekeeper();
        addObject(dealer, 200, 300);

    }


}
