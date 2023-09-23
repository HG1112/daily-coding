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

    # Problem 2
    def maxProduct(self, nums: List[int]) -> int:
        maxi = 0
        mini = 0
        ans = -10**8
        for num in nums:
            if num == 0:
                maxi = 0
                mini = 0
            elif mini == 0 or maxi == 0:
                maxi = num
                mini = num
            else:
                temp_max = maxi
                temp_min = mini
                maxi = max(temp_max* num, temp_min * num, num)
                mini = min(temp_max* num, temp_min * num, num)
            ans = max(ans, maxi)
        return ans


