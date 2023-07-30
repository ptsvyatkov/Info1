import java.util.ArrayList;
/**
 * The Player class holds the information about the current player as well as the player's current location and the items they have with them. 
 * 
 * @author  Pavel Tsvyatkov & Stepan Burlachenko
 * @version 2019
 */
public class Player
{   
    public Location currentLocation;
    private ArrayList<Item> backpack;
    private int backpackWeightLimit;

    /**
     * Constructor for creating a new player that 
     * starts at currentLocation and has a backpack 
     * with weight limit of 8kg.
     */
    public Player()
    {
         currentLocation = null;
         backpackWeightLimit = 8;
         backpack = new ArrayList<>();
    }
    
    /**
     * Sets the current location of the player
     * @param place the location of the player
     */
    public void setLocation(Location place){
        currentLocation = place;
    }
    
    /**
     * Accessor method to get the current location
     */
    public Location getLocation(){
        return currentLocation;
    }
    
    /**
     * This is the method that simulates taking an item from a room.
     * We take the second word, similarly to the goLocation method and
     * use that word as the item that we are trying to pick.
     * @param command the item we are trying to pick
     */
    public void takeItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // print a message if there is no second word
            System.out.println("What do you want to take?");
            return;
        }
        String item = command.getSecondWord();
        
        Item itemToPick = currentLocation.getItem(item);
        
        if(itemToPick != null){
            backpack.add(itemToPick);
            System.out.println("You picked up: " + itemToPick.getName());
        }
        else{
            System.out.println("Item doesn't exist");
        }
    }
    
    
    /**
     * This is the method that simulates dropping an item from our backpack.
     * We take the second word, similarly to the takeItem method and
     * use that word as the item that we are trying to drop.
     * @param command the item we are trying to drop
     */
    public void dropItem(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("What do you want to drop?");
            return;
        }
        
        String itemToDrop = command.getSecondWord();
        
        if(itemToDrop.equals("all")){
            if(backpack.isEmpty()) {
                System.out.println("You don't have anything in the backpack.");
            }else {
                for(Item item : backpack){
                    currentLocation.placeItem(item);
                }
                backpack.clear();
                System.out.println("You dropped everything from your backpack.");
            }
        }
        
        for(int i = 0; i < backpack.size(); i++){
            if(backpack.get(i).getName().equals(itemToDrop)){
                currentLocation.placeItem(backpack.get(i));
                backpack.remove(i);
                System.out.println("You dropped: " + itemToDrop);
            }
            else {
            System.out.println("You do not have " + itemToDrop + " in your backpack!");
            }
        }
}
}
