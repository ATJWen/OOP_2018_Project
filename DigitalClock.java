import javax.swing.*;
import java.awt.*;

public class DigitalClock extends JFrame {

    JLabel jlabClock;
    private ClockThread ct;

    public DigitalClock(){
        jlabClock = new JLabel("Time");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlabClock.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(jlabClock);
        pack();
        setLocationRelativeTo(null);
        ct = new ClockThread(this);
        setVisible(true);
        setSize(450,200);
    }

    public static void main(String[] args){
        new DigitalClock();
    }
}
