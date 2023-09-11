import java.util.*;

class Solution {

  // Problem 1
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    // length one intervals
    for (int num : nums) 
      if (!map.containsKey(num)) map.put(num, num);
    // merge intervals
    for (int num : nums) {
      if (map.containsKey(num)) {
        while (map.containsKey(map.get(num)+1)) {
          int next = map.get(num)+1;
          map.put(num, map.get(next));
          map.remove(next);
        }
      }
    }
    int ans = 0;
    for (int num : map.keySet()) {
      ans = Math.max(ans, map.get(num) - num + 1);
    }
    return ans;
  }

}
