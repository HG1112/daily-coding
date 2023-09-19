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

