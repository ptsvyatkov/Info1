import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;
    private String note;
    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
    public void listAllNotes(){
        int index = 0;
        Iterator<String> it = notes.iterator();
        while (it.hasNext()){
            String notes = it.next();
            System.out.println(index + "." + notes);
            index++;
        }
    }
    
    public void removeNote(int index){
        if(isValid(index)){
        notes.remove(index);
        listAllNotes();
     }
    }
    
    private boolean isValid(int index)
    {
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index needs to be at least 0");
            valid = false;
        }
        else if(index >= notes.size()) {
            System.out.println("Index can't be higher than number of notes.");
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
       }
    
       public void searchNote(String search)
        {
        boolean found = false;
        for(String notes : notes) 
        {
            if(notes.contains(search)) {
                System.out.println(notes);
            found = true;}
            } 
        if (found == false){ System.out.println("Search term not found");}
        }
        
     public void searchNote2(String noteName){
        int index = 0;
        int size = notes.size();
        boolean found = false;
        while(index < size)
        {String note = notes.get(index);
         if(note.contains(noteName))
         {System.out.println(index + ". " + note);
         found = true;}
        index ++;}
        if(found==false)
        { System.out.println("Search term not found.");}
        }
}

