/**
 * This is the Scorekeeper class. It keeps track of the game score and deck size.
 * 
 * @lucas
 * 11:19 
 * 1/10/25
 */
public class Scorekeeper 
{

    // Private static fields
    private static int deckSize;       
    private static int score = 0;     
    private static long startTime = System.currentTimeMillis();  
    
    
    private static boolean firstUpdate = true;

    
    public static void setDeckSize(int size) 
    {
        deckSize = size;  
    }

    
    public static void updateScore() 
    {
        if (firstUpdate) 
        {
            
            score = 27;
            firstUpdate = false;
    } else {
        long elapsedTime = System.currentTimeMillis() - startTime;
        score += Math.max(10, 1000 - elapsedTime / 100);
        startTime = System.currentTimeMillis(); 

    }
    
    }
        
    

    // Public static getter method for score
    public static int getScore() 
    {
        return score;  // Returns the current score
    }
}
