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
 * getAuthor method
 */

public String getAuthor()
{
    return author;
}

public String getTitle()
{
    return title;
}

/*
 * printAuthor method
 */
public void printAuthor()
{
    System.out.println(author);
}

/*
 * printTitle method
 */
public void printTitle()
{
    System.out.println(title);
}

/*
 * getPages method
 */
public int getPages()
{
    return pages;
}

/*
 * Method to print the details about the book
 */
public void printDetails()
{ 
    System.out.println("Author: " + author);
    System.out.println("Title: " + title);
    System.out.println("Page: " + pages);
    
    if (refNumber.length() > 0){
        System.out.println("Refnumber: " + refNumber);
    }
    else {
        } 
    
}

/*
 * Method to store the reference number
 */
public void setRefNumber(String ref)
{
    refNumber = ref;
}

/*
 * Method to get the reference number
 */

public String getRefNumber()
{
    return refNumber;
}

}

