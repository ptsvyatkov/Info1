import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AppointmentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppointmentTest
{
    /**
     * Default constructor for test class AppointmentTest
     */
    public AppointmentTest()
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
    
    /**
     * Checks if the getDescription method returns the
     * description of an appointment correctly.
     */
    //aufgabe 3
    @Test
    public void testGetDescription()
    {
        Appointment appointm1 = new Appointment("Chillin", 5);
        assertEquals("Chillin", appointm1.getDescription());
    }
    
    /**
     * Checks if the getDuration method returns the
     * duration of an appointment correctly.
     */
    //aufgabe 3
    @Test
    public void testGetDuration()
    {
        Appointment appointm1 = new Appointment("Relaxin", 4);
        assertEquals(4, appointm1.getDuration());
    }
    
    /**
     * Checks that creating an appointment with duration of 0 
     * is possible which should not be. 
     */        
    @Test
    public void zeroDurationAppointment()
    {
        Appointment appointm1 = new Appointment("ZeroDurationAppointm", 0);
        assertEquals("duration has to be at least 1", appointm1.getDuration());        
    }
   
    /**
     * Checks that creating an appointment with a negative duration
     * is possible which should not be. 
     */
                 
    @Test
    public void minusDurationAppointment()
    {
        Appointment appointm2 = new Appointment("NegativeDuration", -1);
        assertEquals("duration has to be at least 1", appointm2.getDuration());
    } 
    
     /**
     * Checks if an appointment can be unnamed. It should
     * at least have some sort of description.
     */        
    @Test
    public void UnnamedAppointment()
    {
       Appointment appointm1 = new Appointment("", 1);
       assertEquals("description shouldn't be blank" , appointm1.getDescription());
    }
}