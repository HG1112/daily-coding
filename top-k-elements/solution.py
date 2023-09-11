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
        

