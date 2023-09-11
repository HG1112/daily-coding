from typing import List
class Solution:

    # Problem 1 
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        col = [[False for _ in range(9)] for _ in range(9)]
        row = [[False for _ in range(9)] for _ in range(9)]
        box = [[False for _ in range(9)] for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                val = int(board[i][j]) -1
                if col[j][val] or row[i][val] or box[(i//3)*3 + (j//3)][val]:
                    return False
                col[j][val] = True
                row[i][val] = True
                box[(i//3)*3 + (j//3)][val] = True
        return True
    
        

