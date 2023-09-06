from typing import Optional, List
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        curr = head
        n = 0
        while curr:
            n += 1
            curr = curr.next

        size = n // k
        rem = n % k

        ans = [None for _ in range(k)]
        for i in range(k):
            if not head:
                return ans
            sub = ListNode(head.val)
            ans[i] = sub
            head = head.next
            for _ in range(size + 1 if rem > 0 else size):
                if not head:
                    return ans
                sub.next = ListNode(head.val)
                head = head.next
                sub = sub.next
            rem-=1
        return ans
