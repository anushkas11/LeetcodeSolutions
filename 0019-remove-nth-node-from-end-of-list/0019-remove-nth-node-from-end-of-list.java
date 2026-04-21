class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(n==count) return head.next;
        ListNode t=head;
        for(int i=1;i<count-n;i++){
           t=t.next; 
        }
        t.next=t.next.next;
        return head;
    }
}