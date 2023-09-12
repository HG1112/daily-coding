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

    # Problem 3
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        lo = 0
        hi = n-1
        if nums[lo] < nums[hi]:
            return nums[lo]
        
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            if nums[mid] > nums[hi]:
                lo = mid+1
            elif nums[mid] < nums[hi]:
                hi = mid
            else:
                return nums[mid]
        return -1

    # Problem 4
    def search(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums)-1
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            if nums[mid] == target:
                return mid
            elif nums[lo] < nums[hi]:
                if nums[mid] < target:
                    lo = mid+1
                else:
                    hi = mid-1
            else:
                if nums[mid] < nums[hi]:
                    if nums[mid] < target and target <= nums[hi]:
                        lo = mid+1
                    else:
                        hi = mid-1
                else:
                    if nums[lo] <= target and target < nums[mid]:
                        hi = mid-1
                    else:
                        lo = mid+1
        return -1


