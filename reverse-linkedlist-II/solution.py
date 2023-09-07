from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        ans = ListNode(0)
        curr = ans

        idx = 1
        while head and idx < left:
            curr.next = ListNode(head.val)
            head = head.next
            curr = curr.next
            idx += 1

        stack = []
        while head and idx <= right:
            stack.append(head.val)
            head = head.next
            idx += 1
        while stack:
            curr.next = ListNode(stack.pop())
            curr = curr.next

        while head:
            curr.next = ListNode(head.val)
            head = head.next
            curr = curr.next
        
        return ans.next


