import java.util.*;

class Solution {

  // Problem 1
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    Integer[] cars = new Integer[n];
    for (int i = 0; i < n; i++) cars[i] = i;
    Arrays.sort(cars, (i, j) -> (position[i] - position[j]));
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int i = n-1; i >= 0; i--) {
      int curr = cars[i];
      if (stack.isEmpty()) {
        stack.push(curr);
      } else {
        int front = stack.peek();
        if (speed[front] > speed[curr]) {
          stack.push(curr);
        } else {
          float rel = ((position[front] - position[curr]) * 1.0) / (speed[curr] - speed[front]);
          float total = ((target - position[front]) * 1.0) / (speed[front]);
          if (rel > total)
            stack.push(curr);
        }
      }
    }
    return stack.size();
  }

  public int carFleet2(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cars = new double[n][2];
    for (int i = 0; i < n; i++) {
      cars[i][0] = (double) position[i];
      cars[i][1] = ((double) target - position[i]) / speed[i];
    }
    Arrays.sort(cars, (i, j) -> Double.compare(i[0], j[0]));
    int ans = 1;
    double slowest = cars[n-1][1];
    for (int i = n-2; i >= 0; i--) {
      if (cars[i][1] > slowest) {
        slowest = cars[i][1];
        ans++;
      }
    }

    return ans;
  }
}
