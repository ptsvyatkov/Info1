/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = 1;
        refNumber = "";
    }
    /*
     * Method to print the author
     */
    public String getAuthor()
    {
    return author;
    }
    
    /*
     * Method to print the title
     */
    public String getTitle()
    {
    return title;
    }
    
    /*
     * Method to print the author to the terminal
     */
    public void printAuthor()
    {
    System.out.println(author);
    }
    
    /*
     * Method to print the author to the terminal
     */
    public void printTitle()
    {
    System.out.println(title);
    }
    
    /*
     * Method to print the number of pages
     */
    
    public int getPages()
    {
    return pages;
    }
    
    /*
     * Method to print details about Book
     */
    public void printDetails()
    {
    System.out.println("Author: " + author);
    System.out.println("Title: " + title);
    System.out.println("Pages: " + pages);
    if ( refNumber.length() > 0) {
    System.out.println("Reference Number: " + refNumber); }
    }
    
    /*
     * Mutator that sets the reference number
     */
    public void setRefNumber(String ref)
    {
        if (ref.length() > 2) {
        refNumber = ref; }
        
        else { System.out.println("Error! Wrong RefNumber!");}
    }
    
    /*
     * Accessor to get the reference number
     */
    public String getRefNumber()
    {
    return refNumber;
    }
}
