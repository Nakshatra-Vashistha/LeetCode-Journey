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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode sec = head.next;
            
            prev.next = sec;
            first.next = sec.next;
            sec.next = first;

            prev = first;
            head = first.next;

        }
        return temp.next;

        
    }
}