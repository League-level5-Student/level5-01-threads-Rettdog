package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	public static boolean end = false;
	public static int winner = 0;
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		int length = 500;
		Robot[] robots = new Robot[length];
		int i = 50;
		int increaser = 1000/length;
		for(int j = 0;j<robots.length;j++) {
			robots[j] = new Robot();
			robots[j].setX(i+=increaser);
			robots[j].setY(800);
		}
		Thread[] threads = new Thread[length];
		for(i = 0;i<robots.length;i++) {
		int k = i;
		threads[i] = new Thread(()->new AdvancedRobotRace().robotRun(robots[k],50,k));
		}
		for(Thread t: threads) {
			t.start();
		}
		
		
	}
	
	public void robotRun(Robot rob,int condition, int number) {
		Random randy = new Random();
		rob.setSpeed(100);
		while(rob.getY()>condition&&!end) {
			rob.move(randy.nextInt(50));
			
		}
		
		winner = number;
		if(!end) {
		end = true;
		System.out.println(winner);
		System.out.println("end");
		rob.turn(720);
		JOptionPane.showMessageDialog(null, "Robot "+"#"+(winner+1)+" won!");
		rob.turn(720);
		}
		
		
		
		
			
			
		
	}

}
