package com.mnz.game.entity.star;

import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

import com.mnz.game.GamePanel;

public class StarManager extends JFrame{
        GamePanel gp;
        Star[] stars;

        public StarManager(GamePanel gp, int star_count) {
            this.gp = gp;
            stars = new Star[star_count];
            //setDefaultValues();
            //getPlayerImage();

            // create Star objects
            for(int i = 0; i<star_count; i++){
                stars[i] = new Star(this.gp);
                stars[i].setName("Unknown star");

                // set random coordinates
                Random random = new Random();
                int x_coord = random.nextInt(gp.screenWidth) + 1;
                int y_coord = random.nextInt(gp.screenHeight) + 1;
                stars[i].setX(x_coord);
                stars[i].setY(y_coord);

            }
    
        }

        public void setDefaultValues(){

        }

        public void draw(Graphics2D g2) {

            //g2.setColor(Color.WHITE);
            //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

            // print out every star in star array
            for (Star star : this.stars) {
                // 'star' is the current Star object in the array
                // Perform operations on the 'star' object
                // For example: star.draw(g2);
                star.draw(g2);
            }
    
        }  

        public String toString(){

            String out = String.format("Stars: %s\n", this.stars.length);
            out += String.format(Arrays.toString(stars));

            return out;
    
        }        

        public static void main(String[] args){
            // test toString() method
            GamePanel gp = new GamePanel();
            int stars = 20; // number of stars
            StarManager sm = new StarManager(gp, stars);
            System.out.println(sm.toString());  // output to debug console

        }

        public void update() {

            // print out every star in star array
            for (Star star : this.stars) {
                // 'star' is the current Star object in the array
                // Perform operations on the 'star' object
                // For example: star.draw(g2);
                star.update();
            }
        }
    
}
