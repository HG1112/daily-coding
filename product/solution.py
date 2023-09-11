from typing import List
class Solution:

    # Problem 1 
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left  = [1]
        right = [1]
        for i in range(n-1):
            left.append(left[-1] * nums[i])
        for i in range(n-1, 0, -1):
            right.append(right[-1] * nums[i])

        ans = []
        for i in range(n):
            ans.append(left[i] * right[n-1-i])
        return ans

