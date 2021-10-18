/*
Solution for Leetcode problem no. 206.[EASY] Reverse Linked List:

Given the head of a singly linked list, reverse the list, and return the reversed list.


Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]


Example 2:

Input: head = [1,2]
Output: [2,1]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode reverse(ListNode curr, ListNode prev) {
        if(curr.next == null) {
            curr.next = prev;
            return curr;
        }
        else {
            ListNode temp = curr.next;
            curr.next = prev;
            return reverse(temp, curr);
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        return reverse(head, null);
    }
}