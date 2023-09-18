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
