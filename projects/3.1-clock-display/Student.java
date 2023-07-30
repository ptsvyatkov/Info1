
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private String name2;
    
    public Student (String newName, String newName2)
    {
        name = newName;
        name2 = newName2;
    }
    
    public String getFirstName()
    {
    return name;
    }
    
    public String getSurname()
    {
        return name2;
    }
}
