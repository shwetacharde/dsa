import java.util.Stack;

public class isPalindrome {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ////////////////////////// O(N) TIME O(N) SPACE /////////////////////////////

    public boolean is_Palindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        Stack<Integer> s = new Stack<>();
        
        ListNode temp = head;
        
        while(temp != null){
            s.push(temp.val);
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null) {
            int x = s.pop();
            
            if(x != temp.val){
                return false;
            }
            
            temp = temp.next;
        }
        return true;
    }


    /////////////////////////// O(N) TIME O(N) SPACE ////////////////////////////

    public boolean is_Palindrome2(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode mid = findMid(head);
        // ListNode middleElem = mid;
        
        mid.next = reverse(mid.next);
        mid = mid.next;
        
        ListNode temp = head;
        
        while(mid != null) {
            if(temp.val != mid.val) {
                return false;
            }
            
            temp = temp.next;
            mid = mid.next;
        }
        
        return true;
        
    }
    
    public ListNode findMid(ListNode head){
        // write your code here

        ListNode slow = head;

        if(head == null){
            return null;
        }

        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        ListNode cur = head;
        ListNode forw;

        while(cur != null){
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        return prev;
    }

}
