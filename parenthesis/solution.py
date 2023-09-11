from typing import List
class Solution:

    # Problem 1 
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '{' or c == '[' or c == '(':
                stack.append(c)
            elif stack:
                if c == '}' and stack[-1] == '{':
                    stack.pop()
                elif c == ')' and stack[-1] == '(':
                    stack.pop()
                elif c == ']' and stack[-1] == '[':
                    stack.pop()
                else:
                    return False
            else:
                return False
        return not stack

    # Problem 2
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def f(open: int, close: int, acc: str) -> None:
            if open == 0 and close == 0:
                ans.append(acc)
            else:
                if open > 0:
                    f(open-1, close, acc + '(')
                if open < close:
                    f(open, close-1, acc + ')')
        f(n,n,"")
        return ans

