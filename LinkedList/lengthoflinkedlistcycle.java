public int lengthCycle(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  
  while(fast != null && fast.next != null) {
     fast = fast.next.next;
     slow = slow.next;
     if(fast == slow) {
         ListNode temp = slow;
         int length = 0;
         do {
           temp = temp.next;
           length++;
         } while(temp != slow);

         return length;
      }
   }
   return 0;
}
