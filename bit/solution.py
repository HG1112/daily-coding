from typing import List
class Solution:

    # Problem 1 
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans = ans ^ num
        return ans
    
    # Problem 2
    def hammingWeight(self, n: int) -> int:
        ans = 0
        for i in range(32):
            ans += ((n >> i) & 1)
        return ans

    # Problem 3
    def countBits(self, n: int) -> List[int]:
        ans = [0 for _ in range(n+1)]
        for i in range(n+1):
            ans[i] = ans[i >> 1] + (i & 1)
        return ans


