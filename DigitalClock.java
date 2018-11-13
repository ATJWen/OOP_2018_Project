import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DigitalClock extends JFrame{

    JLabel jlabClock;
    private ClockThread ct;
    ArrayList<Alarm> alarmList = new ArrayList<>();

    public DigitalClock(){ //Begin DigitalClock class
        jlabClock = new JLabel("Time");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clock");
        jlabClock.setFont(new Font("SansSerif Plain", Font.BOLD, 26));
        add(jlabClock);
        pack();
        setLocationRelativeTo(null);
        ct = new ClockThread(this);

        getContentPane().setBackground(Color.BLACK);
        jlabClock.setForeground(Color.GREEN);

        JButton createAlarmButton = new JButton("Create Alarm");
        createAlarmButton.addActionListener(new ActionListener() { //begin alarmbutton action listener
            @Override
            public void actionPerformed(ActionEvent e) { //begin alarmbutton actionPerformed

                Alarm newAlarm = new Alarm();

                JFrame alarmGUI = new JFrame();
                alarmGUI.setTitle("Create Alarm");
                alarmGUI.setVisible(true);
                alarmGUI.setSize(400,300);
                alarmGUI.setLocationRelativeTo(null);

                JPanel createAlarmPanel = new JPanel();

                TextField tfHour = new TextField(newAlarm.getHour());
                createAlarmPanel.add(tfHour);

                createAlarmPanel.add(new JLabel(":"));

                TextField tfMinute = new TextField("00");
                createAlarmPanel.add(tfMinute);

                createAlarmPanel.add(new JLabel(":"));

                TextField tfSecond = new TextField("00");
                createAlarmPanel.add(tfSecond);

                /*String[] meridien = {"AM", "PM"};
                JComboBox meridienBox = new JComboBox(meridien);
                createAlarmPanel.add(meridienBox);*/

                createAlarmPanel.add(new JLabel("\t\t"));

                TextField tfDay = new TextField(newAlarm.getDay());
                createAlarmPanel.add(tfDay);

                createAlarmPanel.add(new JLabel("/"));

                String monthInt = Integer.toString(Integer.parseInt(newAlarm.getMonth()) + 1);
                TextField tfMonth = new TextField(monthInt);
                createAlarmPanel.add(tfMonth);

                createAlarmPanel.add(new JLabel("/"));

                TextField tfYear = new TextField(newAlarm.getYear(), 4);
                createAlarmPanel.add(tfYear);

                JTextArea jtaMessage = new JTextArea(6, 25);
                createAlarmPanel.add(jtaMessage);

                JButton confirmAlarm = new JButton("Create Alarm");
                confirmAlarm.addActionListener(new ActionListener() {  //begin confirmAlarm Action Listener
                    @Override
                    public void actionPerformed(ActionEvent e) { //begin confirmAlarm action performed

                        int tfHourInt = Integer.parseInt(tfHour.getText());
                        int tfMinuteInt = Integer.parseInt(tfMinute.getText());
                        int tfSecondInt = Integer.parseInt(tfSecond.getText());
                        int tfDayInt = Integer.parseInt(tfDay.getText());
                        int tfMonthInt = Integer.parseInt(tfMonth.getText()) - 1;
                        int tfYearInt = Integer.parseInt(tfYear.getText());
                        //String meridienBoxString = (String)meridienBox.getItemAt(meridienBox.getSelectedIndex());
                        newAlarm.setSecond(tfSecondInt);
                        newAlarm.setMinute(tfMinuteInt);
                        newAlarm.setHour(tfHourInt);
                        newAlarm.setDay(tfDayInt, Integer.parseInt(tfMonth.getText()), tfYearInt);
                        newAlarm.setMonth(tfMonthInt);
                        newAlarm.setYear(tfYearInt);


                        if(newAlarm.getBadData() == "") { //saves alarm into arraylist if no badData is found
                            newAlarm.setAlarmTime(tfYearInt, tfMonthInt, tfDayInt, tfHourInt, tfMinuteInt, tfSecondInt);
                            //newAlarm.setAlarmMeridien(meridienBoxString);
                            newAlarm.setAlarmMessage(jtaMessage.getText());
                            alarmList.add(newAlarm);
                            JOptionPane.showMessageDialog(null, "Alarm set to " + newAlarm.getAlarmTime(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            alarmGUI.dispatchEvent(new WindowEvent(alarmGUI, WindowEvent.WINDOW_CLOSING));
                        }else{  //displays error message
                            JOptionPane.showMessageDialog(null, newAlarm.getBadData(), "Invalid Data", JOptionPane.INFORMATION_MESSAGE);
                            newAlarm.setBadData();
                        } //end else

                    }//end confirmAlarm action performed
                });  ////begin confirmAlarm Action Listener
                createAlarmPanel.add(confirmAlarm);

                alarmGUI.add(createAlarmPanel);
            }  //end alarmbutton action performed
        }); //end alarmbutton actionlistener
        add(createAlarmButton);

        JButton createViewAlarmButton = new JButton("View Alarms");
        createViewAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String allAlarmList = "" ;
                for(Alarm list : alarmList){
                    allAlarmList += list.toString();
                } //end for loop to print arraylist
                JOptionPane.showMessageDialog(null, allAlarmList, "All Alarms", JOptionPane.INFORMATION_MESSAGE);
            } //end view alarm action performed
        });  //end view alarm action listener
        add(createViewAlarmButton);

        setVisible(true);
        setSize(350,150);
        setResizable(false);
    }//close DigitalClock class

    public static void main(String[] args){
        new DigitalClock();
    }
}
