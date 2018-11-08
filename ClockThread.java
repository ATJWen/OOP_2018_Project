import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClockThread extends Thread{

    private DigitalClock dc;
    private String time;
    private DateFormat sdf = new SimpleDateFormat("HH:mm:ss  dd/MM/yyyy");

    public ClockThread(DigitalClock dc){
        this.dc = dc;
        start();
    }

    public void run(){
        while(true){
                time = sdf.format(new Date());

                dc.jlabClock.setText(time);
        }
    }
}
