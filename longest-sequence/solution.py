from typing import List
class Solution:

    # Problem 1 
    def longestConsecutive(self, nums: List[int]) -> int:
        intervals = {}
        for num in nums:
            intervals[num] = num
        for num in nums:
            if num in intervals:
                while intervals[num]+1 in intervals:
                    next = intervals[num]+1
                    intervals[num] = intervals[next]
                    intervals.pop(next)
        ans = 0
        for k, v in intervals.items():
            ans = max(ans, v-k+1)
        return ans

