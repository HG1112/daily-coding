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

