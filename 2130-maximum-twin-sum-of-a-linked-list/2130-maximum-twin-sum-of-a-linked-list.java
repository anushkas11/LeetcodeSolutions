/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode prev=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode second=slow;
        second=reverse(second);

        ListNode temp1=head;
        ListNode temp2=second;
        int maxSum=0;
        while(temp1!=null && temp2!=null ){
            int sum=temp1.val+temp2.val;
            temp1=temp1.next;
            temp2=temp2.next;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public ListNode reverse(ListNode head) {
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;   
    }
}