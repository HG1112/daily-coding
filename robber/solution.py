from typing import List
class Solution:

    # Problem 1 
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        pp = -1
        p = 0
        pp = 0
        curr = 0
        for i in range(n):
            no_take = p
            take = nums[i] + pp
            curr = max(take, no_take)
            pp = p
            p = curr
        return curr

    # Problem 2
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        def f(nums, start, end, dp):
            if (start > end):
                return 0
            if dp[end] == -1:
                take = nums[end] + f(nums, start, end-2, dp)
                noTake = f(nums, start, end-1, dp)
                dp[end] = max(take, noTake)
            return dp[end]
        dp = [-1 for _ in range(n)]
        pick = f(nums, 0, n-2, dp)
        dp = [-1 for _ in range(n)]
        noPick = f(nums, 1, n-1, dp)
        return max(pick, noPick)

