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

  // Problem 3
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new LinkedList<>();
    char[][] board = new char[n][n];
    for (char[] c: board) Arrays.fill(c, '.');
    boolean[] col = new boolean[n];
    boolean[] pos = new boolean[2*n -1];
    boolean[] neg = new boolean[2*n -1];
    g(board, 0, col, pos, neg, ans);
    return ans;
  }

  private void g(char[][] board, int i, boolean[] col, boolean[] pos, boolean[] neg, List<List<String>> ans) {
    int n = board.length;
    if (i == n) {
      List<String> acc = new LinkedList<>();
      for (char[] c: board) acc.add(new String(c));
      ans.add(acc);
      return;
    }
    for (int j = 0; j < n; j++) {
      if (col[j]) continue;
      if (pos[i-j+(n-1)]) continue;
      if (neg[i+j]) continue;
      col[j] = true;
      pos[i-j+(n-1)] = true;
      neg[i+j] = true;
      board[i][j] = 'Q';
      g(board, i+1, col, pos, neg, ans);
      col[j] = false;
      pos[i-j+(n-1)] = false;
      neg[i+j] = false;
      board[i][j] = '.';
    }
  }

  // Problem 4
  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(i, j, grid);
        }
      }
    }
    return count;
  }
  private void dfs(int i,int j, char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    grid[i][j] = '0';
    int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    for (int[] di: directions) {
      int x = i + di[0];
      int y = j + di[1];
      if (!(0 <= x && x < m && 0 <= y && y < n)) continue;
      if (grid[x][y] == '0') continue;
      dfs(x, y , grid);
    }
  }

  // Problem 5
  public int maxAreaOfIsland(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          ans = Math.max(ans, count(i, j, grid));
        }
      }
    }
    return ans;
  }
  private int count(int i, int j, int[][] grid) {
    grid[i][j] = 0;
    int ans = 1;
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    int m = grid.length;
    int n = grid[0].length;
    for (int[] di: directions) {
      int x = i + di[0];
      int y = j + di[1];
      if (!(0 <= x && x < m && 0 <= y && y < n)) continue;
      if (grid[x][y] == 0) continue;
      ans += count(x, y, grid);
    }
    return ans;
  }
}


