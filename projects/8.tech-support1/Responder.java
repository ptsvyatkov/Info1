import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response.<br>
 * 30.05.2019 - Pavel and Hussein - modified to also include a HashMap that
 * stores keywords, based on a user's input, and values with proper responses
 * to them. <br>If a keyword is met in the user's input, then the program generates
 * a response with the matching value. <br>In case no keyword is met in the user's
 * input, a random response is then generated and the same random response is
 * never repeated twice in a row.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1
 */
public class Responder

{
    private Random randomGenerator;
    private ArrayList<String> Responses;
    private HashMap<String, String> responseMap;
    private HashMap<String, String> responseMap2;
    private int lastIndex = -1;
    /**
     * Construct a Responder - it consists of a random generator,
     * an array list called Responses, which holds our random responses,
     * a HashMap called responseMap, which holds the responses based on
     * keywords in the user's input and two methods - fillResponses
     * and fillResponseMap, where we add our responses to display.
     */
    public Responder()
    {
       randomGenerator = new Random();
       Responses = new ArrayList<>();   
       responseMap = new HashMap<>();
       responseMap2 = new HashMap<>();
       fillResponseMap();
       fillResponseMap2();
       fillResponses();
    }

    /**
     * This method generates a random response that is never
     * repeated twice in a row. It compares the current and the last index,
     * the lastIndex is kept at class level. If they are the same it picks
     * a different current index, which now becomes the last index.
     * 
     * @return   A string that should be displayed as the response
     */
    public String randomResponse()
    {
        // We initialized lastIndex in the Responder class field
        // and set it to -1, so that it represents the index of our
        // last randomly generated response.
        
        // local variable index
        int index = 0;
        
        // This while loop ensures that our random response is never
        // repeated twice in a row by checking if the index is
        // same as the lastIndex. If they are the same, the program
        // then picks a different random response from the array list.
        while ( index == lastIndex ) {
         index = randomGenerator.nextInt(Responses.size());
        }
        // the lastIndex now becomes the index that we picked
        lastIndex = index;
        return Responses.get(index);
        
    }
    
    /**
     * This method is used by the SupportSystem class to generate
     * a response. It either returns a response based on keywords
     * in the user's input or a random response.
     * 
     * @param words A HashSet filled with each word based on the
     * user's input.
     * @return Returns a response based on keywords from the
     * responseMap or a random response if no word is recognized.
     */
    public String generateResponse(HashSet<String> words)
    {  
       String response = "";
       for (String word : words) {
           if(responseMap.get(word) != null) {
           response = response + responseMap.get(word) + " ";
           }
       }
       if(response.equals("")){
           for(String word : words) {
               if(responseMap2.get(word) != null){
                  response = response + responseMap2.get(word) + " ";
                }
           }
        }    
       if(response.equals("")) {
           response = randomResponse();
       }
       
       // If no word was recognized in the user's input
       // we then return a random response.
       return response;
    }
    
    /**
     * Create a list of random responses. The program picks a random
     * response in case there is no matching keyword in the user's input.
     */
     private void fillResponses()
    {
      Responses.add("That sounds weird. What do you mean exactly?");
      Responses.add("Tell me more about it. I'm not quite sure.");
      Responses.add("Sorry, I need more information about that.");
      Responses.add("That's not a bug, that's a feature.");
    }
    
    /**
     * By using the put(Key,Value) method, we add all the keywords and
     * their corresponding values to our response map.
     */
    private void fillResponseMap()
    {
     responseMap.put("slow", "I think it has something to do with your hardware.");
     responseMap.put("bug", "Well you know, all software has some bugs.");
     responseMap.put("expensive", "Our cost is quite competitive compared to other software.");
    }
    
    private void fillResponseMap2(){
     responseMap2.put("how", "Try reinstalling the software. It should solve the issue.");
     responseMap2.put("why", "Because this is how our software is intended to work.");
     responseMap2.put("who", "You can speak to our manager regarding this matter.");
    }
}
