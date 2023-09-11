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

  // Problem 2
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> prev = new HashMap<>();
    int[] ans = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (prev.containsKey(target - nums[i])) {
        ans[0] = prev.get(target-nums[i]);
        ans[1] = i;
      }
      prev.put(nums[i], i);
    }
    return ans;
  }


  // Problem 3
  public int[] sortedTwoSum(int[] nums, int target) {
    int l = 0, r = nums.length-1;
    int[] ans = new int[2];
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum > target)
        r--;
      else if (sum < target)
        l++;
      else {
        ans[0] = l+1;
        ans[1] = r+1;
        break;
      }
    }
    return ans;
  }

}
