class Trie {

  class TrieNode {
    boolean endOfWord;
    TrieNode[] child;

    TrieNode() {
      endOfWord = false;
      child = new TrieNode[26];
    }
  }

  TrieNode root;
  Trie() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int idx = c - 'a';
      if (cursor.child[idx] == null) {
        cursor.child[idx] = new TrieNode();
      }
      cursor = cursor.child[idx];
    }
    cursor.endOfWord = true;
  }

  public boolean startsWith(String pre) {
    TrieNode cursor = root;
    for (int i = 0; i < pre.length(); i++) {
      char c = pre.charAt(i);
      int idx = c - 'a';
      if (cursor.child[idx] == null) return false;
      cursor = cursor.child[idx];
    }
    return true;
  }

  public boolean contains(String word) {
    TrieNode cursor = root;
    for (int i = 0; i < pre.length(); i++) {
      char c = pre.charAt(i);
      int idx = c - 'a';
      if (cursor.child[idx] == null) return false;
      cursor = cursor.child[idx];
    }
    return cursor.endOfWord;
  }
}
