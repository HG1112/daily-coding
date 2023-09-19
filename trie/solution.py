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

# FIXME : Problem 3
class Solution:
    class Trie:
        def __init__(self):
            self.end = 0
            self.child = [None for _ in range(26)]

    def buildTree(self, words: List[str]):
        self.root = self.Trie()
        def add(word, curr) -> None:
            for c in word:
                idx = ord(c) - ord('a')
                if not curr.child[idx]:
                    curr.child[idx] = self.Trie()
                curr = curr.child[idx]
            curr.end += 1
        for word in words: 
            add(word, self.root)



    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.buildTree(words)
        def dfs(board, i, j, vis, curr, acc, ans):
            vis[i][j] = True
            c = board[i][j]
            idx = ord(c) - ord('a')
            if not curr.child[idx]:
                return
            if curr.child[idx].end != 0:
                ans.append(acc + c)
                curr.child[idx].end -= 1
            directions = [[1,0],[0,1],[-1,0],[0,-1]]
            for di in directions:
                x = i + di[0]
                y = j + di[1]
                if not (0 <= x and x < len(board) and 0 <= y and y < len(board[0])):
                    continue
                if vis[x][y]:
                    continue
                dfs(board,x, y, vis, curr.child[idx], acc + c, ans)
            vis[i][j] = False
        ans = []
        acc = ""
        vis = [ [False for _ in range(len(board[0]))] for _ in range(len(board))]
        curr = self.root
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(board, i, j, vis, curr, acc, ans)
        return ans

