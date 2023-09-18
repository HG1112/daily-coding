import java.util.*;

class Solution {

  // Problem 1
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) return ans;
    Queue<TreeNode> bfs = new ArrayDeque<>();
    bfs.offer(root);
    while (!bfs.isEmpty()) {
      List<Integer> sub = new LinkedList<>();
      int n = bfs.size();
      for (int i = 0; i < n; i++) {
        TreeNode node = bfs.remove();
        sub.add(node.val);
        if (node.left != null) bfs.offer(node.left);
        if (node.right != null) bfs.offer(node.right);
      }
      ans.add(sub);
    }
    return ans;
  }

  // Problem 2
  public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> level = new ArrayDeque<>();
    List<Integer> ans = new LinkedList<>();
    if (root == null) return ans;
    level.add(root);
    while (!level.isEmpty()) {
      int n = level.size();
      TreeNode node = null;
      for (int i = 0; i < n-1; i++) {
        node = level.remove();
        if (node.left != null) level.add(node.left);
        if (node.right != null) level.add(node.right);
      }
      node = level.remove();
      ans.add(node.val);
      if (node.left != null) level.add(node.left);
      if (node.right != null) level.add(node.right);
    }
    return ans;
  }

  // Problem 3
  public boolean isValidBST(TreeNode root) {
    return isValid(root, null , null);
  }

  private boolean isValid(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;
    if (!((min == null || min < node.val) && (max == null || node.val < max))) return false;
    return isValid(node.left, min, max == null ? node.val : Math.min(max, node.val)) &&
    isValid(node.right, min == null ? node.val : Math.max(node.val, min), max);
  }


  // Problem 4
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preStart = 0;
    return build(preorder, preorder.length-1, inorder, 0, inorder-1);
  }

  int preStart;
  private TreeNode build(int[] pre , int preEnd, int[] in, int inStart, int inEnd) {
    if (inStart > inEnd || preStart > preEnd)
      return null;
    TreeNode ans = new TreeNode(pre[preStart]);
    for (int idx = inStart; idx <= inEnd; idx++) {
      if (in[idx] == ans.val) {
        if (inStart < idx) {
          preStart++;
          ans.left = build(pre, preEnd, in, inStart, idx-1);
        }
        if (idx >= inStart && idx < inEnd) {
          preStart++;
          ans.right = build(pre, preEnd, in, idx+1, inEnd);
        }
        break;
      }
    }
    return ans;
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
