class Node:

    def __init__(self, key: int, val: int) -> None:
        self.key = key
        self.val = val
        self.next = None
        self.prev = None

# Problem 1 
class LRUCache:

    def __init__(self, capacity: int):
        self.size = 0
        self.capacity = capacity
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.map = {}
        

    def delete(self, node): 
        prev = node.prev
        next = node.next
        prev.next = next
        next.prev = prev
        node.prev = None
        node.next = None


    def append(self, node):
        prev = self.tail.prev 
        prev.next = node
        node.prev = prev
        node.next = self.tail
        self.tail.prev = node

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        ans = self.map[key].val
        self.delete(self.map[key])
        self.append(self.map[key])
        return ans


    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.map[key].val = value
            self.delete(self.map[key])
            self.append(self.map[key])
        else:
            if self.size == self.capacity:
                node = self.head.next
                self.delete(node)
                self.map.pop(node.key)
                self.size -= 1
            node = Node(key, value)
            self.map[key] = node
            self.size += 1
            self.append(node)

    def print(self) -> None:
        curr = self.head.next
        while curr != self.tail:
            print(curr.key, " ", curr.val)
