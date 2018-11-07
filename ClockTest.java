import javax.swing.*;

public class ClockTest extends JFrame{

    public static void main(String[] args) {

        new ClockTest().setVisible(true);
        /*Clock clock = new Clock();

        System.out.println(clock.getlDate());
        System.out.println(clock.getsDate());

        Alarm alarm = new Alarm();



        //Checks if badData is empty. If empty, display success & save data, if not display badData message
        if(alarm.getBadData() == null){
            JOptionPane.showMessageDialog(null, "Success", "Yes", JOptionPane.INFORMATION_MESSAGE);
        }//end if
        else{
            JOptionPane.showMessageDialog(null, alarm.getBadData(), "No", JOptionPane.INFORMATION_MESSAGE);
        }*/


    }//end main method

    private ClockTest(){
        super("Clock");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
