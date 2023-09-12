from typing import List
class Solution:

    # Problem 1 
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == "+":
                right = stack.pop()
                left = stack.pop()
                stack.append(left + right)
            elif token == "-":
                right = stack.pop()
                left = stack.pop()
                stack.append(left - right)
            elif token == "*":
                right = stack.pop()
                left = stack.pop()
                stack.append(left * right)
            elif token == "/":
                right = stack.pop()
                left = stack.pop()
                stack.append(left // right)
            else:
                stack.append(int(token))

        return stack.pop()
