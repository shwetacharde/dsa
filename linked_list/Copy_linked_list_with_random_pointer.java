/*
Solution for Leetcode problem no. 138 [MEDIUM]. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

 */


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        Node temp = copyHead;
        Node curr = head.next;
        map.put(head, copyHead);
        while(curr != null) {
            temp.next = new Node(curr.val);
            temp = temp.next;
            map.put(curr, temp);
            curr = curr.next;
        }
        temp.next = null;

        Node temp1 = head;
        Node temp2 = copyHead;
        while(temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return copyHead;
    }
}