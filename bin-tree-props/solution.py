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
