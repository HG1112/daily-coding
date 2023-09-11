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


    # Problem 4
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        n = len(nums)
        nums.sort()
        i = 0
        while i < n:
            target = -nums[i]
            lo = i+1
            hi = n-1
            while lo < hi:
                sum = nums[lo] + nums[hi]
                if sum > target:
                    hi-=1
                elif sum < target:
                    lo+=1
                else:
                    ans.append([nums[i], nums[lo], nums[hi]])
                    while lo + 1 < n and nums[lo+1] == nums[lo]:
                        lo += 1
                    lo += 1
                    while hi - 1 > lo and nums[hi-1] == nums[hi]:
                        hi -= 1
                    hi -= 1
            while i+1 < n and nums[i+1] == nums[i]:
                i += 1
            i += 1
        return ans
