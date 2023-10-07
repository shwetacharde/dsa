# problem link - https://leetcode.com/problems/regular-expression-matching/
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        ns, np = len(s), len(p)
        dp = [[False]*(np+1) for _ in range(ns+1)]
        dp[0][0] = True
        # check if every even place is * and valid
        for i in range(1,np,2):
            if p[i] == "*" and dp[0][i-1]:
                dp[0][i+1] = True
        for i in range(ns):
            for j in range(np):
                if s[i] == p[j] or p[j] == ".":
                    dp[i+1][j+1] = dp[i][j]
                elif p[j] == "*":
                    if p[j-1] != "." and p[j-1] != s[i]:
                        dp[i+1][j+1] = dp[i+1][j-1]
                    else:
                        dp[i+1][j+1] = dp[i+1][j-1] or dp[i][j] or dp[i][j+1]
        # print(dp)
        return dp[-1][-1]
