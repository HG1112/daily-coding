import java.util.*;

class Solution {

  // Problem 1
  public int search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0, hi = n-1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] > target)
        hi = mid-1;
      else 
        lo = mid+1;
    }
    return -1;
  }

  // Problem 2
  public int minEatingSpeed(int[] piles, int h) {
    int lo = 1, hi = Integer.MAX_VALUE;
    int ans = -1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (check(piles, mid, h)) {
        ans = mid;
        hi = mid-1;
      } else {
        lo = mid+1;
      }
    }
    return ans;
  }

  private boolean check(int[] piles, int rate, int time) {
    int total = 0;
    for (int pile : piles) {
      total += (pile / rate + (pile % rate != 0 ? 1 : 0));
    }
    return total <= time;
  }

  // Problem 3
  public int findMin(int[] nums) {
    int n = nums.length;
    int lo = 0, hi = n-1;

    if (nums[lo] < nums[hi])
      return nums[lo];

    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (nums[mid] > nums[hi])
        lo = mid+1;
      else if (nums[mid] < nums[hi])
        hi = mid;
      else 
        return nums[mid];
    }
    return -1;
  }

  // Problem 4
  public int search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0, hi = n-1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[lo] < nums[hi]) {
        if (nums[mid] < target)
          lo = mid+1;
        else 
          hi = mid-1;
      } else {
        if (nums[mid] < nums[hi]) {
          if (nums[mid] < target && target <= nums[hi])
            lo = mid+1;
          else 
            hi = mid-1;
        } else {
          if (nums[lo] <= target && target < nums[mid])
            hi = mid-1;
          else 
            lo = mid+1;
        }
      }
    }
    return -1;
  }
}
