from typing import List
class Solution:

    # Problem 1 
    def lastStoneWeight(self, stones: List[int]) -> int:
        import heapq
        nums = [-stone for stone in stones]
        heapq.heapify(nums)
        while nums:
            first = heapq.heappop(nums)
            if not nums:
                return -first
            second = heapq.heappop(nums)
            if first != second:
                heapq.heappush(nums, -abs(first - second))
        return 0
