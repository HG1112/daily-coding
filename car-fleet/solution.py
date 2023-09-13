from typing import List

class Solution:

    # Problem 1 
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        cars = []
        for i in range(n):
            cars.append([position[i], (target - position[i])/speed[i]])
        cars.sort(key=lambda x : x[0])
        ans = 1
        slowest = cars[n-1][1]
        for i in range(n-2, -1, -1):
            if slowest < cars[i][1]:
                slowest = cars[i][1]
                ans += 1
        return ans
