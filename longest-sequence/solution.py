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

    # Problem 2
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        l = 0
        chars = set()
        ans = 0
        for r in range(n):
            c = s[r]
            if c in chars:
                while s[l] != c:
                    chars.remove(s[l])
                    l += 1
                chars.remove(s[l])
                l += 1
            chars.add(c)
            ans = max(ans, (r-l+1))
        return ans

