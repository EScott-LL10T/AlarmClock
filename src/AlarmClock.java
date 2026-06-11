import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
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
                IO.println("Thread was interrupted.");
            }
        }
        IO.println("\n*ALARM NOISES*");
        playSound(song);
    }

    private void playSound(File song){
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(song)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch(LineUnavailableException e){
            IO.println("audio is unavailable.");
        }
        catch (UnsupportedAudioFileException e) { // only to make compiler and ide happy :>
            IO.println("Audio file format is not supported.");
        }
        catch (IOException e) {
            IO.println("IO error.");
        }
    }

}
