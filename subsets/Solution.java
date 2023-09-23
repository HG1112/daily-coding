import java.util.*;

class Solution {

  // Problem 1
  public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> ans = new LinkedList<>();
    for (int bin = 0; bin < (1 << n); bin++) {
      List<Integer> sub = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        if (((bin >> i) & 1) == 1) {
          sub.add(nums[i]);
        }
      }
      ans.add(sub);
    }
    return ans;
  }

  // Problem 2
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    LinkedList<Integer> acc = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    f(nums, nums.length-1, acc, ans);
    return ans;
  }

  private void f(int[] nums, int i, LinkedList<Integer> acc, List<List<Integer>> ans) {
    if (i < 0) {
      ans.add(new LinkedList<Integer>(acc));
      return;
    }
    int count = 0;
    for (int j = i; j >= 0 && nums[j] == nums[i]; j--) count++;
    for (int k = 0; k <= count; k++) {
      for (int j = 0; j < k; j++) acc.addLast(nums[i]);
      f(nums, i - count, acc, ans);
      for (int j = 0; j < k; j++) acc.removeLast();
    }

  }

  // Problem 3
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num: nums) sum += num;
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    int[][] dp = new int[n][target+1];
    for (int[] d: dp) Arrays.fill(d, -1);
    return g(nums, n-1, target, dp);
  }
  private boolean g(int[] nums, int i, int target, int[][] dp) {
    if (target == 0)
      return true;
    if (i < 0)
      return false;
    if (dp[i][target] != -1) return dp[i][target] == 1;
    boolean noTake = g(nums, i-1, target, dp);
    boolean take = false;
    if(target >= nums[i])
      take = take || g(nums, i-1, target - nums[i], dp);
    boolean ans = take || noTake;
    dp[i][target] = ans ? 1 : 0;
    return ans;
  }
}
