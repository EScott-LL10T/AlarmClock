import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class Main {
    static void main(String[] args){
        alarmClock();
    }

    static void alarmClock(){
        Scanner s = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        File file;
        file = new File("src\\alarmSong");
        File[] songs = file.listFiles();
        File song;
        if(songs == null){
            IO.println("no files in alarmSong folder.");
            return;
        }
        if(!songs[0].isFile()){
            IO.println("the file in alarmSong is not a file.");
            return;
        }
        if(!songs[0].getName().contains(".wav")) {
            IO.println("please put a .wav file in alarmSong.");
            return;
        }

        song = songs[0];

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

        AlarmClock alarmClock = new AlarmClock(alarmTime, song, s);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }



}