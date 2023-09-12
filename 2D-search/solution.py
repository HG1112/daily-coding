from typing import List

class Solution:

    # Problem 1 
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        lo = 0
        hi = m*n -1
        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            x = mid // n
            y = mid % n
            if matrix[x][y] < target:
                lo = mid+1
            elif matrix[x][y] > target:
                hi = mid-1
            else:
                return True
        return False

