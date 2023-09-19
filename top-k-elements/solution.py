import heapq
from typing import List
class Solution:

    # Problem 1 
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            if num not in count:
                count[num] = 0
            count[num] +=1

        bucket = [[] for _ in range(len(nums)+1)]
        for num , freq in count:
            bucket[freq].append(num)

        ans = [0 for _ in range(k)]
        idx = 0
        for freq in range(len(nums), -1, -1):
            if bucket[freq]:
                for num in bucket[freq]:
                    ans[idx] = num
                    idx += 1
                    if idx >= k:
                        return ans
        return ans
        
# Problem 2
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.pq = []
        heapq.heapify(self.pq)
        for num in nums:
            self.add(num)
        

    def add(self, val: int) -> int:
        heapq.heappush(self.pq, val)
        if len(self.pq) == self.k + 1:
            heapq.heappop(self.pq)
        return self.pq[0]

class Solution:

    # Problem 3
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def dist(p):
            return p[0]**2 + p[1]**2
        points.sort(key=lambda p: dist(p))
        return points[:k]

    # Problem 4
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def partition(nums: List[int], start: int, end: int, k: int) -> int:
            pivot = start
            lo = start + 1
            hi = end
            while lo <= hi:
                if nums[lo] > nums[pivot]:
                    lo += 1
                elif nums[hi] < nums[pivot]:
                    hi -= 1
                else:
                    nums[lo], nums[hi] = nums[hi], nums[lo]
                    lo += 1
                    hi -= 1
            nums[pivot], nums[hi] = nums[hi], nums[pivot]
            if hi == k-1:
                return nums[hi]
            elif hi < k-1:
                return partition(nums, hi+1, end, k)
            else:
                return partition(nums, start, hi-1, k)
        return partition(nums, 0, len(nums)-1, k)

