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
}
