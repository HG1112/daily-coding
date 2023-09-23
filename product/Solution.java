import java.util.Arrays;

class Solution {

  // Problem 1
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0)
        left[i] = 1;
      else 
        left[i] = left[i-1] * nums[i-1];
    } 

    for (int i = n-1; i >= 0; i--) {
      if (i == n-1) 
        right[i] = 1;
      else 
        right[i] = right[i+1] * nums[i+1];
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++)
      ans[i] = left[i] * right[i];

    return ans;
  }

  // Problem 2
  public int maxProduct(int[] nums) {
    int n = nums.length;
    int ans = Integer.MIN_VALUE;
    int max = 0;
    int min = 0;
    for (int i = 0; i < n; i++) {
      if (max == 0 || min == 0) {
        max = nums[i];
        min = nums[i];
      } else if (nums[i] == 0) {
        max = 0;
        min = 0;
      } else {
        int oldMax = max;
        int oldMin = min;
        max = Math.max(Math.max(oldMax * nums[i], oldMin * nums[i]), nums[i]);
        min = Math.min(Math.min(oldMin* nums[i], oldMax * nums[i]), nums[i]);
      }
      ans = Math.max(ans, max);
    }
    return ans;

  }

}
