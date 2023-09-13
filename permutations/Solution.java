import java.util.*;

class Solution {

  // Problem 1
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> count1 = new HashMap<Character, Integer>();
    Map<Character, Integer> count2 = new HashMap<Character, Integer>();
    int m = s1.length();
    int n = s2.length();
    for (char c: s1.toCharArray()) {
      count1.put(c, count1.getOrDefault(c, 0) + 1);
    }

    int l = 0, match = 0;
    for (int r = 0; r < n; r++) {
      char c = s2.charAt(r);
      if (count1.containsKey(c)) {
        count2.put(c, count2.getOrDefault(c, 0) +1);
        match++;
        while (count1.get(c) < count2.get(c)) {
          count2.put(s2.charAt(l), count2.get(s2.charAt(l))-1);
          l++;
          match--;
        }
      } else {
        count2.clear();
        match = 0;
        l = r+1;
      }
      if (match == m) return true;
    }
    return false;
  }
}
