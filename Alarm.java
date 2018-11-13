import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.YearMonth;
import java.util.Calendar;

public class Alarm extends Clock {

    private DateFormat ssdf = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");
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

    public void setAlarmTime(int alarmYear, int alarmMonth, int alarmDay, int alarmHour, int alarmMinute, int alarmSecond) {
        alarmTime.set(alarmYear, alarmMonth, alarmDay, alarmHour, alarmMinute, alarmSecond);
    }

    public void setAlarmMessage(String alarmMessage){
        if(alarmMessage!=""){
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
        return alarmTime.getTime().toString();
    }

    public String getAlarmMessage(){
        return alarmMessage;
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
