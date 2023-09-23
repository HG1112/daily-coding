class Solution {


  // Problem 1
  public boolean canCross(int[] stones) {
    return move(0, 1, stones);
  }

  private boolean move(int i, int jump, int[] stones) {
    int n = stones.length;
    if (i >= n) return false;
    if (i == n-1) return true;
    if (jump <= 0) return false;
    i = Arrays.binarySearch(stones, stones[i] + jump);
    if (i >= 0) {
      return (move(i, jump-1, stones) || move(i, jump, stones) || move(i, jump+1, stones));
    } else {
      return false;
    }
  }

  // Problem 2
  public int climbStairs(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      if (i >= 1) dp[i] +=  dp[i-1];
      if (i >= 2) dp[i] +=  dp[i-2];
    }
    return dp[n];
  }

  // Problem 3
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
    }
    return dp[n];
  }
}
