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
