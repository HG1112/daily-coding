import java.util.*;

class Solution {

  // Problem 1
  class LRUCache {

    class Node {
      int key;
      int val;
      Node next;
      Node prev;
      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }


    private void del(Node node) {
      Node prev = node.prev;
      Node next = node.next;
      if (node == head) {
        if (head == tail) {
          head = null;
          tail = null;
        } else {
          head = head.next;
        }
      } else if (node == tail) {
        if (head == tail) {
          head = null;
          tail = null;
        } else {
          tail = tail.prev;
        }
      } else {
        prev.next = next;
        next.prev = prev;
      }
      node.prev = null;
      node.next = null;
    }

    private void add(Node node) {
      if (tail == null) {
        head = node;
        tail = head;
      } else {
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
      }
    }


    int capacity;
    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      size = 0;
      map = new HashMap<>();
      head = null;
      tail = null;
    }

    public int get(int key) {
      if (!map.containsKey(key)) return -1;
      int ans = map.get(key).val;
      del(map.get(key));
      add(map.get(key));
      return ans;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        map.get(key).val = value;
        del(map.get(key));
        add(map.get(key));
      } else {
        if (size == capacity) {
          map.remove(head.key);
          del(head);
          size--;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);
        size++;
      }
    }
  }
}
