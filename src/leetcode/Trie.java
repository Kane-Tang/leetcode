package leetcode;

import java.util.Scanner;

public class Trie {
	
	private TrieNode root; // root node
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;//start from the root node
        for(int i=0;i<word.length();i++) {
        	char tmp = word.charAt(i);
        	if(!node.containsKey(tmp)) {//find from its own links
        		System.out.println(tmp);
        		node.put(tmp, new TrieNode());
        	}
        	node = node.get(tmp);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }
    
    public TrieNode searchPrefix(String word) {
    	TrieNode node = root;
    	for(int i=0;i<word.length();i++) {
    		char tmp = word.charAt(i);
    		if(node.containsKey(tmp)) {
    			node = node.get(tmp);
    		}else {
    			return null;
    		}
    	}
    	return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    
    public static void main(String[] args) {
    	Trie obj = new Trie();
    	Scanner in = new Scanner(System.in);
    	while(true) {
    		String s = in.nextLine();
    		obj.insert(s);
    		System.out.println(obj.startsWith("leet"));
    	}
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
