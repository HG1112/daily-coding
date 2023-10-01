from typing import Optional, List
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

    # Problem 3
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges) + 1
        parent = [i for i in range(n)]
        def find(parent, i):
            if parent[i] == i:
                return i
            else:
                parent[i] = find(parent, parent[i])
                return parent[i]
        def union(parent, i, j):
            if find(parent, i) == find(parent, j):
                return True
            parent[find(parent, i)] = find(parent, j)
            return False
        for edge in edges:
            if union(parent, edge[0], edge[1]):
                return edge
        return [-1, -1]



