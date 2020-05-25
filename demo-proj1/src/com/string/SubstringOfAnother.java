package com.string;

//https://www.geeksforgeeks.org/check-string-substring-another/
public class SubstringOfAnother {

	 // Returns true if s1 is substring of s2 
    static int isSubstring(String sub, String main) 
    { 
        int subLength = sub.length(); 
        int mainLength = main.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= mainLength - subLength; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < subLength; j++) 
                if (main.charAt(i + j) != sub.charAt(j)) 
                    break; 
      
            if (j == subLength) 
                return i; 
        } 
      
        return -1; 
    } 
      
    /* Driver program to test above function */
    public static void main(String args[]) 
    { 
        String subString = "for"; 
        String mainString = "geeksforgeeks"; 
          
        int res = isSubstring(subString, mainString); 
          
        if (res == -1) 
            System.out.println("Not present"); 
        else
            System.out.println("Present at index "  
                                           + res); 
    } 
}
//Time complexity : O(subLength * mainLength) where subLength and mainLength are 
//lengths of ssubString and mainString respectively.
