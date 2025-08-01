class Solution {
    public void reorderList(ListNode head) {
       ListNode tem=check(head,head);
       return;
    }
    public ListNode check(ListNode s,ListNode f)
    {
        if(f.next==null)
        {
           ListNode tem=s.next;
           s.next=null;
           return tem; 
        }
        if(f.next.next==null)
        {
            ListNode tem=s.next.next;
            s.next.next=null;
            return tem;
        }
        ListNode res=check(s.next,f.next.next);
        ListNode sn=s.next;
        ListNode resn=res.next;
        s.next=res;
        res.next=sn;
        return resn;
    }
}