import java.util.*;

class Solution {

  // Problem 1
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (token.equals("+")) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(left + right);
      } else if (token.equals("-")) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(left - right);
      } else if (token.equals("*")) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(left * right);
      } else if (token.equals("/")) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(int(left / right));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
