package com.mnz.game.entity.star;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mnz.game.GamePanel;
import com.mnz.game.entity.Entity;

public class Star extends Entity {

    private int magnitude;
    protected GamePanel gp;
    private String name;
    private static final int NUM_CIRCLES = 400; // Number of circles in the array
    private List<StarProperties> stars = new ArrayList<>();

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
        /* this.x = 400;
        this.y = 400; */
    }

    public void setUpStars() {
        Random random = new Random();
        for (int i = 0; i < NUM_CIRCLES; i++) {
            int x = random.nextInt(gp.screenWidth);
            int y = random.nextInt(gp.screenHeight);
            int diameter = random.nextInt(7) + 1;
            int diameter2 = random.nextInt(7) + 1;
            stars.add(new StarProperties(x, y, diameter, diameter2));
        }
    }
    
    public void update() {
        //System.out.println(this.toString());
        // nothing to update
    }

    public void draw(Graphics2D g2) { 
        super.paint(g2);
        g2.setColor(Color.WHITE);
    
        for (StarProperties star : stars) {
            g2.fillOval(star.x, star.y, star.diameter, star.diameter2);
        }
    }   

    public String toString(){
        String out = String.format("Name: %s\n", this.name);
        out += String.format("Coords: (%d, %d)\n", this.x, this.y);
        out += String.format("Magnitude: %s\n", this.magnitude);
        return out;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }
}
