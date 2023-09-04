
 // Definition for singly-linked list.
 class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
     val = x;
     next = null;
   }
 }
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode prev = head;
        ListNode curr = head == null ? null : head.next;

        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            prev = prev.next;
            if (curr == prev) return true;
        }
        return false;
    }
}
