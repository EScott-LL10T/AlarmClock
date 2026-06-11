import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class AlarmClock{
    static void main(String[] args){
        alarmClock();
    }

    static void alarmClock(){
        Scanner s = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        while(alarmTime == null) {
            try {
                IO.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = s.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                IO.println("Alarm set for " + alarmTime);
            } catch (DateTimeParseException e) {
                IO.println("invalid format. Please user HH:MM:SS");
            }
        }


        s.close();
    }
}