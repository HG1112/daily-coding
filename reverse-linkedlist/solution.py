from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    # Problem 1
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

    # Problem 2
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ans = None
        while head:
            node = ListNode(head.val)
            if ans:
                node.next = ans
                ans = node
            else:
                ans = node
            head = head.next
        return ans


    # Problem 3
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head.next
        while slow and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow
        slow = slow.next
        rev = None
        while slow:
            n = slow.next
            if not rev:
                rev = slow
                rev.next = None
            else:
                slow.next = rev
                rev = slow
            slow = n
        i = 0
        while head or rev:
            if i == 0:
                n = head.next
                head.next = rev
                head = n
            else:
                n = rev.next
                rev.next = head
                rev = n
            i ^= 1
                
    # Problem 4
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        l = head
        r = head
        while n-1 > 0:
            r = r.next
            n -= 1
        prev = None
        while r.next:
            r = r.next
            prev = l
            l = l.next
        if prev:
            prev.next = l.next
        else:
            head = head.next
        return head
