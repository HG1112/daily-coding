import java.util.*;

class Solution {

  // Problem 1
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int lo = 0, hi = m*n-1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      int x = mid / n;
      int y = mid % n;
      if (matrix[x][y] > target) {
        hi = mid-1;
      } else if (matrix[x][y] < target) {
        lo = mid+1;
      } else {
        return true;
      }
    }
    return false;
  }

}
