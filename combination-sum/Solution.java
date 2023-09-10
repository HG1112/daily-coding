import java.util.*;

class Solution {

  // Problem 1
  private int combinationSum4(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) return 0;

    int[] dp = new int[target+1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        dp[i] = i - num >= 0 ? dp[i- num] : 0;
      }
    }

    return dp[target];
  }


}
