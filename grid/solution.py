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



