from typing import List
class Solution:

    # Problem 1 
    def isPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s) - 1
        while l < r:
            if not s[l].isalnum():
                l+=1
            elif not s[r].isalnum():
                r-=1
            elif s[l].lower() == s[r].lower():
                l+=1
                r-=1
            else:
                return False

        return True

    # Problem 2
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return [[]]
        ans = []
        for i in range(1, len(s)+1):
            if s[:i] == s[:i][::-1]:
                for n in self.partition(s[i:]):
                    ans.append([s[:i]] + n)
        return ans

    # Problem 3
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        R = 0
        L = 0
        for i in range(n):
            l = i
            r = i
            while l-1 >=0 and r+1 < n and s[l-1] == s[r+1]:
                l -= 1
                r += 1
            if (R - L + 1) <= (r - l + 1):
                R = r
                L = l
        for i in range(n-1):
            l = i
            r = i+1
            if s[l] != s[r]:
                continue
            while l-1 >=0 and r+1 < n and s[l-1] == s[r+1]:
                l -= 1
                r += 1
            if (R - L + 1) <= (r - l + 1):
                R = r
                L = l
        return s[L: R+1]

        

