import java.util.*;

class Solution {

  // Problem 1
  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  // Problem 2
  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    boolean cycle = false;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
    }

    if (!cycle) return null;
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  // Problem 3
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UF uf = new UF(n+1);
    for (int[] edge: edges) {
      if (uf.union(edge[0], edge[1])) return edge;
    }
    return new int[]{-1, -1};
  }

  class UF {
    int[] parent;
    UF(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int i) {
      if (parent[i] == i) return i;
      else return parent[i] = find(parent[i]);
    }
    boolean union(int i, int j) {
      int pi = find(i);
      int pj = find(j);
      if (pi == pj) return true;
      parent[pi] = pj;
      return false;
    }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}
