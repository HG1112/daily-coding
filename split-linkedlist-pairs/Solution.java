// Definition for singly-linked list.
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    int n = 0;
    ListNode curr = head;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    int sizeOfBucket = n / k;
    int rem = n % k;

    ListNode[] ans = new ListNode[k];
    for (int i = 0; i < k; i++) {
      if (head == null) return ans;
      ans[i] = new ListNode(head.val);
      curr = ans[i];
      head = head.next;
      for (int j = 1; j < (rem > 0 ? sizeOfBucket + 1 : sizeOfBucket); j++) {
        if (head == null) return ans;
        curr.next = new ListNode(head.val);
        curr = curr.next;
        head = head.next;
      }
      rem--;
    }

    return ans;
  }
}

