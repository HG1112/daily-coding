import java.util.*;

class Solution {

  // Problem 1
  public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return f(nums, n-1, dp);
  }

  private int f(int[] nums, int i, int[] dp) {
    if (i < 0)
      return 0;
    if (dp[i] != -1) return dp[i];
    int noTake = f(nums, i-1, dp);
    int take = nums[i] + f(nums, i-2, dp);
    return dp[i] = Math.max(take, noTake);
  }

  // Problem 2
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    int take = g(nums, 0, n-2);
    int noTake = g(nums, 1, n-1);
    return Math.max(take, noTake);
  }
  private int g(int[] nums, int start, int end) {
    int pp = 0;
    int p = 0;
    int curr = 0;
    for (int i = start; i <= end; i++) {
      int take = pp + nums[i];
      int noTake = p;
      curr = Math.max(take, noTake);
      pp = p;
      p = curr;
    }
    return curr;
  }
}
