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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode A = list1;
        ListNode B = list1;

        // while(a-- > 0 || b-- > 0 ){
        //     if(a > 0){
        //         A = A.next;
        //     }
        //     if(b > 0){
        //         B = B.next;
        //     }
        // }

        for(int i = 1 ; i < a ; i++){
            A = A.next;
        }
        for(int i = 1 ; i <= b ; i++){
            B = B.next;
        }

        ListNode connect = B.next;
        // B.next = null;

        ListNode bTail = list2;
        while(bTail.next != null){
            bTail = bTail.next;
        }

        A.next = list2;
        bTail.next = connect;

        return list1;


    }
}