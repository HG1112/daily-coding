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

    # Problem 3
    def twoSumSorted(self, numbers: List[int], target: int) -> List[int]:
        ans = [-1, -1]
        lo = 0
        hi = len(numbers)-1
        while lo < hi:
            sum = numbers[lo] + numbers[hi]
            if sum > target:
                hi-=1
            elif sum < target:
                lo+=1
            else:
                ans[0] = lo+1
                ans[1] = hi+1
                break
        return ans

