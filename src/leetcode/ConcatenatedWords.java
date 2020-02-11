package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

	public ConcatenatedWords() {
		// TODO Auto-generated constructor stub
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		// build trienode tree
		TrieNode root = new TrieNode();
		for (String word : words) {
			addWord(word, root);
		}

		// check whether one word is composed of others
		List<String> res = new ArrayList();
		for (String word : words) {
			if (testWord(root, word, 0, 0)) {
				res.add(word);
			}
		}
		return res;
	}

	public boolean testWord(TrieNode root, String word, int index, int count) {
		TrieNode cur = root;
		int l = word.length();
		for (int i = index; i < l; i++) {
			char c = word.charAt(i);
			if (cur.sons[c - 'a'] == null) {
				return false;
			}

			if (cur.sons[c - 'a'].isEnd) {
				if(i == l-1) {
					return count >= 1;
				}
				if (testWord(root, word, i + 1, count + 1)) {
					return true;
				}
			}
			cur = cur.sons[c - 'a'];
		}
		return false;
	}

	public void addWord(String word, TrieNode node) {
		int l = word.length();
		TrieNode cur = node;
		for (int i = 0; i < l; i++) {
			char c = word.charAt(i);
			if (cur.sons[c - 'a'] == null) {
				cur.sons[c - 'a'] = new TrieNode();
			}
			cur = cur.sons[c - 'a'];
		}
		cur.isEnd = true;
	}

	class TrieNode {
		TrieNode[] sons;
		boolean isEnd;

		public TrieNode() {
			this.sons = new TrieNode[26];
		}
	}

	public static void main(String[] args) {
		String[] words = new String[] { "cat", "cats", "catcats" };
		ConcatenatedWords c = new ConcatenatedWords();
		List<String> ans = c.findAllConcatenatedWordsInADict(words);
		System.out.println(ans.size());
		for (String s : ans) {
			System.out.println(s);
		}
	}

	/*
	 * public List<String> findAllConcatenatedWordsInADict(String[] words) { Trie
	 * trie = new Trie(); List<String> res = new ArrayList(); if(words.length == 0)
	 * { return res; }
	 * 
	 * for(String word: words) { trie.insert(word); }
	 * 
	 * for(String word: words) { if(trie.concatenated(word.toCharArray(), 0, 0)) {
	 * res.add(word); } } return res; }
	 * 
	 * public static void main(String[] args) { String[] words = new String[]
	 * {"cat","catcat"}; ConcatenatedWords cw = new ConcatenatedWords();
	 * List<String> ans = cw.findAllConcatenatedWordsInADict(words);
	 * System.out.println(ans.size()); for(String s: ans) { System.out.println(s); }
	 * }
	 */
}
