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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode[] l1_arr=new ListNode[100],l2_arr=new ListNode[100];
        int i=l1_arr.length-1;
        while (l1!=null || l2!=null) {
            if (l1!=null) {
                l1_arr[i]=l1;
                l1=l1.next;
            }
            if (l2!=null) {
                l2_arr[i]=l2;
                l2=l2.next;
            }
            i--;
        }
        ListNode head=new ListNode();
        ListNode head_temp=head;
        int deci=0;
        for (int j=99;j>=0;j--) {
            int t=0;
            if (l1_arr[j]!=null && l2_arr[j]!=null) t=l1_arr[j].val+l2_arr[j].val;
            else if (l1_arr[j]!=null) t=l1_arr[j].val;
            else if (l2_arr[j]!=null) t=l2_arr[j].val;
            else break;
            ListNode temp=new ListNode();
            if (deci==1) {t++;temp.val=t%10;deci=0;}
            else temp.val=t%10;
            if (t>9) deci=1;
            head_temp.next=temp;
            head_temp=head_temp.next;
        }
        if (deci==1) head_temp.next=new ListNode(1);
        return head.next;
    }
}
