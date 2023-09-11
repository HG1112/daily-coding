from typing import List

class Solution:

    # Problem 1 
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0 for _ in range(n)]
        stack = []
        for i in range(n-1, -1, -1):
            while stack and temperatures[stack[-1]] <= temperatures[i]:
                stack.pop()
            ans[i] = stack[-1] - i if stack else 0
            stack.append(i)
        return ans

    # Problem 2
    def maxArea(self, height: List[int]) -> int:
        lo = 0
        hi = len(height) - 1

        ans = 0
        while lo < hi:
            ans = max(ans, min(height[lo], height[hi]) * (hi - lo))
            if height[lo] > height[hi]:
                hi -= 1
            else:
                lo += 1
        return ans


