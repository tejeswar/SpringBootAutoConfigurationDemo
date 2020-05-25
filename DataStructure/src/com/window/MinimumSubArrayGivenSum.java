package com.window;

public class MinimumSubArrayGivenSum {

	public static void main(String[] args) {
		int[] arr = {7,2,1,1,6,5};
		int targetSum = 11;
		int minSubArrLength = minSubArrayLength(arr,targetSum);
		System.out.println("Length of minimum subarrary is : "+minSubArrLength);
	}
	private static int minSubArrayLength(int[] arr, int targetSum) {
		// TODO Auto-generated method stub
		int startIndex = 0;
		int endIndex = 0;
		int currentSum = 0;
		int minLength = Integer.MAX_VALUE;
		
		for( ;endIndex<arr.length; endIndex++) {
			
			currentSum += arr[endIndex];
			while(currentSum >= targetSum && startIndex <= endIndex) {
				
		    minLength = Math.min(minLength, (endIndex-startIndex)+1);
		    currentSum = currentSum - arr[startIndex];
		    startIndex++;				
			}
			
		}
		return (minLength == Integer.MAX_VALUE) ? 0:minLength;
	}
}
