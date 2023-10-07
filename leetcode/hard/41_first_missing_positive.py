# ps - https://leetcode.com/problems/first-missing-positive/description/
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            if (i+1) != nums[i]:
                curr = nums[i]
                nums[i] = ""
                while curr != "" and 0 <= curr-1 < len(nums) and curr != nums[curr-1]:
                    nums[curr-1], curr = curr, nums[curr-1]
        # print(nums)
        for i in range(len(nums)):
            if i+1 != nums[i]:
                return i+1
        return len(nums)+1
