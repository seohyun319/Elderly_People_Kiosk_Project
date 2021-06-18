import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayAudio{
    Clip clip;
    String filename;
    AudioInputStream audioStream;

    public PlayAudio(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        audioStream=AudioSystem.getAudioInputStream(
                new File(filename)
                        .getAbsoluteFile());

        clip = AudioSystem.getClip();

        clip.open(audioStream);

    }

    public void Play()
    {

        clip.start();


    }
    public void Stop() {
        clip.stop();
    }
}