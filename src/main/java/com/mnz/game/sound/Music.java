package com.mnz.game.sound;

import java.io.*;
import javax.sound.sampled.*;

/*
* Author: N. Mattinson
* Date: 01/10/23
* Music.java
* 
* Attributes:
* 
* Constructors:
* +Music()
* 
* Methods:
* +playMusic(String) : void
*  
*/
public class Music extends SoundManager{
    // Attributes

    // Constructors
    public Music() {        // Empty Constructor

    }

    // Methods
    public void playMusic(String relativePathName) {
        // Create the music components and loop music
        try {
            File audioFile = new File(relativePathName); // Use relative path
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters

    // toString Method
}
