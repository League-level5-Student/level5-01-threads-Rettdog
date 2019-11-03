package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
public static void main(String[] args) {
	Robot blue = new Robot();
	Robot yellow = new Robot();
	Robot black = new Robot();
	Robot green = new Robot();
	Robot red = new Robot();
	blue.setPenColor(Color.blue);
	black.setPenColor(Color.black);
	yellow.setPenColor(Color.yellow);
	green.setPenColor(Color.green);
	red.setPenColor(Color.red);
	(new OlympicRings_Threaded()).drawCircle(blue,100,100,25,5);
	(new OlympicRings_Threaded()).drawCircle(black,250,100,25,5);
	(new OlympicRings_Threaded()).drawCircle(red,400,100,25,5);
	(new OlympicRings_Threaded()).drawCircle(yellow,175,150,25,5);
	(new OlympicRings_Threaded()).drawCircle(green,315,150,25,5);
	
}
public void drawCircle(Robot rob,int x,int y,int r,int segments) {
	double theta = 90/segments;
	double div = 0;
	for(int i = 0;i<90;i++) {
		div+=Math.cos(theta*i);
	}
	double forward = r/div;
	rob.hide();
	rob.setSpeed(10);
	rob.penUp();
	rob.setX(x+=r);
	rob.setY(y);
	rob.penDown();
	
	for(int i = 0;i<segments*4;i++) {
		rob.move((int) forward);
		rob.turn((int) theta);
	}
	rob.penUp();
	
}
	
}

