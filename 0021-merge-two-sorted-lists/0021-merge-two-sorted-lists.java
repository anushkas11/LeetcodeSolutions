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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1=list1;
        ListNode h2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(h1!=null && h2!=null){
            if(h1.val<=h2.val){
                dummy.next=h1;
                h1=h1.next;
                dummy=dummy.next;
            }
            else{
                dummy.next=h2;
                h2=h2.next;
                dummy=dummy.next;
            }
        }
        while(h1!=null){
            dummy.next=h1;
            h1=h1.next;
            dummy=dummy.next;
        }
        while(h2!=null){
            dummy.next=h2;
            h2=h2.next;
            dummy=dummy.next;
        }
        return temp.next;
    }
}