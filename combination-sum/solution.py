from typing import List
class Solution:

    # Problem 1 
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0 for _ in range(target+1)]
        dp[0] = 1
        for i in range(1, target+1):
            for num in nums:
                if i >= num:
                    dp[i] += dp[i-num]

        return dp[target]

    # Problem 2
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        idx = {}
        for i in range(len(nums)):
            find = target - nums[i]
            if find in idx:
                return [idx[find], i]
            idx[nums[i]] = i
        return []


