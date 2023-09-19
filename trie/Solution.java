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

  // Problem 2
  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word: words)
      trie.addWord(word);
    int m = board.length;
    int n = board[0].length;
    int[][] vis = new int[m][n];
    for (int[] d: vis) Arrays.fill(d, -1);
    List<String> ans = new LinkedList<>();
    String acc = "";
    for (int i = 0; i < m; i++) 
      for (int j = 0; j < n; j++)
        dfs(board, i, j, vis, trie.root, ans, acc);
    return ans;
  }

  private void dfs(char[][] board, int i, int j, int[][] vis, TrieNode curr, List<String> ans, String acc) {
    if (i >= board.length || j >= board[0].length)
      return;
    char c = board[i][j];
    vis[i][j] = 1;
    int idx = c - 'a';
    if (curr.child[idx] == null) return;

    acc += c;
    // tweak end from boolean to number of words ending at curr and idx
    if (curr.child[idx].endOfWord != 0) {
      curr.child[idx].endOfWord--;
      ans.add(acc);
    }
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    for (int[] di: directions) {
      int x = i + di[0];
      int y = j + di[1];
      if (!(0 <= x && x < board.length && 0 <= y && y < board[0].length)) continue;
      if (vis[x][y] != -1) continue;
      dfs(board, x, y, vis, curr.child[idx], ans, acc);
    }
    vis[i][j] = -1;
  }

}
