# Reverse Linkedlist

Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

## Intuition

- Linear iteration and one-index counting 
- reversing can be achieved by stack or by using three pointers and changing next pointers to previous

### [Link to Leetcode](https://leetcode.com/problems/reverse-linked-list-ii/)
### [Solution in Java](Solution.java#L44)
### [Solution in Python](solution.py#L13)

## Problem 2

Given the head of a singly linked list, reverse the list, and return the reversed list.

### [link to leetcode](https://leetcode.com/problems/reverse-linked-list/)
### [solution in java](solution.java#L11)
### [solution in python](solution.py#L41)

## Problem 3

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.


### [link to leetcode](https://leetcode.com/problems/reorder-list/)
### [solution in java](solution.java#L60)
### [solution in python](solution.py#L55)

## Problem 4

Given the head of a linked list, remove the nth node from the end of the list and return its head.


### [link to leetcode](https://leetcode.com/problems/reorder-list/)
### [solution in java](solution.java#L86)
### [solution in python](solution.py#L89)

## Problem 5

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.

Your code will only be given the head of the original linked list.


### [link to leetcode](https://leetcode.com/problems/reorder-list/)
### [solution in java](solution.java#L86)
### [solution in python](solution.py#L107)
