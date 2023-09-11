import java.util.*;

class MinStack {

  private class Node {
    int val;
    int min;
    Node next;
    Node prev;

    Node(int val) {
      this.val = val;
      min = val;
      next = null;
      prev = null;
    }
  }

  Node head;
  Node tail;
  public MinStack() {
    head = null;
    tail = null;
  }

  public void push(int val) {
    Node node = new Node(val);
    if (head == null) {
      head = node;
      tail = head;
    } else {
      node.prev = tail;
      tail.next = node;
      node.min = Math.min(node.min, tail.min);
      tail = tail.next;
    }
  }

  public void pop() {
    if (tail == null) return;
    if (head == tail) {
      head = null;
      tail = head;
    } else {
      Node prev = tail.prev;
      prev.next = null;
      tail.prev = null;
      tail = prev;
    }
  }

  public int top() {
    return tail.val;
  }

  public int getMin() {
    return tail.min;
  }
}
