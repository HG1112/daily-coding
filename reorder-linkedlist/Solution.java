import java.util.*;
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  // Problem 1
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode ans = new ListNode(0);
    ListNode curr = ans;
    int idx = 1;
    while (idx < left) {
      curr.next = new ListNode(head.val);
      curr = curr.next;
      head = head.next;
      idx++;
    }

    Stack<ListNode> stack = new Stack<>();
    while (idx <= right) {
      stack.push(head);
      head = head.next;
      idx++;
    }
    while (!stack.isEmpty()) {
      curr.next = new ListNode(stack.pop().val);
      curr = curr.next;
    }

    while (head != null) {
      curr.next = new ListNode(head.val);
      curr = curr.next;
      head = head.next;
    }

    return ans.next;
  }


  // Problem 2
  public ListNode reverseList(ListNode head) {
    ListNode ans = null;
    while (head != null) {
      ListNode next = new ListNode(head.val);
      if (ans == null) {
        ans = next;
      } else {
        next.next = ans;
        ans = next;
      }
      head = head.next;
    }
    return ans;
  }

  // Problem 3
  public void reorderList(ListNode head) {
    ListNode curr = head;
    int n = 0;
    Stack<ListNode> rev = new Stack<>();
    while (curr != null) {
      rev.push(curr);
      n++;
      curr = curr.next;
    }
    curr = head;
    for (int i = 0; i < n/2; i++) {
      ListNode node = rev.pop();
      ListNode next = curr.next;
      curr.next = node;
      node.next = next;
      curr = next;
    }
    if (n%2 == 1) {
      ListNode node = rev.pop();
      curr.next = node;
      curr = curr.next;
    }
    curr.next = null;
  }

  // Problem 4
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dum = new ListNode(0, head);
    del(head, dum , n);
    return dum.next;
  }

  private int del(ListNode node, ListNode prev, int n) {
    if (node == null) return 0;
    int h = 1 + del(node.next, node, n);
    if (h == n) prev.next = node.next;
    return h;
  }

  // Problem 5
  public Node copyRandomList(Node head) {
    Node ans = new Node(0);
    Node curr = head;
    Map<Node, Node> map = new HashMap<>();
    while (curr != null) {
      map.put(curr, new Node(curr.val));
      curr = curr.next;
    }
    curr = head;
    Node copy = ans;
    while (curr != null) {
      copy.next = map.get(curr);
      copy = copy.next;
      copy.random = map.get(curr.random);
      curr = curr.next;
    }
    return ans.next;
  }
}
