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


    # Problem 2
    def letterCombinations(self, digits: str) -> List[str]:
        letters = [ [], [], ['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'], ['p', 'q', 'r', 's'], ['t', 'u', 'v'], ['w', 'x', 'y', 'z'] ]
        def gen(digits, i, letters, acc, ans):
            if i == len(digits):
                copy = ''.join(c for c in acc)
                ans.append(copy)
                return
            idx = ord(digits[i]) - ord('0')
            for c in letters[idx]:
                gen(digits, i+1, letters, acc + c, ans)
        ans = []
        if not digits:
            return ans
        gen(digits, 0, letters, "", ans)
        return ans


    # Problem 3
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for _ in range(n)] for _ in range(n)]
        col = [False for _ in range(n)]
        pos = [False for _ in range(2*n - 1)]
        neg = [False for _ in range(2*n - 1)]
        def gen(board, i, col, pos, neg, ans):
            n = len(board)
            if i == n:
                ans.append([''.join(row) for row in board])
                return
            for j in range(n):
                if col[j] or pos[i-j + (n-1)] or neg[i+j]:
                    continue
                col[j] = True
                pos[i-j+(n-1)] = True
                neg[i+j] = True
                board[i][j] = 'Q'
                gen(board, i+1, col, pos, neg, ans)
                board[i][j] = '.'
                col[j] = False
                pos[i-j+(n-1)] = False
                neg[i+j] = False
        ans = []
        gen(board, 0, col, pos, neg, ans)
        return ans



    # Problem 4
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i, j, grid):
            m = len(grid)
            n = len(grid[0])
            grid[i][j] = '0'
            directions = [[-1, 0], [0, -1], [1,0], [0,1]]
            for di in directions:
                x = i + di[0]
                y = j + di[1]
                if not (0 <= x and x < m and 0 <= y and y < n):
                    continue
                if grid[x][y] == '0':
                    continue
                dfs(x, y, grid)
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    dfs(i, j, grid)
        return count

    # Problem 5
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        def count(i, j, grid):
            directions = [[1,0],[0,1],[-1,0],[0,-1]]
            grid[i][j] = 0
            ans = 1
            for di in directions:
                x = i + di[0]
                y = j + di[1]
                if not (0 <= x and x < m and 0 <= y and y < n):
                    continue
                if grid[x][y] == 0:
                    continue
                ans += count(x, y, grid)
            return ans
        ans = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    ans = max(ans, count(i, j, grid))
        return ans


