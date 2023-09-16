import java.util.*;

class Solution {

  // Problem 1
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> bfs = new ArrayDeque<>();
    bfs.offer(root);
    while (!bfs.isEmpty()) {
      TreeNode node = bfs.remove();
      TreeNode temp = node.right;
      node.right = node.left;
      node.left = temp;

      if (node.left != null) bfs.offer(node.left);
      if (node.right != null) bfs.offer(node.right);
    }
    return root;
  }
}

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
