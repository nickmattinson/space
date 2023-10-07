package com.mnz.game.entity;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity extends JPanel {

    /*
     * Author: M. Mattinson
     * Date: 01/10/23
     * Entity.java
     * 
     * Attributes:
     * -name:String
     * -x:double
     * -y:double
     * -health:float = 1f // 0 < health <= 1
     * -speed:float = 0f   // speed >= 0
     * -heading:double = 0d; // 0 <= heading <= 360
     * 
     * Constructors:
     * +Player(name:String)
     * +Player()
     * 
     * Methods:
     * +toString():String
     * +move():void
     * 
     * +take a look at this code, its a basic and wrong way of "painting" the character to the screen
     */

    protected String name;
    protected int x;
    protected int y; 
    protected float health;         //aliens might need health, maybe planet, maybe asteroids, etc
    protected double speed;         //aliens, planets, asteroids, etc.
    protected double heading; 
    protected int Jx;
    protected int Jy;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    // constructors
    /*
     * new player constructor using name
     */
    public Entity(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.health = 1f;
        this.speed = 0d;
        this.heading = 0d;  // degrees
    }

      public Entity() {
        this.name = "Unknown entity";
        this.x = 0;
        this.y = 0;
        this.health = 1f;
        this.speed = 0d;
        this.heading = 0d;
    }

    public void paintComponent (Graphics g) {
        //super.paintComponent(g);
        //setSize(100,100);
        g.drawOval(this.Jx,this.Jy,5,5);

    }

    /*
     * override toString() method
     */
    public String toString(){
        String out = String.format("Name: %s\n", this.name);
        out += String.format("Coords: (%d, %d)\n", this.x, this.y);
        out += String.format("Heading: %05.1f\n", this.heading);
        out += String.format("Speed: %.2f\n", this.speed);
        out += String.format("Health: %.2f\n", this.health);
        return out;  
       }



    public void move() {
        /*
         * using the player's speed and heading
         * update the player's x and y position
         * NOTE. usually Cos goes with X and Sin with Y
         * but, the heading starts at the North pole, 0 degrees 
         * is straigh up, so you have to revserse the Cos and Sin
         */
        this.x = (int) (this.x + (this.speed * Math.sin(this.heading * Math.PI / 180)));
        this.y = (int) (this.y + (this.speed * Math.cos(this.heading * Math.PI / 180)));

        // update the Jx and Jy coordinates
        this.Jx = (this.x + 4000) / (20);
        this.Jy = (this.y + 3000) / (20);


    }

 

    public int getJx() {
        return Jx;
    }

    public void setJx(int jx) {
        Jx = jx;
    }

    public int getJy() {
        return Jy;
    }

    public void setJy(int jy) {
        Jy = jy;
    }

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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = Math.max(speed,0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        // reduce angle, but may still be negative...
        heading = heading % 360;

        // then ensure angle between 0 and 360
        this.heading = (heading + 360) % 360; 
    }

    public static void main(String[] args){
        // test toString() method
        Entity e = new Entity("Test entity");
        e.setX(300);
        e.setY(300);
        e.setHeading(125f);
        e.setHealth(.95f);
        e.setSpeed(12.23f);
        e.move();
        System.out.println(e.toString());  // output to debug console

    }
    
}
