from typing import List
class Solution:

    # Problem 1 
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        n = len(heights)
        ans = 0
        for i in range(n):
            while stack and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                l = stack[-1] if stack else -1
                ans = max(ans, h * (i-l-1))
            stack.append(i)
        while stack:
            h = heights[stack.pop()]
            l = stack[-1] if stack else -1
            ans = max(ans, h * (n-l-1))
        return ans
