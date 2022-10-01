## link - https://leetcode.com/problems/n-queens/

'''
y = -x + c
c = y+x
x = y+c
'''

class Solution:
    def solveNQueens(self, N: int) -> List[List[str]]:
        def isValid(curr, r, c):
            # print(curr)
            for i in range(N):
                if i == r:
                    continue
                if curr[i][c] == "Q":
                    return False
            for j in range(N):
                if j == c:
                    continue
                if curr[r][j] == "Q":
                    return False
            # print("passed row-col")
            i,j = r,c
            for k in range(N):
                i, j = (r+k)%N, (c+k)%N
                if (i,j) == (r,c) or ((i-r)//(j-c) != 1):
                    continue
                # print(i,j, curr[i][j], r,c)
                if curr[i][j] == 'Q':
                    return False
            # print("so far", r,c)
            s = r+c
            i,j = s,0
            if s >= N:
                i = N-1
                j = s-i
            while i >= 0 and j < N:
                # print(i,j, "last loop", r,c)
                if (i,j) == (r,c):
                    j += 1
                    i -= 1
                    continue
                # print(i,j)
                if curr[i][j] == "Q":
                    return False
                j += 1
                i -= 1
            # print("valid case")
            return True
        
        
        empty = [["."]*N for _ in range(N)]
        ans = []
        def helper(curr,r,c,cnt):
            # print(curr, cnt)
            if isValid(curr,r,c):
                # print("valid")
                if cnt == N:
                    temp = []
                    for i in range(N):
                        temp.append("".join(curr[i]))
                    ans.append(temp)
                    return
                for j in range(N):
                    curr[cnt][j] = "Q"
                    helper(curr,cnt,j,cnt+1)
                    curr[cnt][j] = "."
        
        for j in range(N):
            empty[0][j] = "Q"
            helper(empty,0,j,1)
            empty[0][j] = "."
        return ans
            
