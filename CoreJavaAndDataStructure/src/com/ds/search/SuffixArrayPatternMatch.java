package com.ds.search;



public class SuffixArrayPatternMatch {
	private final String[] suffixArray;

	public SuffixArrayPatternMatch(String[] suffixArray) {
		this.suffixArray = suffixArray;
	}
	private int compare(String str, String pattern) {
	     return str.startsWith(pattern) ? 0 : str.compareTo(pattern);
	}
	public boolean search (String pattern) {
        return binarySearch(0, suffixArray.length - 1, pattern);
    }
	private boolean binarySearch(int lb, int hb, String pattern) {
        if (lb > hb) {
            return false;
        }
        int mid = (lb + hb) / 2;

        int match = compare(suffixArray[mid], pattern);

        if (match == 0) return true;

        if (match > 0) { 
            return binarySearch(lb, mid -1, pattern);
        } else {
            return binarySearch(mid + 1, hb, pattern);
        }
    }
	public static void main(String[] args) {
		String[] suffix = { "a", "ameya", "eya", "meya", "ya" };
		SuffixArrayPatternMatch sapm = new SuffixArrayPatternMatch(suffix);
		System.out.println("Pattern found ? "+sapm.search("ya"));
	}
}

