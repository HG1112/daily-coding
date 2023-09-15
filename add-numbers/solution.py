from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:

    # Problem 1 
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        ans = ListNode(0)
        curr = ans
        while l1 or l2:
            l = l1.val if l1 else 0
            r = l2.val if l2 else 0
            carry += (l + r)
            curr.next = ListNode(carry%10)
            carry = carry // 10
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            curr = curr.next
        if carry > 0:
            curr.next = ListNode(carry)
        return ans.next
