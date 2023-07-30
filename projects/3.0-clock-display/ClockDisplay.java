
/**
 * The ClockDisplay class implements a digital clock display for a
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
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String americanTime;
  
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        americanTime = "am";
        updateDisplay();
    }
    
      /**
      * public ClockDisplay(int amountHours){
        hours = new NumberDisplay(amountHours);
        minutes = new NumberDisplay(60);
        if (amountHours == 12) {
            americanTime = "am";
        } else { 
            americanTime = "";
        }
        updateDisplay();
      }*/
    
    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            //if (hours.getValue() == 0 && americanTime == "am") {
            //americanTime = "pm";}
            //else if (hours.getValue() == 0 && americanTime == "pm") {
            //americanTime = "am";}
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
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
        int newhour;
        if(hours.getValue() > 12){
            newhour = hours.getValue() - 12;
            displayString = newhour + ":" + 
                        minutes.getDisplayValue() + "pm";
        }
        else if (hours.getValue() == 12){
            newhour = hours.getValue();
            displayString = newhour + ":" + 
                        minutes.getDisplayValue() + "pm";
        }
        else {
            if(hours.getValue() == 0){
                newhour = 12;
            }
            else {
                newhour = hours.getValue();
            }
            displayString = newhour + ":" + 
                        minutes.getDisplayValue() + "am";
        }         
    }
}
