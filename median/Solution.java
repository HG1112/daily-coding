import java.util.*;

class Solution {

  // Problem 1
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
    int m = nums1.length, n = nums2.length;
    if (m > n) return findMedianSortedArrays(nums2, nums1);
    int lo = 0, hi = m;
    int p = (m+n)/2 + (m+n)%2;
    double ans = -1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      l1 = mid-1 >= 0 ? nums1[mid-1] : Integer.MIN_VALUE;
      r1 = mid < m ? nums1[mid] : Integer.MAX_VALUE;
      l2 = p-mid-1 >= 0 ? nums2[p-mid-1] : Integer.MIN_VALUE;
      r2 = p-mid < n ? nums2[p-mid] : Integer.MAX_VALUE;
      if (l1 > r2) {
        hi = mid-1;
      } else if (l2 > r1) {
        lo = mid+1;
      } else {
        if ((n+m)%2 == 0) {
          ans = Math.max(l1, l2) + Math.min(r1, r2);
          ans /= 2;
        } else {
          ans = Math.max(l1, l2);
        }
        break;
      }
    }

    return ans;
  }

}
