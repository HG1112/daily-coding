from typing import List
class Solution:

    # Problem 1 
    def containsDuplicate(self, nums: List[int]) -> bool:
        exist = set()
        for num in nums:
            if num in exist:
                return True
            exist.add(num)
        return False


    # Problem 2
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        slow = nums[slow]
        fast = nums[nums[fast]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
        slow = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow
