import java.util.*;

class Solution {

  // Problem 1
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    } else if (root == null && subRoot != null) {
      return false;
    } else if (root != null && subRoot == null) {
      return true;
    } else {
      if (preorder(root, subRoot))
        return true;
      else 
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
  }

  private boolean preorder(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null)
      return true;
    else if (root == null || subRoot == null)
      return false;
    else 
      return (root.val == subRoot.val) && preorder(root.left, subRoot.left) && preorder(root.right, subRoot.right);
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
