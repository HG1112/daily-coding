import java.util.*;

class Solution {

  // Problem 1
  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
  public Node cloneGraph(Node node) {
    Map<Node, Node> clones = new HashMap<>();
    return clone(node, clones);
  }
  private Node clone(Node node, Map<Node, Node> clones) {
    if (node == null)
      return null;
    if (clones.containsKey(node)) 
      return clones.get(node);
    Node copy = new Node(node.val);
    clones.put(node, copy);
    for (Node neighbor: node.neighbors) {
      copy.neighbors.add(clone(neighbor, clones));
    }
    return copy;
  } 
}
