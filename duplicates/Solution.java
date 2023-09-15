import java.util.*;

class Solution {

  // Problem 1
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) return true;
      set.add(num);
    }
    return false;
  }

  // Problem 2
  public int findDuplicate(int[] nums) {
    int ans = 0;
    for (int bit = 0; bit <= 31; bit++) {
      int mask = 1 << bit;
      int x = 0, y = 0;
      for (int i = 0; i < nums.length; i++) {
        x += (nums[i] & mask);
        if (i > = 0)
          y += (i & mask);
      }
      if (x > y)
        ans |= mask;
    }
    return ans;
  }

}
