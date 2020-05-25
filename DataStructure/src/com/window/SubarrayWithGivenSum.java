package com.window;

import java.util.HashMap;

public class SubarrayWithGivenSum {
public static void main(String[] args) {
	
	int sum = 10;
	int[] arr = {10, 2, -2, -20 };  //expect out put 0 to 0
    
//	int sum = 0;
//	int[] arr = {10, 2, -2, -20, 10};  //expect out put 1 to 2
	
	int n = arr.length; 
   
    subArraySum(arr, n, sum); 
}
    
    public static void subArraySum(int[] arr, int n, int sum) { 
        //cur_sum to keep track of cummulative sum till that point 
        int cur_sum = 0; 
        int start = 0; 
        int end = -1; 
        HashMap<Integer, Integer> hashMap = new HashMap<>(); 
  
        for (int i = 0; i < n; i++) { 
            cur_sum = cur_sum + arr[i]; 
            //check whether cur_sum - sum = 0, if 0 it means 
            //the sub array is starting from index 0- so stop 
            //this if is really required other wise we will get wrong answer for inputs like int sum = 10;int[] arr = {10, 2, -2, -20 }
            if (cur_sum - sum == 0) {  //it will handle all the subarrays that starts from 
                start = 0; 
                end = i; 
                break; 
            } 
            //if hashMap already has the value, means we already  
            // have subarray with the sum - so stop 
            if (hashMap.containsKey(cur_sum - sum)) { 
                start = hashMap.get(cur_sum - sum) + 1; 
                end = i; 
                break; 
            } 
            //if value is not present then add to hashmap 
            hashMap.put(cur_sum, i); 
  
        } 
        // if end is -1 : means we have reached end without the sum 
        if (end == -1) { 
            System.out.println("No subarray with given sum exists"); 
        } else { 
            System.out.println("Sum found between indexes " 
                            + start + " to " + end); 
        } 
  
    } 

}
