package com.training.upulie;

public class Application {	
	
	public static void main(String args[]) {
		
		int[][] pattern={
				{0,0,0,0,0,0,0},
				{1,0,0,0,0,0,0},
				{0,0,0,1,0,0,0},
				{0,0,0,0,0,0,0},
				{0,1,1,1,0,1,0},
				{0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0}
				};
		int s=3;
		
		//results 
		double[] buckets = new double[pattern.length];
		
		
		Problem2 p2=new Problem2(pattern, s, 0);
		double[] initialWaterBuckets= p2.start();
		printBuckets(initialWaterBuckets);
		
		for (int x =0; x<Problem2.waterPours.size();x++) {
			System.out.println("row "+Problem2.waterPours.get(x).row);
			System.out.println("col "+Problem2.waterPours.get(x).col);
			System.out.println("pattern "+Problem2.waterPours.get(x).pattern);
			
			//for each of these, 
			Problem2 p = new Problem2(Problem2.waterPours.get(x).pattern, Problem2.waterPours.get(x).col, Problem2.waterPours.get(x).row);
			double[] newBuckets= p2.start();
			printBuckets(newBuckets);
		}
	}
	
	static void printBuckets(double[] b) {
		for(int x=0;x>=b.length;x++) {
			System.out.print(x+" ");
		}
	}

}
