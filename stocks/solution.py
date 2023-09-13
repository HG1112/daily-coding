from typing import List
class Solution:

    # Problem 1 
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy = prices[0]
        ans = 0
        for i in range(1, n):
            ans = max(ans, prices[i] - buy)
            buy = min(buy, prices[i])
        return ans

