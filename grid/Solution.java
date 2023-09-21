import java.util.*;

class Solution {

  // Problem 1
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] vis = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, i, j, 0, vis, word)) return true;
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int i, int j, int k, boolean[][] vis, String word) {
    boolean ans = false;
    if (word.charAt(k) != board[i][j]) return ans;
    if (k == word.length() - 1) return true;
    vis[i][j] = true;
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    for (int[] di: directions) {
      int x = i + di[0];
      int y = j + di[1];
      if (!(0 <= x && x < board.length && 0 <= y && y < board[0].length)) continue;
      if (vis[x][y]) continue;
      ans = ans || dfs(board, x, y, k+1, vis, word);
    }
    vis[i][j] = false;
    return ans;
  }

  // Problem 2
  public List<String> letterCombinations(String digits) {
    char[][] letters = {
    {},
    {},
    {'a', 'b', 'c'},
    {'d', 'e', 'f'},
    {'g', 'h', 'i'},
    {'j', 'k', 'l'},
    {'m', 'n', 'o'},
    {'p', 'q', 'r', 's'},
    {'t', 'u', 'v'},
    {'w', 'x', 'y', 'z'}
    };
    String acc = "";
    List<String> ans = new LinkedList<>();
    if (digits.isEmpty()) return ans;
    f(digits, 0, letters, acc, ans);
    return ans;
  }
  private void f(String digits, int i, char[][] letters, String acc, List<String> ans) {
    if (i == digits.length()) {
      ans.add(acc);
      return;
    }
    int idx = digits.charAt(i) - '0';
    for (char c : letters[idx]) {
      f(digits, i+1, letters, acc + c, ans);
    }
  }
}
