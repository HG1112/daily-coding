import java.util.ArrayList;
import java.util.Arrays;

class Solution {

  // Problem 1
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new LinkedList<>();
    if (numRows == 0) return ans;
    List<Integer> one = new ArrayList<>();
    one.add(1);
    ans.add(one);
    for (int i = 1; i < numRows; i++) {
      List<Integer> prev = ans.getLast();
      int[] sub = new int[i+1];
      int n = prev.size();
      for (int j = 0; j < i+1; j++) {
        sub[j] = (0 <= j-1 && j-1 < n ? prev.get(j-1) : 0) + (0 <= j && j < n ? prev.get(j) : 0);
      }
      ans.add(Arrays.asList(sub));
    }
    return ans;
  }
}
