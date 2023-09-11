import java.util.*;

class Solution {

  // Problem 1
  public int[] topKFrequent(int[] nums, int k) {
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
  }

  public int[] topKFrequent2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    ArrayList<Integer>[] count = new ArrayList[nums.length+1];
    for (int num: map.keySet()) {
      if (count[map.get(num)] == null) count[map.get(num)] = new ArrayList<Integer>();
      count[map.get(num)].add(num);
    }
    int[] ans = new int[k];
    int idx =0;
    for (int i = nums.length; i >= 0 && idx < k; i--) {
      if (count[i] != null) {
        for (int num : count[i]) {
          ans[idx++] = num;
        }
      }
    }
    return ans;
  }

  // Problem 2
}
