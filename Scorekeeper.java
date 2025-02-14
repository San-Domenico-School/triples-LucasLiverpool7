

/**
 * Author: Lucas
 * Date: 1/13/2025
 */
public class Scorekeeper
{
    private static int deckSize;
    private static int score;
    private static long startTime = System.currentTimeMillis();

   
    public static void setDeckSize(int newSize)
    {
        deckSize = newSize;
    }

   
     public static void updateScore()
    {
        int timePassed = (int)((System.currentTimeMillis() - startTime) / 1000);
        int points = deckSize - timePassed;  
        if(points > 0)
        {
            score += points;
        }
        startTime = System.currentTimeMillis();
    }


    public static int getScore()
    {
        return score;
    }
}