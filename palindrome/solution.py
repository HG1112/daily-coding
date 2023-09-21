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

        

