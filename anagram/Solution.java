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
  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> groups = new HashMap<>();
    for (String s : strs) {
      String encoded = encode(s);
      if (!groups.containsKey(encoded)) groups.put(encoded, new LinkedList<String>());
      groups.get(encoded).add(s);
    }
    return new LinkedList<>(groups.values());
  }

  private String encode(String s) {
    char[] c = new char[26];
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';
      c[idx]++;
    }
    return Arrays.toString(c);
  }
}
