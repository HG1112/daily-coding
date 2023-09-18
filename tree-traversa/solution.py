from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # Problem 1 
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans = []
        queue = []
        if not root:
            return ans
        queue.append(root)
        while queue:
            n = len(queue)
            sub = []
            for _ in range(n):
                node = queue.pop(0)
                sub.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(sub)
        return ans

    # Problem 2
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        if not root:
            return ans
        level = []
        level.append(root)
        while level:
            n = len(level)
            for _ in range(n-1):
                node = level.pop(0)
                if node.left:
                    level.append(node.left)
                if node.right:
                    level.append(node.right)
            node = level.pop(0)
            ans.append(node.val)
            if node.left:
                level.append(node.left)
            if node.right:
                level.append(node.right)
        return ans

