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

    # Problem 6
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        def ocean(stack, vis, grid):
            directions = [[1,0],[0,1],[-1,0],[0,-1]]
            m = len(grid)
            n = len(grid[0])
            for i, j in stack:
                vis[i][j] = True
            while stack:
                i, j = stack.pop()
                for di in directions:
                    x = i + di[0]
                    y = j + di[1]
                    if not (0 <= x and x < m and 0 <= y and y < n):
                        continue
                    if vis[x][y]:
                        continue
                    if grid[x][y] < grid[i][j]:
                        continue
                    vis[x][y] = True
                    stack.append([x,y])
        m = len(heights)
        n = len(heights[0])
        pacific = []
        atlantic = []
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    pacific.append([i, j])
                if i == m-1 or j == n-1:
                    atlantic.append([i, j])
        p = [[False for _ in range(n)]  for _ in range(m)]
        a = [[False for _ in range(n)]  for _ in range(m)]
        ocean(pacific, p, heights)
        ocean(atlantic, a, heights)
        ans = []
        for i in range(m):
            for j in range(n):
                if p[i][j] and a[i][j]:
                    ans.append([i,j])
        return ans
                
    
    # Problem 7
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def fill(i, j, vis, board):
            vis[i][j] = True
            dir = [[1,0],[0,1],[-1,0],[0,-1]]
            for di in dir:
                x = i + di[0]
                y = j + di[1]
                if not (0 <= x and x < m and 0 <= y and y < n):
                    continue
                if vis[x][y]:
                    continue
                if board[i][j] == 'X':
                    continue
                fill(x,y,vis, board)

        m = len(board)
        n = len(board[0])
        vis = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            if board[i][0] == 'O':
                fill(i, 0, vis, board)
            if board[i][n-1] == 'O':
                fill(i, n-1, vis, board)
        for j in range(n):
            if board[0][j] == 'O':
                fill(0, j, vis, board)
            if board[m-1][j] == 'O':
                fill(m-1, j, vis, board)
        for i in range(m):
            for j in range(n):
                if not vis[i][j]:
                    board[i][j] = 'X'

    

