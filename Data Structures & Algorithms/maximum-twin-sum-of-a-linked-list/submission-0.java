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
public class Solution {
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        int i = 0, j = arr.size() - 1, res = 0;
        while (i < j) {
            res = Math.max(res, arr.get(i) + arr.get(j));
            i++;
            j--;
        }
        return res;
    }
}