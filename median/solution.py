from typing import List
class Solution:

    # Problem 1 
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        MAX = 10**9
        MIN = -10**9
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        m = len(nums1)
        n = len(nums2)
        lo = 0
        hi = m
        p = (m+n)//2 + (m+n)%2
        ans = -1.0
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            l1 = nums1[mid-1] if mid-1 >= 0 else MIN
            r1 = nums1[mid] if mid < m else MAX
            l2 = nums2[p-mid-1] if p-mid-1 >= 0 else MIN
            r2 = nums2[p-mid] if p-mid < n else MAX
            if l1 > r2:
                hi = mid-1
            elif l2 > r1:
                lo = mid+1
            else:
                if (m+n)%2 == 0:
                    ans = (max(l1, l2) + min(r1, r2)) / 2
                else:
                    ans = max(l1, l2)
                break
        return ans

# Problem 2
import heapq
class MedianFinder:

    def __init__(self):
        self.left = []
        self.right = []
        heapq.heapify(self.left)
        heapq.heapify(self.right)
        

    def addNum(self, num: int) -> None:
        if not self.left or -self.left[0] >= num:
            heapq.heappush(self.left, -num)
        elif not self.right or self.right[0] <= num:
            heapq.heappush(self.right, num)
        else:
            heapq.heappush(self.left, -num)
        if len(self.left) > len(self.right) + 1:
            heapq.heappush(self.right, -heapq.heappop(self.left))
        elif len(self.right) > len(self.left):
            heapq.heappush(self.left, -heapq.heappop(self.right))


    def findMedian(self) -> float:
        if len(self.left) == len(self.right):
            return (-self.left[0] + self.right[0])/2
        else:
            return -self.left[0]

