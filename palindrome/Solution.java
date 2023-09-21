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
}
