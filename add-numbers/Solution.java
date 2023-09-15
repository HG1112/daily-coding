import java.util.*;

class Solution {

  // Problem 1
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0, sum = 0;
    ListNode ans = new ListNode(0);
    ListNode curr = ans;
    while (l1 != null || l2 != null) {
      int left = l1 != null ? l1.val : 0;
      int right = l2!= null ? l2.val : 0;
      sum = left + right + carry;
      carry = sum/10;
      curr.next = new ListNode(sum%10);
      curr = curr.next;
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next: null;
    }
    if (carry != 0) curr.next = new ListNode(carry);
    return ans.next;
  }
}

public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
