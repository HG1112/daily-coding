from bisect import bisect
import collections
class Solution:

    # Problem 1 
    class TimeMap:

        def __init__(self):
            self.kt = collections.defaultdict(list)
            self.kv = collections.defaultdict(list)
        

        def set(self, key: str, value: str, timestamp: int) -> None:
            self.kt[key].append(timestamp)
            self.kv[key].append(value)
        

        def get(self, key: str, timestamp: int) -> str:
            idx = bisect.bisect(self.kt[key], timestamp)
            if idx == 0:
                return ""
            return self.kv[key][idx-1]
