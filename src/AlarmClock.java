import java.time.LocalTime;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;

    AlarmClock(LocalTime alarmTime){
        this.alarmTime = alarmTime;
    }

    @Override
    public void run(){

        while(LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);
                IO.println(LocalTime.now());
            } catch (InterruptedException e) {
                IO.println("Thread was interrupted");
            }
        }
    }

}
