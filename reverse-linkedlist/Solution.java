import java.util.*;
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  // Problem 1
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode ans = new ListNode(0);
    ListNode curr = ans;
    int idx = 1;
    while (idx < left) {
      curr.next = new ListNode(head.val);
      curr = curr.next;
      head = head.next;
      idx++;
    }

    Stack<ListNode> stack = new Stack<>();
    while (idx <= right) {
      stack.push(head);
      head = head.next;
      idx++;
    }
    while (!stack.isEmpty()) {
      curr.next = new ListNode(stack.pop().val);
      curr = curr.next;
    }

    while (head != null) {
      curr.next = new ListNode(head.val);
      curr = curr.next;
      head = head.next;
    }

    return ans.next;
  }


  // Problem 2
  public ListNode reverseList(ListNode head) {
    ListNode ans = null;
    while (head != null) {
      ListNode next = new ListNode(head.val);
      if (ans == null) {
        ans = next;
      } else {
        next.next = ans;
        ans = next;
      }
      head = head.next;
    }
    return ans;
  }

  // Problem 3
  public void reorderList(ListNode head) {
    ListNode curr = head;
    int n = 0;
    Stack<ListNode> rev = new Stack<>();
    while (curr != null) {
      rev.push(curr);
      n++;
      curr = curr.next;
    }
    curr = head;
    for (int i = 0; i < n/2; i++) {
      ListNode node = rev.pop();
      ListNode next = curr.next;
      curr.next = node;
      node.next = next;
      curr = next;
    }
    if (n%2 == 1) {
      ListNode node = rev.pop();
      curr.next = node;
      curr = curr.next;
    }
    curr.next = null;
  }
}
