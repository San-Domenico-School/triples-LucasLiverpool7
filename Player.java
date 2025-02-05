import greenfoot.*;  
import java.util.ArrayList;  

/**
 * Player class for managing card selection and interaction with the dealer
 * Time: 12:00 PM 2/2/25
 * Author: [Lucas]
 */
public class Player extends Actor 
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;

    public Player(Dealer dealer) 
    {
        this.dealer = dealer;
        this.cardsSelected = new Card[3];
        this.cardsOnBoard = new ArrayList<>();
        this.selectedCardsIndex = new ArrayList<>();
    }

    public void addedToWorld(World world) 
    {
        cardsOnBoard = (ArrayList<Card>) world.getObjects(Card.class);
    }

    public void act() 
    {
        if (!cardsOnBoard.isEmpty()) 
        {
            selectCards();
            boolean threeCardsHaveBeenSelected = setCardsSelected();
            if (threeCardsHaveBeenSelected) 
            {
                dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
                dealer.checkIfTriple();
                resetCardsSelected();
            }
        }
    }

    private void selectCards() 
    {
        for (int i = 0; i < cardsOnBoard.size(); i++) 
        {
            if (Greenfoot.mouseClicked(cardsOnBoard.get(i))) 
            {
                Card clickedCard = cardsOnBoard.get(i);
                if (selectedCardsIndex.contains(i)) 
                {
                    clickedCard.setIsSelected(false);
                    clickedCard.setImage(clickedCard.getCardImage());
                    selectedCardsIndex.remove(Integer.valueOf(i));
                } 
                else 
                {
                    clickedCard.setIsSelected(true);
                    clickedCard.setImage(clickedCard.getSelectedCardImage());
                    selectedCardsIndex.add(i);
                }
            }
        }
    }

    private boolean setCardsSelected() 
    {
        if (selectedCardsIndex.size() == 3) 
        {
            for (int i = 0; i < 3; i++) 
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
            return true;
        }
        return false;
    }

    private void resetCardsSelected() 
    {
        for (Card card : cardsOnBoard) 
        {
            card.setImage(card.getCardImage());
            card.setIsSelected(false);
        }
        selectedCardsIndex.clear();
    }
}
