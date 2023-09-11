import java.util.*;

class Solution {

  // Problem 1
  public boolean isValidSudoku(char[][] board) {
    boolean[][] col = new boolean[9][9];
    boolean[][] row = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') continue;
        int value = board[i][j] - '1';
        if (col[j][value]) return false;
        col[j][value] = true;
        if (row[i][value]) return false;
        row[i][value] = true;
        if (box[(i/3 * 3) + j/3][value]) return false;
        box[(i/3 * 3) + j/3][value] = true;
      }
    }
    return true;
  }

}
