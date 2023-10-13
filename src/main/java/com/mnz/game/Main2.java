package com.mnz.game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.mnz.game.sound.Music;

public class Main2 {

    public static JFrame window;
    public static void main(String[] args){
        // Create music and menu instance
        Music menuMusic = new Music();
        Menu mainMenu = new Menu();

        // Declare Variables
        final String relativeMenuMusicPath = "src\\main\\resources\\sounds\\2ssongsv2.wav";

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Space Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        //gamePanel.getConfig().loadConfig();

        if (gamePanel.isFullScreenOn()) {
            window.setUndecorated(true);
        }
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setUpGame();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Open main menu
                mainMenu.openMainMenu(gamePanel);
                // Play menu music
                menuMusic.playMusic(relativeMenuMusicPath);
            }
        });
        gamePanel.startGameThread();
        
    }
    
}
