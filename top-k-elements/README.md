# Top K Elements

## Problem 1

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

### [Link to Leetcode](https://leetcode.com/problems/top-k-frequent-elements/)
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : map.keySet()) {
      pq.add(num);
      if (pq.size() > k) pq.poll();
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++)
      ans[i] = pq.poll();
    return ans;
### [Solution in Java](Solution.java#L5)
### [Solution in Python](solution.py#L3)

