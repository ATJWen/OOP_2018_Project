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

                TextField tfHour = new TextField(newAlarm.getHour());
                createAlarmPanel.add(tfHour);
                int tfHourInt = Integer.parseInt(tfHour.getText());

                createAlarmPanel.add(new JLabel(":"));

                TextField tfMinute = new TextField(newAlarm.getMinute());
                createAlarmPanel.add(tfMinute);
                int tfMinuteInt = Integer.parseInt(tfMinute.getText());

                createAlarmPanel.add(new JLabel(":"));

                TextField tfSecond = new TextField(newAlarm.getSecond());
                createAlarmPanel.add(tfSecond);
                int tfSecondInt = Integer.parseInt(tfSecond.getText());

                createAlarmPanel.add(new JLabel("\t\t"));

                TextField tfDay = new TextField(newAlarm.getDay());
                createAlarmPanel.add(tfDay);
                int tfDayInt = Integer.parseInt(tfDay.getText());

                createAlarmPanel.add(new JLabel("/"));

                TextField tfMonth = new TextField(newAlarm.getMonth());
                createAlarmPanel.add(tfMonth);
                int tfMonthInt = Integer.parseInt(tfMonth.getText());

                createAlarmPanel.add(new JLabel("/"));

                TextField tfYear = new TextField(newAlarm.getYear(), 4);
                createAlarmPanel.add(tfYear);
                int tfYearInt = Integer.parseInt(tfYear.getText());

                JTextArea jtaMessage = new JTextArea(6, 25);
                createAlarmPanel.add(jtaMessage);

                JButton confirmAlarm = new JButton("Create Alarm");
                confirmAlarm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newAlarm.setYear(tfYearInt);
                        newAlarm.setMonth(tfMonthInt);
                        newAlarm.setDay(tfDayInt, tfMonthInt, tfYearInt);
                        newAlarm.setHour(tfHourInt);
                        newAlarm.setMinute(tfMinuteInt);
                        newAlarm.setSecond(tfSecondInt);

                        if(newAlarm.getBadData() == "") {

                            newAlarm.setAlarmTime(tfYearInt, tfMonthInt, tfDayInt, tfHourInt, tfMinuteInt, tfSecondInt);
                            newAlarm.setAlarmMessage(jtaMessage.getText());
                            JOptionPane.showMessageDialog(null, "Alarm Succesfully Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, newAlarm.getBadData(), "Error", JOptionPane.ERROR_MESSAGE);
                        }

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
        setSize(350,150);
        setResizable(false);
    }

    public static void main(String[] args){
        new DigitalClock();
    }
}
