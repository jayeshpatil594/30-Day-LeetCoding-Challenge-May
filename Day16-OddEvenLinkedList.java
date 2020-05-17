class Solution {
    public ListNode oddEvenList(ListNode head) {
    // Time: O(n) Space : O(1)
        if(head == null){
            return null;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
