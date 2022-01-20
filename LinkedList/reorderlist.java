// https://leetcode.com/problems/reorder-list/

class Solution {
    
     public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head) {
        
        //edge case very important: otherwise NullPointer Exception
        if(head == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

      while(present != null) {
         present.next = prev;
         prev = present;
         present = next;
         if(next != null) {
           next = next.next;
          }
    }

         head = prev;
         return head;
   
     }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        
        //rearrange
        while(hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        
        if(hf != null) {
            hf.next = null;
        }
    }
}
