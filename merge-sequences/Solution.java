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
}
