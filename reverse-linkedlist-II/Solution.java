import java.util.*;
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
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
}
