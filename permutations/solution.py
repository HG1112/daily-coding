from typing import List
class Solution:

    # Problem 1 
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m1 = {}
        for c in s1:
            if c not in m1:
                m1[c] = 0
            m1[c] += 1
        m = len(s1)
        n = len(s2)
        m2 = {}
        match = 0
        l = 0
        for r in range(n):
            c = s2[r]
            if c in m1:
                if c not in m2:
                    m2[c] = 0
                while m2[c] >= m1[c]:
                    m2[s2[l]] -= 1
                    l += 1
                    match -= 1
                m2[c] += 1
                match += 1
            else:
                m2.clear()
                match = 0
                l = r+1
            if match == m:
                return True
        return False
