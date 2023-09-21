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

  // Problem 4
  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    List<List<Integer>> ans = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      int target = -nums[i];
      int lo = i+1;
      int hi = n-1;
      while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        if (sum > target) {
          hi--;
        } else if (sum < target) {
          lo++;
        } else {
          ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
          while (lo + 1 < n && nums[lo+1] == nums[lo]) lo++;
          lo++;
          while (hi - 1 > lo && nums[hi - 1] == nums[hi]) hi--;
          hi--;
        }
      }
      while (i+1 < n && nums[i+1] == nums[i]) {
        i++;
      }
    }
    return ans;
  }


  // Problem 5
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> acc = new LinkedList<>();
    f(candidates, candidates.length-1, target, acc, ans);
    return ans;
  }

  private void f(int[] nums, int i, int target, LinkedList<Integer> acc, List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(new LinkedList<Integer>(acc));
      return;
    }
    if (i < 0 || target < 0) return;
    acc.addLast(nums[i]);
    f(nums, i, target - nums[i], acc, ans);
    acc.removeLast();
    f(nums, i-1, target, acc, ans);
  }

  // Problem 6
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    LinkedList<Integer> acc = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    g(candidates, 0, target, acc, ans);
    return ans;
  }

  private void g(int[] nums, int i, int target, LinkedList<Integer> acc, List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(new LinkedList<>(acc));
      return;
    }
    if (i == nums.length || target < 0) return;
    int count = 0;
    for (int j = i; j < nums.length && nums[i] == nums[j]; j++) count++;
    int value = target;
    g(nums, i + count, value ,acc, ans);
    for (int k = 1; k <= count; k++) {
      acc.addLast(nums[i]);
      value -= nums[i];
      g(nums, i + count, value ,acc, ans);
    }
    for (int j = 1; j <= count; j++) acc.removeLast();
  }
}
