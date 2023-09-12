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

    # Problem 3
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = [0]
        right = [0]
        for i in range(1, n):
            left.append(max(left[-1], height[i-1]))
        for i in range(n-2, -1, -1):
            right.append(max(right[-1], height[i+1]))

        ans = 0
        for i in range(n):
            h = min(left[i], right[n-1-i])
            if h > height[i]:
                ans += (h - height[i])
        return ans

    def trap_2(self, height: List[int]) -> int:
        n = len(height)
        stack = []
        ans = 0
        for i in range(n):
            while stack and height[stack[-1]] < height[i]:
                h = height[stack.pop()]
                if not stack:
                    break
                l = stack[-1]
                r = i
                ans += (min(height[l], height[r]) - h) * (r-l-1)
            stack.append(i)
        return ans


