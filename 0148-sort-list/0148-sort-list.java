class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=middle(head);
        ListNode rightHead=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);

        return merge(left,right);
        
    }
    public ListNode middle(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                tail.next=a;
                a=a.next;
            }
            else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
    tail.next=(a!=null)?a:b;
    return dummy.next;
    }
}