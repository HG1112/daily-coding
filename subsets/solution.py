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


    # Problem 2
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def gen(nums, i, acc, ans):
            if i < 0:
                ans.append([i for i in acc])
                return
            count = 0
            for j in range(i, -1, -1):
                if nums[i] == nums[j]:
                    count += 1
                else:
                    break
            for k in range(count+1):
                for _ in range(k):
                    acc.append(nums[i])
                gen(nums, i - count, acc, ans)
                for _ in range(k):
                    acc.pop()
        nums.sort()
        acc = []
        ans = []
        gen(nums, len(nums)-1, acc, ans)
        return ans

    # Problem 3
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total // 2
        dp = [[False for _ in range(target+1)] for _ in range(n)]
        for val in range(target+1):
            for i in range(n):
                if val == 0:
                    dp[i][val] = True
                elif i == 0:
                    dp[i][val] = nums[i] == val
                else:
                    dp[i][val] = dp[i][val] or dp[i-1][val]
                    if val >= nums[i]:
                        dp[i][val] = dp[i][val] or dp[i-1][val - nums[i]]
        return dp[n-1][target]



