# ps - https://leetcode.com/problems/merge-k-sorted-lists/submissions/682143885/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        arr = []
        for l in lists:
            while l:
                arr.append(l.val)
                l = l.next
        
        arr.sort()
        head = None
        curr = None
        for num in arr:
            if not head:
                curr = ListNode(num)
                head = curr
            else:
                curr.next = ListNode(num)
                curr = curr.next
        
        return head
        
        
