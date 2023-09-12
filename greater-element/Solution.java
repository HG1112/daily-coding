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

  // Problem 3
  public int trap(int[] height) {
    int n = height.length;
    int[] lmax = new int[n];
    int[] rmax = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0) lmax[i] = 0;
      else {
        lmax[i] = Math.max(lmax[i-1], height[i-1]);
      }
    }

    for (int i = n-1; i >= 0; i--) {
      if (i == n-1) {
        rmax[i] = 0;
      } else {
        rmax[i] = Math.max(rmax[i+1], height[i+1]);
      }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int h = Math.min(lmax[i], rmax[i]);
      if (h > height[i])
      ans += (h - height[i]);
    }
    return ans;
  }
  public int trap2(int[] height) {
    int n = height.length;
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        int curr = stack.pop();
        if (stack.isEmpty()) break;
        int l = stack.peek();
        int r = i;
        ans += (Math.min(height[l], height[r]) - height[curr]) * (r - l - 1);
      }
      stack.push(i);
    }
    return ans;
  }
}
