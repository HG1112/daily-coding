from typing import Optional
class Solution:

    # Problem 1 
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        def clone(node, map):
            if not node:
                return None
            if node in map:
                return map[node]
            copy = Node(node.val)
            map[node] = copy
            for neighbor in node.neighbors:
                copy.neighbors.append(clone(neighbor, map))
            return copy
        map = {}
        return clone(node, map)

class Node:
    
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
