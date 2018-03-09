package time2;

/**
 * Time2 class declaration with overloaded constructors
 *
 * @author Kemar
 * @version 3/6/18
 */
public class Time2 {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    
    // Time2 no-arg constructor:
    // initializes each instance variables to zero
    public Time2() {
        this(0, 0, 0); // invoke constructor with three arguments
    }
    
    /**
     * Time2 constructor: hour supplied, minute and second defaulted to 0.
     * 
     * @param hour 
     */
    public Time2(int hour) {
        this(hour, 0, 0); // invoke constructor with three arguments
    }
    
    /**
     * Time2 constructor: hour and minute supplied, second defaulted to 0.
     * 
     * @param hour 
     * @param minute 
     */
    public Time2(int hour, int minute) {
        this(hour, minute, 0); // invoke constructor with three arguments
    }
    
    /**
     * Time2 constructor: hour, minute, and second supplied
     * 
     * @param hour
     * @param minute
     * @param second 
     */
    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    /**
     * Time2 constructor: another Time2 object supplied
     * 
     * @param time another Time2 object
     */
    public Time2(Time2 time) {
        this(time.hour, time.minute, time.second);
    }
    
    // Set Methods
    
    /**
     * Set a new time value using universal time: validate the data
     * 
     * @param hour
     * @param minute
     * @param second 
     */
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    /**
     * Validate and set hour.
     * 
     * @param hour 
     */
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
        this.hour = hour;
    }
    
    /**
     * Validate and set minute.
     * 
     * @param minute 
     */
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        
        this.minute = minute;
    }
    
    /**
     * Validate and set second.
     * 
     * @param second 
     */
    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        
        this.second = second;
    }
    
    // Get methods
    
    /**
     * Get hour value.
     * 
     * @return hour
     */
    public int getHour() {return hour;}
    
    /**
     * Get minute value.
     * 
     * @return minute
     */
    public int getMinute() {return minute;}
    
    /**
     * Get second value.
     * 
     * @return second
     */
    public int getSecond() {return second;}
    
    /**
     * Convert to String in universal time format (HH:MM:SS)
     * 
     * @return universal-time format
     */
    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
    
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}
