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
    private static int deckSize;       // Stores the size of the deck
    private static int score = 0;      // Stores the current score, initialized to 0
    private static long startTime = System.currentTimeMillis();  // Stores the start time in milliseconds
    
    // Flag to track if it's the first update
    private static boolean firstUpdate = true;

    // Public static setter method for deckSize
    public static void setDeckSize(int size) 
    {
        deckSize = size;  // Assigns the input parameter 'size' to deckSize
    }

    // Public static void method to update the score
    public static void updateScore() 
    {
        if (firstUpdate) 
        {
            // Set score to 27 on the first update
            score = 27;
            firstUpdate = false;  // After the first update, set the flag to false
        }
        // Subsequent updates do not change the score
    }

    // Public static getter method for score
    public static int getScore() 
    {
        return score;  // Returns the current score
    }
}
