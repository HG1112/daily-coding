import java.util.*;

class Solution {

  // Problem 1
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        int h = heights[stack.pop()];
        int l = stack.isEmpty() ? -1 : stack.peek();
        int r = i;
        ans = Math.max(ans, h * (r-l-1));
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int h = heights[stack.pop()];
      int l = stack.isEmpty() ? -1 : stack.peek();
      int r = n;
      ans = Math.max(ans, h * (r-l-1));
    }
    return ans;
  }

}
