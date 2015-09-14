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

//initialize var for total
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
            sum = sum + p.num;
        }
    }
    fill(255);
    text("Total: " + sum, 340, 785);
}

public void mousePressed() {
    redraw();
    sum = 0;
}

class Die //models one single dice cube
{
    int num;
    int value;
    int myX, myY;
    Die(int x, int y) //constructor
        {
            num = (int)(Math.random() * 6) + 1;
            myX = x;
            myY = y;
        }

    public void roll() {
        if (num == 1) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 25, myY + 25, 10, 10);
        } else if (num == 2) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (num == 3) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 25, myY + 25, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (num == 4) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 15, 10, 10);
            ellipse(myX + 15, myY + 35, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (num == 5) {
            fill((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            ellipse(myX + 15, myY + 15, 10, 10);
            ellipse(myX + 35, myY + 15, 10, 10);
            ellipse(myX + 25, myY + 25, 10, 10);
            ellipse(myX + 15, myY + 35, 10, 10);
            ellipse(myX + 35, myY + 35, 10, 10);
        } else if (num == 6) {
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
