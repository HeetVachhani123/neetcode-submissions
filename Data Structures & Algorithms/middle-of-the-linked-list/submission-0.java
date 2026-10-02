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
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode temp = head;
//         int len=0;
//         while(temp != null){
//             temp = temp.next;
//             len++;
//         }
//         int mid = len/2;
//         temp = head;
//         for(int i=0; i<mid; i++){
//             temp = temp.next;
//         }
//         return temp;
//     }
// }
// this is two pass solution O(n) & O(1) respectively tho

//this --> one pass solution , better for interview POV , using slow and fast approach

class Solution{
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

//fast.next != null && fast != null --> gives error why? remember that there is no next for null :)