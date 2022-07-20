package com.training.upulie;

import java.util.Arrays;

public class Problem1 {
	
	static int[][] pattern={
			{0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,0,0,0,0},
			{0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0}
			};
	static int s=3;
	
	public static void main(String args[]) {
		
		int[][] splittedWaterPaths = waterfall(pattern,s);
		System.out.println("splittedWaterPaths "+Arrays.deepToString(splittedWaterPaths));
		
	}
	public static int[][] waterfall(int[][] pattern,int s) {
		System.out.println("Problem 1");
		System.out.println("pattern "+Arrays.deepToString(pattern));
		
		//for storing water percentages
		int[] buckets = new int[pattern.length];
		int[][] percentages = new int[pattern.length][pattern[0].length];
		
		//setting the initial percentage
		percentages[0][s]=100;
		
		System.out.println("buckets "+buckets.length);
		System.out.println("s "+s);
		
		
		for(int row=1;row<pattern.length;row++) {
			for(int col=s;col<pattern[row].length;col++) {
				if(isAHole(row,col)) {
					//if it is a hole, it falls through
					percentages[row][col]=percentages[row-1][col];
				}else {
					//if it is a wall, it will split
					if((col >= 1) & (col <= percentages[row].length-2)) {
						percentages[row][col-1]=(percentages[row-1][col]/2);
						percentages[row][col+1]=(percentages[row-1][col]/2);
					}
				}	
			}	
		}
		return percentages;
	}
	
	public static boolean isAHole(int row,int col) {
		if(pattern[row][col]==1)
			return false;
		else
			return true;
	}
}
