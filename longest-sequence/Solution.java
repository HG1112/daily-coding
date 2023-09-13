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

  // Problem 2
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0;
    for (int l =0, r= 0; r < n; r++) {
      char c = s.charAt(r);
      if (set.contains(c)) {
        while (s.charAt(l) != c) {
          set.remove(s.charAt(l++));
        }
        l++;
        set.remove(c);
      }
      set.add(c);
      ans = Math.max(ans, (r-l+1));
    }
    return ans;
  }
}
