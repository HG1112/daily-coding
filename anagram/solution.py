from typing import List
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


    # Problem 2    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def encode(s: str) -> str:
            chars = [0 for _ in range(26)]
            for c in s:
                chars[ord(c) - ord('a')] += 1
            return str(chars)

        groups = {}
        for s in strs:
            ser = encode(s)
            if ser not in groups:
                groups[ser] = []
            groups[ser].append(s)

        return [v for _, v in groups.items()]



