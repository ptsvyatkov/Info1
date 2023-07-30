import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * A user's input is then broken down into individual words, separated on every whitespace, and returned in a HashSet.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * The getInput method takes no parameters. It reads
     * a line of text from standard input (the text terminal), we
     * then use trim() to remove leading and trailing whitespace, then
     * by using toLowerCase() the input is now lowercase. In the end
     * we replace all punctuation marks. We use the .split() method to 
     * split the user's input on every whitespace. We use a for loop to
     * add every word from the input into a HashSet called words.
     *
     * @return  A set of Strings, but now each String is every single word
     * typed by the user.
     */
    public HashSet<String> getInput()
    {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase().replaceAll("\\p{Punct}","");
        
        String[] wordArray = inputLine.split(" ");
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
            words.add(word);
        }
            
        return words;
    }
}
