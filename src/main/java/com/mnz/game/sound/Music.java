package com.mnz.game.sound;

import java.io.*;
import javax.sound.sampled.*;

/*
* Author: N. Mattinson
* Date: 14 OCT 23
* Music.java
* 
* Attributes:
* -`clip:Clip
*
* Constructors:
* +Music()
* 
* Methods:
* +`playMusic(String) : void
* +`stopMusic():void
*  
*/
public class Music extends SoundManager{
    // Attributes
    private static Clip clip;
    // Constructors

    public Music() {        // Empty Constructor

    }

    // Methods
    public static void playMusic(String relativePathName) {
        // Create the music components and loop music
        try {
            File audioFile = new File(relativePathName); // Use relative path
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopMusic(String relativePathName){
        if(clip != null && clip.isOpen()){
            clip.stop();
            clip.close();
        }  
    }
}
