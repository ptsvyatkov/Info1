
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
    private String alarmTime;
    private boolean alarmSet;
  
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        alarmTime = "";
        alarmSet = false;
        updateDisplay();
    }
       
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
        alarmTime = "";
        alarmSet = false;
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
        }
        updateDisplay();
        if(alarmSet && alarmTime.equals(displayString)){
            System.out.println("Riiiiiiiing!");
        }
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
        int displayHour;
        String displayHourString;
        String americanTime;
        if(hours.getValue() > 12){
            displayHour = hours.getValue() - 12;
            americanTime = "pm";
        }
        else if (hours.getValue() == 12){
            displayHour = hours.getValue();
            americanTime = "pm";
        }
        else {
            if(hours.getValue() == 0){
                displayHour = 12;
                americanTime = "am";
            }
            else {
                displayHour = hours.getValue();
                americanTime = "am";
            }
        }
        if(displayHour <10){
            displayHourString = "0" + displayHour;
             displayString = displayHourString + ":" + 
                        minutes.getDisplayValue() + americanTime;
        }
        else {
            displayString = displayHour + ":" + 
                        minutes.getDisplayValue() + americanTime;
        }
    }
    
    public void setAlarm (int alarmHour, int alarmMinute, String alarmAT){
        String alarmMinString;
        String alarmHourString;
        if(alarmHour <10){
            alarmHourString = "0" + alarmHour;
        }
        else{
            alarmHourString = "" + alarmHour;
        }
        if(alarmMinute <10){
            alarmMinString = "0" + alarmMinute;
        }
        else{
            alarmMinString = "" + alarmMinute;
        }
        alarmTime = alarmHourString + ":" + alarmMinString + alarmAT;
        alarmSet = true;
        System.out.println("The alarm is set to " + alarmTime);
    }

    public void setAlarmOff(){
        alarmSet = false;
        System.out.println("The alarm is turned off.");
    }
}
