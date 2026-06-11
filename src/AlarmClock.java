import java.awt.*;
import java.io.File;
import java.time.LocalTime;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final File song;

    AlarmClock(LocalTime alarmTime, File song){
        this.alarmTime = alarmTime;
        this.song = song;
    }

    @Override
    public void run(){

        while(LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            } catch (InterruptedException e) {
                IO.println("Thread was interrupted");
            }
        }
        IO.println("\n**ALARM NOISES**");
        Toolkit.getDefaultToolkit().beep();
    }

}
