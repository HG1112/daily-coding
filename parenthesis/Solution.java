import java.util.*;

class Solution {

  // Problem 1
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (!stack.isEmpty()) {
        if (c == ')' && stack.peek() == '(') 
        stack.pop();
        else if (c == '}' && stack.peek() == '{')
        stack.pop();
        else if (c == ']' && stack.peek() == '[')
        stack.pop();
        else 
        return false;
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }


  // Problem 2
  public List<String> generateParenthesis(int n) {
    List<String> ans = new LinkedList<>();
    f(n,n,"", ans);
    return ans;
  }

  private void f(int open, int close, String acc, List<String> ans) {
    if (open == 0 && close == 0) {
      ans.add(acc);
    } else {
      if (open > 0) f(open-1, close, acc + '(', ans);
      if (open < close) f(open, close-1, acc + ')', ans);
    }
  }

}
