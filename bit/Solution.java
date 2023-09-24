import java.util.*;

class Solution {

  // Problem 1
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int num: nums) ans = ans ^ num;
    return ans;
  }

  // Problem 2
  public int hammingWeight(int n) {
    int ans = 0;
    for (int i = 0; i < 32; i++) 
      ans += ((n >> i) & 1);
    return ans;
  }

  // Problem 3
  public int[] countBits(int n) {
    int[] ans = new int[n+1];
    for (int i = 0; i <= n; i++) {
      ans[i] = Integer.bitCount(i);
    }
    return ans;
  }
}
