package com.ds.search;

import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=sz1qaKt0KGQ
//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/GenerateNMatchedParenStrings/GenerateNMatchedParenStrings.java
public class GenerateNMatchedParenStrings {
	
	public static void main(String[] args) {
		GenerateNMatchedParenStrings generateNMatchedParenStrings = new GenerateNMatchedParenStrings();
		List<String> generateParentheses = generateNMatchedParenStrings.generateParentheses(3);
		System.out.println(generateParentheses);
	}

	public List<String> generateParentheses(int numPairs) {
	    List<String> result = new ArrayList<>();

	    directedGenerateBalancedParentheses(numPairs, numPairs, "", result); // kick off the recursion

	    return result;
	  }

	  private void directedGenerateBalancedParentheses(
	    int numLeftParensNeeded,
	    int numRightParensNeeded,
	    String parenStringInProgress,
	    List<String> result) {
	   
	    if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
	      result.add(parenStringInProgress);
	      return;
	    }
	    if (numLeftParensNeeded > 0) {
	      directedGenerateBalancedParentheses(
	        numLeftParensNeeded - 1,
	        numRightParensNeeded,
	        parenStringInProgress + "(",
	        result
	      );
	    }
	    if (numLeftParensNeeded < numRightParensNeeded) {
	      directedGenerateBalancedParentheses(
	        numLeftParensNeeded,
	        numRightParensNeeded - 1,
	        parenStringInProgress + ")",
	        result
	      );
	    }
	  }
}
