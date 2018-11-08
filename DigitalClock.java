import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalClock extends JFrame{

    JLabel jlabClock;
    private ClockThread ct;
    //Alarm allAlarm[] = new Alarm[number];
    //Alarm account;

    public DigitalClock(){
        jlabClock = new JLabel("Time");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clock");
        jlabClock.setFont(new Font("SansSerif Plain", Font.BOLD, 26));
        add(jlabClock);
        pack();
        setLocationRelativeTo(null);
        ct = new ClockThread(this);

       // getContentPane().setBackground(Color.BLACK);
        //setForeground(Color.GREEN);

        JButton createAlarmButton = new JButton("Create Alarm");
        createAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame alarmGUI = new JFrame();
                alarmGUI.setTitle("Create Alarm");
                alarmGUI.setVisible(true);
                alarmGUI.setSize(400,150);
                alarmGUI.setResizable(false);
                alarmGUI.setLocationRelativeTo(null);
            }
        });
        add(createAlarmButton);

        JButton createTimerButton = new JButton("Create Timer");
        createTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(createTimerButton);

        setVisible(true);
        setSize(400,150);
        setResizable(false);
    }

    public static void main(String[] args){
        new DigitalClock();
    }
}
