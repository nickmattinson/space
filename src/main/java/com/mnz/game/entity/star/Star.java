package com.mnz.game.entity.star;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import com.mnz.game.GamePanel;
import com.mnz.game.entity.Entity;



public class Star extends Entity {

    int magnitude;
    GamePanel gp;
    int x, y;
    String name;



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star(GamePanel gp) {
        this.gp = gp;
        this.name = "Unknown star";
        this.x = 400;
        this.y = 400;
 
        
        // randome int between 1 and 5
        Random random = new Random();
        this.magnitude = random.nextInt(50) + 10;
        //setSize(WIDTH, HEIGHT);




    }
    
    public void update() {
        //System.out.println(this.toString());
        // nothing to update

    }

    public void draw(Graphics2D g2) {

        // create a circle representing the star
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, magnitude, magnitude); // Draw the circle
        g2.dispose();

    }   

    public String toString(){

        String out = String.format("Name: %s\n", this.name);
        out += String.format("Coords: (%d, %d)\n", this.x, this.y);
        out += String.format("Magnitude: %s\n", this.magnitude);
        return out;

    }
    
    public static void main(String[] args){
        // test toString() method
        GamePanel gp = new GamePanel();
        Star s = new Star(gp);
        s.setName("Test star");
        s.setX(300);
        s.setY(300);
        System.out.println(s.toString());  // output to debug console

    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }



}
