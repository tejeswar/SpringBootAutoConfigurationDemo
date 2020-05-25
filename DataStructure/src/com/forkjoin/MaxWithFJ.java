package com.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
//https://www.ibm.com/developerworks/java/library/j-jtp11137/index.html
public class MaxWithFJ extends RecursiveAction {
    private final int threshold;
    private final SelectMaxProblem problem;
    public int result;
 
    public MaxWithFJ(SelectMaxProblem problem, int threshold) {
        this.problem = problem;
        this.threshold = threshold;
    }
 
    protected void compute() {
        if (problem.size < threshold) {
        	  result = problem.solveSequentially();
        	  System.out.println("Solving sequenctially...");
        }
          
        else {
            int midpoint = problem.size / 2;
            MaxWithFJ left = new MaxWithFJ(problem.subproblem(0, midpoint), threshold);
            MaxWithFJ right = new MaxWithFJ(problem.subproblem(midpoint + 
              1, problem.size), threshold);
            left.fork();
            right.compute();
            left.join();
            System.out.println(left.result+" : "+right.result);
            result = Math.max(left.result, right.result);
        }
    }
 
    public static void main(String[] args) {
    	
    	int[] arr1 = getRandomArray();
        SelectMaxProblem problem = new SelectMaxProblem(arr1 , 0, arr1.length,arr1.length);
        int threshold = 5;
        int nThreads = 4;
        MaxWithFJ mfj = new MaxWithFJ(problem, threshold);
        ForkJoinPool fjPool = new ForkJoinPool(nThreads);
 
        fjPool.invoke(mfj);
        int result = mfj.result;
        System.out.println("Result is : "+result);
    }
    
    public static int[] getRandomArray() {
    	int[] arr1 = {5,3,8,6,4,98,456,34,23,43,1000,2003,95,123,234,421,865};
    	int[] arr = new int[1000];
    	Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
           arr[i] = rd.nextInt(); // storing random integers in an array
           //System.out.println(arr[i]); // printing each array element
        }
        //return arr;
        return arr1;
    }
}
