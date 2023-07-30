import java.util.ArrayList;
/**
 * Creates Items that have a description and a weight
 *
 * @version 2019-7-3
 */
public class Item
{
    private String name;
    //iformation displayed for the player
    private String description;
    //how much the item weighs
    private int weight;
    

    /**
     * Constructor for objects of class Item
     * @param a String that is used as information for the player
     * @param an int that determines how light or heavy the item is going to be
     */
    public Item (String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
        
    }
    
    /**
     * Method for returning information about each item
     * @return a String that tells the player about the item 
     * and it's weight
     */
    public String getDetailedDescription(){
        String longDescription = description + ", weighs " + weight +"kg.";
        return longDescription;
    }
    
    /**
     * Returns the description of an item.
     * @return description of an item. 
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * Returns the weight of an item.
     * @return weight of an item. 
     */
    public int getWeight()
    {
        return weight;
    }
}
