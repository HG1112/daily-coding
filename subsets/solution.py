from typing import List
class Solution:

    # Problem 1 
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        ans = []
        for bin in range(0, (1 << n)):
            sub = []
            for i in range(n):
                if ((bin >> i) & 1) == 1:
                    sub.append(nums[i])
            ans.append(sub)
        return ans


