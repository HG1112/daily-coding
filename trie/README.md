# Trie 


## Problem 1

Time Complexity : O(max word length)

Space Complexity: O(max word length * num of words * num of alphabets)

[Implementation in Java](Trie.java)
[Implementation in Python](trie.py)


## Problem 2

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


### [Link to Leetcode](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
### [Solution in Java](Solution.java#L5)
### [Solution in Python](solution.py#L8)

## Problem 3

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.


### [Link to Leetcode](https://leetcode.com/problems/word-search-ii/)
### [Solution in Java](Solution.java#L55)
### [Solution in Python](solution.py#L41)
