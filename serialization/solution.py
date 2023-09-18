from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        ans = []
        def preorder(node: Optional[TreeNode], ans: list[str]) -> None:
            if not node:
                ans.append("")
                return
            ans.append(str(node.val))
            preorder(node.left, ans)
            preorder(node.right, ans)
        preorder(root, ans)
        return ','.join(ans)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        preorder = data.split(",")
        ends = [0, len(preorder)-1]
        def parse(preorder: list[str], ends: list[int]):
            if ends[0] > ends[1]:
                return None
            if preorder[ends[0]] == '':
                ends[0] += 1
                return None
            ans = TreeNode(int(preorder[ends[0]]))
            ends[0] += 1
            ans.left = parse(preorder, ends)
            ans.right = parse(preorder, ends)
            return ans
        return parse(preorder, ends)

