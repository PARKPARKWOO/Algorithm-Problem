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
    private int result;
    private int[] value;
    private int idx;
    public int pairSum(ListNode head) {
        idx = 0;
        ListNode tmp = head;
        while (tmp != null) {
            idx++;
            tmp = tmp.next;
        }
        tmp = head;
        value = new int[idx];
        idx = 0;
        while (tmp != null) {
            value[idx++] = tmp.val;
            tmp = tmp.next;
        }
        int right = value.length - 1;
        for (int i = 0; i < value.length / 2; i++) {
            result = Math.max(result, value[right--] + value[i]);
        }
        return result;
    }
}