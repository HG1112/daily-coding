from typing import Optional
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:

    # Problem 1 
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        fast = slow = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

    # Problem 2
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        slow = head
        fast = head
        cycle = False
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                cycle = True
                break
        if not cycle:
            return None
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow

