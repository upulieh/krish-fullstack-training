package com.training.upulie;

import java.util.Arrays;

public class Problem1 {
	
	static int[][] pattern={
			{0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,0,0,1,0},
			{0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0}
			};
	static int s=6;
	

	
	public static void main(String args[]) {
		System.out.println("*******************Problem**********************");
		printArray(pattern);
		
		double[][] splittedWaterPaths = waterfall(pattern,s);
		System.out.println("*******************Solution*********************");
		printArray(splittedWaterPaths);
		
		double[] buckets = new double[pattern.length];
		buckets = splittedWaterPaths[splittedWaterPaths.length-1];
		System.out.println("************************************************");
		printArray(buckets);
		
	}
	public static double[][] waterfall(int[][] pattern,int s) {
//		System.out.println("Problem 1");
//		System.out.println("s "+s);
//		printArray(pattern);
		
		//for storing water percentages
		double[][] percentages = new double[pattern.length][pattern[0].length];
		
		//setting the initial percentage
		percentages[0][s]=100.0;
//		printArray(percentages);
		
		
		for(int row=1;row<pattern.length;row++) {
			for(int col=0;col<pattern[row].length;col++) {
				if((percentages[row-1][col]!=0.0)) {
//					System.out.println("percentage prev "+percentages[row-1][col]);
					if(isAHole(row,col)) {
						//if it is a hole, it falls through
//						System.out.println("0 Falling through to "+(row)+","+col+" from "+(row-1)+","+col+" percentage "+percentages[row-1][col]);
						percentages[row][col]=percentages[row-1][col];
//						printArray(percentages);
					}else {
						//if it is a wall, it will split
						if(col==0) {
//							System.out.println("1 "+"Splitting "+(row)+","+col+" from "+(row-1)+","+col +" Changing "+percentages[row][col+1]+" to "+percentages[row-1][col]/2.0);
							percentages[row][col+1]=percentages[row-1][col]/2.0;
//							printArray(percentages);
						}else if(col == percentages[row].length-1) {
//							System.out.println("2 "+"Splitting "+(row)+","+col+" from "+(row-1)+","+col +" Changing "+percentages[row][col+1]+" to "+percentages[row-1][col]/2.0);
							percentages[row][col-1]=percentages[row-1][col]/2.0;
//							printArray(percentages);
						}else {
							//assuming if both adjacent sides are also 1 (1,1,1), water disappears
							////assuming it all goes through one hole if the other is closed
							if(pattern[row][col-1]==1 & pattern[row][col+1]==0) {
								//left close, right open
//								System.out.println("left close, right open");
								percentages[row][col+1]=percentages[row-1][col];
							}else if(pattern[row][col-1]==0 & pattern[row][col+1]==1) {
								//right close, left open
//								System.out.println("right close, left open");
								percentages[row][col-1]=percentages[row-1][col]; 
							}else {
								//both open (50%, 50%)
//								System.out.println("both open (50%, 50%)");
								percentages[row][col-1]=percentages[row-1][col]/2.0;
								percentages[row][col+1]=percentages[row-1][col]/2.0;
							}
							
//							System.out.println("3 "+"Splitting "+(row)+","+(col-1)+" from "+(row-1)+","+col +" changing "+percentages[row][col+1]+" to "+percentages[row][col-1]);
//							System.out.println("4 "+"Splitting "+(row)+","+(col+1)+" from "+(row-1)+","+col +" Changing "+percentages[row][col+1]+" to "+percentages[row][col+1]);
//							printArray(percentages);
						}	
					}	
				}
			}	
		}
		return percentages;
	}
	
	public static boolean isAHole(int row,int col) {
		if(pattern[row][col]==1)
			return false; //is a wall
		else 
			return true; //is a hole
	}
	
	public static void printArray(int[][] array) {
		for(int[] row : array) {
			for(int value : row) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(double[][] array) {
		for(double[] row : array) {
			for(double value : row) {
				System.out.print(value+"   ");
			}
			System.out.println();
		}
	}
	public static void printArray(double[] array) {
			for(double value : array) {
				System.out.print(value+"   ");
			}
			System.out.println();
	}
}
