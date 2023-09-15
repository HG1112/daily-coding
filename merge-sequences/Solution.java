import java.util.*;

class Solution {

  // Problem 1
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    else if (list2 == null)
      return list1;
    else if (list1.val < list2.val) {
      ListNode ans = new ListNode(list1.val);
      ans.next = mergeTwoLists(list1.next, list2);
      return ans;
    } else {
      ListNode ans = new ListNode(list2.val);
      ans.next = mergeTwoLists(list1, list2.next);
      return ans;
    }
  }

  // Problem 2
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
    for (ListNode node: lists) 
      if (node != null) pq.offer(node);
    ListNode head = new ListNode(0);
    ListNode curr = head;
    while (!pq.isEmpty()) {
      ListNode node = pq.remove();
      if (node.next != null) pq.offer(node.next);
      curr.next = node;
      node.next = null;
      curr = curr.next;
    }
    return head.next;
  } 
}
