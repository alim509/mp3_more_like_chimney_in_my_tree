package al5872;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MP3Player
{
    private AudioInputStream ais;
    private Clip mp3Clip;
    private boolean isPlaying;


    public MP3Player(File file)
    {
        try
        {
            ais = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
            mp3Clip = AudioSystem.getClip();
            isPlaying = false;
        }
        catch (Exception e)
        {

        }
    }

    public void play()
    {
        if(!isPlaying)
        {
            try
            {
                mp3Clip.open(ais);
                mp3Clip.start();
                isPlaying = !isPlaying;
            }
            catch (Exception e)
            {

            }
        }
    }
}
