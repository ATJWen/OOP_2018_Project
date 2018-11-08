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

                Alarm newAlarm = new Alarm();

                JFrame alarmGUI = new JFrame();
                alarmGUI.setTitle("Create Alarm");
                alarmGUI.setVisible(true);
                alarmGUI.setSize(400,300);
                alarmGUI.setLocationRelativeTo(null);

                JPanel createAlarmPanel = new JPanel();

                TextField tfHour = new TextField("00");
                createAlarmPanel.add(tfHour);
                int tfHourInt = Integer.parseInt(tfHour.getText());

                createAlarmPanel.add(new JLabel(":"));

                TextField tfMinute = new TextField("00");
                createAlarmPanel.add(tfMinute);
                int tfMinuteInt = Integer.parseInt(tfMinute.getText());

                createAlarmPanel.add(new JLabel(":"));

                TextField tfSecond = new TextField("00");
                createAlarmPanel.add(tfSecond);
                int tfSecondInt = Integer.parseInt(tfSecond.getText());

                createAlarmPanel.add(new JLabel("\t\t"));

                TextField tfDay = new TextField("00");
                createAlarmPanel.add(tfDay);
                int tfDayInt = Integer.parseInt(tfDay.getText());

                createAlarmPanel.add(new JLabel("/"));

                TextField tfMonth = new TextField("00");
                createAlarmPanel.add(tfMonth);
                int tfMonthInt = Integer.parseInt(tfMonth.getText());

                createAlarmPanel.add(new JLabel("/"));

                TextField tfYear = new TextField("00", 4);
                createAlarmPanel.add(tfYear);
                int tfYearInt = Integer.parseInt(tfYear.getText());

                JTextArea jtaMessage = new JTextArea(6, 25);
                createAlarmPanel.add(jtaMessage);

                JButton confirmAlarm = new JButton("Create Alarm");
                confirmAlarm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newAlarm.setAlarmTime(tfYearInt, tfMonthInt, tfDayInt, tfHourInt, tfMinuteInt, tfSecondInt);
                        newAlarm.setAlarmMessage(jtaMessage.getText());
                    }
                });
                createAlarmPanel.add(confirmAlarm);

                alarmGUI.add(createAlarmPanel);
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
