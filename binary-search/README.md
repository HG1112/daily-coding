# Binary Search

## Problem 1

Given an array of integers nums which is sorted in ascending order, and an integer target,

write a function to search target in nums.

If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

### [Link to Leetcode](https://leetcode.com/problems/binary-search/)
### [Solution in Java](Solution.java#L5)
### [Solution in Python](solution.py#L3)

## Problem 2

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 

The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. 

Each hour, she chooses some pile of bananas and eats k bananas from that pile. 

If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

### [Link to Leetcode](https://leetcode.com/problems/koko-eating-bananas/)
### [Solution in Java](Solution.java#L22)
### [Solution in Python](solution.py#L20)

## Problem 3

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

### [Link to Leetcode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
### [Solution in Java](Solution.java#L45)
### [Solution in Python](solution.py#L42)


## Problem 4

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

### [Link to Leetcode](https://leetcode.com/problems/search-in-rotated-sorted-array/)
### [Solution in Java](Solution.java#L45)
### [Solution in Python](solution.py#L42)
