package al5872;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        MyGUIProgram m = new MyGUIProgram("Chimney MP3", 400, 400, "LIBRARY", "HELP", "OPEN", "SAVE AS", "SEARCH", "PLAY", "NEXT");
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("/Users/al5091/IdeaProjects/mp3_more_like_chimney_in_my_tree/Chimney MP3/bensound-creativeminds.mp3").getAbsoluteFile());
            Clip c = AudioSystem.getClip();
            c.open(ais);
            c.start();
        }
        catch (Exception e)
        {}

    }
}

