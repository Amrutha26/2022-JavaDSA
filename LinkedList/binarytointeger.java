class Solution {
    public int getDecimalValue(ListNode head) {
        
        // we cannot traverse the linkedlist from right to left
        // therefore we use a method called doubling method 
        int res = 0;
        
        while(head != null) {
            res *= 2;
            res += head.val;
            head = head.next;
        }
        
        return res;
    }
}

