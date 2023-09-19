import java.util.*;

class Solution {

  // Problem 1
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int stone: stones) pq.offer(stone);
    while (!pq.isEmpty()) {
      int first = pq.remove();
      if (pq.isEmpty()) return first;
      int second = pq.remove();
      if (first != second) pq.offer(Math.abs(first - second));
    }
    return 0;
  }
}
