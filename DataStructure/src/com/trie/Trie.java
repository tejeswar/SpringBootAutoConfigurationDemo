package com.trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/discuss/156159/Java-solution-with-delete()-method
public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode(true); // root can represent an empty string
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
//    	trie.insert("abc");
//    	trie.insert("abgl");
//    	trie.insert("cdf");
//    	trie.insert("abcd");
    	trie.insert("lmn");
//    	boolean abc_search = trie.search("abc");
//    	System.out.println("abc found ? : "+abc_search);
    	boolean lmn_search = trie.search("lmn");
    	System.out.println("lmn found ? : "+lmn_search);
    	trie.delete("lmn");
    	System.out.println("lmn found ? : "+trie.search("lmn"));
    	
//    	trie.delete("abcd");
//    	System.out.println("abc found ? : "+trie.search("abc"));
	}
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            
            TrieNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) {
                child = new TrieNode(false);
                parent.children.put(cur, child);
            }
            
            parent = child; // Navigate to next level
        }
        
        parent.isEndOfWord = true;
    }
    
    /** Returns true if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) { // Assume that empty string is in the trie
            return false;
        }
        
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            
            TrieNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'word' is way too long or its prefix doesn't appear in the Trie
                return false;
            }
            
            parent = child; // Navigate to next level
        }
        
        return parent.isEndOfWord;
    }
    
    /** Returns true if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) { // Assume that empty string is a valid prefix
        if (prefix == null) {
            return false;
        }
        
        TrieNode parent = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            
            TrieNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'prefix' is way too long or its prefix doesn't appear in the Trie
                return false;
            }
            
            parent = child; // Navigate to next level
        }
        
        return true;
    }
    
    /** Deletes a word from the trie if present, and return true if the word is deleted successfully. */
    public boolean delete(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        
        // All nodes below 'deleteBelow' and on the path starting with 'deleteChar' (including itself) will be deleted if needed
        TrieNode deleteBelow = null;
        char deleteChar = '\0';
        
        // Search to ensure word is present
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            
            TrieNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'word' is way too long or its prefix doesn't appear in the Trie
                return false;
            }
            
            if (parent.children.size() > 1 || parent.isEndOfWord) { // Update 'deleteBelow' and 'deleteChar'
                deleteBelow = parent;
                deleteChar = cur;
            }
            
            parent = child;
        }
        
        if (!parent.isEndOfWord) { // word isn't in trie
            return false;
        }
        
        if (parent.children.isEmpty()) {
            deleteBelow.children.remove(deleteChar);
        } else {
            parent.isEndOfWord = false; // Delete word by mark it as not the end of a word
        }
        
        return true;
    }
}
