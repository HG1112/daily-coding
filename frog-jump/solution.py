from typing import List
class Solution:
    # Problem 2
    def climbStairs(self, n: int) -> int:
        pp = 0
        p = 1
        curr = 0
        for _ in range(1, n+1):
            curr = p + pp
            pp = p
            p = curr
        return curr


    # Problem 3
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        pp = 0
        p = 0
        curr = 0
        n = len(cost)
        for i in range(2, n+1):
            curr = min(pp + cost[i-2], p + cost[i-1])
            pp = p
            p = curr
        return curr

