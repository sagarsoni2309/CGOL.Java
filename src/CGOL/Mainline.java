package CGOL;

import java.util.Scanner;

/**
 * 
 * @author Sagar Soni
 *@version 1.0
 */
public class Mainline {
public static void main(String args[]) throws InterruptedException{
	
	//For original generation
	logic.printOriginal();
	
	// No. of generation
	char decision;
	boolean nextGeneration=true;
	Scanner temp=new Scanner(System.in);
	while(nextGeneration) {
		System.out.println("You want Next generation?");
		decision=temp.next().charAt(0);
		
		// new thread for CGOL rules
		if(decision=='y' ) {
			logic thread=new logic();
			thread.start();
		}else {
			System.out.println("Game Over");
			nextGeneration=false;
		}
	}
	temp.close();
}
}
