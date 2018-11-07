import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {

    private static final DateFormat lsdf = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
    public static final DateFormat ssdf = new SimpleDateFormat("hh:mm:ss a yyyy/MM/dd");
    public Calendar datetime = Calendar.getInstance();
    public int hour;
    public int minute;
    public int second;

    public String getlDate() {
        return lsdf.format(datetime.getTime());
    }

    public String getsDate() {
        return ssdf.format(datetime.getTime());
    }
}
