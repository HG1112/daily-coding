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
}
