import javax.swing.*;

public class ClockTest {

    public static void main(String[] args) {

        Clock clock = new Clock();

        System.out.println(clock.getlDate());
        System.out.println(clock.getsDate());

        Alarm alarm = new Alarm();
        /*set
        hour
        minute
        second
        day
        month
        year
        wake up message
         */

        //Uncomment
        //Checks if badData is empty. If empty, display success & save data, if not display badData message
        /*if(alarm.getBadData() == null){
            JOptionPane.showMessageDialog(null, "Success", "Yes", JOptionPane.INFORMATION_MESSAGE);
        }//end if
        else{
            JOptionPane.showMessageDialog(null, alarm.getBadData(), "No", JOptionPane.INFORMATION_MESSAGE);
        }*/

        //To display getAlarmTime() getAlarmMessage()
    }
}
