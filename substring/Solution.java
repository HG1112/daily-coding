import java.util.*;

class Solution {

  // Problem 1
  public String minWindow(String s, String t) {
    int n = s.length();
    int m = t.length();
    int minLen = Integer.MAX_VALUE;
    String minString = "";
    Map<Character, Integer> tCount = new HashMap<>();
    for (char c : t.toCharArray()) 
      tCount.put(c, tCount.getOrDefault(c, 0) + 1);

    int l = 0, r = 0;
    int total = 0;
    Map<Character, Integer> sCount = new HashMap<>();
    while (true) {
      if (total < m) {
        if (r == n) break;
        char c = s.charAt(r);
        sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        if (tCount.containsKey(c) && sCount.get(c) <= tCount.get(c)) total++;
        r++;
      }  else if (total == m) {
        if (minLen > (r-l)) {
          minLen = (r-l);
          minString = s.substring(l, r);
        }
        char c = s.charAt(l);
        sCount.put(c, sCount.get(c)-1);
        if (tCount.containsKey(c) && sCount.get(c) < tCount.get(c)) total--;
        l++;
      }
    }
    return minString;
  }
}
