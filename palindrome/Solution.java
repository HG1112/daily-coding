import java.util.*;

class Solution {

  // Problem 1
  public boolean isPalindrome(String s) {
    int l = 0, r = s.length()-1;
    while (l < r) {
      if (!Character.isLetterOrDigit(s.charAt(l))) {
        l++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(r))) {
        r--;
        continue;
      }
      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
      l++;
      r--;
    }
    return true;
  }

  // Problem 2
  public List<List<String>> partition(String s) {
    LinkedList<String> acc = new LinkedList<>();
    List<List<String>> ans = new LinkedList<>();
    f(s, 0, "", acc, ans);
    return ans;
  }
  private void f(String s, int i, String str, LinkedList<String> acc, List<List<String>> ans) {
    if (i == s.length()) {
      ans.add(new LinkedList<String>(acc));
      return;
    }
    for (int j = i; j < s.length(); j++) {
      str = str + s.charAt(j);
      if (isPalindrome(str)) {
        acc.addLast(str);
        f(s, j+1, "", acc, ans);
        acc.removeLast();
      }
    }
  }

  // Problem 3
  public String longestPalindrome(String s) {
    int ansL = 0, ansR = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      int l = i, r = i;
      while (l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
        l--; r++;
      }
      if ((ansR - ansL + 1) <= (r-l+1)) {
        ansR = r;
        ansL = l;
      }
    }
    for (int i = 0; i < n-1; i++) {
      int l = i, r = i+1;
      if (s.charAt(l) != s.charAt(r)) continue;
      while (l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
        l--; r++;
      }
      if ((ansR - ansL + 1) <= (r-l+1)) {
        ansR = r;
        ansL = l;
      }
    }
    return s.substring(ansL, ansR+1);
  }

  // Problem 4
  public int countSubstrings(String s) {
    int n = s.length();
    int count = 0;
    for (int i = 0; i < n; i++) {
      int l = i;
      int r = i;
      count++;
      while (l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
        l--;
        r++;
        count++;
      }
    }
    for (int i = 0; i < n-1; i++) {
      int l = i;
      int r = i+1;
      if (s.charAt(l) != s.charAt(r)) continue;
      count++;
      while (l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
        l--;
        r++;
        count++;
      }
    }
    return count;
  }
}
