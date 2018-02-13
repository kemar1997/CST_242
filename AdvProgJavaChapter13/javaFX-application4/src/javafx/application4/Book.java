
package javafx.application4;

/**
 *
 * @author Carl
 */
public class Book 
{
    String title;
    String author;
    int pages;
    
    /**
     * Default constructor for class Book that sets default values for title
     * and author (empty String) and pages (0).
     */
    public Book()
    {
        this("", "", 0);
    }
    
    /**
     * Sets values for title, author and pages to the values of the parameters.
     * 
     * @param title the title of the Book
     * @param author the author of the Book
     * @param pages the number of pages in the Book
     */
    public Book(String title, String author, int pages)
    {
        setTitle(title);
        setAuthor(author);
        setPages(pages);
    }
    
    /**
     * Updates the title field.
     * 
     @param title the title of the Book
     */
    public void setTitle (String title)
    {
        this.title = title;
    }
    /**
     * Updates the author field.
     * 
     @param author the author of the Book
     */
    public void setAuthor (String author)
    {
        this.author = author;
    }
    /**
     * Updates the title field.
     * 
     @param pages the number of pages in the Book
     */
    public void setPages (int pages)
    {
        this.pages = pages;
    }
    
    /**
     * Retrieves the title field.
     * 
     * @return the title of the Book.
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Retrieves the author field.
     * 
     * @return the author of the Book.
     */
    public String getAuthor()
    {
        return author;
    }
    /**
     * Retrieves the pages field.
     * 
     * @return the number of pages in the Book.
     */
    public int getPages()
    {
        return pages;
    }
    
    /**
     * Retrieves a String representation of a Book object with the title, author 
     * and number of pages.
     * 
     * @return the title, author and number of pages in a formatted String.
     */
    @Override
    public String toString()
    {
        return "Title: \t\t" + getTitle()
                + "\nAuthor: \t" + getAuthor()
                + "\nPages: \t" + getPages();
    }
}
