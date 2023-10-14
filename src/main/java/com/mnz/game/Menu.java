package com.mnz.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mnz.game.GamePanel.GameState;
import com.mnz.game.sound.Music;

/*
* Author: N. Mattinson
* Date: 14 OCT 23
* Menu.java
* 
* Attributes:
* +.relativeMenuMusicPath:String
* +.playButton:JButton
* +.mainMenuTitle:JLabel
* +toolBar:JPanel
* +leftSide:JPanel
* +rightSide:JPanel
* +centerSpace:JPanel
* +enterUsername:JTextField
* +customFont:Font
* + frame:JFrame
* 
* Constructors:
* +Menu()
* 
* Methods:
* +openMainMenu():void
* +isOpen():boolean
* +playButtonClicked():void
*
*/

public class Menu {
    // Declare Variables
    public final String relativeMenuMusicPath = "src\\main\\resources\\sounds\\2ssongsv2.wav";
    public static String spawnMusic = "src\\main\\resources\\sounds\\spacehop.wav";
    public final String galaxyMusic = "src\\main\\resources\\sounds\\ship_is_hit.wav";
    public final String battleMusic = "src\\main\\resources\\sounds\\shields_up.wav";
    public final JButton playButton = new JButton("PLAY");
    public final JLabel mainMenuTitle = new JLabel("NOVA FLUX");
    public JPanel toolBar = new JPanel();;
    public JPanel leftSide = new JPanel();;
    public JPanel rightSide = new JPanel();;
    public JPanel centerSpace = new JPanel();;
    public JTextField enterUsername;
    public Font customFont;
    public JFrame frame;
    
    // Constructors
    public Menu (){     // Empty constructor

    }

    // Methods
    public void openMainMenu(GamePanel gp, JFrame frame, int screenHeight, int screenWidth){
        this.frame = frame;
        // Create JPanels
        centerSpace = new JPanel();

        // Format each panel
        centerSpace.setPreferredSize(new Dimension(screenHeight , screenWidth));
        centerSpace.setBackground(Color.black);

        //build framework for main menu
        enterUsername = new JTextField("Enter username...");
        enterUsername.setSize(100, 20);

        // Customize font
        Font customFont = new Font("Arial", Font.BOLD, 18);
        playButton.setFont(customFont);
        mainMenuTitle.setFont(customFont);
        enterUsername.setFont(customFont);

        // Add components to the center panel
        //centerSpace.add(mainMenuTitle);
        centerSpace.add(playButton);
        //centerSpace.add(enterUsername);

        // Play menu music
        Music.playMusic(relativeMenuMusicPath);

        // Add panels to the main window
        frame.add(leftSide, BorderLayout.LINE_START);
        frame.add(toolBar, BorderLayout.PAGE_START);
        frame.add(rightSide, BorderLayout.LINE_END);
        frame.add(centerSpace, BorderLayout.CENTER);

        // Make the JFrame visible
        frame.setVisible(true);
        //isOpen = true;
    }

    public boolean playButtonClicked(){
        // Make play button work
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                GamePanel.menuIsOpen = false;
                GamePanel.gameState = GameState.PLAYING;
                mainMenuTitle.setVisible(false);
                playButton.setVisible(false);
                enterUsername.setVisible(false);
                centerSpace.setVisible(false);
                Music.stopMusic(relativeMenuMusicPath);
            }
        });
        return true;
    }

    public void closeMenu(){
        centerSpace.setVisible(false);
    }

    public void openMenu(){
        centerSpace.setVisible(true);
    }
}
