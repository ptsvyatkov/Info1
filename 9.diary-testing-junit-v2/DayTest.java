/**
 * The test class DayTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class DayTest extends junit.framework.TestCase
{
    private Appointment appointm1;
    private Appointment appointm2;
    private Day day1;
    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    // fixture for Aufgabe 5
    protected void setUp()
    {
        day1 = new Day(45);
        appointm1 = new Appointment("Flight", 2);
        appointm2 = new Appointment("Hospital", 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Test basic functionality by booking at either end
     * of a day, and in the middle.
     */
    public void testMakeThreeAppointments() //already in here
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Java class", 1);
        Appointment appointm3 = new Appointment("Meet John", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(true, day1.makeAppointment(13, appointm2));
        assertEquals(true, day1.makeAppointment(17, appointm3));
    }

    /**
     * Check that double-booking is not permitted.
     */
    public void testDoubleBooking() //already in here
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Error", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(false, day1.makeAppointment(9, appointm2));
    }
    
    /**
    * Check that the first appointment for an empty diary is at 9 a.m.
    */
    public void testFindSpaceEmpty() //already in here
    {
        Day day2 = new Day(13);
        day2.showAppointments();
        Appointment a = new Appointment("First", 1);
        assertEquals(9, day2.findSpace(a));
    }

    /**
    * 
    */
    public void testFindSpace9() //already in here
    {
        Day day1 = new Day(13);
        Appointment a = new Appointment("first", 1);
        assertEquals(9, day1.findSpace(a));
        day1.showAppointments();
    }

    /**
    * 
    */
    public void testNotFull() //already in here
    {
        Day day1 = new Day(13);
        Appointment appointm1 = new Appointment("first!", 1);
        assertEquals(true, day1.makeAppointment(11, appointm1));
        Appointment appointm2 = new Appointment("second", 1);
        assertEquals(9, day1.findSpace(appointm2));
        day1.showAppointments();
        Appointment b3 = new Appointment("BIg", 3);
        assertEquals(12, day1.findSpace(b3));
    } 
    
    /**
    * Checks that findSpace method returns 10 for the second
    * appointment in a day, if there is already a single
    * one-hour appointment.
    */
    //aufgabe 1
    public void testFindSpace()
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Swimming", 1);
        Appointment appointm2 = new Appointment("Soccer", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(10, day1.findSpace(appointm2));
    }
   
    /**
    * Check that findSpace returns a value of 10 for an one-hour
    * appointment if there is already an one-hour appointment at 9am.
    */
    public void testFindSpaceTen() //aufgabe 1
    { 
        Day day2 = new Day(2);
        Appointment appointm3 = new Appointment("Wake up", 1);
        Appointment appointm4 = new Appointment("Brush Teeth" , 1);
        assertEquals(true, day2.makeAppointment(9, appointm3));
        assertEquals(10, day2.findSpace(appointm4));
    }
    
    /**
    * Check that findSpace returns a value of -1 if an attempt is 
    * made to find an appointment in a day, that is already full.
    */
    public void testNoSpaceLeft()  //aufgabe 2
    {
        Day day1 = new Day(23);
        Appointment appointm1 = new Appointment("School", 9);
        Appointment appointm2 = new Appointment("After School", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));        
        assertEquals(-1, day1.findSpace(appointm2));
    }        
      
    /**
    * Check that double-booking with different duration 
    * is not permitted. 
    */
    public void testDoubleBookingDifferentDuration() //aufgabe 4
    {
        Day day1 = new Day(45);
        Appointment appointm1 = new Appointment("School", 1);
        Appointment appointm2 = new Appointment("Shopping", 2);
        assertEquals(true, day1.makeAppointment(11, appointm1));
        assertEquals(false, day1.makeAppointment(11, appointm2));
    }
    
    public void testDoubleBookingTwo() //using fixture for aufgabe 5
    {
        assertEquals(true, day1.makeAppointment(10, appointm1));
        assertEquals(false, day1.makeAppointment(11, appointm2));
    }
    
    /**
     * Check that findSpace returns 9 for the first available time
     * for an appointment in a free day.
     */
    //aufgabe 6
    public void testPositiveFirstAvailableTime()
    {
        Appointment appointm3 = new Appointment("firstThingForToday", 1);
        Day day2 = new Day(2);
        assertEquals(9, day2.findSpace(appointm3));
    }
    
     /**
     * Check that an appointment with a duration of -1
     * cannot be added to a day.
     */
     //aufgabe 6
    public void testNegativeAppointmentDurationMinusOne()
     {
        Appointment appointm3 = new Appointment("durationMinusOne", -1);
        Day day2 = new Day(1);
        assertEquals(false, day2.makeAppointment(9, appointm3));
    }
     
    /**
      * Creates an appointment with duration 8 hours ( 9 to 17 ), then
      * finds space for another appointment with 1 hour duration and
      * should return 17.
      */
     //aufgbe 6
    public void testFindSpaceAfter8hAppointment()
    {
        Appointment appointm3 = new Appointment("Studying", 8);
        Day day2 = new Day(2);
        Appointment appointm4 = new Appointment("Gaming", 1);
        assertEquals(true, day2.makeAppointment(9, appointm3));
        assertEquals(17, day2.findSpace(appointm4));
    }
    
    /**
     * Creates appointment with a 0 hour duration and adds the
     * appointment to a day. Expected to not be possible.
     */
    //aufgabe 6
    public void testNegativeAddDurationOf0()
    {
       Appointment appointm3 = new Appointment("ZeroHourAppointm", 0);
       Day day1 = new Day(3);
       assertEquals(false, day1.makeAppointment(9, appointm3));
    }
    
     /**
     * Creates a 1 hour appointment and checks that it can't be
     * added to a day before 9 or after 18 o'clock.
     */
     //aufgabe 6
    public void testCannotTakeAppointmentBefore9After18()
    {
        Appointment appointm3 = new Appointment("Playing", 1);
        Day day2 = new Day(4);
        assertEquals(false, day2.makeAppointment(8, appointm3));
        assertEquals(false, day2.makeAppointment(18, appointm3));
    }
    
    /**
     * Checks if it's possible to create a "-1","0" or anything
     * above "366" day. Only days between 1 and 366 should be allowed. 
     */
    //aufgabe 6
    public void testNegativeNotAllowedDayNumber()
    {
        Day day1 = new Day(0);
        assertEquals(false, day1.getDayNumber());
        Day day2 = new Day(-1);
        assertEquals(false, day2.getDayNumber());
        Day day3 = new Day(367);
        assertEquals(false, day2.getDayNumber());
    }
    
    /**
     * Checks that the time before 9 is not valid for appointments
     */
    //aufgabe 6
    public void testNegativeValidTimeBefore9()
    {
        Day day2 = new Day(1);
        assertEquals(false, day2.validTime(8));
    }
    
    /**
     * Checks that the time after 18 is not valid for appointments
     */
    //aufgabe 6
    public void testNegativeValidTimeAfter18()
    {
        Day day2 = new Day(1);
        assertEquals(false, day2.validTime(18));
    }
    
    /**
     * Test basic functionality by looking for a valid time at either 
     * beginning, middle or end of a day.
     */
     //aufgabe6
    public void testPositiveValidTime()
    {
        Day day2 = new Day(35);
        assertEquals(true, day2.validTime(9));
        assertEquals(true, day2.validTime(14));
        assertEquals(true, day2.validTime(17));
    }
    
    /**
     * Creates a 1 hour appointment and finds space for it. Program
     * returns 9, which is correct. Then creates an appointment with
     * duration 0 hours, which should not be possible, and findSpace
     * returns -1, which is supposed to be for insufficient space,
     * but there actually is enough space. We should not allow 
     * appointments to be created with a duration less than 1.
     */
    //aufgabe 6
    public void testFindSpaceForNegativeDuration()
    {
        Appointment appointm3 = new Appointment("FirstThing", 1);
        assertEquals(9, day1.findSpace(appointm3));
        Appointment appointm4 = new Appointment("SecondThing", 0);
        assertEquals("not allowed", day1.findSpace(appointm4));
    }

    public void testAdding10HourAppointment()
    {
        Appointment appointm3 = new Appointment("Laying", 10);
        day1.showAppointments();
    }

    public void testAdding10HourAppointment1()
    {
        Day day2 = new Day(1);
        Appointment appointm3 = new Appointment("Laying", 10);
        assertEquals(false, day2.makeAppointment(9, appointm3));
        day2.showAppointments();
    }
}

