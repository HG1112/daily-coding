class Solution:

    # Problem 1 
    def min_coins(self, coins: list[int], amount: int) -> int:
        dp = [-1 for _ in range(amount+1)]
        dp[0] = 0
        for i in range(1, amount+1):
            for coin in coins:
                if i >= coin and dp[i-coin] > 0:
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
