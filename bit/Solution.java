import java.util.*;

class Solution {

  // Problem 1
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int num: nums) ans = ans ^ num;
    return ans;
  }

}
