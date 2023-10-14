package com.mnz.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import com.mnz.game.entity.planet.Planet;
import com.mnz.game.entity.player.Player;
import com.mnz.game.entity.star.Star;
import com.mnz.game.sound.Music;
import com.mnz.game.util.KeyHandler;

/*
* Author: N. Mattinson & M. Mattinson
* Last Date Updated: 14 OCT 23
* GamePanel.java
* 
* Attributes:
* .originalTileSize: int
* .scale:int
* +.tileSize:int
* .maxScreenCol:int
* .maxScreenRow:int
* +.screenWidth:int
* +.screenHeight:int
* FPS:int
* gameThread:GameThread
* player:Player
* star:Star
* planet:Planet
* +menuMusic:Music
* +mainMenu:Menu
* menuIsOpen:boolean
* pauseButtonClicked:boolean
* gameStarted:boolean
* 
* Constructors:
* +GamePanel()
* 
* Methods:
* startGameThread():void
* run():void
* startMenu():void
* update():void
* paintComponent(Graphics):void
* setUpGame():void
* switchToMenu():void
* switchToPlaying():void
* getConfig():Object
* isFullScreenOn():boolean
*
*/

public class GamePanel extends JPanel implements Runnable{
    // Screen settings
    final int originalTileSize = 32;
    final int scale = 1;
    final int maxScreenCol = 60;
    final int maxScreenRow = 40;
    public final int tileSize = originalTileSize * scale;
    public final int screenWidth = tileSize * maxScreenCol;  // 1920 pixels
    public final int screenHeight = tileSize * maxScreenRow;  // 1280 pixels

    int FPS = 60; // Frames per second

    // Create Objects from Classes
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    Star star = new Star(this);
    Planet planet = new Planet(this);
    // StarManager starmgr = new StarManager(this, 5);

    // Create music and menu instance
    public static Music music = new Music();
    public static Menu mainMenu = new Menu();
    public static GameState gameState;

    // Declare Variables
    static boolean menuIsOpen = false;
    static boolean pauseButtonClicked = false;
    static boolean gameStarted = false;
    static boolean musicIsPlaying = false;

    public enum GameState {
        MENU, PLAYING;
    }

    // Constructor (empty)
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        gameState = GameState.MENU; // Set the initial state to MENU
    }

    // Methods
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (true){
            // Game logic (physics, AI, etc.)
            double drawInterval = 1000000000 / FPS; // 0.0166666 seconds
            double nextDrawTime = System.nanoTime() + drawInterval;
            
            // Render the game
            while(gameThread != null) {
                if (gameState == GameState.MENU) { 
                    // When you're done with the menu, switch back to PLAYING
                    while (mainMenu.playButtonClicked() && gameStarted == true){    
                        menuIsOpen = false; // Reset the menuIsOpen flag
                        gameStarted = true;
                        gameState = GameState.PLAYING;
                    }
                }
                if (gameState == GameState.PLAYING) {
                    update();
                    repaint();
                    if (!musicIsPlaying){
                        Music.playMusic(Menu.spawnMusic);
                        musicIsPlaying = true;
                    }
                    try {
                        double remainingTime = nextDrawTime - System.nanoTime();
                        remainingTime = remainingTime / 1000000;

                        if(remainingTime < 0) {
                            remainingTime = 0;
                        }
                        Thread.sleep((long) remainingTime);
                        nextDrawTime += drawInterval;

                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if(pauseButtonClicked){
                        gameStarted = false;
                        gameState = GameState.MENU;
                    }
                }
            }
        }
    }

    public void startMenu(){
        if (gameState == GameState.MENU) {
            if (!menuIsOpen) {
                // Display the menu only once
                mainMenu.openMainMenu(this, Main.window, screenHeight, screenWidth);
                menuIsOpen = true; // Set the menuIsOpen flag to true
            }
        }
    }

    public void update() {
        star.update();
        planet.update();
        player.update();
        //starmgr.update();
    }
    
    // Draw game components
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // This order is super important! == Layering in the window  [highest in list is furthest back, lowest on list is closest]
        star.draw(g2d);
        planet.draw(g2d);
        player.draw(g2d); 

        //starmgr.draw(g2);
        //***************************************WORK ON THIS PART TO GET STAR AND PLANET IMPLEMENTED. */
    }

    public void setUpGame() {
        player.setName("Mike");
        star.setName("Sun");
        star.setMagnitude(10);
        star.setX(this.screenHeight/2);
        star.setX(this.screenWidth/2);
        System.out.println(star.toString());  // output to debug console
        planet.setX(700);
        planet.setY(400);

        star.setUpStars();
    }

    public void switchToMenu() {
        gameState = GameState.MENU;
    }

    public void switchToPlaying() {
        gameState = GameState.PLAYING;
    }

    public Object getConfig() {
        return null;
    }

    public boolean isFullScreenOn() {
        return false;
    }
}
