from typing import List
import math

class Solution:


    # Problem 1 
    def countOrders(self, n: int) -> int:
        M = 10**9 + 7
        if n == 1:
            return 1
        next = self.countOrders(n-1);
        return (((((n % M) * ((2 * n - 1) % M)) % M) * (next % M)) % M)

    # for the heck of it
    def countOrders2(self, n: int) -> int:
        M = 10**9 + 7
        return ((math.factorial(2*n) >> n) % M)
