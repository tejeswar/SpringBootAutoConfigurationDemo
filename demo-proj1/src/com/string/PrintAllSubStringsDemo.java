package com.string;

public class PrintAllSubStringsDemo {

    static void subString(char str[], int n) { 
        // Pick starting point 
        for (int subStringlen = 1; subStringlen <= n; subStringlen++) { 
            // Pick ending point 
            for (int startingIndex = 0; startingIndex <= n - subStringlen; startingIndex++) { 
                //  Print characters from current 
                // starting point to current ending 
                // point.   
                int endingIndex = startingIndex + subStringlen - 1; 
                for (int k = startingIndex; k <= endingIndex; k++) { 
                    System.out.print(str[k]); 
                } 
  
                System.out.println(); 
            } 
        } 
    } 

    public static void main(String[] args) { 
        char str[] = {'a', 'b', 'c','d'}; 
        subString(str, str.length); 
  
    } 
	
}
