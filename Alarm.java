import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.YearMonth;
import java.util.*;

public class Alarm extends Clock {

    private DateFormat ssdf = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");

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
    public void setYear(int year){
        if(year >= Calendar.getInstance().get(Calendar.YEAR)){
            this.alarmYear = year;
        }else{
            this.badData += "Invalid year\n";
        }
    }

    public void setMonth(int month){
        if(month <= 12 && month >= 0){
            this.alarmMonth = month;
        }else{
            this.badData += "Invalid month\n";
        }
    }


    public void setDay(int day, int month, int year){
        //YearMonth yearMonthObject = YearMonth.of(year, month); //code from javapointstutorials.com
        //int daysInMonth = yearMonthObject.lengthOfMonth();

        if(day <= 31 && day >= 1){
            this.alarmDay = day;
        }else{
            this.badData += "Invalid day\n";
        }
    }

    public void setHour(int hour){
        if(hour <= 24 && hour >= 0){
            this.alarmHour = hour;
        }else{
            this.badData += "Invalid hour\n";
        }
    }

    public void setMinute(int minute){
        if(minute <= 59 && minute >= 0){
            this.alarmMinute = minute;
        }else{
            this.badData += "Invalid minute\n";
        }
    }

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

    public void setAlarmMeridien(String alarmMeridien)
    {
        if(alarmMeridien.equals("AM") && alarmHour<=12 || alarmHour>0 && alarmMeridien.equals("PM"))
            this.alarmMeridien = alarmMeridien;
        else
            badData += "Invalid meridien value\n";
    }




    public void setAlarmTime(int alarmYear, int alarmMonth, int alarmDay, int alarmHour, int alarmMinute, int alarmSecond,String alarmMeridien) {

        alarmTime.clear(); //added by JB to fix a spurious error with the alarmTime object's hour value

        this.alarmTime.set(alarmYear, alarmMonth, alarmDay, alarmHour, alarmMinute, alarmSecond);
        //System.out.println(alarmHour);
        //Code added here by JB to set the AM/PM value of the alarmTime object
        if(alarmMeridien.equals("AM"))
            alarmTime.set(Calendar.AM_PM,Calendar.AM);
        else
            alarmTime.set(Calendar.AM_PM,Calendar.PM);

    }

    //Small modification by JB to fix logical error
    public void setAlarmMessage(String alarmMessage){
        if(alarmMessage.equals("")){
            this.alarmMessage = alarmMessage;
        }//end if
        else{
            this.alarmMessage = "No message";
        }//end else
    }

    public void setBadData(){
        this.badData = "";
    }

    //accessor methods
    public int getAlarmYear() {
        return alarmYear;
    }

    public int getAlarmMonth() {
        return alarmMonth;
    }

    public int getAlarmDay() {
        return alarmDay;
    }

    public int getAlarmHour() {
        return alarmHour;
    }

    public int getAlarmMinute() {
        return alarmMinute;
    }

    public int getAlarmSecond() {
        return alarmSecond;
    }


    public String getBadData() {
        return badData;
    }

    public String getAlarmTime() {
        //return alarmTime.getTime().toString();
        //Code added by JB to render the alarm setting in a particular way, padding with zeroes where necessary and including the meridien value
        //You may want to render it differently Aaron so feel free to do so

        return String.format("%02d",alarmTime.get(Calendar.HOUR)) + ":" + String.format("%02d",alarmTime.get(Calendar.MINUTE)) + ":" + String.format("%02d",alarmTime.get(Calendar.SECOND)) + " " + getAlarmMeridien() +
                "   " + String.format("%02d",alarmTime.get(Calendar.DATE)) + "/" + String.format("%02d",alarmTime.get(Calendar.MONTH)+1) + "/" + String.format("%d",alarmTime.get(Calendar.YEAR));
    }

    public String getAlarmMessage(){
        return alarmMessage;
    }

    //JB added this accessor to retrieve meridien value of alarm
    public String getAlarmMeridien()
    {
        return alarmMeridien;
    }

    //Constructors
    public Alarm(Calendar alarmTime, String alarmMessage){
        this.alarmTime = alarmTime;
        this.alarmMessage = alarmMessage;
    }

    public Alarm(){
        this(Calendar.getInstance(), "No Message");
    }

    //toString Message
    @Override
    public String toString(){
        return getAlarmTime() + "\n" + getAlarmMessage() + "\n\n";
    }

    //Alarm Methods

}
