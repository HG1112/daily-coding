import java.util.*;

public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);
    return sb.toString();
  }

  private void preorder(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append(",");
      return;
    }
    sb.append(node.val + ",");
    preorder(node.left, sb);
    preorder(node.right, sb);
  }


  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] tokens = data.split(",");
    start = 0;
    return build(tokens, tokens.length - 1);
  }

  int start;
  private TreeNode build(String[] pre, int end) {
    if (start > end)
      return null;
    String value = pre[start];
    start++;
    if (value.length() == 0) return null;
    TreeNode ans = new TreeNode(Integer.parseInt(value));
    ans.left = build(pre, end);
    ans.right = build(pre, end);
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

