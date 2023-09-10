from typing import List

class Solution:

    # Problem 1 
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[]]
        if numRows == 0:
            return ans

        one = [1]
        ans.append(one)

        for row in range(1, numRows):
            n = len(ans[-1])
            sub = []
            for i in range(0, row+1):
                left = ans[-1][i-1] if i-1 >= 0 else 0
                right = ans[-1][i] if i < n else 0
                sub.append(left + right)
            ans.append(sub)

        return ans
