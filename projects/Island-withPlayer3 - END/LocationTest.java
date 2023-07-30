

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LocationTest
{
    private Item item1;
    private Location location1;
    private Item item2;

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        item1 = new Item("seashell","seashell", 2);
        location1 = new Location("seaShore");
        item2 = new Item("sand","fist full of sand", 1);
        location1.placeItem(item2);
        location1.placeItem(item1);
        location1.getItemString();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
