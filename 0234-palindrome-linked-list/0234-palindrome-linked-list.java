class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr1=head;
        ListNode curr2=reverse(slow.next);
        while(curr2!=null){
            if(curr1.val!=curr2.val) return false;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return true;
    }
}