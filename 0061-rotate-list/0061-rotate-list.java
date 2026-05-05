class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        temp=head;
        k = k % n;
        if (k == 0) return head;
        for(int i=1;i<n-k;i++){
            temp=temp.next;
        }
        ListNode second=temp.next;
        temp.next=null;
        ListNode t=second;
        while(t.next!=null) t=t.next;

        t.next=head;
        
        return second;
    }
}