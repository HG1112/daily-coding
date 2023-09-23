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

}
