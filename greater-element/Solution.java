import java.util.*;

class Solution {

  // Problem 1
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int n = temperatures.length;
    int[] ans = new int[n];
    for (int i = n-1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) 
      stack.pop();
      ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return ans;
  }

  // Problem 2
  public int maxArea(int[] height) {
    int n = height.length;
    int lo = 0,  hi = n-1;
    int ans = 0;
    while (lo < hi) {
      ans = Math.max(Math.min(height[lo], height[hi]) * (hi - lo), ans);
      if (height[lo] > height[hi])
        hi--;
      else 
        lo++;
    }
    return ans;
  }
}
