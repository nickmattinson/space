package com.mnz.game;

import javax.swing.JFrame;

public class Main2 {

    public static JFrame window;


    public static void main(String[] args){

       

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
        gamePanel.startGameThread();
        
    }
    
}
