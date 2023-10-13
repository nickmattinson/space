package com.mnz.game;
import javax.swing.*;

import com.mnz.game.sound.Music;

/*
* Author: N. Mattinson
* Date: 01/10/23
* Main.java    
* 
* Attributes:
* =menuMusic:Music
* =mainMenu:Menu
* XrelativeMenuMusicPath:String
* Xrelative2ssongsv2MusicPath:String
* 
* Constructors:
* +main()
* 
* Methods:
* +run():void
*  
*/

public class Main {
    public static void main(String[] args) {
        // Create music and menu instance
        Music menuMusic = new Music();
        Menu mainMenu = new Menu();

        // Declare Variables
        final String relativeMenuMusicPath = "src\\main\\resources\\sounds\\2ssongsv2.wav";

        //functions now (old main method, need to convert back to main2. or bring main2 code 
        //to this main method and delete this code)

        //this line of code allows the game to run using EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Open main menu
                mainMenu.openMainMenu();
                // Play menu music
                menuMusic.playMusic(relativeMenuMusicPath);
            }
        }); 
    }
}