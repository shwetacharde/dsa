# link - https://leetcode.com/problems/n-queens-ii/

class Solution:
    def totalNQueens(self, n: int) -> int:
        def isvalid(board,r,c):
            if sum(board[r]) > 1:
                return False
            
            c1 = 0
            # print(r,c)
            for i in range(n):
                c1 += board[i][c]
            if c1 > 1:
                return False
            # print("c2")
            
            c1 = 0
            l,m = r,c
            if r < c:
                l,m = 0,c-r
            else:
                l,m = r-c,0
                
            while 0 <= l < n and 0 <= m < n:
                c1 += board[l][m]
                l += 1
                m += 1
            if c1 > 1:
                return False
            
            # print("c3")
            c1 = 0
            l,m = r,c
            if r+c < n:
                l,m = 0,r+c
            else:
                m = n-1
                l = r+c-m
            while 0 <= l < n and 0 <= m < n:
                c1 += board[l][m]
                l += 1
                m -= 1
            if c1 > 1:
                return False
            
            return True
        
        global ans
        ans = 0
        def helper(board, cnt, r,c):
            global ans
            # for row in board:
            #     print(row)
            # print()
            if isvalid(board,r,c):
                # print("valid")
                if cnt == n:
                    ans += 1
                    return
                cnt += 1
                r += 1
                for j in range(n):
                    board[r][j] = 1
                    helper(board, cnt,r,j)
                    board[r][j] = 0
        
        board = [[0]*n for _ in range(n)]
        for j in range(n):
            board[0][j] = 1
            helper(board, 1, 0,j)
            board[0][j] = 0
        return ans
