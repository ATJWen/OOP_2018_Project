/**
 * @author Aaron Tan
 * @version 1.0
 */

import javax.swing.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.YearMonth;
import java.util.*;

public class Alarm extends Clock implements Serializable{

    //private DateFormat sdf = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");

    /*JB Advice - do you really need this attribute alarmTime
     *since you are already keeping the time associated with the Alarm object
     *via the other attributes in the class anyway?
     *
     *Have you some other reason that you want the time stored within this nested object
     *Looking at your code currently, it is pretty redundant - I used it in getAlarmTime()
     *but I could have done the exact same job just using the other attributes of the class*/

    private Calendar alarmTime;
    private String alarmMessage;
    //variables for validation purposes
    private int alarmYear;
    private int alarmMonth;
    private int alarmDay;
    private int alarmHour;
    private int alarmMinute;
    private int alarmSecond;
    private String badData="";
    private String alarmMeridien; //added by JB for the meridien attribute of the alarm clock

    //mutators

    /**
     * @param year the year for the alarm
     */
    public void setYear(int year){
        if(year >= Calendar.getInstance().get(Calendar.YEAR)){
            this.alarmYear = year;
        }else{
            this.badData += "Invalid year\n";
        }
    }

    /**
     * @param month the month for the alarm
     */
    public void setMonth(int month){
        if(month <= 12 && month >= 0){
            this.alarmMonth = month;
        }else{
            this.badData += "Invalid month\n";
        }
    }


    /**
     * @param day the day for the alarm
     */
    public void setDay(int day){
        //YearMonth yearMonthObject = YearMonth.of(year, month); //code from javapointstutorials.com
        //int daysInMonth = yearMonthObject.lengthOfMonth();

        if(day <= 31 && day >= 1){
            this.alarmDay = day;
        }else{
            this.badData += "Invalid day\n";
        }
    }

    /**
     * @param hour the hour for the alarm
     */
    public void setHour(int hour){
        if(hour <= 12 && hour >= 1){
            this.alarmHour = hour;
        }else{
            this.badData += "Invalid hour\n";
        }
    }

    /**
     *
     * @param minute the minute for the alarm
     */
    public void setMinute(int minute){
        if(minute <= 59 && minute >= 0){
            this.alarmMinute = minute;
        }else{
            this.badData += "Invalid minute\n";
        }
    }

    /**
     *
     * @param second the second for the alarm
     */
    public void setSecond(int second){
        if(second <= 59 && second >= 0){
            this.alarmSecond = second;
        }else{
            this.badData += "Invalid second\n";
        }
    }

    //JB added this method to set meridien value provided the hour value corresponds
    //So if, for example, the user tries to set the alarm to 14:12:11 AM, it will raise a red flag
    //and not set the alarm unless the user changes the meridien to PM instead

    /**
     *
     * @param meridien the meridien for the alarm. either AM or PM
     */
    public void setMeridien(String meridien)
    {
        if(alarmMeridien.equals("AM") || alarmMeridien.equals("PM"))
            this.alarmMeridien = meridien;
        else
            badData += "Invalid meridien value\n";
    }


    /**
     * @param alarmYear the year for the alarm
     * @param alarmMonth the month for the alarm
     * @param alarmDay the day for the alarm
     * @param alarmHour the hour for the alarm
     * @param alarmMinute the minute for the alarm
     * @param alarmSecond the second for the alarm
     * @param alarmMeridien the meridien for the alarm. either AM or PM
     */
    public void setAlarmTime(int alarmYear, int alarmMonth, int alarmDay, int alarmHour, int alarmMinute, int alarmSecond,String alarmMeridien) {

        alarmTime.clear(); //added by JB to fix a spurious error with the alarmTime object's hour value

        this.alarmTime.set(alarmYear, alarmMonth, alarmDay, alarmHour, alarmMinute, alarmSecond);
        //Code added here by JB to set the AM/PM value of the alarmTime object
        if(alarmMeridien.equals("AM"))
            alarmTime.set(Calendar.AM_PM,Calendar.AM);
        else
            alarmTime.set(Calendar.AM_PM,Calendar.PM);

    }

    //Small modification by JB to fix logical error

    /**
     * @param message the message to be saved with the alarm
     */
    public void setMessage(String message){
        if(alarmMessage.equals("")){
            this.alarmMessage = message;
        }//end if
        else{
            this.alarmMessage = "No message";
        }//end else
    }

    /**
     * To set a messsage indicating which inputs are invalid
     */
    public void setBadData(){
        this.badData = "";
    }


    /**
     * @return an error message if the inputs are not valid
     */
    public String getBadData() {
        return badData;
    }


    /**
     * @return the alarm time set in a String format
     */
    public String getAlarmTimeString() {
        //return alarmTime.getTime().toString();
        //Code added by JB to render the alarm setting in a particular way, padding with zeroes where necessary and including the meridien value
        //You may want to render it differently Aaron so feel free to do so

        return String.format("%02d",alarmTime.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d",alarmTime.get(Calendar.MINUTE)) + ":" + String.format("%02d",alarmTime.get(Calendar.SECOND)) + " " + getAlarmMeridien() +
                "   " + String.format("%02d",alarmTime.get(Calendar.DATE)) + "/" + String.format("%02d",alarmTime.get(Calendar.MONTH)+1) + "/" + String.format("%d",alarmTime.get(Calendar.YEAR));
    }

    /**
     *
     * @return the message set in the alarm
     */
    public String getAlarmMessage(){
        return alarmMessage;
    }

    /**
     *
     * @return the alarm time
     */
    public Calendar getAlarmTime(){
        return alarmTime;
    }

    //JB added this accessor to retrieve meridien value of alarm

    /**
     *
     * @return the alarm meridien
     */
    public String getAlarmMeridien()
    {
        return alarmMeridien;
    }

    //Constructors

    /**
     * @param alarmTime the alarm time to set
     * @param alarmMessage the message for the alarm
     */
    public Alarm(Calendar alarmTime, String alarmMessage){
        this.alarmTime = alarmTime;
        this.alarmMessage = alarmMessage;
    }

    public Alarm(){
        this(Calendar.getInstance(), "No Message");
    }

    //toString Message

    /**
     *
     * @return the alarm time and message together.
     */
    @Override
    public String toString(){
        return getAlarmTimeString() + "\n" + getAlarmMessage() + "\n\n";
    }

    //Alarm Methods

    /**
     * To allow the alarm to ring when the set time has arrived.
     */
    public void ring(){
        JOptionPane.showMessageDialog(null, toString(), "Alarm", JOptionPane.INFORMATION_MESSAGE);
        //AudioFilePlayer.playAudio();
    }

}
