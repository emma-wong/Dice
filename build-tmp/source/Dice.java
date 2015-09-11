import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int sum = 0;

public void setup() {
    size(800, 800);
    noLoop();
}

public void draw() {
    background(0, 0, 0);
    for (int y = 10; y <= 730; y += 70) {
        for (int i = 10; i <= 780; i += 66) {
            Die p = new Die(i, y);
            p.show();
            p.roll();
            sum = sum + p.roll;
        }
    }
    fill(255);
    text("Total: " + sum, 300, 785);
}

public void mousePressed() {
    redraw();
    sum = 0;
}
class Die //models one single dice cube
{
    int roll;
    int value;
    int myX, myY;
    Die(int x, int y) //constructor
        {
            roll = (int)(Math.random() * 6) + 1;
            myX = x;
            myY = y;
        }

    public void roll() {
        if (roll == 1) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 25, myY + 25, 10, 10);
        } else if (roll == 2) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (roll == 3) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 25, myY + 25, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (roll == 4) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 15, 10, 10);
            ellipse(myX + 15, myY + 35, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (roll == 5) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 15, 10, 10);
            ellipse(myX + 25, myY + 25, 10, 10);
            ellipse(myX + 15, myY + 35, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (roll == 6) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 9, 9);
            ellipse(myX + 15, myY + 25, 9, 9);
            ellipse(myX + 15, myY + 35, 9, 9);
            ellipse(myX + 35, myY + 15, 9, 9);
            ellipse(myX + 35, myY + 25, 9, 9);
            ellipse(myX + 35, myY + 35, 9, 9);
        }
    }

    public void show() {
        stroke(2);
        fill(255, 255, 255);
        rect(myX, myY, 50, 50, 7);
        textSize(20);
    }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
