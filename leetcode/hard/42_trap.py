## Link - https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def trap(self, height: List[int]) -> int:
        rh = []
        n = len(height)
        rmax = 0
        for i in range(n-1, -1, -1):
            rmax = max(rmax, height[i])
            rh.append(rmax)
        rh = rh[::-1]
        ans = 0
        lmax = 0
        for i in range(len(height)):
            lmax = max(lmax, height[i])
            m = min(lmax, rh[i])
            if m > height[i]:
                ans += m-height[i]
        return ans
