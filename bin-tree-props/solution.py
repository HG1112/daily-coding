from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # Problem 1 
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def depth(node: Optional[TreeNode]) -> int:
            if node:
                return 1 + max(depth(node.left), depth(node.right))
            else:
                return 1
        return depth(root)

    # Problem 2
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        ans = [0]
        def depth(node: Optional[TreeNode], ans: list[int]) -> int:
            if node:
                left = depth(node.left, ans)
                right = depth(node.right, ans)
                ans[0] = max(ans[0], left + right)
                return max(left, right) + 1
            else:
                return 0
        depth(root, ans)
        return ans[0]

    # Problem 3
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        ans = [True]
        def depth(node: Optional[TreeNode], ans: list[bool]) -> int:
            if node:
                left = depth(node.left, ans)
                right = depth(node.right ,ans)
                if abs(left - right) > 1:
                    ans[0] = False
                return 1 + max(left, right)
            else:
                return 0
        depth(root, ans)
        return ans[0]

    # Problem 4
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        stack = []
        if not p and not q:
            return True
        elif not p or not q:
            return False
        else:
            stack.append(p)
            stack.append(q)
            while stack:
                p = stack.pop()
                q = stack.pop()
                if p.val != q.val:
                    return False
                if (p.left and not q.left) or (not p.left and q.left):
                    return False
                elif p.left and q.left:
                    stack.append(p.left)
                    stack.append(q.left)

                if (p.right and not q.right) or (not p.right and q.right):
                    return False
                elif p.right and q.right:
                    stack.append(p.right)
                    stack.append(q.right)
        return True

