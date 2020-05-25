package com.window;

public class MaximumSumSubarrayKadane {

	public static void main(String[] args) {
		//int arr[] = {-8 ,-3,-6,-2,-5,-4};
		//int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		//int arr[] = {-2,1};// 1 : 1
		//int arr[] = {-2,1,2}; // 1 : 2
		int arr[] = {-2,1,2,4,-8,5};
		kadane(arr);
	}
	
	public static int kadane(int[] arr) {
		int startIndex = 0;
		int endingIndex = 0;
		int maxStartIndex = 0;
		int maxEndingIndex = 0;
		int maxSumSoFar = arr[0];
		int currentSum = arr[0];
		for(int i=1;i<arr.length;i++) {
			currentSum = currentSum + arr[i];
			endingIndex += 1;
			if(currentSum < arr[i]) {
				currentSum = arr[i];
				startIndex = i;
				endingIndex = i;
			}
			if(maxSumSoFar < currentSum) {
				maxSumSoFar = currentSum;
				maxStartIndex = startIndex;
				maxEndingIndex = endingIndex;
			}
			
		}
		
		System.out.println(maxStartIndex+" : "+maxEndingIndex);
		return 0;
	}
}
