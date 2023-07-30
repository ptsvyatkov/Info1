import java.util.Set;
import java.util.HashMap;

/**
 * Class Location - a location in an adventure game.
 * 
 * @author   Pavel Tsvyatkov & Stepan Burlachenko
 * @version 2019
 */

public class Location 
{
    private String description;
    private HashMap<String, Location> exits;// stores exits of this location.

    /**
     * Create a location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Here we can set an exit from this Location.
     * @param direction The exit's direction.
     * @param neighbor  The location to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of our Location.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Returns a more detailed description of the location.
     * @return Long description of this location.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * This method shows the possible exits in a location.
     * @return location exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Returns the Location we went to and if there wasn't anything
     * in the direction we specified, it should return null.
     * @param direction Direction of the exit.
     * @return After we have moved to a direction, return the location.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
}