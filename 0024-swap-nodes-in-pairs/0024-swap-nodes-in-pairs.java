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
    private int idx = 0;
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        int i = idx++;
        ListNode next = swapPairs(head.next);
        swapNum(i, head, next);
        return head;
    }
    
    private void swapNum(int i, ListNode head, ListNode next) {
        if (next == null) return;
        if (i % 2 == 0) {
            int tmp = head.val;
            head.val = next.val;
            next.val = tmp;
        }
    }
}