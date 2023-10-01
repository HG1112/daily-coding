import java.util.*;

class Solution {

  // Problem 1
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] vis = new int[numCourses];
    Arrays.fill(vis, -1);
    for (int i = 0; i < numCourses; i++) {
      if (vis[i] == -1) {
        if (cycle(i, vis, prerequisites))
          return false;
      }
    }
    return true;
  }

  private boolean cycle(int i, int[] vis, int[][] prerequisites) {
    vis[i] = 2;
    for (int[] prereq: prerequisites) {
      if (prereq[1] != i) continue;
      int j = prereq[0];
      if (vis[j] == 2) return true;
      if (vis[j] == 1) continue;
      if (cycle(j, vis, prerequisites)) return true;
    }
    vis[i] = 1;
    return false;
  }

  // Problem 2
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] vis = new int[numCourses];
    Arrays.fill(vis, -1);
    int[] ans = new int[numCourses];
    Stack<Integer> topo = new Stack<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (vis[i] == -1) {
        if (cycle(i, vis, prerequisites, topo)) return new int[]{};
      }
    }
    for (int i = numCourses-1; i >= 0; i--) {
      ans[i] = topo.pop();
    }
    return ans;
  }

  private boolean cycle(int i, int[] vis, int[][] prerequisites, Stack<Integer> topo) {
    vis[i] = 2;
    for (int[] prereq: prerequisites) {
      if (prereq[0] != i) continue;
      int j = prereq[1];
      if (vis[j] == 2) return true;
      if (vis[j] == 1) continue;
      if (cycle(j, vis, prerequisites, topo)) return true;
    }
    vis[i] = 1;
    topo.push(i);
    return false;
  }
}
