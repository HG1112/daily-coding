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

  // Problem 2
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    LinkedList<Integer> max = new LinkedList<>();
    int[] ans = new int[n-k+1];
    int i = 0;
    for (int l = 0, r = 0; r < n; r++) {
      while (!max.isEmpty() && nums[max.getLast()] < nums[r]) max.removeLast();
      max.addLast(r);
      if (r-l+1 == k) {
        ans[i++] = nums[max.getFirst()];
        if (max.getFirst() == l) max.removeFirst();
        l++;
      }
    }
    return ans;
  }
}
