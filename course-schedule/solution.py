from typing import List
class Solution:

    # Problem 1 
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def cycle(i, vis, prerequisites):
            vis[i] = 2
            for prereq in prerequisites:
                if prereq[0] == i:
                    j = prereq[1]
                    if vis[j] == 2:
                        return True
                    if vis[j] == 1:
                        continue
                    if cycle(j, vis, prerequisites):
                        return True
            vis[i] = 1
            return False
        vis = [-1 for _ in range(numCourses)]
        for i in range(numCourses):
            if vis[i] == -1:
                if cycle(i, vis, prerequisites):
                    return False
        return True

    # Problem 2
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        def cycle(i, vis, prerequisites, topo):
            vis[i] = 2
            for prereq in prerequisites:
                if prereq[0] != i:
                    continue
                j = prereq[1]
                if vis[j] == 2:
                    return True
                if vis[j] == 1:
                    continue
                if cycle(j, vis, prerequisites, topo):
                    return True
            vis[i] = 1
            topo.append(i)
            return False
        vis = [-1 for _ in range(numCourses)]
        topo = []
        for i in range(numCourses):
            if vis[i] == -1 and cycle(i, vis, prerequisites, topo):
                return []
        return topo


