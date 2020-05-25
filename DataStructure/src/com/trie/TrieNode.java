package com.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
        this.children = new HashMap<>();
    }
}

