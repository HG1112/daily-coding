class MinStack:

    class Node:
        def __init__(self, val):
            self.val = val
            self.next = None
            self.prev = None
            self.min = val

    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, val: int) -> None:
        node = self.Node(val)
        if self.tail:
            node.prev = self.tail
            self.tail.next = node
            node.min = min(node.min, self.tail.min)
            self.tail = self.tail.next
        else:
            self.head = node
            self.tail = node

    def pop(self) -> None:
        if not self.head:
            return None

        if self.head == self.tail:
            self.head = None
            self.tail = None
        else:
            prev = self.tail.prev
            self.tail.prev = None
            prev.next = None
            self.tail = prev
        

    def top(self) -> int:
        return self.tail.val

    def getMin(self) -> int:
        return self.tail.min

