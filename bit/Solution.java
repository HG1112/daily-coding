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

  // Problem 4
  public int reverseBits(int n) {
    int l = 0, r = 31;
    int ans = 0;
    while (l <= r) {
      int left = (n >> l) & 1;
      int right = (n >> r) & 1;
      ans = ans | (right << l);
      ans = ans | (left << r);
      l++;
      r--;
    }
    return ans;
  }

  // Problem 5
  public int missingNumber(int[] nums) {
    int n = nums.length();
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = ans ^ nums[i-1];
      ans = ans ^ i;
    }
    return ans;
  }

  // Problem 6
  public int getSum(int a, int b) {
    return b == 0 ? a : getSum(a^b, (a&b) << 1);
  }
}
