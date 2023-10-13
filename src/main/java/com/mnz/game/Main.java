package com.mnz.game;

import javax.swing.JFrame;
public class Main {
    public static JFrame window;
    public static GamePanel gamePanel = new GamePanel();

    
    public static void main(String[] args){
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Nova Flux");
        window.add(gamePanel);
        //********************* What is this if statement doing?? ****************************
        if (gamePanel.isFullScreenOn()) {
            window.setUndecorated(true);
        }

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.switchToMenu();
        gamePanel.startMenu();
        gamePanel.startGameThread();
    } 
}
