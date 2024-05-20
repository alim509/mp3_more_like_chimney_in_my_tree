package al5872;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MyGUIProgram extends Frame {

    // private variables
    private JFrame frame;
    private JMenuBar topMenu;
    private JMenu library, help;
    private JMenuItem furtherOption1, furtherOption2;
    private JPanel panel;
    private JTextField tf;
    private JButton play, pause, next;
    private JTextArea ta;
    private ArrayList<String> playlist;
    private MP3Player player;
    private boolean isPlaying;


    // Constructor to setup the GUI components
    public MyGUIProgram(String name, int width, int height, String tb1, String tb2, String tb1o1, String tb1o2, String bb1, String bb2, String bb3) {

        //Creating the Frame
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);


        //Creating the MenuBar and adding components
        topMenu = new JMenuBar();
        library = new JMenu(tb1);
        help = new JMenu(tb2);
        topMenu.add(library);
        topMenu.add(help);
        furtherOption1 = new JMenuItem(tb1o1);
        furtherOption2 = new JMenuItem(tb1o2);
        library.add(furtherOption1);
        library.add(furtherOption2);


        //Creating the panel at bottom and adding components
        panel = new JPanel(); // the panel is not visible in output
        tf = new JTextField(10); // accepts upto 10 characters
        play = new JButton(bb2);
        pause = new JButton(bb3);
        next = new JButton(bb1);
        //panel.add(tf);
        panel.add(play);
        panel.add(pause);
        panel.add(next);

        // Text Area at the Center
        ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, topMenu);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        //File folder = new File("/Users/al5872/IdeaProjects/mp3_more_like_chimney_in_my_tree/Chimney MP3/");
        File folder = new File("Chimney MP3");
        File[] files = folder.listFiles();
        playlist = new ArrayList<String>();
        for (File f: files)
        {
            playlist.add(f.getAbsolutePath());
        }
        player = new MP3Player();

        player.setPath(playlist.get(0));
        isPlaying = false;

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!isPlaying)
                {
                    if(player.canResume())
                        player.resume();
                    else
                        player.play(-1);
                    isPlaying = true;
                }
            }

        });

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (isPlaying) {
                    player.pause();
                    isPlaying = false;

                }
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                player.pause();
                playlist.add(playlist.remove(0));
                player.setPath(playlist.get(0));
                isPlaying = true;
                player.play(-1);
            }
        });



    }

}