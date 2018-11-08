import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock{

    private static final DateFormat lsdf = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
    public static final DateFormat ssdf = new SimpleDateFormat("hh:mm:ss a yyyy/MM/dd");
    public Calendar datetime = Calendar.getInstance();
    public String hour = Integer.toString(datetime.get(Calendar.HOUR));
    public String minute = Integer.toString(datetime.get(Calendar.MINUTE));
    public String second = Integer.toString(datetime.get(Calendar.SECOND));
    public String year = Integer.toString(datetime.get(Calendar.YEAR));
    public String month = Integer.toString(datetime.get(Calendar.MONTH));
    public String day = Integer.toString(datetime.get(Calendar.DATE));

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

    public String getlDate() {
        return lsdf.format(datetime.getTime());
    }

    public String getsDate() {
        return ssdf.format(datetime.getTime());
    }
}
