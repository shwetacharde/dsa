# ps - https://leetcode.com/problems/longest-valid-parentheses/description/
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        st = []
        
        for i,char in enumerate(s):
            if char == "(":
                st.append(i)
            elif st and s[st[-1]] == "(" and char == ")":
                st.pop()
            else:
                st.append(i)
        
        a = 0
        b = n
        m = 0
        if st:
            while st:
                a = st.pop()
                m = max((b-a-1), m)
                b = a
            m = max(m,b)
        else:
            return n
        return m
