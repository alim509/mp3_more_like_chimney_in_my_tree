package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyGUIProgram extends Frame {

    // private variables
    private JFrame frame;
    private JMenuBar topMenu;
    private JMenu library, help;
    private JMenuItem furtherOption1, furtherOption2;
    private JPanel panel;
    private JLabel label;
    private JTextField tf;
    private JButton send, reset;
    private JTextArea ta;
    private Media m;
    private MediaPlayer mP;

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
        label = new JLabel(bb1);
        tf = new JTextField(10); // accepts upto 10 characters
        send = new JButton(bb2);
        reset = new JButton(bb3);
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, topMenu);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = tf.getText();
            }

        });


    }

}
