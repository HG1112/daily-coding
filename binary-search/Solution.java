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
}
