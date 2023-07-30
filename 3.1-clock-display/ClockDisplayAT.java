
/**
 * The ClockDisplayAT class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class ClockDisplayAT
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String americanTime;
  
    
    /**
     * Constructor for ClockDisplayAT objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplayAT()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        americanTime = "am";
        updateDisplay();
    }
       
    /**
     * Constructor for ClockDisplayAT objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplayAT(int hour, int minute, String ampm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        americanTime = ampm;
        setTime(hour, minute, ampm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        boolean rollover = false;
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (hours.getValue() == 0 && minutes.getValue() == 0){
                rollover = true;}
            if (rollover && americanTime == "am") {
                americanTime = "pm";
                rollover = false;}
            else if (rollover && americanTime == "pm") {
                americanTime = "am";
                rollover = false;}
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String ampm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        americanTime = ampm;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int displayHour;
        if(hours.getValue() == 0){
            displayHour = 12;
        }
        else {
            displayHour = hours.getValue();
        }
        if (hours.getValue() < 10 && hours.getValue() != 0){
        displayString = "0" + displayHour + ":" + 
                        minutes.getDisplayValue() + americanTime;
        }
        else{
        displayString = displayHour + ":" + 
                        minutes.getDisplayValue() + americanTime;
        }
    }
}
