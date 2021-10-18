public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode t1 = head;
        ListNode t2 = head.next;
        
        while(t2 != null){
            if(t1.val == t2.val){
                t1.next = t2.next;
                t2 = t2.next;
            }
            else{
                t1 = t2;
                t2 = t2.next;
            }
        }
        
        return head;
    }
}
