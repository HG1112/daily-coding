import java.util.Arrays;

class Solution {

  // Problem 1
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int min = prices[0];
    int ans = 0;
    for (int i = 1; i < n; i++) {
      ans = Math.max(ans, prices[i] - min);
      min = Math.min(prices[i] , min);
    }
    return ans;
  }
}
