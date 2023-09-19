import java.util.*;

class Solution {

  // Problem 1
  class WordDictionary {

    class TrieNode {
      boolean end;
      TrieNode[] child;

      TrieNode() {
        end = false;
        child = new TrieNode[26];
      }

    }
    TrieNode root;

    public WordDictionary() {
      root = new TrieNode();
    }
    
    public void addWord(String word) {
      TrieNode curr = root;
      for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.child[idx] == null)
          curr.child[idx] = new TrieNode();
        curr = curr.child[idx];
      }
      curr.end = true;
    }
    
    public boolean search(String word) {
      return search(word, 0, root);
    }
    private boolean search(String word, int i, TrieNode curr) {
      if (i == word.length())
        return curr != null && curr.end;
      boolean ans = false;
      if (word.charAt(i) == '.') {
        for (int idx = 0; idx < 26; idx++) 
          if (curr.child[idx] != null)
            ans = ans || search(word, i+1, curr.child[idx]);
      } else {
        int idx = word.charAt(i) - 'a';
        if (curr.child[idx] == null) return false;
        ans = search(word, i+1, curr.child[idx]);
      }
      return ans;
    }
}

}
