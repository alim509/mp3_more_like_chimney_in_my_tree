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
    private JButton play, next;
    private JTextArea ta;
    private ArrayList<MP3Player> playlist;



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
        next = new JButton(bb3);
        panel.add(tf);
        panel.add(play);

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
        playlist = new ArrayList<MP3Player>();
        for (File f: files)
        {
            playlist.add(new MP3Player(f));
        }





        /*String list = "";
        files[0].toURI().getPath();
        for(File f: files)
        {
            list = (list + (f + "").substring(72, (f + "").length() - 4) + "\n");
        }
        ta.setText(list);*/

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                playlist.get(0).play();
            }

        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }

        });



    }

}