import java.util.Arrays;

class Solution {

  // Problem 1
  private int minCoins(int amount, int[] denomination) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin: denomination) {
        if (i >= coin && dp[i-coin] >= 0) {
          if (dp[i] == -1) 
            dp[i] = dp[i-coin] + 1;
          else
            dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
        }
      }
    }
    return dp[amount];
  }


  // Problem 2
  private int numFlips(int n) {
    int ans = 0;
    while (n > 1) {
      ans++;
      n = n >> 1;
    }
    return ans;
  }
}
