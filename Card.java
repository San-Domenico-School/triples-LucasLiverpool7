import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * this is the card class. it controls cards
 * Lucas
 * 1/10/25 (1:43)

 */

public class Card extends Actor
{
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage image, cardImage, selectedCardImage;
    private int numberOfShapes;
    private int shading;
    enum Color
    {
        NO_COLOR, GREEN, BLUE, RED
    }
    enum Shape
    {
        NO_SHAPE, CIRCLE, SQUARE, TRIANGLE
    } 
    
    public Card (Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        setImage (cardImage);
       
    }
    
    public Color getColor()
    {
        return color;
    }
    public Shape getShape()
    {
        return shape;
    }
    public int getShading()
    {
        return shading;
    }
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    public boolean getIsSelected()
    {
        return isSelected;
    }
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
}
   
    



