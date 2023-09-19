class TrieNode:

    def __init__(self) -> None:
        self.end = False
        self.child = [None for _ in range(26)]

class Trie:

    def __init__(self) -> None:
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cursor = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not cursor.child[idx]:
                cursor.child[idx] = TrieNode()
            cursor = cursor.child[idx]
        cursor.end = True

    def startsWith(self, pre: str) -> None:
        cursor = self.root
        for c in pre:
            idx = ord(c) - ord('a')
            if not cursor.child[idx]:
                return False
            cursor = cursor.child[idx]
        return True

    def contains(self, word: str) -> None:
        cursor = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not cursor.child[idx]:
                return False
            cursor = cursor.child[idx]
        return cursor.end
