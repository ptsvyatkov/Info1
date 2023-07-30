/**
 * World of You - ISLAND
 * You were in a shipwreck. You wake up on an unknown island. You
 * need to find items to rebuild your boat and leave the island.
 * Be careful, noone knows what creatures lurk around the Jungle.
 * @version 2019
 */
public class Game 
{
    private Parser parser;
    private Location currentLocation;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createLocations();
        parser = new Parser();
    }

    /**
     * Create all the locations and link their exits together.
     */
    private void createLocations()
    {
        Location beach, jungles, temple, shipwreck, volcano, bunker, waterfall;
      
        // create the loctions
        beach = new Location("on the beach");
        jungles = new Location("deep into the jungles");
        temple = new Location("in an abandoned temple");
        shipwreck = new Location("near the shipwreck");
        volcano = new Location("near the volcano");
        waterfall = new Location("at the waterfall");
        bunker = new Location("near the bunker");
        
        // initialise location exits
        beach.setExit("east", shipwreck);
        beach.setExit("south", jungles);

        jungles.setExit("north", beach);
        jungles.setExit("east", waterfall);
        jungles.setExit("west", temple);
        jungles.setExit("south", volcano);

        temple.setExit("east", jungles);
        temple.setExit("south", bunker);
        
        bunker.setExit("north", temple);
        
        volcano.setExit("north", jungles);
        
        waterfall.setExit("west", jungles);
        
        shipwreck.setExit("west", beach);

        currentLocation = beach;  // start game at the beach
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Jungles!");
        System.out.println("Your ship has wrecked, you are alone on this island.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentLocation.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goLocation(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")){
            listItems();
        }
        else if (commandWord.equals("pick")){
            pickItem(command);
        }
        else if (commandWord.equals("eat")){
            eat();
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are alone. You need to escape.");
        System.out.println("Find a way to build a boat and get away.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * location, otherwise print an error message.
     */
    private void goLocation(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Location nextLocation = currentLocation.getExit(direction);

        if (nextLocation == null) {
            System.out.println("There is no way!");
        }
        else {
            currentLocation = nextLocation;
            System.out.println(currentLocation.getLongDescription());
        }
    }
    
    /**
     * Listing all the items that can be picked in the current location.
     */
    private void listItems()
    {
        System.out.println("There are no items to pick here.");
    }
    
    /**
     * For now we just print a message, later we will be able to
     * eat only when we have found food.
     */
    private void eat(){
      System.out.println("You have eaten now and aren't hungry any more.");
    }
    
     /**
     * Picking an item
     */
    private void pickItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to pick...
            System.out.println("Pick what?");
            return;
        }   
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}