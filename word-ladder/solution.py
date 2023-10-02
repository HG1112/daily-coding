from typing import List
class Solution:

    # Problem 1 
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        begin = end = -1
        for i in range(len(wordList)):
            if beginWord == wordList[i]:
                begin = i
            if endWord == wordList[i]:
                end = i
        if end == -1:
            return 0
        if begin == -1:
            wordList.append(beginWord)
            begin = len(wordList) - 1
        n = len(wordList)
        g = Graph(n)
        for i in range(n):
            for j in range(i+1, n):
                if self.match(wordList[i], wordList[j]):
                    g.addEdge(i, j)
        return g.bfs(begin, end)

    def match(self, a, b):
        if len(a) != len(b):
            return False
        count = 0
        for i in range(len(a)):
            if a[i] != b[i]:
                count += 1
        return count == 1


class Graph:
    def __init__(self, n) -> None:
        self.adj = [[] for _ in range(n)]
    def addEdge(self, u, v):
        self.adj[u].append(v)
        self.adj[v].append(u)
    def bfs(self, start, end):
        if start == end:
            return 0
        level = []
        vis = [False for _ in range(len(self.adj))]
        level.append([start, 1])
        vis[start] = True
        while level:
            n = len(level)
            for _ in range(n):
                u, length = level.pop(0)
                if u == end:
                    return length
                for v in self.adj[u]:
                    if not vis[v]:
                        vis[v] = True
                        level.append([v, length+1])
        return 0
