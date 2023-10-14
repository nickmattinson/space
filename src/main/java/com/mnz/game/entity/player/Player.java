package com.mnz.game.entity.player;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mnz.game.GamePanel;
import com.mnz.game.entity.Entity;
import com.mnz.game.util.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    boolean imageIsRead;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 600;
        y = 600;
        speed = 0;
        direction = "down";
        heading = 0d;  // degrees
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/ship_1.png"));
            //up1 = ImageIO.read(getClass().getResource("resources/player/ship_1.png"));
            if (up1 != null){
                imageIsRead = true;
            }
            System.out.println("player image read properly: " + imageIsRead);

            up2 = up1;
            down1 = up1;
            down2 = up1;
            left1 = up1;
            left2 = up1;
            right1 = up1;
            right2 = up1;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed == true) {
            direction = "up";
            setSpeed(speed +.1);
        }
        else if(keyH.downPressed == true){
            direction = "down";
            setSpeed(speed -.1);
        }
        else if(keyH.leftPressed == true){
            direction = "left";
            //x -= speed;
            setHeading(heading - 1);
        }
        else if(keyH.rightPressed == true){
            direction = "right";
            //x += speed;
            setHeading(heading + 1);
        }
        //System.out.println(this.toString());  // debug 
        this.x = (int) (this.x + (this.speed * Math.sin(this.heading * Math.PI / 180)));
        this.y = (int) (this.y - (this.speed * Math.cos(this.heading * Math.PI / 180)));
    }

    public void draw(Graphics2D g2) {
        super.paint(g2);
        BufferedImage image = null;
    
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
    
        final double rads = Math.toRadians(heading);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads, 0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
    
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(image, rotatedImage);
        
        // Calculate the position to draw the rotated image
        int drawX = x - (w - image.getWidth()) / 2;
        int drawY = y - (h - image.getHeight()) / 2;
        System.out.println("( " + drawX + ", " + drawY + ")");
    
        g2.drawImage(rotatedImage, drawX, drawY, w, h, null);
    }    

    public String toString(){
        String out = super.toString();
        out += String.format("Player: %s\n", "additional player info");
        return out;
    }

    public static void main(String[] args){
        // test toString() method
        GamePanel gp = new GamePanel();
        KeyHandler keyh = new KeyHandler();
        Player p = new Player(gp, keyh);
        p.setName("Test player");
        p.setX(300);
        p.setY(300);
        p.setHeading(125f);
        p.setHealth(.95f);
        p.setSpeed(12.23f);
        p.move();
        System.out.println(p.toString());  // output to debug console
    }
}
