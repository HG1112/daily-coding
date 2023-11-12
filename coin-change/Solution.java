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
      }aCountcoutn = new HashMap<>();
    for (char c : a.toCharArray()) aCountcoutn.put(c, aCountcoutn
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

  // Problem 3
  public int change(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[amount+1][n];
    for (int[] d: dp) Arrays.fill(d, -1);
    return f(amount, coins, n-1, dp);
  }

  private int f(int amount, int[] coins, int i, int[][] dp) {
    if (amount == 0)
      return 1;
    if (i < 0) 
      return 0;
    if (dp[amount][i] != -1) return dp[amount][i];
    int ans = 0;
    if (amount >= coins[i])
      ans += f(amount- coins[i], coins, i, dp);
    ans += f(amount, coins, i-1, dp);
    return dp[amount][i] = ans;
  }
}
