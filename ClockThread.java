/**
 * @author Infinity - https://www.youtube.com/watch?v=e3PnuTUjmQs
 */

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClockThread extends Thread{

    private DigitalClock dc;
    private String time;
    private DateFormat sdf = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");

    public ClockThread(DigitalClock dc){
        this.dc = dc;
        start();
    }

    public void run(){
        while(true){
            time = sdf.format(new Date());

            dc.jlabClock.setText(time);

            //try-catch added by JB to reduce the pressure on the CPU
            //this ensures the while loop sleeps every second, after which
            //it executes once more and draws the current system time
            //on the clock label on the GUI

            try
            {
                sleep(1000);
            }
            catch(InterruptedException ie)
            {
                System.out.println("Clock thread interrupted!");
            }


        }
    }
}
