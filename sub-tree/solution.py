from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # Problem 1 
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        left = root.left
        right = root.right
        root.left = self.invertTree(right)
        root.right = self.invertTree(left)
        return root

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        from hashlib import sha256
        def sha_hash(x):
            sha = sha256()
            sha.update(x.encode('utf-8'))
            return sha.hexdigest()
        def merkle(node):
            if not node:
                return '#'
            left = merkle(node.left)
            right = merkle(node.right)
            node.merkle = sha_hash(left + str(node.val) + right)
            return node.merkle
        merkle(root)
        merkle(subRoot)
        def dfs(node):
            if not node:
                return False
            return (node.merkle == subRoot.merkle) or dfs(node.left) or dfs(node.right)
        return dfs(root)
