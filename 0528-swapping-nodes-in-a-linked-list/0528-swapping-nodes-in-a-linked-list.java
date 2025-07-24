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
    private List<ListNode> list;
    public ListNode swapNodes(ListNode head, int k) {
        list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int size = list.size();
        int be = k - 1;
        int end = size - k;
        int idx = 0;

        
        int beV = list.get(be).val;
        list.get(be).val = list.get(end).val;
        list.get(end).val = beV;
        return head;
    }
}