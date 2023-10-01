# Cycle

## Problem 1

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

### [Link to Leetcode](https://leetcode.com/problems/linked-list-cycle/)
### [Solution in Java](Solution.java#L5)
### [Solution in Python](solution.py#L8)

## Problem 2

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 

Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). 

It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

### [Link to Leetcode](https://leetcode.com/problems/linked-list-cycle-ii/)
### [Solution in Java](Solution.java#L17)
### [Solution in Python](solution.py#L20)

## Problem 3

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. 

The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. 

The graph is represented as an array edges of length n where edges\[i\] = \[ai, bi\] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes.

If there are multiple answers, return the answer that occurs last in the input.

### [Link to Leetcode](https://leetcode.com/problems/redundant-connection/)
### [Solution in Java](Solution.java#L41)
### [Solution in Python](solution.py#L41)
