from typing import List

class TrieNode:
    def __init__(self):
        self.end = False
        self.child = [None for _ in range(26)]

    # Problem 1 
class WordDictionary:

    def __init__(self):
        self.root = TrieNode()


    def addWord(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.child[idx]:
                curr.child[idx] = TrieNode()
            curr = curr.child[idx]
        curr.end = True


    def search(self, word: str) -> bool:
        def find(word: str, i: int, curr: TrieNode) -> bool:
            if i == len(word):
                return curr and curr.end
            ans = False
            if word[i] == '.':
                for node in curr.child:
                    if node:
                        ans = ans or find(word, i+1, node)
            else:
                idx = ord(word[i]) - ord('a')
                if curr.child[idx]:
                    ans = find(word, i+1, curr.child[idx])
            return ans
        return find(word, 0, self.root)

