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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }




        ListNode left = head;
        for(int i = 0 ; i < k-1 ; i++){
            left = left.next;
        }
        ListNode right = head;
        for(int i = 0 ; i < length-k; i++){
            right = right.next;
        }

        int swap = left.val;
        left.val = right.val;
        right.val = swap;

        return head;
        
    }
}