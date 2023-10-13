package com.mnz.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
* Author: N. Mattinson
* Date: 01/10/23
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
    // Attributes
    protected boolean isOpen = false;

    // Constructors
    public Menu (){     // Empty constructor

    }

    // Methods
    public void openMainMenu(GamePanel gp){
        // Create a JFrame instance v1
        JFrame frame = new JFrame("NovaFlux");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the JFrame
        frame.setSize(1920, 1080);

        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);
        
        // Create JPanels
        JPanel toolBar = new JPanel();
        JPanel leftSide = new JPanel();
        JPanel rightSide = new JPanel();
        JPanel centerSpace = new JPanel();

        // Format each panel
        centerSpace.setPreferredSize(new Dimension(1720, 880));

        //build framework for main menu
        JLabel title = new JLabel("NOVA FLUX");
        JTextField enterUsername = new JTextField("Enter username...");
        enterUsername.setSize(100, 20);
        JButton play = new JButton("PLAY");

        // Customize font
        Font customFont = new Font("Arial", Font.BOLD, 18);
        play.setFont(customFont);
        title.setFont(customFont);
        enterUsername.setFont(customFont);

        // Add components to the center panel
        centerSpace.add(title);
        centerSpace.add(play);
        centerSpace.add(enterUsername);

        // Make play button work
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ImageIcon playerSpriteIcon = new ImageIcon("src\\main\\resources\\player\\ship_1.png");
                Image playerSpriteImage = playerSpriteIcon.getImage();
                JLabel playerSpriteLabel = new JLabel(new ImageIcon(playerSpriteImage));
                centerSpace.add(playerSpriteLabel);
                title.setVisible(false);
                play.setVisible(false);
                enterUsername.setVisible(false);
            }
        });


        // Add panels to the main window
        frame.add(leftSide, BorderLayout.LINE_START);
        frame.add(toolBar, BorderLayout.PAGE_START);
        frame.add(rightSide, BorderLayout.LINE_END);
        frame.add(centerSpace, BorderLayout.CENTER);

        // Make the JFrame visible
        frame.setVisible(true);
        isOpen = true;
    }
    // Getters and Setters
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    // toString Method
    @Override
    public String toString() {
        return "Menu [isOpen=" + isOpen + "]";
    }
}
