import java.util.*;

class Solution {

  // Problem 1
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
    for (char c : t.toCharArray()) {
      if (count.containsKey(c)) {
        if (count.get(c) == 1) {
          count.remove(c);
        } else {
          count.put(c, count.get(c)-1);
        }
      } else {
        return false;
      }
    }
    return count.isEmpty();
  }

  // Problem 2
}
