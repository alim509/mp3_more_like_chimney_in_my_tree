package com.company;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

       new MyGUIProgram("Chimney MP3", 400, 400, "LIBRARY", "HELP", "OPEN", "SAVE AS", "SEARCH", "PLAY", "RESET");

       //extract(new File("c:\\"));
    }

   /* public static void extract(File dir) {
        File l[] = dir.listFiles();

        if (l == null) {
            System.out.println("[skipped] " + dir);
            return;
        }

        for (File x : l) {
            if (x.isDirectory())
                extract(x);
            if (x.isHidden() || !x.canRead())
                continue;
            else if (x.getName().endsWith(".mp3"))
                System.out.println(x.getPath());//name should be included in path
        }
    } */
}

