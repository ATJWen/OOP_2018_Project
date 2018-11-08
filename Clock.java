import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock{

    private static final DateFormat lsdf = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
    public static final DateFormat ssdf = new SimpleDateFormat("hh:mm:ss a yyyy/MM/dd");
    public Calendar datetime = Calendar.getInstance();
    public String hour = datetime.get(Calendar.HOUR);
    public String minute;
    public String second;
    public String year;
    public String month;
    public String day;

    public String getlDate() {
        return lsdf.format(datetime.getTime());
    }

    public String getsDate() {
        return ssdf.format(datetime.getTime());
    }
}
