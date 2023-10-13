package com.mnz.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
* Author: N. Mattinson
* Date: 13 OCT 23
* Menu.java
* 
* Attributes:
* -isOpen:boolean
* 
* Constructors:
* +Music()
* 
* Methods:
* +openMainMenu():void
* +isOpen():boolean
* +setOpen():void
* +toString():String
*
*/

public class Menu {
    // Declare Variables
    public final String relativeMenuMusicPath = "src\\main\\resources\\sounds\\spacehop.wav";
    public final JButton playButton = new JButton("PLAY");
    public final JLabel mainMenuTitle = new JLabel("NOVA FLUX");
    public JPanel toolBar = new JPanel();;
    public JPanel leftSide = new JPanel();;
    public JPanel rightSide = new JPanel();;
    public JPanel centerSpace = new JPanel();;
    public JTextField enterUsername;
    public Font customFont;
    
    //protected boolean isOpen = false;

    // Constructors
    public Menu (){     // Empty constructor

    }

    // Methods
    public void openMainMenu(GamePanel gp, JFrame frame){
        // Create JPanels
        toolBar = new JPanel();
        leftSide = new JPanel();
        rightSide = new JPanel();
        centerSpace = new JPanel();

        // Format each panel
        centerSpace.setPreferredSize(new Dimension(1720, 880));
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
        centerSpace.add(mainMenuTitle);
        centerSpace.add(playButton);
        centerSpace.add(enterUsername);

        // Play menu music
        GamePanel.menuMusic.playMusic(relativeMenuMusicPath);

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
                ImageIcon playerSpriteIcon = new ImageIcon("src\\main\\resources\\player\\ship_1.png");
                Image playerSpriteImage = playerSpriteIcon.getImage();
                JLabel playerSpriteLabel = new JLabel(new ImageIcon(playerSpriteImage));
                centerSpace.add(playerSpriteLabel);
                mainMenuTitle.setVisible(false);
                playButton.setVisible(false);
                enterUsername.setVisible(false);
                //isOpen = false;
            }
        });
        return true;
    }

    public void closeMenu(){
        mainMenuTitle.setVisible(false);
        playButton.setVisible(false);
        enterUsername.setVisible(false);
    }
}
