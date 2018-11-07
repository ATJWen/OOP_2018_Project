import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class Alarm extends Clock {

    private Calendar alarmTime = Calendar.getInstance();
    private String alarmMesssage;
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
            badData += "Invalid year\n";
        }
    }

    public void setMonth(int month){
        if(month <= 12 && month >= 1){
            this.alarmMonth = month;
        }else{
            badData += "Invalid month\n";
        }
    }


    public void setDay(int day, int month, int year){
       YearMonth yearMonthObject = YearMonth.of(year, month); //code from javapointstutorials.com
       int daysInMonth = yearMonthObject.lengthOfMonth();

        if(day <= daysInMonth && day >= 1){
            this.alarmDay = day;
        }else{
            badData += "Invalid day\n";
        }
    }

    public void setHour(int hour){
        if(hour <= 23 && hour >= 0){
            this.alarmHour = hour;
        }else{
            badData += "Invalid hour\n";
        }
    }

    public void setMinute(int minute){
        if(minute <= 59 && minute >= 0){
            this.alarmMinute = minute;
        }else{
            badData += "Invalid minute\n";
        }
    }

    public void setSecond(int second){
        if(second <= 59 && second >= 0){
            this.alarmSecond = second;
        }else{
            badData += "Invalid second\n";
        }
    }

    public void setAlarmTime(int alarmYear, int alarmMonth, int alarmDay, int alarmHour, int alarmMinute, int alarmSecond) {
        Date date = new Date(alarmYear, alarmMonth, alarmDay);
        alarmTime.setTime(date);
        alarmTime.set(Calendar.HOUR, alarmHour);
        alarmTime.set(Calendar.MINUTE, alarmMinute);
        alarmTime.set(Calendar.SECOND, alarmSecond);
    }

    public void setAlarmMesssage(String alarmMesssage){
        if(alarmMesssage!=""){
            this.alarmMesssage = alarmMesssage;
        }//end if
        else{
            this.alarmMesssage = "No message";
        }//end else
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
        if(badData!="") {
            return null;
        }//end if
        else {
            return badData;
        }//end else
    }

    public Calendar getAlarmTime() {
        return alarmTime;
    }

    public String getAlarmMesssage(){
        return alarmMesssage;
    }

    //Constructors
    public Alarm(int alarmYear, int alarmMonth, int alarmDay, int alarmHour, int alarmMinute, int alarmSecond, String alarmMessage){
        this.alarmYear = alarmYear;
        this.alarmMonth = alarmMonth;
        this.alarmDay = alarmDay;
        this.alarmHour = alarmHour;
        this.alarmMinute = alarmMinute;
        this.alarmSecond = alarmSecond;
        this.alarmMesssage = alarmMessage;
    }

    public Alarm(){
        this(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DATE),0,0,0, "");
    }

    //toString Message
    public String toString(){
        return ssdf.format(getAlarmTime()) + "\t\t\t" + getAlarmMesssage();
    }

    //Alarm Methods

}
