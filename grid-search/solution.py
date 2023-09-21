from typing import List
class Solution:

    # Problem 1 
    def exist(self, board: List[List[str]], word: str) -> bool:
        def f(board, word, i, j, k, vis):
            if board[i][j] != word[k]:
                return False
            if k == len(word)-1:
                return True
            directions = [[1,0],[0,1],[-1,0],[0,-1]]
            vis[i][j] = True
            ans = False
            for di in directions:
                x = i + di[0]
                y = j + di[1]
                if not (0 <= x and x < len(board) and 0 <= y and y < len(board[0])):
                    continue
                if vis[x][y]:
                    continue
                ans = ans or f(board, word, x, y, k+1, vis)
            vis[i][j] = False
            return ans
        m = len(board)
        n = len(board[0])
        vis = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if f(board, word, i, j, 0, vis):
                    return True
        return False


