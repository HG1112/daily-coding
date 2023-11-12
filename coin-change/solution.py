class Solution:

    # Problem 1 
    def min_coins(self, coins: list[int], amount: int) -> int:
        dp = [-1 for _ in range(amount+1)]
        dp[0] = 0
        for i in range(1, amount+1):
            for coin in coins:
                if i >= coin and dp[i-coin] >= 0:
                    if dp[i] == -1:
                        dp[i] = dp[i-coin]+1
                    else:
                        dp[i] = min(dp[i-coin]+1, dp[i])
        return dp[amount]

    # Problem 2
    def num_flips(self, n: int) -> int:
        ans = 0
        while n > 1:
            ans += 1
            n = n >> 1
        return ans

    # Problem 3
    def change(self, amount: int, coins: List[int]) -> int:
        def f(amount, i, coins, dp):
            if amount == 0:
                return 1
            if i < 0:
                return 0
            if dp[amount][i] != -1:
                return dp[amount][i]
            ans = 0
            if amount >= coins[i]:
                ans += f(amount - coins[i], i, coins, dp)
            ans += f(amount, i-1, coins, dp)
            dp[amount][i] = ans
            return ans
        dp = [[-1 for _ in range(len(coins))] for _ in range(amount+1)]
        return f(amount, len(coins)-1, coins, dp)


