class Solution {

  public boolean canCross(int[] stones) {
    return move(0, 1, stones);
  }

  private boolean move(int i, int jump, int[] stones) {
    int n = stones.length;
    if (i >= n) return false;
    if (i == n-1) return true;
    if (jump <= 0) return false;
    i = Arrays.binarySearch(stones, stones[i] + jump);
    if (i >= 0) {
      return (move(i, jump-1, stones) || move(i, jump, stones) || move(i, jump+1, stones));
    } else {
      return false;
    }
  }
}
