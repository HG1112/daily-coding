from typing import List
class Solution:

    # Problem 1 
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans = ans ^ num
        return ans

