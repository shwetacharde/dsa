public class Reverse_Nodes_In_k_Group {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        int i = 0;
        ListNode cur = head;
        
        while(cur!=null && i<k){
            cur = cur.next;
            i++;
        }
        
        if(i == k) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode forw;

            for(int j=0 ; j<k && curr!=null; j++){
                forw = curr.next;
                curr.next = prev;
                prev = curr;
                curr = forw;
            }

            head.next = reverseKGroup(curr,k);
            return prev;
        }
        else {
            return head;
        }
    }
}
