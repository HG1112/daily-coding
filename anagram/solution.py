class Solution:

    # Problem 1 
    def isAnagram(self, s: str, t: str) -> bool:
        count = {}
        for c in s:
            if c not in count:
                count[c] = 0
            count[c] += 1
        for c in t:
            if c not in count:
                return False
            if count[c] == 1:
                count.pop(c)
            else:
                count[c] -= 1

        return not count
