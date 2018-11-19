import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.ArrayList;

/*JB Advice - these are things you could add to your application to beef it up
 *
 *ensure that no 2 Alarm objects have values that are exactly the same values
 *
 *allow a "snooze" feature on your alarm so that, when it goes off, you have the choice to snooze for
 *a certain amount of time before it goes off again - the user could be allowed to enter the snooze time
 *if you like
 *
 *When the alarm does go off, and should the user decide to "stop" rather than "snooze" then the alarm
 *object should be removed from the array list of Alarm objects
 *
 *Fix up the validation so that the user cannot set alarm for days and months in the past
 *
 *Play an audio file when the alarm goes off - you could have your alarm set up so that the
 *user is given the choice to wake up to a "beep"-type sound or a song (could be randomised)
 *You can use the AudioFilePlayer class to play the sound file
 *
 */

public class DigitalClock extends JFrame{

    static JLabel jlabClock;
    private ClockThread ct;
    private static ArrayList<Alarm> alarmList = new ArrayList<>();

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

                TextField tfHour = new TextField("00");
                createAlarmPanel.add(tfHour);

                createAlarmPanel.add(new JLabel(":"));

                TextField tfMinute = new TextField("00");
                createAlarmPanel.add(tfMinute);

                createAlarmPanel.add(new JLabel(":"));

                TextField tfSecond = new TextField("00");
                createAlarmPanel.add(tfSecond);

                String[] meridien = {"a.m", "p.m"};
                JComboBox meridienBox = new JComboBox(meridien);
                createAlarmPanel.add(meridienBox);

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
                        System.out.println(tfHour.getText());
                        int tfHourInt = Integer.parseInt(tfHour.getText());
                        int tfMinuteInt = Integer.parseInt(tfMinute.getText());
                        int tfSecondInt = Integer.parseInt(tfSecond.getText());
                        int tfDayInt = Integer.parseInt(tfDay.getText());
                        int tfMonthInt = Integer.parseInt(tfMonth.getText()) - 1;
                        int tfYearInt = Integer.parseInt(tfYear.getText());
                        String meridienBoxString = (String)meridienBox.getItemAt(meridienBox.getSelectedIndex());
                        System.out.println(meridienBoxString);
                        newAlarm.setSecond(tfSecondInt);
                        newAlarm.setMinute(tfMinuteInt);
                        newAlarm.setHour(tfHourInt);
                        newAlarm.setDay(tfDayInt, Integer.parseInt(tfMonth.getText()), tfYearInt);
                        newAlarm.setMonth(tfMonthInt);
                        newAlarm.setYear(tfYearInt);
                        newAlarm.setAlarmMeridien(meridienBoxString);

                        //JB Modified code - updated test from using == to using .equals() here
                        if(newAlarm.getBadData().equals("")) { //saves alarm into arraylist if no badData is found
                            newAlarm.setAlarmTime(tfYearInt, tfMonthInt, tfDayInt, tfHourInt, tfMinuteInt, tfSecondInt,meridienBoxString);
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
        boolean runningclock = true;

        while(runningclock) {
            for (Alarm list : alarmList) {
                    Timer timer = new Timer();
                    timer.schedule(list.ring(), list.getAlarmDate());
                }
            }
        }
    }

}