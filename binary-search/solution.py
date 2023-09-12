from typing import List

class Solution:

    # Problem 1 
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        lo = 0
        hi = n-1
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            if nums[mid] < target:
                lo = mid+1
            elif nums[mid] > target:
                hi = mid-1
            else:
                return mid
        return -1

    # Problem 2
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lo = 0
        hi = 0
        for pile in piles:
            hi += pile
        ans = -1
        def check(piles: List[int], rate: int, time: int) -> bool:
            total = 0
            for pile in piles:
                total += (pile // rate)
                total += (1 if pile % rate != 0 else 0)
            return total <= time
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            if check(piles, mid, h):
                ans = mid
                hi = mid-1
            else:
                lo = mid+1
        return ans
