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
  class KthLargest {
    PriorityQueue<Integer> pq;
    int K;

    public KthLargest(int k, int[] nums) {
      pq = new PriorityQueue<>(k);
      K = k;
      for (int num: nums) {
        add(num);
      }
    }

    public int add(int val) {
      pq.offer(val);
      if (pq.size() == K+1) {
        pq.remove();
      }
      return pq.peek();
    }
  }

  // Problem 3
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a,b) -> -(dist(a) - dist(b)));
    for (int[] point: points) {
      pq.offer(point);
      if (pq.size() == k+1)
        pq.remove();
    }
    int[][] ans = new int[k][2];
    for (int i = 0; i < k; i++)
      ans[i] = pq.remove();
    return ans;
  }
  private int dist(int[] p) {
    return p[0]*p[0] + p[1]*p[1];
  }

  // Problem 4
  public int findKthLargest(int[] nums, int k) {
    return find(nums, 0, nums.length-1, k);
  }
  public int find(int[] nums, int start, int end, int k) {
    int pivot = start;
    int lo = start+1;
    int hi = end;
    while (lo <= hi) {
      if (nums[lo] > nums[pivot])
        lo++;
      else if (nums[hi] < nums[pivot])
        hi--;
      else {
        swap(nums, lo, hi);
        lo++;
        hi--;
      }
    }
    swap(nums, pivot, hi);
    if (hi == k-1) return nums[hi];
    else if (hi < k-1) return find(nums, hi+1, end, k);
    else return find(nums, start, hi-1, k);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
