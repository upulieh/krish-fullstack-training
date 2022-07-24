package com.training.upulie;

import java.util.ArrayList;
import java.util.List;

public class Problem2{
	static List<Store> waterPours=new ArrayList<Store>();
	
	int[][] pattern;
	int col;
	int row;
	
	public Problem2(int[][] pattern, int col, int row) {
		this.pattern=pattern;
		this.col=col;
		this.row=row;
		
		start();
	}
	
	public double[] start() {
		System.out.println("*******************Problem**********************");
		printArray(pattern);
		
		double[][] splittedWaterPaths = waterfall(pattern,row, col);
		System.out.println("*******************Solution*********************");
		printArray(splittedWaterPaths);
		
		
		System.out.println("************************************************");
		printArray(splittedWaterPaths[splittedWaterPaths.length-1]);
		return splittedWaterPaths[splittedWaterPaths.length-1];
	}
	
	public double[][] waterfall(int[][] pattern,int r, int s) {
//		System.out.println("Problem 1");
//		System.out.println("s "+s);
//		printArray(pattern);
		
		//for storing water percentages
		double[][] percentages = new double[pattern.length][pattern[0].length];
		
		//setting the initial percentage
		percentages[r][s]=100.0;
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
						if(col==0) { //left most column
//							System.out.println("1 "+"Splitting "+(row)+","+col+" from "+(row-1)+","+col +" Changing "+percentages[row][col+1]+" to "+percentages[row-1][col]/2.0);
							percentages[row][col+1]=percentages[row-1][col]/2.0;
//							printArray(percentages);
						}else if(col == percentages[row].length-1) { //right most column
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
							}else if(pattern[row][col-1]==0 & pattern[row][col+1]==0){
								//both open (50%, 50%)
//								System.out.println("both open (50%, 50%)");
								percentages[row][col-1]=percentages[row-1][col]/2.0;
								percentages[row][col+1]=percentages[row-1][col]/2.0;
							}else{ //both closed, go in search for the hole in that direction								
								//to the left
								for(int x=(col-2);x>=0;x--) {
									if(pattern[row][x]==0) {
										//recursive pattern ?			
										waterPours.add(new Store(pattern,row,x));
									}	
								}
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

	public boolean isAHole(int row,int col) {
		if(pattern[row][col]==1)
			return false; //is a wall
		else 
			return true; //is a hole
	}
	
	public void printArray(int[][] array) {
		for(int[] row : array) {
			for(int value : row) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
	
	public void printArray(double[][] array) {
		for(double[] row : array) {
			for(double value : row) {
				System.out.print(value+"   ");
			}
			System.out.println();
		}
	}
	public void printArray(double[] array) {
			for(double value : array) {
				System.out.print(value+"   ");
			}
			System.out.println();
	}
}


