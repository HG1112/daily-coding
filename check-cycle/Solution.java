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
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}
