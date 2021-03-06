import java.util.Calendar;

public class Clock{

    private Calendar datetime = Calendar.getInstance();
    private String hour = Integer.toString(datetime.get(Calendar.HOUR));
    private String minute = Integer.toString(datetime.get(Calendar.MINUTE));
    private String second = Integer.toString(datetime.get(Calendar.SECOND));
    private String year = Integer.toString(datetime.get(Calendar.YEAR));
    private String month = Integer.toString(datetime.get(Calendar.MONTH));
    private String day = Integer.toString(datetime.get(Calendar.DATE));

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public String getSecond() {
        return second;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

}